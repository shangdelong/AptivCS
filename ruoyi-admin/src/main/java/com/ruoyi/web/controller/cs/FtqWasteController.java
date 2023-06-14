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
import com.ruoyi.cs.domain.FtqWaste;
import com.ruoyi.cs.service.IFtqWasteService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * FTQ废品统计模块Controller
 * 
 * @author shangshang
 * @date 2023-06-14
 */
@Controller
@RequestMapping("/cs/waste")
public class FtqWasteController extends BaseController
{
    private String prefix = "cs/waste";

    @Autowired
    private IFtqWasteService ftqWasteService;

    @RequiresPermissions("cs:waste:view")
    @GetMapping()
    public String waste()
    {
        return prefix + "/waste";
    }

    /**
     * 查询FTQ废品统计模块列表
     */
    @RequiresPermissions("cs:waste:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FtqWaste ftqWaste)
    {
        startPage();
        List<FtqWaste> list = ftqWasteService.selectFtqWasteList(ftqWaste);
        return getDataTable(list);
    }

    /**
     * 导出FTQ废品统计模块列表
     */
    @RequiresPermissions("cs:waste:export")
    @Log(title = "FTQ废品统计模块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FtqWaste ftqWaste)
    {
        List<FtqWaste> list = ftqWasteService.selectFtqWasteList(ftqWaste);
        ExcelUtil<FtqWaste> util = new ExcelUtil<FtqWaste>(FtqWaste.class);
        return util.exportExcel(list, "FTQ废品统计模块数据");
    }

    /**
     * 新增FTQ废品统计模块
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存FTQ废品统计模块
     */
    @RequiresPermissions("cs:waste:add")
    @Log(title = "FTQ废品统计模块", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FtqWaste ftqWaste)
    {
        return toAjax(ftqWasteService.insertFtqWaste(ftqWaste));
    }

    /**
     * 修改FTQ废品统计模块
     */
    @RequiresPermissions("cs:waste:edit")
    @GetMapping("/edit/{ftqId}")
    public String edit(@PathVariable("ftqId") Long ftqId, ModelMap mmap)
    {
        FtqWaste ftqWaste = ftqWasteService.selectFtqWasteByFtqId(ftqId);
        mmap.put("ftqWaste", ftqWaste);
        return prefix + "/edit";
    }

    /**
     * 修改保存FTQ废品统计模块
     */
    @RequiresPermissions("cs:waste:edit")
    @Log(title = "FTQ废品统计模块", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FtqWaste ftqWaste)
    {
        return toAjax(ftqWasteService.updateFtqWaste(ftqWaste));
    }

    /**
     * 删除FTQ废品统计模块
     */
    @RequiresPermissions("cs:waste:remove")
    @Log(title = "FTQ废品统计模块", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ftqWasteService.deleteFtqWasteByFtqIds(ids));
    }
}
