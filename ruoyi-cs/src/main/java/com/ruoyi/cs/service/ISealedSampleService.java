package com.ruoyi.cs.service;

import java.util.List;
import com.ruoyi.cs.domain.SealedSample;

/**
 * 封样件数据Service接口
 * 
 * @author shangshang
 * @date 2023-05-23
 */
public interface ISealedSampleService 
{
    /**
     * 查询封样件数据
     * 
     * @param id 封样件数据主键
     * @return 封样件数据
     */
    public SealedSample selectSealedSampleById(Long id);

    public SealedSample selectSealedSampleByEightD(String eightD);
    /**
     * 查询封样件数据列表
     * 
     * @param sealedSample 封样件数据
     * @return 封样件数据集合
     */
    public List<SealedSample> selectSealedSampleList(SealedSample sealedSample);

    /**
     * 新增封样件数据
     * 
     * @param sealedSample 封样件数据
     * @return 结果
     */
    public int insertSealedSample(SealedSample sealedSample);

    /**
     * 修改封样件数据
     * 
     * @param sealedSample 封样件数据
     * @return 结果
     */
    public int updateSealedSample(SealedSample sealedSample);

    /**
     * 批量删除封样件数据
     * 
     * @param ids 需要删除的封样件数据主键集合
     * @return 结果
     */
    public int deleteSealedSampleByIds(String ids);

    /**
     * 删除封样件数据信息
     * 
     * @param id 封样件数据主键
     * @return 结果
     */
    public int deleteSealedSampleById(Long id);

    /**
     *
     * @param sampleList 封样数据列表
     * @param updateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return
     */
    String importSample(List<SealedSample> sampleList, boolean updateSupport, String operName);

    /**
     * 样件到列表
     * @param sealedSample
     * @return
     */
    void selectSealedSampleDueList(SealedSample sealedSample);

}
