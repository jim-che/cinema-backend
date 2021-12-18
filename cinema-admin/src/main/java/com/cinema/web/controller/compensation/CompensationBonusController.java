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
import com.cinema.compensation.domain.CompensationBonus;
import com.cinema.compensation.service.ICompensationBonusService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 全勤奖金管理Controller
 * 
 * @author cinema
 * @date 2021-12-13
 */
@RestController
@RequestMapping("/compensation/bonus")
public class CompensationBonusController extends BaseController
{
    @Autowired
    private ICompensationBonusService compensationBonusService;

    @Resource
    private PersonEmployeeMapper personEmployeeMapper;

    /**
     * 查询全勤奖金管理列表
     */
    @PreAuthorize("@ss.hasPermi('compensation:bonus:list')")
    @GetMapping("/list")
    public TableDataInfo list(CompensationBonus compensationBonus)
    {
        startPage();
        List<CompensationBonus> list = compensationBonusService.selectCompensationBonusList(compensationBonus);
        return getDataTable(list);
    }

    /**
     * 导出全勤奖金管理列表
     */
    @PreAuthorize("@ss.hasPermi('compensation:bonus:export')")
    @Log(title = "全勤奖金管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CompensationBonus compensationBonus)
    {
        List<CompensationBonus> list = compensationBonusService.selectCompensationBonusList(compensationBonus);
        ExcelUtil<CompensationBonus> util = new ExcelUtil<CompensationBonus>(CompensationBonus.class);
        util.exportExcel(response, list, "全勤奖金管理数据");
    }

    /**
     * 获取全勤奖金管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('compensation:bonus:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(compensationBonusService.selectCompensationBonusById(id));
    }

    /**
     * 新增全勤奖金管理
     */
    @PreAuthorize("@ss.hasPermi('compensation:bonus:add')")
    @Log(title = "全勤奖金管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CompensationBonus compensationBonus)
    {
        List<PersonEmployee> personEmployees = personEmployeeMapper.selectPersonEmployeeList(null);
        boolean flag = false;

        for (PersonEmployee personEmployee : personEmployees) {
            if(personEmployee.getEmployeeId().equals(compensationBonus.getEmployeeId())){
                flag = true;
                compensationBonus.setEmployeeName(personEmployee.getName());
                break;
            }
        }


        return toAjax(compensationBonusService.insertCompensationBonus(compensationBonus));
    }

    /**
     * 修改全勤奖金管理
     */
    @PreAuthorize("@ss.hasPermi('compensation:bonus:edit')")
    @Log(title = "全勤奖金管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CompensationBonus compensationBonus)
    {
        return toAjax(compensationBonusService.updateCompensationBonus(compensationBonus));
    }

    /**
     * 删除全勤奖金管理
     */
    @PreAuthorize("@ss.hasPermi('compensation:bonus:remove')")
    @Log(title = "全勤奖金管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(compensationBonusService.deleteCompensationBonusByIds(ids));
    }
}
