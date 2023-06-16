package com.ruoyi.cs.mapper;

import java.util.List;
import com.ruoyi.cs.domain.SealedSample;

/**
 * 封样件数据Mapper接口
 * 
 * @author shangshang
 * @date 2023-05-23
 */
public interface SealedSampleMapper
{
    /**
     * 查询封样件数据
     * 
     * @param id 封样件数据主键
     * @return 封样件数据
     */
    public SealedSample selectSealedSampleById(Long id);

    /**
     * 通过零件号查询样件
     * @param eightD 零件号
     * @return
     */
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
     * 删除封样件数据
     * 
     * @param id 封样件数据主键
     * @return 结果
     */
    public int deleteSealedSampleById(Long id);

    /**
     * 批量删除封样件数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSealedSampleByIds(String[] ids);

    /**
     * 获取快过期样件列表
     * @return
     */
    List<SealedSample> selectSealedSampleDueList();

    /**
     * 校验零件号是否唯一
     * @param eightD 零件号
     * @return
     */
    public SealedSample checkEightDUnique(String eightD);

    /**
     * 校验零件位置是否唯一
     * @param sampleLocation 零件位置
     * @return
     */
    public SealedSample checkSampleLocationUnique(String sampleLocation);
}
