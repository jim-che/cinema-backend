package com.cinema.web.controller.monitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import com.cinema.system.mapper.SysOperLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cinema.common.annotation.Log;
import com.cinema.common.core.controller.BaseController;
import com.cinema.common.core.domain.AjaxResult;
import com.cinema.common.core.page.TableDataInfo;
import com.cinema.common.enums.BusinessType;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.system.domain.SysOperLog;
import com.cinema.system.service.ISysOperLogService;

/**
 * 操作日志记录
 * 
 * @author cinema
 */
@RestController
@RequestMapping("/monitor/operlog")
public class SysOperlogController extends BaseController
{

    private final Map<Integer, String> map = new HashMap<>();
    {
        map.put(1, "/manage");
        map.put(2, "/ticket");
        map.put(3, "/person");
        map.put(4, "/session");
        map.put(5, "/movie");
        map.put(6, "/compensation");
    }
    @Autowired
    private ISysOperLogService operLogService;

    @Resource
    private SysOperLogMapper sysOperLogMapper;

    @PreAuthorize("@ss.hasPermi('monitor:operlog:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysOperLog operLog)
    {
        startPage();
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('monitor:operlog:list')")
    @GetMapping("/listByName")
    public TableDataInfo listByName(@PathParam("name") String name){
        startPage();
        List<SysOperLog> logs = sysOperLogMapper.selectLogByName(map.get(Integer.parseInt(name)));
        System.out.println((map.get(Integer.parseInt(name))));
        return getDataTable(logs);
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOperLog operLog)
    {
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        util.exportExcel(response, list, "操作日志");
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/{operIds}")
    public AjaxResult remove(@PathVariable Long[] operIds)
    {
        return toAjax(operLogService.deleteOperLogByIds(operIds));
    }

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/clean")
    public AjaxResult clean()
    {
        operLogService.cleanOperLog();
        return AjaxResult.success();
    }
}
