package com.ruoyi.web.controller.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.web.controller.system.SysProfileController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.cs.domain.SealedSample;
import com.ruoyi.cs.service.ISealedSampleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 封样件的管理Controller
 * 
 * @author shangshang
 * @date 2023-05-23
 */
@Controller
@RequestMapping("/cs/sample")
public class SealedSampleController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(SealedSampleController.class);
    private String prefix = "cs/sample";

    @Autowired
    private ISealedSampleService sealedSampleService;

    @RequiresPermissions("cs:sample:view")
    @GetMapping()
    public String sample()
    {
        return prefix + "/sample";
    }

    /**
     * 查询封样件的管理列表
     */
    @RequiresPermissions("cs:sample:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SealedSample sealedSample)
    {
        startPage();
        List<SealedSample> list = sealedSampleService.selectSealedSampleList(sealedSample);
//        sealedSample.addAttribute("list", list);//增加
        return getDataTable(list);
    }

    /**
     * 查询到期封样件的列表
     */
//    @RequiresPermissions("cs:sample:list")
//    @PostMapping("/list")
//    @ResponseBody
//    public TableDataInfo dueList(SealedSample sealedSample)
//    {
//        startPage();
//        List<SealedSample> list = sealedSampleService.selectSealedSampleDueList(sealedSample);
////        sealedSample.addAttribute("list", list);//增加
//        return getDataTable(list);
//    }


    /**
     * 导出封样件的管理列表
     */
    @RequiresPermissions("cs:sample:export")
    @Log(title = "封样件的管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SealedSample sealedSample)
    {
        List<SealedSample> list = sealedSampleService.selectSealedSampleList(sealedSample);
        ExcelUtil<SealedSample> util = new ExcelUtil<SealedSample>(SealedSample.class);
        return util.exportExcel(list, "封样件的管理数据");
    }

    @Log(title = "封样件的管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("cs:sample:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SealedSample> util = new ExcelUtil<SealedSample>(SealedSample.class);
        List<SealedSample> sampleList = util.importExcel(file.getInputStream());
        String message = sealedSampleService.importSample(sampleList, updateSupport, getLoginName());
        return AjaxResult.success(message);
    }

//    private String getEightD() {
//        return getEightD();
//    }


    @RequiresPermissions("cs:sample:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.importTemplateExcel("用户数据");
    }

    /**
     * 新增封样件的管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存封样件的管理
     */
    @RequiresPermissions("cs:sample:add")
    @Log(title = "封样件的管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SealedSample sealedSample)
    {
        return toAjax(sealedSampleService.insertSealedSample(sealedSample));
    }

    /**
     * 修改封样件的管理
     */
    @RequiresPermissions("cs:sample:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SealedSample sealedSample = sealedSampleService.selectSealedSampleById(id);
        mmap.put("sealedSample", sealedSample);
        return prefix + "/edit";
    }

    /**
     * 修改保存封样件的管理
     */
    @RequiresPermissions("cs:sample:edit")
    @Log(title = "封样件的管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SealedSample sealedSample)
    {

        return toAjax(sealedSampleService.updateSealedSample(sealedSample));
    }

    /**
     * 删除封样件的管理
     */
    @RequiresPermissions("cs:sample:remove")
    @Log(title = "封样件的管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sealedSampleService.deleteSealedSampleByIds(ids));
    }

//    @RequiresPermissions("cs:sample:getData")
//    @RequestMapping("/getData")
//    @ResponseBody
//    public List<Map<String, Object>> getData() {
//        List<Map<String, Object>> dataList = new ArrayList<>();
//        try {
//            // 这里使用JdbcTemplate连接数据库进行查询
//            String sql = "SELECT id, name FROM table";
//            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
//            dataList.addAll(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dataList;
//    }

//    @GetMapping("/showItems")
//    public String showItems(SealedSample sealedSample) {
//        List<SealedSample> itemList = sealedSampleService.findAllItems();
//        sealedSample.addAttribute("itemList", itemList);
//        return "show_items";
//    }

}
