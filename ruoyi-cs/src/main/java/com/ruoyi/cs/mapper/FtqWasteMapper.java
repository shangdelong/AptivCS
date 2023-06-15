package com.ruoyi.cs.mapper;

import java.util.List;
import com.ruoyi.cs.domain.FtqWaste;

/**
 * FTQ废品统计数据Mapper接口
 * 
 * @author shangshang
 * @date 2023-06-14
 */
public interface FtqWasteMapper 
{
    /**
     * 查询FTQ废品统计数据
     * 
     * @param ftqId FTQ废品统计数据主键
     * @return FTQ废品统计数据
     */
    public FtqWaste selectFtqWasteByFtqId(Long ftqId);

    /**
     * 查询FTQ废品统计数据列表
     * 
     * @param ftqWaste FTQ废品统计数据
     * @return FTQ废品统计数据集合
     */
    public List<FtqWaste> selectFtqWasteList(FtqWaste ftqWaste);

    /**
     * 新增FTQ废品统计数据
     * 
     * @param ftqWaste FTQ废品统计数据
     * @return 结果
     */
    public int insertFtqWaste(FtqWaste ftqWaste);

    /**
     * 修改FTQ废品统计数据
     * 
     * @param ftqWaste FTQ废品统计数据
     * @return 结果
     */
    public int updateFtqWaste(FtqWaste ftqWaste);

    /**
     * 删除FTQ废品统计数据
     * 
     * @param ftqId FTQ废品统计数据主键
     * @return 结果
     */
    public int deleteFtqWasteByFtqId(Long ftqId);

    /**
     * 批量删除FTQ废品统计数据
     * 
     * @param ftqIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFtqWasteByFtqIds(String[] ftqIds);
}
