package com.ruoyi.cs.service.impl;

import java.util.List;

import com.ruoyi.cs.service.ISealedSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cs.mapper.SealedSampleMapper;
import com.ruoyi.cs.domain.SealedSample;
import com.ruoyi.common.core.text.Convert;

/**
 * 封样件的管理Service业务层处理
 * 
 * @author shangshang
 * @date 2023-05-23
 */
@Service
public class SealedSampleServiceImpl implements ISealedSampleService
{
    @Autowired
    private SealedSampleMapper sealedSampleMapper;

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
     * 新增封样件的管理
     * 
     * @param sealedSample 封样件的管理
     * @return 结果
     */
    @Override
    public int insertSealedSample(SealedSample sealedSample)
    {
        return sealedSampleMapper.insertSealedSample(sealedSample);
    }

    /**
     * 修改封样件的管理
     * 
     * @param sealedSample 封样件的管理
     * @return 结果
     */
    @Override
    public int updateSealedSample(SealedSample sealedSample)
    {
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
}
