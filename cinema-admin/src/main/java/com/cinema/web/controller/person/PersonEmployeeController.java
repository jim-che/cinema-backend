package com.cinema.web.controller.person;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.manage.domain.CinemaInfo;
import com.cinema.manage.mapper.CinemaInfoMapper;
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
import com.cinema.person.domain.PersonEmployee;
import com.cinema.person.service.IPersonEmployeeService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 员工管理Controller
 * 
 * @author cinema
 * @date 2021-12-11
 */
@RestController
@RequestMapping("/person/employee")
public class PersonEmployeeController extends BaseController
{
    @Autowired
    private IPersonEmployeeService personEmployeeService;

    @Resource
    private PersonEmployeeMapper personEmployeeMapper;

    @Resource
    private CinemaInfoMapper cinemaInfoMapper;

    /**
     * 查询员工管理列表
     */
    @PreAuthorize("@ss.hasPermi('person:employee:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonEmployee personEmployee)
    {
        startPage();
        List<PersonEmployee> list = personEmployeeService.selectPersonEmployeeList(personEmployee);
        return getDataTable(list);
    }

    /**
     * 导出员工管理列表
     */
    @PreAuthorize("@ss.hasPermi('person:employee:export')")
    @Log(title = "员工管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonEmployee personEmployee)
    {
        List<PersonEmployee> list = personEmployeeService.selectPersonEmployeeList(personEmployee);
        ExcelUtil<PersonEmployee> util = new ExcelUtil<PersonEmployee>(PersonEmployee.class);
        util.exportExcel(response, list, "员工管理数据");
    }

    /**
     * 获取员工管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('person:employee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(personEmployeeService.selectPersonEmployeeById(id));
    }

    /**
     * 新增员工管理
     */
    @PreAuthorize("@ss.hasPermi('person:employee:add')")
    @Log(title = "员工管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonEmployee personEmployee)
    {
        List<CinemaInfo> cinemaInfos = cinemaInfoMapper.selectCinemaInfoList(null);
        boolean flag = false;
        for (CinemaInfo cinemaInfo : cinemaInfos) {
            if(cinemaInfo.getCinemaId().equals(personEmployee.getCinemaId())){
                flag = true;
                personEmployee.setCinemaName(cinemaInfo.getName());
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("影院编号不正确!");
        }
        personEmployee.setEmployeeId(generateEmployeeId(personEmployee.getCinemaId()));
        return toAjax(personEmployeeService.insertPersonEmployee(personEmployee));
    }


    public String generateEmployeeId(String cinemaId){
        List<PersonEmployee> personEmployees = personEmployeeMapper.selectPersonEmployeeByCinemaId(cinemaId);
        if(personEmployees.size()==0){
            return cinemaId + "YG0001";
        }

        int num = Integer.parseInt(personEmployees.get(personEmployees.size() - 1).getEmployeeId().substring(8, 11)) + 1;

        return cinemaId + "YG" + String.format("0%4d", num);
    }

    /**
     * 修改员工管理
     */
    @PreAuthorize("@ss.hasPermi('person:employee:edit')")
    @Log(title = "员工管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonEmployee personEmployee)
    {
        return toAjax(personEmployeeService.updatePersonEmployee(personEmployee));
    }

    /**
     * 删除员工管理
     */
    @PreAuthorize("@ss.hasPermi('person:employee:remove')")
    @Log(title = "员工管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(personEmployeeService.deletePersonEmployeeByIds(ids));
    }
}
