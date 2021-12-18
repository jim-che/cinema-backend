package com.cinema.compensation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.compensation.mapper.CompensationBaseMapper;
import com.cinema.compensation.domain.CompensationBase;
import com.cinema.compensation.service.ICompensationBaseService;

/**
 * 基本工资管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-11
 */
@Service
public class CompensationBaseServiceImpl implements ICompensationBaseService 
{
    @Autowired
    private CompensationBaseMapper compensationBaseMapper;

    /**
     * 查询基本工资管理
     * 
     * @param id 基本工资管理主键
     * @return 基本工资管理
     */
    @Override
    public CompensationBase selectCompensationBaseById(Long id)
    {
        return compensationBaseMapper.selectCompensationBaseById(id);
    }

    /**
     * 查询基本工资管理列表
     * 
     * @param compensationBase 基本工资管理
     * @return 基本工资管理
     */
    @Override
    public List<CompensationBase> selectCompensationBaseList(CompensationBase compensationBase)
    {
        return compensationBaseMapper.selectCompensationBaseList(compensationBase);
    }

    /**
     * 新增基本工资管理
     * 
     * @param compensationBase 基本工资管理
     * @return 结果
     */
    @Override
    public int insertCompensationBase(CompensationBase compensationBase)
    {
        return compensationBaseMapper.insertCompensationBase(compensationBase);
    }

    /**
     * 修改基本工资管理
     * 
     * @param compensationBase 基本工资管理
     * @return 结果
     */
    @Override
    public int updateCompensationBase(CompensationBase compensationBase)
    {
        return compensationBaseMapper.updateCompensationBase(compensationBase);
    }

    /**
     * 批量删除基本工资管理
     * 
     * @param ids 需要删除的基本工资管理主键
     * @return 结果
     */
    @Override
    public int deleteCompensationBaseByIds(Long[] ids)
    {
        return compensationBaseMapper.deleteCompensationBaseByIds(ids);
    }

    /**
     * 删除基本工资管理信息
     * 
     * @param id 基本工资管理主键
     * @return 结果
     */
    @Override
    public int deleteCompensationBaseById(Long id)
    {
        return compensationBaseMapper.deleteCompensationBaseById(id);
    }
}
