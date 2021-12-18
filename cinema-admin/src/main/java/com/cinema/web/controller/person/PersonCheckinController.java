package com.cinema.web.controller.person;

import java.math.BigDecimal;
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
import com.cinema.person.domain.PersonCheckin;
import com.cinema.person.service.IPersonCheckinService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 考勤管理Controller
 * 
 * @author cinema
 * @date 2021-12-11
 */
@RestController
@RequestMapping("/person/checkin")
public class PersonCheckinController extends BaseController
{
    @Autowired
    private IPersonCheckinService personCheckinService;

    @Resource
    private PersonEmployeeMapper personEmployeeMapper;

    /**
     * 查询考勤管理列表
     */
    @PreAuthorize("@ss.hasPermi('person:checkin:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonCheckin personCheckin)
    {
        startPage();
        List<PersonCheckin> list = personCheckinService.selectPersonCheckinList(personCheckin);
        return getDataTable(list);
    }

    /**
     * 导出考勤管理列表
     */
    @PreAuthorize("@ss.hasPermi('person:checkin:export')")
    @Log(title = "考勤管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonCheckin personCheckin)
    {
        List<PersonCheckin> list = personCheckinService.selectPersonCheckinList(personCheckin);
        ExcelUtil<PersonCheckin> util = new ExcelUtil<PersonCheckin>(PersonCheckin.class);
        util.exportExcel(response, list, "考勤管理数据");
    }

    /**
     * 获取考勤管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('person:checkin:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(personCheckinService.selectPersonCheckinById(id));
    }

    /**
     * 新增考勤管理
     */
    @PreAuthorize("@ss.hasPermi('person:checkin:add')")
    @Log(title = "考勤管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonCheckin personCheckin)
    {
        List<PersonEmployee> personEmployees = personEmployeeMapper.selectPersonEmployeeList(null);
        boolean flag = false;
        for (PersonEmployee personEmployee : personEmployees) {
            if(personEmployee.getEmployeeId().equals(personCheckin.getEmployeeId())){
                flag = true;
                personCheckin.setEmployeeName(personEmployee.getName());
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("员工编号不正确");
        }
        personCheckin.setAttendanceRate(BigDecimal.valueOf(personCheckin.getAttendanceTime() * 100 / 25));
        return toAjax(personCheckinService.insertPersonCheckin(personCheckin));
    }

    /**
     * 修改考勤管理
     */
    @PreAuthorize("@ss.hasPermi('person:checkin:edit')")
    @Log(title = "考勤管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonCheckin personCheckin)
    {
        return toAjax(personCheckinService.updatePersonCheckin(personCheckin));
    }

    /**
     * 删除考勤管理
     */
    @PreAuthorize("@ss.hasPermi('person:checkin:remove')")
    @Log(title = "考勤管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(personCheckinService.deletePersonCheckinByIds(ids));
    }
}
