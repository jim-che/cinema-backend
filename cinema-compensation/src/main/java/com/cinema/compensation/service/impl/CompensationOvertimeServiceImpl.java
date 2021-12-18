package com.cinema.compensation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.compensation.mapper.CompensationOvertimeMapper;
import com.cinema.compensation.domain.CompensationOvertime;
import com.cinema.compensation.service.ICompensationOvertimeService;

/**
 * 加班薪资管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-11
 */
@Service
public class CompensationOvertimeServiceImpl implements ICompensationOvertimeService 
{
    @Autowired
    private CompensationOvertimeMapper compensationOvertimeMapper;

    /**
     * 查询加班薪资管理
     * 
     * @param id 加班薪资管理主键
     * @return 加班薪资管理
     */
    @Override
    public CompensationOvertime selectCompensationOvertimeById(Long id)
    {
        return compensationOvertimeMapper.selectCompensationOvertimeById(id);
    }

    /**
     * 查询加班薪资管理列表
     * 
     * @param compensationOvertime 加班薪资管理
     * @return 加班薪资管理
     */
    @Override
    public List<CompensationOvertime> selectCompensationOvertimeList(CompensationOvertime compensationOvertime)
    {
        return compensationOvertimeMapper.selectCompensationOvertimeList(compensationOvertime);
    }

    /**
     * 新增加班薪资管理
     * 
     * @param compensationOvertime 加班薪资管理
     * @return 结果
     */
    @Override
    public int insertCompensationOvertime(CompensationOvertime compensationOvertime)
    {
        return compensationOvertimeMapper.insertCompensationOvertime(compensationOvertime);
    }

    /**
     * 修改加班薪资管理
     * 
     * @param compensationOvertime 加班薪资管理
     * @return 结果
     */
    @Override
    public int updateCompensationOvertime(CompensationOvertime compensationOvertime)
    {
        return compensationOvertimeMapper.updateCompensationOvertime(compensationOvertime);
    }

    /**
     * 批量删除加班薪资管理
     * 
     * @param ids 需要删除的加班薪资管理主键
     * @return 结果
     */
    @Override
    public int deleteCompensationOvertimeByIds(Long[] ids)
    {
        return compensationOvertimeMapper.deleteCompensationOvertimeByIds(ids);
    }

    /**
     * 删除加班薪资管理信息
     * 
     * @param id 加班薪资管理主键
     * @return 结果
     */
    @Override
    public int deleteCompensationOvertimeById(Long id)
    {
        return compensationOvertimeMapper.deleteCompensationOvertimeById(id);
    }
}
