package com.ruoyi.cs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cs.mapper.QaIssueTrackingMapper;
import com.ruoyi.cs.domain.QaIssueTracking;
import com.ruoyi.cs.service.IQaIssueTrackingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 不合格追踪记录模块Service业务层处理
 * 
 * @author shangshang
 * @date 2023-06-14
 */
@Service
public class QaIssueTrackingServiceImpl implements IQaIssueTrackingService 
{
    @Autowired
    private QaIssueTrackingMapper qaIssueTrackingMapper;

    /**
     * 查询不合格追踪记录模块
     * 
     * @param issueId 不合格追踪记录模块主键
     * @return 不合格追踪记录模块
     */
    @Override
    public QaIssueTracking selectQaIssueTrackingByIssueId(Long issueId)
    {
        return qaIssueTrackingMapper.selectQaIssueTrackingByIssueId(issueId);
    }

    /**
     * 查询不合格追踪记录模块列表
     * 
     * @param qaIssueTracking 不合格追踪记录模块
     * @return 不合格追踪记录模块
     */
    @Override
    public List<QaIssueTracking> selectQaIssueTrackingList(QaIssueTracking qaIssueTracking)
    {
        return qaIssueTrackingMapper.selectQaIssueTrackingList(qaIssueTracking);
    }

    /**
     * 新增不合格追踪记录模块
     * 
     * @param qaIssueTracking 不合格追踪记录模块
     * @return 结果
     */
    @Override
    public int insertQaIssueTracking(QaIssueTracking qaIssueTracking)
    {
        return qaIssueTrackingMapper.insertQaIssueTracking(qaIssueTracking);
    }

    /**
     * 修改不合格追踪记录模块
     * 
     * @param qaIssueTracking 不合格追踪记录模块
     * @return 结果
     */
    @Override
    public int updateQaIssueTracking(QaIssueTracking qaIssueTracking)
    {
        return qaIssueTrackingMapper.updateQaIssueTracking(qaIssueTracking);
    }

    /**
     * 批量删除不合格追踪记录模块
     * 
     * @param issueIds 需要删除的不合格追踪记录模块主键
     * @return 结果
     */
    @Override
    public int deleteQaIssueTrackingByIssueIds(String issueIds)
    {
        return qaIssueTrackingMapper.deleteQaIssueTrackingByIssueIds(Convert.toStrArray(issueIds));
    }

    /**
     * 删除不合格追踪记录模块信息
     * 
     * @param issueId 不合格追踪记录模块主键
     * @return 结果
     */
    @Override
    public int deleteQaIssueTrackingByIssueId(Long issueId)
    {
        return qaIssueTrackingMapper.deleteQaIssueTrackingByIssueId(issueId);
    }
}
