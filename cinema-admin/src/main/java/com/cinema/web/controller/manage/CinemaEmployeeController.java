package com.cinema.web.controller.manage;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.cinema.manage.domain.CinemaHall;
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
import com.cinema.common.annotation.Log;
import com.cinema.common.core.controller.BaseController;
import com.cinema.common.core.domain.AjaxResult;
import com.cinema.common.enums.BusinessType;
import com.cinema.manage.domain.CinemaEmployee;
import com.cinema.manage.service.ICinemaEmployeeService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 员工管理Controller
 * 
 * @author cinema
 * @date 2021-12-11
 */
@RestController
@RequestMapping("/manage/employee")
public class CinemaEmployeeController extends BaseController
{
    @Autowired
    private ICinemaEmployeeService cinemaEmployeeService;

    /**
     * 查询员工管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:employee:list')")
    @GetMapping("/list")
    public TableDataInfo list(CinemaEmployee cinemaEmployee)
    {
        startPage();
        List<CinemaEmployee> list = cinemaEmployeeService.selectCinemaEmployeeList(cinemaEmployee);
        return getDataTable(list);
    }

    /**
     * 导出员工管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:employee:export')")
    @Log(title = "员工管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CinemaEmployee cinemaEmployee)
    {
        List<CinemaEmployee> list = cinemaEmployeeService.selectCinemaEmployeeList(cinemaEmployee);
        ExcelUtil<CinemaEmployee> util = new ExcelUtil<CinemaEmployee>(CinemaEmployee.class);
        util.exportExcel(response, list, "员工管理数据");
    }

    /**
     * 获取员工管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:employee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cinemaEmployeeService.selectCinemaEmployeeById(id));
    }

    /**
     * 新增员工管理
     */
    @PreAuthorize("@ss.hasPermi('manage:employee:add')")
    @Log(title = "员工管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CinemaEmployee cinemaEmployee)
    {
        return toAjax(cinemaEmployeeService.insertCinemaEmployee(cinemaEmployee));
    }


    /**
     * 修改员工管理
     */
    @PreAuthorize("@ss.hasPermi('manage:employee:edit')")
    @Log(title = "员工管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CinemaEmployee cinemaEmployee)
    {
        return toAjax(cinemaEmployeeService.updateCinemaEmployee(cinemaEmployee));
    }

    /**
     * 删除员工管理
     */
    @PreAuthorize("@ss.hasPermi('manage:employee:remove')")
    @Log(title = "员工管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cinemaEmployeeService.deleteCinemaEmployeeByIds(ids));
    }
}
