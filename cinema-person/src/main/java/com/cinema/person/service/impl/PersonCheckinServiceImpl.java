package com.cinema.person.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.person.mapper.PersonCheckinMapper;
import com.cinema.person.domain.PersonCheckin;
import com.cinema.person.service.IPersonCheckinService;

/**
 * 考勤管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-11
 */
@Service
public class PersonCheckinServiceImpl implements IPersonCheckinService 
{
    @Autowired
    private PersonCheckinMapper personCheckinMapper;

    /**
     * 查询考勤管理
     * 
     * @param id 考勤管理主键
     * @return 考勤管理
     */
    @Override
    public PersonCheckin selectPersonCheckinById(Long id)
    {
        return personCheckinMapper.selectPersonCheckinById(id);
    }

    /**
     * 查询考勤管理列表
     * 
     * @param personCheckin 考勤管理
     * @return 考勤管理
     */
    @Override
    public List<PersonCheckin> selectPersonCheckinList(PersonCheckin personCheckin)
    {
        return personCheckinMapper.selectPersonCheckinList(personCheckin);
    }

    /**
     * 新增考勤管理
     * 
     * @param personCheckin 考勤管理
     * @return 结果
     */
    @Override
    public int insertPersonCheckin(PersonCheckin personCheckin)
    {
        return personCheckinMapper.insertPersonCheckin(personCheckin);
    }

    /**
     * 修改考勤管理
     * 
     * @param personCheckin 考勤管理
     * @return 结果
     */
    @Override
    public int updatePersonCheckin(PersonCheckin personCheckin)
    {
        return personCheckinMapper.updatePersonCheckin(personCheckin);
    }

    /**
     * 批量删除考勤管理
     * 
     * @param ids 需要删除的考勤管理主键
     * @return 结果
     */
    @Override
    public int deletePersonCheckinByIds(Long[] ids)
    {
        return personCheckinMapper.deletePersonCheckinByIds(ids);
    }

    /**
     * 删除考勤管理信息
     * 
     * @param id 考勤管理主键
     * @return 结果
     */
    @Override
    public int deletePersonCheckinById(Long id)
    {
        return personCheckinMapper.deletePersonCheckinById(id);
    }
}
