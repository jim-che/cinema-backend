package com.cinema.compensation.service;

import java.util.List;
import com.cinema.compensation.domain.CompensationBase;

/**
 * 基本工资管理Service接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface ICompensationBaseService 
{
    /**
     * 查询基本工资管理
     * 
     * @param id 基本工资管理主键
     * @return 基本工资管理
     */
    public CompensationBase selectCompensationBaseById(Long id);

    /**
     * 查询基本工资管理列表
     * 
     * @param compensationBase 基本工资管理
     * @return 基本工资管理集合
     */
    public List<CompensationBase> selectCompensationBaseList(CompensationBase compensationBase);

    /**
     * 新增基本工资管理
     * 
     * @param compensationBase 基本工资管理
     * @return 结果
     */
    public int insertCompensationBase(CompensationBase compensationBase);

    /**
     * 修改基本工资管理
     * 
     * @param compensationBase 基本工资管理
     * @return 结果
     */
    public int updateCompensationBase(CompensationBase compensationBase);

    /**
     * 批量删除基本工资管理
     * 
     * @param ids 需要删除的基本工资管理主键集合
     * @return 结果
     */
    public int deleteCompensationBaseByIds(Long[] ids);

    /**
     * 删除基本工资管理信息
     * 
     * @param id 基本工资管理主键
     * @return 结果
     */
    public int deleteCompensationBaseById(Long id);
}
