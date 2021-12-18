package com.cinema.session.service;

import java.util.List;
import com.cinema.session.domain.SessionMaintain;

/**
 * 维护管理Service接口
 * 
 * @author cinema
 * @date 2021-12-12
 */
public interface ISessionMaintainService 
{
    /**
     * 查询维护管理
     * 
     * @param id 维护管理主键
     * @return 维护管理
     */
    public SessionMaintain selectSessionMaintainById(Long id);

    /**
     * 查询维护管理列表
     * 
     * @param sessionMaintain 维护管理
     * @return 维护管理集合
     */
    public List<SessionMaintain> selectSessionMaintainList(SessionMaintain sessionMaintain);

    /**
     * 新增维护管理
     * 
     * @param sessionMaintain 维护管理
     * @return 结果
     */
    public int insertSessionMaintain(SessionMaintain sessionMaintain);

    /**
     * 修改维护管理
     * 
     * @param sessionMaintain 维护管理
     * @return 结果
     */
    public int updateSessionMaintain(SessionMaintain sessionMaintain);

    /**
     * 批量删除维护管理
     * 
     * @param ids 需要删除的维护管理主键集合
     * @return 结果
     */
    public int deleteSessionMaintainByIds(Long[] ids);

    /**
     * 删除维护管理信息
     * 
     * @param id 维护管理主键
     * @return 结果
     */
    public int deleteSessionMaintainById(Long id);
}
