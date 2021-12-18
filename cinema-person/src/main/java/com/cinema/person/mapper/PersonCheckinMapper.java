package com.cinema.person.mapper;

import java.util.List;
import com.cinema.person.domain.PersonCheckin;

/**
 * 考勤管理Mapper接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface PersonCheckinMapper 
{
    /**
     * 查询考勤管理
     * 
     * @param id 考勤管理主键
     * @return 考勤管理
     */
    public PersonCheckin selectPersonCheckinById(Long id);

    /**
     * 查询考勤管理列表
     * 
     * @param personCheckin 考勤管理
     * @return 考勤管理集合
     */
    public List<PersonCheckin> selectPersonCheckinList(PersonCheckin personCheckin);

    /**
     * 新增考勤管理
     * 
     * @param personCheckin 考勤管理
     * @return 结果
     */
    public int insertPersonCheckin(PersonCheckin personCheckin);

    /**
     * 修改考勤管理
     * 
     * @param personCheckin 考勤管理
     * @return 结果
     */
    public int updatePersonCheckin(PersonCheckin personCheckin);

    /**
     * 删除考勤管理
     * 
     * @param id 考勤管理主键
     * @return 结果
     */
    public int deletePersonCheckinById(Long id);

    /**
     * 批量删除考勤管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonCheckinByIds(Long[] ids);
}
