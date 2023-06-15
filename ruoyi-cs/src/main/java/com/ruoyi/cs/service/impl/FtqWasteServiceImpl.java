package com.ruoyi.cs.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.cs.domain.SealedSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cs.mapper.FtqWasteMapper;
import com.ruoyi.cs.domain.FtqWaste;
import com.ruoyi.cs.service.IFtqWasteService;
import com.ruoyi.common.core.text.Convert;

import javax.validation.Validator;

/**
 * FTQ废品统计数据Service业务层处理
 * 
 * @author shangshang
 * @date 2023-06-14
 */
@Service
public class FtqWasteServiceImpl implements IFtqWasteService 
{
    private static final Logger log = LoggerFactory.getLogger(SealedSampleServiceImpl.class);
    @Autowired
    private FtqWasteMapper ftqWasteMapper;

    @Autowired
    protected Validator validator;

    /**
     * 查询FTQ废品统计数据
     * 
     * @param ftqId FTQ废品统计数据主键
     * @return FTQ废品统计数据
     */
    @Override
    public FtqWaste selectFtqWasteByFtqId(Long ftqId)
    {
        return ftqWasteMapper.selectFtqWasteByFtqId(ftqId);
    }

    /**
     * 查询FTQ废品统计数据列表
     * 
     * @param ftqWaste FTQ废品统计数据
     * @return FTQ废品统计数据
     */
    @Override
    public List<FtqWaste> selectFtqWasteList(FtqWaste ftqWaste)
    {
        return ftqWasteMapper.selectFtqWasteList(ftqWaste);
    }

    /**
     * 新增FTQ废品统计数据
     * 
     * @param ftqWaste FTQ废品统计数据
     * @return 结果
     */
    @Override
    public int insertFtqWaste(FtqWaste ftqWaste)
    {
        ftqWaste.setCreatedTime(DateUtils.getNowDate());
        return ftqWasteMapper.insertFtqWaste(ftqWaste);
    }

    /**
     * 修改FTQ废品统计数据
     * 
     * @param ftqWaste FTQ废品统计数据
     * @return 结果
     */
    @Override
    public int updateFtqWaste(FtqWaste ftqWaste)
    {
        ftqWaste.setUpdatedTime(DateUtils.getNowDate());
        return ftqWasteMapper.updateFtqWaste(ftqWaste);
    }

    /**
     * 批量删除FTQ废品统计数据
     * 
     * @param ftqIds 需要删除的FTQ废品统计数据主键
     * @return 结果
     */
    @Override
    public int deleteFtqWasteByFtqIds(String ftqIds)
    {
        return ftqWasteMapper.deleteFtqWasteByFtqIds(Convert.toStrArray(ftqIds));
    }

    /**
     * 删除FTQ废品统计数据信息
     * 
     * @param ftqId FTQ废品统计数据主键
     * @return 结果
     */
    @Override
    public int deleteFtqWasteByFtqId(Long ftqId)
    {
        return ftqWasteMapper.deleteFtqWasteByFtqId(ftqId);
    }

    @Override
    public String importFtqWaste(List<FtqWaste> ftqWasteList, boolean updateSupport, String loginName) {
        if (StringUtils.isNull(ftqWasteList) || ftqWasteList.size() == 0)
        {
            throw new ServiceException("导入ftq废品数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
//        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (FtqWaste ftqWaste : ftqWasteList)
        {
            try
            {
                // 验证是否存在这个废品
                FtqWaste s = ftqWasteMapper.selectFtqWasteByFtqId(ftqWaste.getFtqId());
                if (StringUtils.isNull(s))
                {
                    BeanValidators.validateWithException(validator, ftqWaste);
//                    user.setPassword(Md5Utils.hash(user.getLoginName() + password));
                    ftqWaste.setCreateBy(loginName);
//
//                  获取当前时间
                    ftqWaste.setCreatedTime(DateUtils.getNowDate());
                    ftqWasteMapper.insertFtqWaste(ftqWaste);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、物料名称 " + ftqWaste.getPartName() + " 导入成功");
                }
                else if (updateSupport)
                {
                    BeanValidators.validateWithException(validator, ftqWaste);
//                    checkUserAllowed(u);
//                    checkUserDataScope(u.getUserId());
                    ftqWaste.setFtqId(s.getFtqId());
                    ftqWaste.setUpdateBy(loginName);

                    ftqWasteMapper.updateFtqWaste(ftqWaste);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、物料名称 " + ftqWaste.getPartName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、物料名称 " + ftqWaste.getPartName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、物料名称 " + ftqWaste.getPartName() + " 导入失败：";
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
}
