package com.cinema.manage.service;

import java.util.List;
import com.cinema.manage.domain.CinemaEmployee;

/**
 * 员工管理Service接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface ICinemaEmployeeService 
{
    /**
     * 查询员工管理
     * 
     * @param id 员工管理主键
     * @return 员工管理
     */
    public CinemaEmployee selectCinemaEmployeeById(Long id);

    /**
     * 查询员工管理列表
     * 
     * @param cinemaEmployee 员工管理
     * @return 员工管理集合
     */
    public List<CinemaEmployee> selectCinemaEmployeeList(CinemaEmployee cinemaEmployee);

    /**
     * 新增员工管理
     * 
     * @param cinemaEmployee 员工管理
     * @return 结果
     */
    public int insertCinemaEmployee(CinemaEmployee cinemaEmployee);

    /**
     * 修改员工管理
     * 
     * @param cinemaEmployee 员工管理
     * @return 结果
     */
    public int updateCinemaEmployee(CinemaEmployee cinemaEmployee);

    /**
     * 批量删除员工管理
     * 
     * @param ids 需要删除的员工管理主键集合
     * @return 结果
     */
    public int deleteCinemaEmployeeByIds(Long[] ids);

    /**
     * 删除员工管理信息
     * 
     * @param id 员工管理主键
     * @return 结果
     */
    public int deleteCinemaEmployeeById(Long id);
}
