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
import com.cinema.compensation.domain.CompensationBase;
import com.cinema.compensation.service.ICompensationBaseService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 基本工资管理Controller
 * 
 * @author cinema
 * @date 2021-12-11
 */
@RestController
@RequestMapping("/compensation/base")
public class CompensationBaseController extends BaseController
{
    @Resource
    private ICompensationBaseService compensationBaseService;

    @Resource
    private PersonEmployeeMapper personEmployeeMapper;

    /**
     * 查询基本工资管理列表
     */
    @PreAuthorize("@ss.hasPermi('compensation:base:list')")
    @GetMapping("/list")
    public TableDataInfo list(CompensationBase compensationBase)
    {
        startPage();
        List<CompensationBase> list = compensationBaseService.selectCompensationBaseList(compensationBase);
        return getDataTable(list);
    }

    /**
     * 导出基本工资管理列表
     */
    @PreAuthorize("@ss.hasPermi('compensation:base:export')")
    @Log(title = "基本工资管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CompensationBase compensationBase)
    {
        List<CompensationBase> list = compensationBaseService.selectCompensationBaseList(compensationBase);
        ExcelUtil<CompensationBase> util = new ExcelUtil<CompensationBase>(CompensationBase.class);
        util.exportExcel(response, list, "基本工资管理数据");
    }

    /**
     * 获取基本工资管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('compensation:base:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(compensationBaseService.selectCompensationBaseById(id));
    }

    /**
     * 新增基本工资管理
     */
    @PreAuthorize("@ss.hasPermi('compensation:base:add')")
    @Log(title = "基本工资管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CompensationBase compensationBase)
    {
        boolean flag = false;
        List<PersonEmployee> personEmployees = personEmployeeMapper.selectPersonEmployeeList(null);
        for (PersonEmployee personEmployee : personEmployees) {
            if(personEmployee.getEmployeeId().equals(compensationBase.getEmployeeId())){
                flag = true;
                compensationBase.setEmployeeName(personEmployee.getName());
                compensationBase.setEmployeeType(personEmployee.getEmployeeType().toString());
                compensationBase.setSalary(personEmployee.getSalary());
                break;
            }
        }
        return toAjax(compensationBaseService.insertCompensationBase(compensationBase));
    }

    /**
     * 修改基本工资管理
     */
    @PreAuthorize("@ss.hasPermi('compensation:base:edit')")
    @Log(title = "基本工资管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CompensationBase compensationBase)
    {
        return toAjax(compensationBaseService.updateCompensationBase(compensationBase));
    }

    /**
     * 删除基本工资管理
     */
    @PreAuthorize("@ss.hasPermi('compensation:base:remove')")
    @Log(title = "基本工资管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(compensationBaseService.deleteCompensationBaseByIds(ids));
    }
}
