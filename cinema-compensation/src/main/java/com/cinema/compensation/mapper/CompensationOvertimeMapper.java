package com.cinema.compensation.mapper;

import java.util.List;
import com.cinema.compensation.domain.CompensationOvertime;

/**
 * 加班薪资管理Mapper接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface CompensationOvertimeMapper 
{
    /**
     * 查询加班薪资管理
     * 
     * @param id 加班薪资管理主键
     * @return 加班薪资管理
     */
    public CompensationOvertime selectCompensationOvertimeById(Long id);

    /**
     * 查询加班薪资管理列表
     * 
     * @param compensationOvertime 加班薪资管理
     * @return 加班薪资管理集合
     */
    public List<CompensationOvertime> selectCompensationOvertimeList(CompensationOvertime compensationOvertime);

    /**
     * 新增加班薪资管理
     * 
     * @param compensationOvertime 加班薪资管理
     * @return 结果
     */
    public int insertCompensationOvertime(CompensationOvertime compensationOvertime);

    /**
     * 修改加班薪资管理
     * 
     * @param compensationOvertime 加班薪资管理
     * @return 结果
     */
    public int updateCompensationOvertime(CompensationOvertime compensationOvertime);

    /**
     * 删除加班薪资管理
     * 
     * @param id 加班薪资管理主键
     * @return 结果
     */
    public int deleteCompensationOvertimeById(Long id);

    /**
     * 批量删除加班薪资管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompensationOvertimeByIds(Long[] ids);
}
