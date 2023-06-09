package com.ruoyi.cs.service;

import java.util.List;
import com.ruoyi.cs.domain.SealedSample;

/**
 * 封样件的管理Service接口
 * 
 * @author shangshang
 * @date 2023-05-23
 */
public interface ISealedSampleService 
{
    /**
     * 查询封样件的管理
     * 
     * @param id 封样件的管理主键
     * @return 封样件的管理
     */
    public SealedSample selectSealedSampleById(Long id);

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
     * 批量删除封样件的管理
     * 
     * @param ids 需要删除的封样件的管理主键集合
     * @return 结果
     */
    public int deleteSealedSampleByIds(String ids);

    /**
     * 删除封样件的管理信息
     * 
     * @param id 封样件的管理主键
     * @return 结果
     */
    public int deleteSealedSampleById(Long id);

    /**
     *
     * @param sampleList
     * @param updateSupport
     * @param loginName
     * @return
     */
    String importSample(List<SealedSample> sampleList, boolean updateSupport, String loginName);

//    List<SealedSample> findAllItems();
}
