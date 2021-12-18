package com.cinema.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.manage.mapper.CinemaEmployeeMapper;
import com.cinema.manage.domain.CinemaEmployee;
import com.cinema.manage.service.ICinemaEmployeeService;

/**
 * 员工管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-11
 */
@Service
public class CinemaEmployeeServiceImpl implements ICinemaEmployeeService 
{
    @Autowired
    private CinemaEmployeeMapper cinemaEmployeeMapper;

    /**
     * 查询员工管理
     * 
     * @param id 员工管理主键
     * @return 员工管理
     */
    @Override
    public CinemaEmployee selectCinemaEmployeeById(Long id)
    {
        return cinemaEmployeeMapper.selectCinemaEmployeeById(id);
    }

    /**
     * 查询员工管理列表
     * 
     * @param cinemaEmployee 员工管理
     * @return 员工管理
     */
    @Override
    public List<CinemaEmployee> selectCinemaEmployeeList(CinemaEmployee cinemaEmployee)
    {
        return cinemaEmployeeMapper.selectCinemaEmployeeList(cinemaEmployee);
    }

    /**
     * 新增员工管理
     * 
     * @param cinemaEmployee 员工管理
     * @return 结果
     */
    @Override
    public int insertCinemaEmployee(CinemaEmployee cinemaEmployee)
    {
        return cinemaEmployeeMapper.insertCinemaEmployee(cinemaEmployee);
    }

    /**
     * 修改员工管理
     * 
     * @param cinemaEmployee 员工管理
     * @return 结果
     */
    @Override
    public int updateCinemaEmployee(CinemaEmployee cinemaEmployee)
    {
        return cinemaEmployeeMapper.updateCinemaEmployee(cinemaEmployee);
    }

    /**
     * 批量删除员工管理
     * 
     * @param ids 需要删除的员工管理主键
     * @return 结果
     */
    @Override
    public int deleteCinemaEmployeeByIds(Long[] ids)
    {
        return cinemaEmployeeMapper.deleteCinemaEmployeeByIds(ids);
    }

    /**
     * 删除员工管理信息
     * 
     * @param id 员工管理主键
     * @return 结果
     */
    @Override
    public int deleteCinemaEmployeeById(Long id)
    {
        return cinemaEmployeeMapper.deleteCinemaEmployeeById(id);
    }
}
