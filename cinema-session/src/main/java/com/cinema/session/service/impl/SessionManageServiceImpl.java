package com.cinema.session.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.session.mapper.SessionManageMapper;
import com.cinema.session.domain.SessionManage;
import com.cinema.session.service.ISessionManageService;

/**
 * 场次管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-13
 */
@Service
public class SessionManageServiceImpl implements ISessionManageService 
{
    @Autowired
    private SessionManageMapper sessionManageMapper;

    /**
     * 查询场次管理
     * 
     * @param id 场次管理主键
     * @return 场次管理
     */
    @Override
    public SessionManage selectSessionManageById(Long id)
    {
        return sessionManageMapper.selectSessionManageById(id);
    }

    /**
     * 查询场次管理列表
     * 
     * @param sessionManage 场次管理
     * @return 场次管理
     */
    @Override
    public List<SessionManage> selectSessionManageList(SessionManage sessionManage)
    {
        return sessionManageMapper.selectSessionManageList(sessionManage);
    }

    /**
     * 新增场次管理
     * 
     * @param sessionManage 场次管理
     * @return 结果
     */
    @Override
    public int insertSessionManage(SessionManage sessionManage)
    {
        return sessionManageMapper.insertSessionManage(sessionManage);
    }

    /**
     * 修改场次管理
     * 
     * @param sessionManage 场次管理
     * @return 结果
     */
    @Override
    public int updateSessionManage(SessionManage sessionManage)
    {
        return sessionManageMapper.updateSessionManage(sessionManage);
    }

    /**
     * 批量删除场次管理
     * 
     * @param ids 需要删除的场次管理主键
     * @return 结果
     */
    @Override
    public int deleteSessionManageByIds(Long[] ids)
    {
        return sessionManageMapper.deleteSessionManageByIds(ids);
    }

    /**
     * 删除场次管理信息
     * 
     * @param id 场次管理主键
     * @return 结果
     */
    @Override
    public int deleteSessionManageById(Long id)
    {
        return sessionManageMapper.deleteSessionManageById(id);
    }
}
