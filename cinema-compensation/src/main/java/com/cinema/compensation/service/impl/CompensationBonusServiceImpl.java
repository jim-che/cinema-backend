package com.cinema.compensation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.compensation.mapper.CompensationBonusMapper;
import com.cinema.compensation.domain.CompensationBonus;
import com.cinema.compensation.service.ICompensationBonusService;

/**
 * 全勤奖金管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-13
 */
@Service
public class CompensationBonusServiceImpl implements ICompensationBonusService 
{
    @Autowired
    private CompensationBonusMapper compensationBonusMapper;

    /**
     * 查询全勤奖金管理
     * 
     * @param id 全勤奖金管理主键
     * @return 全勤奖金管理
     */
    @Override
    public CompensationBonus selectCompensationBonusById(Long id)
    {
        return compensationBonusMapper.selectCompensationBonusById(id);
    }

    /**
     * 查询全勤奖金管理列表
     * 
     * @param compensationBonus 全勤奖金管理
     * @return 全勤奖金管理
     */
    @Override
    public List<CompensationBonus> selectCompensationBonusList(CompensationBonus compensationBonus)
    {
        return compensationBonusMapper.selectCompensationBonusList(compensationBonus);
    }

    /**
     * 新增全勤奖金管理
     * 
     * @param compensationBonus 全勤奖金管理
     * @return 结果
     */
    @Override
    public int insertCompensationBonus(CompensationBonus compensationBonus)
    {
        return compensationBonusMapper.insertCompensationBonus(compensationBonus);
    }

    /**
     * 修改全勤奖金管理
     * 
     * @param compensationBonus 全勤奖金管理
     * @return 结果
     */
    @Override
    public int updateCompensationBonus(CompensationBonus compensationBonus)
    {
        return compensationBonusMapper.updateCompensationBonus(compensationBonus);
    }

    /**
     * 批量删除全勤奖金管理
     * 
     * @param ids 需要删除的全勤奖金管理主键
     * @return 结果
     */
    @Override
    public int deleteCompensationBonusByIds(Long[] ids)
    {
        return compensationBonusMapper.deleteCompensationBonusByIds(ids);
    }

    /**
     * 删除全勤奖金管理信息
     * 
     * @param id 全勤奖金管理主键
     * @return 结果
     */
    @Override
    public int deleteCompensationBonusById(Long id)
    {
        return compensationBonusMapper.deleteCompensationBonusById(id);
    }
}
