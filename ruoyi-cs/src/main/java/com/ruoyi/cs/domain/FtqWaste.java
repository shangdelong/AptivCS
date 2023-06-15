package com.ruoyi.cs.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * FTQ废品统计对象 ftq_waste
 * 
 * @author shangshang
 * @date 2023-06-14
 */
public class FtqWaste extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long ftqId;

    /** 周数 */
    @Excel(name = "周数")
    private String weekNumber;

    /** 废品产生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "废品产生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wasteDate;

    /** 零件号 */
    @Excel(name = "零件号")
    private String partNumber;

    /** 废品产生数量 */
    @Excel(name = "废品产生数量")
    private Long wasteQuantity;

    /** 零件名称 */
    @Excel(name = "零件名称")
    private String partName;

    /** 项目-区域 */
    @Excel(name = "项目-区域")
    private String projectArea;

    /** 废品产生原因 */
    @Excel(name = "废品产生原因")
    private String wasteReason;

    /** 缺陷描述 */
    @Excel(name = "缺陷描述")
    private String defectDescription;

    /** 班长 */
    @Excel(name = "班长")
    private String shiftLeader;

    /** 单位成本 */
    @Excel(name = "单位成本")
    private BigDecimal unitCost;

    /** 总成本 */
    @Excel(name = "总成本")
    private BigDecimal totalCost;

    /** 创建时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    @Excel(name = "创建时间",type = Excel.Type.EXPORT)
    private Date createdTime;

    /** 修改时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    @Excel(name = "修改时间",type = Excel.Type.EXPORT)
    private Date updatedTime;

    public void setFtqId(Long ftqId) 
    {
        this.ftqId = ftqId;
    }

    public Long getFtqId() 
    {
        return ftqId;
    }
    public void setWeekNumber(String weekNumber) 
    {
        this.weekNumber = weekNumber;
    }

    public String getWeekNumber() 
    {
        return weekNumber;
    }
    public void setWasteDate(Date wasteDate) 
    {
        this.wasteDate = wasteDate;
    }

    public Date getWasteDate() 
    {
        return wasteDate;
    }
    public void setPartNumber(String partNumber) 
    {
        this.partNumber = partNumber;
    }

    public String getPartNumber() 
    {
        return partNumber;
    }
    public void setWasteQuantity(Long wasteQuantity) 
    {
        this.wasteQuantity = wasteQuantity;
    }

    public Long getWasteQuantity() 
    {
        return wasteQuantity;
    }
    public void setPartName(String partName) 
    {
        this.partName = partName;
    }

    public String getPartName() 
    {
        return partName;
    }
    public void setProjectArea(String projectArea) 
    {
        this.projectArea = projectArea;
    }

    public String getProjectArea() 
    {
        return projectArea;
    }
    public void setWasteReason(String wasteReason) 
    {
        this.wasteReason = wasteReason;
    }

    public String getWasteReason() 
    {
        return wasteReason;
    }
    public void setDefectDescription(String defectDescription) 
    {
        this.defectDescription = defectDescription;
    }

    public String getDefectDescription() 
    {
        return defectDescription;
    }
    public void setShiftLeader(String shiftLeader) 
    {
        this.shiftLeader = shiftLeader;
    }

    public String getShiftLeader() 
    {
        return shiftLeader;
    }
    public void setUnitCost(BigDecimal unitCost) 
    {
        this.unitCost = unitCost;
    }

    public BigDecimal getUnitCost() 
    {
        return unitCost;
    }
    public void setTotalCost(BigDecimal totalCost) 
    {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalCost() 
    {
        return totalCost;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ftqId", getFtqId())
            .append("weekNumber", getWeekNumber())
            .append("wasteDate", getWasteDate())
            .append("partNumber", getPartNumber())
            .append("wasteQuantity", getWasteQuantity())
            .append("partName", getPartName())
            .append("projectArea", getProjectArea())
            .append("wasteReason", getWasteReason())
            .append("defectDescription", getDefectDescription())
            .append("shiftLeader", getShiftLeader())
            .append("unitCost", getUnitCost())
            .append("totalCost", getTotalCost())
            .append("remark", getRemark())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
