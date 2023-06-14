package com.ruoyi.cs.mapper;

import java.util.List;
import com.ruoyi.cs.domain.QaIssueTracking;

/**
 * 不合格追踪记录模块Mapper接口
 * 
 * @author shangshang
 * @date 2023-06-14
 */
public interface QaIssueTrackingMapper 
{
    /**
     * 查询不合格追踪记录模块
     * 
     * @param issueId 不合格追踪记录模块主键
     * @return 不合格追踪记录模块
     */
    public QaIssueTracking selectQaIssueTrackingByIssueId(Long issueId);

    /**
     * 查询不合格追踪记录模块列表
     * 
     * @param qaIssueTracking 不合格追踪记录模块
     * @return 不合格追踪记录模块集合
     */
    public List<QaIssueTracking> selectQaIssueTrackingList(QaIssueTracking qaIssueTracking);

    /**
     * 新增不合格追踪记录模块
     * 
     * @param qaIssueTracking 不合格追踪记录模块
     * @return 结果
     */
    public int insertQaIssueTracking(QaIssueTracking qaIssueTracking);

    /**
     * 修改不合格追踪记录模块
     * 
     * @param qaIssueTracking 不合格追踪记录模块
     * @return 结果
     */
    public int updateQaIssueTracking(QaIssueTracking qaIssueTracking);

    /**
     * 删除不合格追踪记录模块
     * 
     * @param issueId 不合格追踪记录模块主键
     * @return 结果
     */
    public int deleteQaIssueTrackingByIssueId(Long issueId);

    /**
     * 批量删除不合格追踪记录模块
     * 
     * @param issueIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQaIssueTrackingByIssueIds(String[] issueIds);
}
