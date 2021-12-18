package com.cinema.person.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.person.mapper.PersonEmployeeMapper;
import com.cinema.person.domain.PersonEmployee;
import com.cinema.person.service.IPersonEmployeeService;

/**
 * 员工管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-11
 */
@Service
public class PersonEmployeeServiceImpl implements IPersonEmployeeService 
{
    @Autowired
    private PersonEmployeeMapper personEmployeeMapper;

    /**
     * 查询员工管理
     * 
     * @param id 员工管理主键
     * @return 员工管理
     */
    @Override
    public PersonEmployee selectPersonEmployeeById(Long id)
    {
        return personEmployeeMapper.selectPersonEmployeeById(id);
    }

    /**
     * 查询员工管理列表
     * 
     * @param personEmployee 员工管理
     * @return 员工管理
     */
    @Override
    public List<PersonEmployee> selectPersonEmployeeList(PersonEmployee personEmployee)
    {
        return personEmployeeMapper.selectPersonEmployeeList(personEmployee);
    }

    /**
     * 新增员工管理
     * 
     * @param personEmployee 员工管理
     * @return 结果
     */
    @Override
    public int insertPersonEmployee(PersonEmployee personEmployee)
    {
        return personEmployeeMapper.insertPersonEmployee(personEmployee);
    }

    /**
     * 修改员工管理
     * 
     * @param personEmployee 员工管理
     * @return 结果
     */
    @Override
    public int updatePersonEmployee(PersonEmployee personEmployee)
    {
        return personEmployeeMapper.updatePersonEmployee(personEmployee);
    }

    /**
     * 批量删除员工管理
     * 
     * @param ids 需要删除的员工管理主键
     * @return 结果
     */
    @Override
    public int deletePersonEmployeeByIds(Long[] ids)
    {
        return personEmployeeMapper.deletePersonEmployeeByIds(ids);
    }

    /**
     * 删除员工管理信息
     * 
     * @param id 员工管理主键
     * @return 结果
     */
    @Override
    public int deletePersonEmployeeById(Long id)
    {
        return personEmployeeMapper.deletePersonEmployeeById(id);
    }
}
