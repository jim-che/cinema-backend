package com.cinema.web.controller.compensation;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.person.domain.PersonEmployee;
import com.cinema.person.mapper.PersonEmployeeMapper;
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
import com.cinema.compensation.domain.CompensationOvertime;
import com.cinema.compensation.service.ICompensationOvertimeService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 加班薪资管理Controller
 * 
 * @author cinema
 * @date 2021-12-11
 */
@RestController
@RequestMapping("/compensation/overtime")
public class CompensationOvertimeController extends BaseController
{
    @Autowired
    private ICompensationOvertimeService compensationOvertimeService;

    @Resource
    private PersonEmployeeMapper personEmployeeMapper;

    /**
     * 查询加班薪资管理列表
     */
    @PreAuthorize("@ss.hasPermi('compensation:overtime:list')")
    @GetMapping("/list")
    public TableDataInfo list(CompensationOvertime compensationOvertime)
    {
        startPage();
        List<CompensationOvertime> list = compensationOvertimeService.selectCompensationOvertimeList(compensationOvertime);
        return getDataTable(list);
    }

    /**
     * 导出加班薪资管理列表
     */
    @PreAuthorize("@ss.hasPermi('compensation:overtime:export')")
    @Log(title = "加班薪资管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CompensationOvertime compensationOvertime)
    {
        List<CompensationOvertime> list = compensationOvertimeService.selectCompensationOvertimeList(compensationOvertime);
        ExcelUtil<CompensationOvertime> util = new ExcelUtil<CompensationOvertime>(CompensationOvertime.class);
        util.exportExcel(response, list, "加班薪资管理数据");
    }

    /**
     * 获取加班薪资管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('compensation:overtime:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(compensationOvertimeService.selectCompensationOvertimeById(id));
    }

    /**
     * 新增加班薪资管理
     */
    @PreAuthorize("@ss.hasPermi('compensation:overtime:add')")
    @Log(title = "加班薪资管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CompensationOvertime compensationOvertime)
    {
        List<PersonEmployee> personEmployees = personEmployeeMapper.selectPersonEmployeeList(null);
        boolean flag = false;
        for (PersonEmployee personEmployee : personEmployees) {
            if(personEmployee.getEmployeeId().equals(compensationOvertime.getEmployeeId())){
                flag = true;
                compensationOvertime.setEmployeeName(personEmployee.getName());
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("员工编号不存在");
        }

        return toAjax(compensationOvertimeService.insertCompensationOvertime(compensationOvertime));
    }

    /**
     * 修改加班薪资管理
     */
    @PreAuthorize("@ss.hasPermi('compensation:overtime:edit')")
    @Log(title = "加班薪资管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CompensationOvertime compensationOvertime)
    {
        return toAjax(compensationOvertimeService.updateCompensationOvertime(compensationOvertime));
    }

    /**
     * 删除加班薪资管理
     */
    @PreAuthorize("@ss.hasPermi('compensation:overtime:remove')")
    @Log(title = "加班薪资管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(compensationOvertimeService.deleteCompensationOvertimeByIds(ids));
    }
}
