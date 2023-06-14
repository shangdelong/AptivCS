package com.ruoyi.web.controller.cs;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.cs.domain.QaIssueTracking;
import com.ruoyi.cs.service.IQaIssueTrackingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 不合格追踪记录模块Controller
 * 
 * @author shangshang
 * @date 2023-06-14
 */
@Controller
@RequestMapping("/cs/tracking")
public class QaIssueTrackingController extends BaseController
{
    private String prefix = "cs/tracking";

    @Autowired
    private IQaIssueTrackingService qaIssueTrackingService;

    @RequiresPermissions("cs:tracking:view")
    @GetMapping()
    public String tracking()
    {
        return prefix + "/tracking";
    }

    /**
     * 查询不合格追踪记录模块列表
     */
    @RequiresPermissions("cs:tracking:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QaIssueTracking qaIssueTracking)
    {
        startPage();
        List<QaIssueTracking> list = qaIssueTrackingService.selectQaIssueTrackingList(qaIssueTracking);
        return getDataTable(list);
    }

    /**
     * 导出不合格追踪记录模块列表
     */
    @RequiresPermissions("cs:tracking:export")
    @Log(title = "不合格追踪记录模块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QaIssueTracking qaIssueTracking)
    {
        List<QaIssueTracking> list = qaIssueTrackingService.selectQaIssueTrackingList(qaIssueTracking);
        ExcelUtil<QaIssueTracking> util = new ExcelUtil<QaIssueTracking>(QaIssueTracking.class);
        return util.exportExcel(list, "不合格追踪记录模块数据");
    }

    /**
     * 新增不合格追踪记录模块
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存不合格追踪记录模块
     */
    @RequiresPermissions("cs:tracking:add")
    @Log(title = "不合格追踪记录模块", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QaIssueTracking qaIssueTracking)
    {
        return toAjax(qaIssueTrackingService.insertQaIssueTracking(qaIssueTracking));
    }

    /**
     * 修改不合格追踪记录模块
     */
    @RequiresPermissions("cs:tracking:edit")
    @GetMapping("/edit/{issueId}")
    public String edit(@PathVariable("issueId") Long issueId, ModelMap mmap)
    {
        QaIssueTracking qaIssueTracking = qaIssueTrackingService.selectQaIssueTrackingByIssueId(issueId);
        mmap.put("qaIssueTracking", qaIssueTracking);
        return prefix + "/edit";
    }

    /**
     * 修改保存不合格追踪记录模块
     */
    @RequiresPermissions("cs:tracking:edit")
    @Log(title = "不合格追踪记录模块", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QaIssueTracking qaIssueTracking)
    {
        return toAjax(qaIssueTrackingService.updateQaIssueTracking(qaIssueTracking));
    }

    /**
     * 删除不合格追踪记录模块
     */
    @RequiresPermissions("cs:tracking:remove")
    @Log(title = "不合格追踪记录模块", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qaIssueTrackingService.deleteQaIssueTrackingByIssueIds(ids));
    }
}
