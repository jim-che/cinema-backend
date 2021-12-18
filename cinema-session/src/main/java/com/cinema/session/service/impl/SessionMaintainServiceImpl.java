package com.cinema.session.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.session.mapper.SessionMaintainMapper;
import com.cinema.session.domain.SessionMaintain;
import com.cinema.session.service.ISessionMaintainService;

/**
 * 维护管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-12
 */
@Service
public class SessionMaintainServiceImpl implements ISessionMaintainService 
{
    @Autowired
    private SessionMaintainMapper sessionMaintainMapper;

    /**
     * 查询维护管理
     * 
     * @param id 维护管理主键
     * @return 维护管理
     */
    @Override
    public SessionMaintain selectSessionMaintainById(Long id)
    {
        return sessionMaintainMapper.selectSessionMaintainById(id);
    }

    /**
     * 查询维护管理列表
     * 
     * @param sessionMaintain 维护管理
     * @return 维护管理
     */
    @Override
    public List<SessionMaintain> selectSessionMaintainList(SessionMaintain sessionMaintain)
    {
        return sessionMaintainMapper.selectSessionMaintainList(sessionMaintain);
    }

    /**
     * 新增维护管理
     * 
     * @param sessionMaintain 维护管理
     * @return 结果
     */
    @Override
    public int insertSessionMaintain(SessionMaintain sessionMaintain)
    {
        return sessionMaintainMapper.insertSessionMaintain(sessionMaintain);
    }

    /**
     * 修改维护管理
     * 
     * @param sessionMaintain 维护管理
     * @return 结果
     */
    @Override
    public int updateSessionMaintain(SessionMaintain sessionMaintain)
    {
        return sessionMaintainMapper.updateSessionMaintain(sessionMaintain);
    }

    /**
     * 批量删除维护管理
     * 
     * @param ids 需要删除的维护管理主键
     * @return 结果
     */
    @Override
    public int deleteSessionMaintainByIds(Long[] ids)
    {
        return sessionMaintainMapper.deleteSessionMaintainByIds(ids);
    }

    /**
     * 删除维护管理信息
     * 
     * @param id 维护管理主键
     * @return 结果
     */
    @Override
    public int deleteSessionMaintainById(Long id)
    {
        return sessionMaintainMapper.deleteSessionMaintainById(id);
    }
}
