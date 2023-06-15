package com.ruoyi.cs.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.cs.service.ISealedSampleService;
import com.ruoyi.system.mapper.SysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.ruoyi.cs.mapper.SealedSampleMapper;
import com.ruoyi.cs.domain.SealedSample;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import javax.validation.Validator;

/**
 * 封样件数据Service业务层处理
 * 
 * @author shangshang
 * @date 2023-05-23
 */
@Service
@Component
public class SealedSampleServiceImpl implements ISealedSampleService
{
    private static final Logger log = LoggerFactory.getLogger(SealedSampleServiceImpl.class);

    @Autowired
    private SealedSampleMapper sealedSampleMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    protected Validator validator;

    @Autowired
    private JavaMailSender mailSender; // JavaMailSender是Spring Boot默认提供的邮件发送工具类

    @Scheduled(cron = "0 0 8 * * ?") // 每天早上8点检查

    /**
     * 查询封样件数据
     * 
     * @param id 封样件数据主键
     * @return 封样件数据
     */
    @Override
    public SealedSample selectSealedSampleById(Long id)
    {
        return sealedSampleMapper.selectSealedSampleById(id);
    }

    /**
     *
     * @param eightD 样件的零件号
     * @return
     */
    @Override
    public SealedSample selectSealedSampleByEightD(String eightD) {
        return sealedSampleMapper.selectSealedSampleByEightD(eightD);
    }

    /**
     * 查询封样件数据列表
     * 
     * @param sealedSample 封样件数据
     * @return 封样件数据
     */
    @Override
    public List<SealedSample> selectSealedSampleList(SealedSample sealedSample)
    {
        return sealedSampleMapper.selectSealedSampleList(sealedSample);
    }

    /**
     * 新增封样件
     * 
     * @param sealedSample 封样件数据
     * @return 结果
     */
    @Override
    public int insertSealedSample(SealedSample sealedSample)
    {
        sealedSample.setCreateTime(DateUtils.getNowDate());
        return sealedSampleMapper.insertSealedSample(sealedSample);
    }

    /**
     * 修改封样件
     * 
     * @param sealedSample 封样件数据
     * @return 结果
     */
    @Override
    public int updateSealedSample(SealedSample sealedSample)
    {
        sealedSample.setUpdateTime(DateUtils.getNowDate());
        return sealedSampleMapper.updateSealedSample(sealedSample);
    }

    /**
     * 批量删除封样件数据
     * 
     * @param ids 需要删除的封样件数据主键
     * @return 结果
     */
    @Override
    public int deleteSealedSampleByIds(String ids)
    {
        return sealedSampleMapper.deleteSealedSampleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除封样件数据信息
     * 
     * @param id 封样件数据主键
     * @return 结果
     */
    @Override
    public int deleteSealedSampleById(Long id)
    {
        return sealedSampleMapper.deleteSealedSampleById(id);
    }


    /**
     * 导入封样数据
     * @param sampleList 封样数据列表
     * @param updateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return
     */
    @Override
    public String importSample(List<SealedSample> sampleList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(sampleList) || sampleList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
//        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (SealedSample sample : sampleList)
        {
            try
            {
                // 验证是否存在这个样件
                SealedSample s = sealedSampleMapper.selectSealedSampleByEightD(sample.getEightD());
                if (StringUtils.isNull(s))
                {
                    BeanValidators.validateWithException(validator, sample);
//                    user.setPassword(Md5Utils.hash(user.getLoginName() + password));
                    sample.setCreateBy(operName);
//                     获取系统当前时间
//                    Date time = new Date();

//                     将当前时间存储到UserEntity中
//                    sample.setCreateTime(time);
                    sealedSampleMapper.insertSealedSample(sample);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、物料名称 " + sample.getSealedSample() + " 导入成功");
                }
                else if (updateSupport)
                {
                    BeanValidators.validateWithException(validator, sample);
//                    checkUserAllowed(u);
//                    checkUserDataScope(u.getUserId());
                    sample.setId(s.getId());
                    sample.setUpdateBy(operName);

                    sealedSampleMapper.updateSealedSample(sample);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、物料名称 " + sample.getSealedSample() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、物料名称 " + sample.getSealedSample() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、物料名称 " + sample.getSealedSample() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }



    @Override
    public void selectSealedSampleDueList(SealedSample sealedSample)
    { List<SealedSample> sealedSampleList = selectSealedSampleDueListA();
          for(SealedSample sealedSample1:sealedSampleList){
              String email = sysUserMapper.selectUserEmailById(sealedSample1.getUserIid());
              // 发送邮件提醒
              SimpleMailMessage message = new SimpleMailMessage();
              message.setFrom("2924639689@qq.com");
              message.setTo(email);
              message.setSubject("以下样件30天内即将过期！");
//              message.setText("您好，您的账号已过期，请尽快续费。");
              message.setText(sealedSample1.getId()+sealedSample1.getSealedSample()+sealedSample1.getEightD()+sealedSample1.getSampleLocation()+sealedSample1.getBusiness()+sealedSample1.getSealedSampleDue()+sealedSample1.getRemainingTime());
              mailSender.send(message);
          }
//        for (SealedSample sealedsample:selectSealedSampleDueList(sealedSample)) {
//            if(isExpired(sealedsample)){ // 判断是否快过期
//                // 发送邮件提醒
//                SimpleMailMessage message = new SimpleMailMessage();
//                message.setFrom("发送邮件的邮箱地址");
//                for (SysUser sysuser: selectSysUserEmail(user)) {
//                    message.setTo(sysuser.getEmail());
//                }
//
//                message.setSubject("您的账号已过期");
//                message.setText("您好，您的账号已过期，请尽快续费。");
//                mailSender.send(message);
//            }
//        }
    }

    public List<SealedSample> selectSealedSampleDueListA(){
        return sealedSampleMapper.selectSealedSampleDueList();
    }


}
