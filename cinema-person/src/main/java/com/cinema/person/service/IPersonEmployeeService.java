package com.cinema.person.service;

import java.util.List;
import com.cinema.person.domain.PersonEmployee;

/**
 * 员工管理Service接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface IPersonEmployeeService 
{
    /**
     * 查询员工管理
     * 
     * @param id 员工管理主键
     * @return 员工管理
     */
    public PersonEmployee selectPersonEmployeeById(Long id);

    /**
     * 查询员工管理列表
     * 
     * @param personEmployee 员工管理
     * @return 员工管理集合
     */
    public List<PersonEmployee> selectPersonEmployeeList(PersonEmployee personEmployee);

    /**
     * 新增员工管理
     * 
     * @param personEmployee 员工管理
     * @return 结果
     */
    public int insertPersonEmployee(PersonEmployee personEmployee);

    /**
     * 修改员工管理
     * 
     * @param personEmployee 员工管理
     * @return 结果
     */
    public int updatePersonEmployee(PersonEmployee personEmployee);

    /**
     * 批量删除员工管理
     * 
     * @param ids 需要删除的员工管理主键集合
     * @return 结果
     */
    public int deletePersonEmployeeByIds(Long[] ids);

    /**
     * 删除员工管理信息
     * 
     * @param id 员工管理主键
     * @return 结果
     */
    public int deletePersonEmployeeById(Long id);
}
