package com.ruoyi.cs.service;

import java.util.List;
import com.ruoyi.cs.domain.FtqWaste;

/**
 * FTQ废品统计模块Service接口
 * 
 * @author shangshang
 * @date 2023-06-14
 */
public interface IFtqWasteService 
{
    /**
     * 查询FTQ废品统计模块
     * 
     * @param ftqId FTQ废品统计模块主键
     * @return FTQ废品统计模块
     */
    public FtqWaste selectFtqWasteByFtqId(Long ftqId);

    /**
     * 查询FTQ废品统计模块列表
     * 
     * @param ftqWaste FTQ废品统计模块
     * @return FTQ废品统计模块集合
     */
    public List<FtqWaste> selectFtqWasteList(FtqWaste ftqWaste);

    /**
     * 新增FTQ废品统计模块
     * 
     * @param ftqWaste FTQ废品统计模块
     * @return 结果
     */
    public int insertFtqWaste(FtqWaste ftqWaste);

    /**
     * 修改FTQ废品统计模块
     * 
     * @param ftqWaste FTQ废品统计模块
     * @return 结果
     */
    public int updateFtqWaste(FtqWaste ftqWaste);

    /**
     * 批量删除FTQ废品统计模块
     * 
     * @param ftqIds 需要删除的FTQ废品统计模块主键集合
     * @return 结果
     */
    public int deleteFtqWasteByFtqIds(String ftqIds);

    /**
     * 删除FTQ废品统计模块信息
     * 
     * @param ftqId FTQ废品统计模块主键
     * @return 结果
     */
    public int deleteFtqWasteByFtqId(Long ftqId);
}
