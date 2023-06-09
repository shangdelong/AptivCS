package com.ruoyi.cs.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.cs.service.ISealedSampleService;
import com.ruoyi.cs.service.ISysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cs.mapper.SealedSampleMapper;
import com.ruoyi.cs.domain.SealedSample;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import javax.validation.Validator;

/**
 * 封样件的管理Service业务层处理
 * 
 * @author shangshang
 * @date 2023-05-23
 */
@Service
public class SealedSampleServiceImpl implements ISealedSampleService
{
    private static final Logger log = LoggerFactory.getLogger(SealedSampleServiceImpl.class);

    @Autowired
    private SealedSampleMapper sealedSampleMapper;

//    @Autowired
//    private ISysConfigService configService;

    @Autowired
    protected Validator validator;

    /**
     * 查询封样件的管理
     * 
     * @param id 封样件的管理主键
     * @return 封样件的管理
     */
    @Override
    public SealedSample selectSealedSampleById(Long id)
    {
        return sealedSampleMapper.selectSealedSampleById(id);
    }

    /**
     * 查询封样件的管理列表
     * 
     * @param sealedSample 封样件的管理
     * @return 封样件的管理
     */
    @Override
    public List<SealedSample> selectSealedSampleList(SealedSample sealedSample)
    {
        return sealedSampleMapper.selectSealedSampleList(sealedSample);
    }

    /**
     * 新增封样件
     * 
     * @param sealedSample 封样件的管理
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
     * @param sealedSample 封样件的管理
     * @return 结果
     */
    @Override
    public int updateSealedSample(SealedSample sealedSample)
    {
        sealedSample.setUpdateTime(DateUtils.getNowDate());
        return sealedSampleMapper.updateSealedSample(sealedSample);
    }

    /**
     * 批量删除封样件的管理
     * 
     * @param ids 需要删除的封样件的管理主键
     * @return 结果
     */
    @Override
    public int deleteSealedSampleByIds(String ids)
    {
        return sealedSampleMapper.deleteSealedSampleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除封样件的管理信息
     * 
     * @param id 封样件的管理主键
     * @return 结果
     */
    @Override
    public int deleteSealedSampleById(Long id)
    {
        return sealedSampleMapper.deleteSealedSampleById(id);
    }


    @Override
    public String importSample(List<SealedSample> sampleList, boolean updateSupport, String loginName) {
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
                SealedSample s = sealedSampleMapper.selectSealedSampleById(sample.getId());
                if (StringUtils.isNull(s))
                {
                    BeanValidators.validateWithException(validator, sample);
//                    user.setPassword(Md5Utils.hash(user.getLoginName() + password));
                    sample.setCreateBy(loginName);
                    sealedSampleMapper.insertSealedSample(sample);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sample.getSealedSample() + " 导入成功");
                }
                else if (updateSupport)
                {
                    BeanValidators.validateWithException(validator, sample);
//                    checkUserAllowed(u);
//                    checkUserDataScope(u.getUserId());
//                    user.setUserId(u.getUserId());
//                    user.setUpdateBy(operName);
                    sealedSampleMapper.updateSealedSample(sample);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sample.getSealedSample() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + sample.getSealedSample() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + sample.getSealedSample() + " 导入失败：";
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

//    @Override
//    public List<SealedSample> findAllItems() {
//        return null;
//    }
}
