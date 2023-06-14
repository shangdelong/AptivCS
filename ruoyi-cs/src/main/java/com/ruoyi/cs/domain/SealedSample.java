package com.ruoyi.cs.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 封样件的管理对象 sealed_sample
 * 
 * @author shangshang
 * @date 2023-05-23
 */
public class SealedSample extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String sealedSample;

    /** 8D号 */
    @Excel(name = "8D号")
    private String eightD;

    /** 样件位置 */
    @Excel(name = "样件位置")
    private String sampleLocation;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    /** 供应商号 */
    @Excel(name = "供应商号")
    private String supplyHouse;

    /** 业务 */
    @Excel(name = "业务")
    private String business;

    /** 图纸日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "图纸日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date drawingTime;

    /** 封样日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "封样日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sealedSampleTime;

    /** 样件复检周期 */
    @Excel(name = "样件复检周期")
    private String sampleIndate;

    /** 样件到期日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "样件到期日期", width = 30, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date sealedSampleDue;

    /** 到今日还有（）天 */
    @Excel(name = "到今日还有（）天", readConverterExp = "到今日还有（）天",type = Excel.Type.EXPORT)
    private String remainingTime;

    /** 实际复检日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际复检日期", width = 30, dateFormat = "yyyy-MM-dd",type = Excel.Type.EXPORT)
    private Date recheckTime;

    /** 备注 */
    @Excel(name = "备注",type = Excel.Type.EXPORT)
    private String notes;

    /** 上传的图片 */
    @Excel(name = "上传的图片",type = Excel.Type.EXPORT)
    private String images;

    /** 创建时间 */
    @Excel(name = "创建时间",type = Excel.Type.EXPORT)
    private Date createTime;

    /** 修改时间 */
    @Excel(name = "修改时间",type = Excel.Type.EXPORT)
    private Date updateTime;

    /** sys_user表的外键 */
    @Excel(name = "sys_user表的外键")
    private Long userIid;


    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }




    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSealedSample(String sealedSample) 
    {
        this.sealedSample = sealedSample;
    }

    public String getSealedSample() 
    {
        return sealedSample;
    }
    public void setEightD(String eightD) 
    {
        this.eightD = eightD;
    }

    public String getEightD()
    {
        return eightD;
    }
    public void setSampleLocation(String sampleLocation) 
    {
        this.sampleLocation = sampleLocation;
    }

    public String getSampleLocation() 
    {
        return sampleLocation;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setSupplyHouse(String supplyHouse) 
    {
        this.supplyHouse = supplyHouse;
    }

    public String getSupplyHouse() 
    {
        return supplyHouse;
    }
    public void setBusiness(String business) 
    {
        this.business = business;
    }

    public String getBusiness() 
    {
        return business;
    }
    public void setDrawingTime(Date drawingTime) 
    {
        this.drawingTime = drawingTime;
    }

    public Date getDrawingTime() 
    {
        return drawingTime;
    }
    public void setSealedSampleTime(Date sealedSampleTime) 
    {
        this.sealedSampleTime = sealedSampleTime;
    }

    public Date getSealedSampleTime() 
    {
        return sealedSampleTime;
    }
    public void setSampleIndate(String sampleIndate)
    {
        this.sampleIndate = sampleIndate;
    }

    public String getSampleIndate()
    {
        return sampleIndate;
    }
    public void setSealedSampleDue(Date sealedSampleDue) 
    {
        this.sealedSampleDue = sealedSampleDue;
    }

    public Date getSealedSampleDue() 
    {
        return sealedSampleDue;
    }
    public void setRemainingTime(String remainingTime)
    {
        this.remainingTime = remainingTime;
    }

    public String getRemainingTime()
    {
        return remainingTime;
    }
    public void setRecheckTime(Date recheckTime) 
    {
        this.recheckTime = recheckTime;
    }

    public Date getRecheckTime() 
    {
        return recheckTime;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }
    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
    }

    public void setUserIid(Long userIid)
    {
        this.userIid = userIid;
    }

    public Long getUserIid()
    {
        return userIid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sealedSample", getSealedSample())
            .append("eightD", getEightD())
            .append("sampleLocation", getSampleLocation())
            .append("supplier", getSupplier())
            .append("supplyHouse", getSupplyHouse())
            .append("business", getBusiness())
            .append("drawingTime", getDrawingTime())
            .append("sealedSampleTime", getSealedSampleTime())
            .append("sampleIndate", getSampleIndate())
            .append("sealedSampleDue", getSealedSampleDue())
            .append("remainingTime", getRemainingTime())
            .append("recheckTime", getRecheckTime())
            .append("notes", getNotes())
            .append("images", getImages())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userIid", getUserIid())
            .toString();
    }

//    public void addAttribute(String itemList, List<SealedSample> itemList1) {
//    }


//    public void addAttribute(String list, List<SealedSample> list1) {
//    }
}
