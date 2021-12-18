package com.cinema.compensation.service;

import java.util.List;
import com.cinema.compensation.domain.CompensationBonus;

/**
 * 全勤奖金管理Service接口
 * 
 * @author cinema
 * @date 2021-12-13
 */
public interface ICompensationBonusService 
{
    /**
     * 查询全勤奖金管理
     * 
     * @param id 全勤奖金管理主键
     * @return 全勤奖金管理
     */
    public CompensationBonus selectCompensationBonusById(Long id);

    /**
     * 查询全勤奖金管理列表
     * 
     * @param compensationBonus 全勤奖金管理
     * @return 全勤奖金管理集合
     */
    public List<CompensationBonus> selectCompensationBonusList(CompensationBonus compensationBonus);

    /**
     * 新增全勤奖金管理
     * 
     * @param compensationBonus 全勤奖金管理
     * @return 结果
     */
    public int insertCompensationBonus(CompensationBonus compensationBonus);

    /**
     * 修改全勤奖金管理
     * 
     * @param compensationBonus 全勤奖金管理
     * @return 结果
     */
    public int updateCompensationBonus(CompensationBonus compensationBonus);

    /**
     * 批量删除全勤奖金管理
     * 
     * @param ids 需要删除的全勤奖金管理主键集合
     * @return 结果
     */
    public int deleteCompensationBonusByIds(Long[] ids);

    /**
     * 删除全勤奖金管理信息
     * 
     * @param id 全勤奖金管理主键
     * @return 结果
     */
    public int deleteCompensationBonusById(Long id);
}
