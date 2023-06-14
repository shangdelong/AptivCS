package com.ruoyi.cs.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 不合格追踪记录模块对象 qa_issue_tracking
 * 
 * @author shangshang
 * @date 2023-06-14
 */
public class QaIssueTracking extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long issueId;

    /** 不合格品发生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "不合格品发生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issueDate;

    /** 零件号 */
    @Excel(name = "零件号")
    private String partNumber;

    /** 项目 */
    @Excel(name = "项目")
    private String project;

    /** 零件名称 */
    @Excel(name = "零件名称")
    private String partName;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    /** 不良问题描述 */
    @Excel(name = "不良问题描述")
    private String defectDescription;

    /** 反馈区域 */
    @Excel(name = "反馈区域")
    private String feedbackArea;

    /** 是否重复 */
    @Excel(name = "是否重复")
    private Integer isRepeat;

    /** 问题照片 */
    @Excel(name = "问题照片")
    private String problemPicture;

    /** 处理措施 */
    @Excel(name = "处理措施")
    private String handlingMethods;

    /** 可疑品总数 */
    @Excel(name = "可疑品总数")
    private Long qualifiedQty;

    /** 不良数量 */
    @Excel(name = "不良数量")
    private Long defectQty;

    /** 存放位置 */
    @Excel(name = "存放位置")
    private String storageLocation;

    /** 红牌号 */
    @Excel(name = "红牌号")
    private String redCardNumber;

    /** 责任人 */
    @Excel(name = "责任人")
    private String responsiblePerson;

    /** 是否为供应商问题 */
    @Excel(name = "是否为供应商问题")
    private Integer isSupplierIssue;

    /** 编号 */
    @Excel(name = "编号")
    private String prrQmr;

    /** 状态（关闭/进行中） */
    @Excel(name = "状态", readConverterExp = "关=闭/进行中")
    private Long status;

    public void setIssueId(Long issueId) 
    {
        this.issueId = issueId;
    }

    public Long getIssueId() 
    {
        return issueId;
    }
    public void setIssueDate(Date issueDate) 
    {
        this.issueDate = issueDate;
    }

    public Date getIssueDate() 
    {
        return issueDate;
    }
    public void setPartNumber(String partNumber) 
    {
        this.partNumber = partNumber;
    }

    public String getPartNumber() 
    {
        return partNumber;
    }
    public void setProject(String project) 
    {
        this.project = project;
    }

    public String getProject() 
    {
        return project;
    }
    public void setPartName(String partName) 
    {
        this.partName = partName;
    }

    public String getPartName() 
    {
        return partName;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setDefectDescription(String defectDescription) 
    {
        this.defectDescription = defectDescription;
    }

    public String getDefectDescription() 
    {
        return defectDescription;
    }
    public void setFeedbackArea(String feedbackArea) 
    {
        this.feedbackArea = feedbackArea;
    }

    public String getFeedbackArea() 
    {
        return feedbackArea;
    }
    public void setIsRepeat(Integer isRepeat) 
    {
        this.isRepeat = isRepeat;
    }

    public Integer getIsRepeat() 
    {
        return isRepeat;
    }
    public void setProblemPicture(String problemPicture) 
    {
        this.problemPicture = problemPicture;
    }

    public String getProblemPicture() 
    {
        return problemPicture;
    }
    public void setHandlingMethods(String handlingMethods) 
    {
        this.handlingMethods = handlingMethods;
    }

    public String getHandlingMethods() 
    {
        return handlingMethods;
    }
    public void setQualifiedQty(Long qualifiedQty) 
    {
        this.qualifiedQty = qualifiedQty;
    }

    public Long getQualifiedQty() 
    {
        return qualifiedQty;
    }
    public void setDefectQty(Long defectQty) 
    {
        this.defectQty = defectQty;
    }

    public Long getDefectQty() 
    {
        return defectQty;
    }
    public void setStorageLocation(String storageLocation) 
    {
        this.storageLocation = storageLocation;
    }

    public String getStorageLocation() 
    {
        return storageLocation;
    }
    public void setRedCardNumber(String redCardNumber) 
    {
        this.redCardNumber = redCardNumber;
    }

    public String getRedCardNumber() 
    {
        return redCardNumber;
    }
    public void setResponsiblePerson(String responsiblePerson) 
    {
        this.responsiblePerson = responsiblePerson;
    }

    public String getResponsiblePerson() 
    {
        return responsiblePerson;
    }
    public void setIsSupplierIssue(Integer isSupplierIssue) 
    {
        this.isSupplierIssue = isSupplierIssue;
    }

    public Integer getIsSupplierIssue() 
    {
        return isSupplierIssue;
    }
    public void setPrrQmr(String prrQmr) 
    {
        this.prrQmr = prrQmr;
    }

    public String getPrrQmr() 
    {
        return prrQmr;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("issueId", getIssueId())
            .append("issueDate", getIssueDate())
            .append("partNumber", getPartNumber())
            .append("project", getProject())
            .append("partName", getPartName())
            .append("supplier", getSupplier())
            .append("defectDescription", getDefectDescription())
            .append("feedbackArea", getFeedbackArea())
            .append("isRepeat", getIsRepeat())
            .append("problemPicture", getProblemPicture())
            .append("handlingMethods", getHandlingMethods())
            .append("qualifiedQty", getQualifiedQty())
            .append("defectQty", getDefectQty())
            .append("storageLocation", getStorageLocation())
            .append("redCardNumber", getRedCardNumber())
            .append("responsiblePerson", getResponsiblePerson())
            .append("isSupplierIssue", getIsSupplierIssue())
            .append("prrQmr", getPrrQmr())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
