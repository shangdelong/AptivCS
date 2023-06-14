package com.ruoyi.cs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cs.mapper.FtqWasteMapper;
import com.ruoyi.cs.domain.FtqWaste;
import com.ruoyi.cs.service.IFtqWasteService;
import com.ruoyi.common.core.text.Convert;

/**
 * FTQ废品统计模块Service业务层处理
 * 
 * @author shangshang
 * @date 2023-06-14
 */
@Service
public class FtqWasteServiceImpl implements IFtqWasteService 
{
    @Autowired
    private FtqWasteMapper ftqWasteMapper;

    /**
     * 查询FTQ废品统计模块
     * 
     * @param ftqId FTQ废品统计模块主键
     * @return FTQ废品统计模块
     */
    @Override
    public FtqWaste selectFtqWasteByFtqId(Long ftqId)
    {
        return ftqWasteMapper.selectFtqWasteByFtqId(ftqId);
    }

    /**
     * 查询FTQ废品统计模块列表
     * 
     * @param ftqWaste FTQ废品统计模块
     * @return FTQ废品统计模块
     */
    @Override
    public List<FtqWaste> selectFtqWasteList(FtqWaste ftqWaste)
    {
        return ftqWasteMapper.selectFtqWasteList(ftqWaste);
    }

    /**
     * 新增FTQ废品统计模块
     * 
     * @param ftqWaste FTQ废品统计模块
     * @return 结果
     */
    @Override
    public int insertFtqWaste(FtqWaste ftqWaste)
    {
        return ftqWasteMapper.insertFtqWaste(ftqWaste);
    }

    /**
     * 修改FTQ废品统计模块
     * 
     * @param ftqWaste FTQ废品统计模块
     * @return 结果
     */
    @Override
    public int updateFtqWaste(FtqWaste ftqWaste)
    {
        return ftqWasteMapper.updateFtqWaste(ftqWaste);
    }

    /**
     * 批量删除FTQ废品统计模块
     * 
     * @param ftqIds 需要删除的FTQ废品统计模块主键
     * @return 结果
     */
    @Override
    public int deleteFtqWasteByFtqIds(String ftqIds)
    {
        return ftqWasteMapper.deleteFtqWasteByFtqIds(Convert.toStrArray(ftqIds));
    }

    /**
     * 删除FTQ废品统计模块信息
     * 
     * @param ftqId FTQ废品统计模块主键
     * @return 结果
     */
    @Override
    public int deleteFtqWasteByFtqId(Long ftqId)
    {
        return ftqWasteMapper.deleteFtqWasteByFtqId(ftqId);
    }
}
