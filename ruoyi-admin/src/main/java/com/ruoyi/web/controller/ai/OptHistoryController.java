package com.ruoyi.web.controller.ai;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.OptHistory;
import com.ruoyi.system.service.IOptHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户历史操作记录图Controller
 * 
 * @author ruoyi
 * @date 2025-03-09
 */
@RestController
@RequestMapping("/ai/history")
public class OptHistoryController extends BaseController
{
    @Autowired
    private IOptHistoryService optHistoryService;

    /**
     * 查询用户历史操作记录图列表
     */
    @GetMapping("/list")
    public TableDataInfo list(OptHistory optHistory)
    {
        startPage();
        List<OptHistory> list = optHistoryService.selectOptHistoryList(optHistory);
        return getDataTable(list);
    }

    /**
     * 导出用户历史操作记录图列表
     */
    @Log(title = "用户历史操作记录图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OptHistory optHistory)
    {
        List<OptHistory> list = optHistoryService.selectOptHistoryList(optHistory);
        ExcelUtil<OptHistory> util = new ExcelUtil<OptHistory>(OptHistory.class);
        util.exportExcel(response, list, "用户历史操作记录图数据");
    }

    /**
     * 获取用户历史操作记录图详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(optHistoryService.selectOptHistoryById(id));
    }

    /**
     * 新增用户历史操作记录图
     */
    @Log(title = "用户历史操作记录图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OptHistory optHistory)
    {
        return toAjax(optHistoryService.insertOptHistory(optHistory));
    }

    /**
     * 修改用户历史操作记录图
     */
    @Log(title = "用户历史操作记录图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OptHistory optHistory)
    {
        return toAjax(optHistoryService.updateOptHistory(optHistory));
    }

    /**
     * 删除用户历史操作记录图
     */
    @Log(title = "用户历史操作记录图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(optHistoryService.deleteOptHistoryByIds(ids));
    }
}
