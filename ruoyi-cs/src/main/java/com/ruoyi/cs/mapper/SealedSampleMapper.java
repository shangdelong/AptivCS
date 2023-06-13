package com.ruoyi.cs.mapper;

import java.util.List;
import com.ruoyi.cs.domain.SealedSample;

/**
 * 封样件的管理Mapper接口
 * 
 * @author shangshang
 * @date 2023-05-23
 */
public interface SealedSampleMapper
{
    /**
     * 查询封样件的管理
     * 
     * @param id 封样件的管理主键
     * @return 封样件的管理
     */
    public SealedSample selectSealedSampleById(Long id);

    /**
     * 通过零件号查询样件
     * @param eightD 零件号
     * @return
     */
    public SealedSample selectSealedSampleByEightD(String eightD);

    /**
     * 查询封样件的管理列表
     * 
     * @param sealedSample 封样件的管理
     * @return 封样件的管理集合
     */
    public List<SealedSample> selectSealedSampleList(SealedSample sealedSample);

    /**
     * 新增封样件的管理
     * 
     * @param sealedSample 封样件的管理
     * @return 结果
     */
    public int insertSealedSample(SealedSample sealedSample);

    /**
     * 修改封样件的管理
     * 
     * @param sealedSample 封样件的管理
     * @return 结果
     */
    public int updateSealedSample(SealedSample sealedSample);

    /**
     * 删除封样件的管理
     * 
     * @param id 封样件的管理主键
     * @return 结果
     */
    public int deleteSealedSampleById(Long id);

    /**
     * 批量删除封样件的管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSealedSampleByIds(String[] ids);


    List<SealedSample> selectSealedSampleDueList();
}
