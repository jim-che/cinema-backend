package com.cinema.session.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.session.mapper.SessionInfoMapper;
import com.cinema.session.domain.SessionInfo;
import com.cinema.session.service.ISessionInfoService;

/**
 * 影厅管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-12
 */
@Service
public class SessionInfoServiceImpl implements ISessionInfoService 
{
    @Autowired
    private SessionInfoMapper sessionInfoMapper;

    /**
     * 查询影厅管理
     * 
     * @param id 影厅管理主键
     * @return 影厅管理
     */
    @Override
    public SessionInfo selectSessionInfoById(Long id)
    {
        return sessionInfoMapper.selectSessionInfoById(id);
    }

    /**
     * 查询影厅管理列表
     * 
     * @param sessionInfo 影厅管理
     * @return 影厅管理
     */
    @Override
    public List<SessionInfo> selectSessionInfoList(SessionInfo sessionInfo)
    {
        return sessionInfoMapper.selectSessionInfoList(sessionInfo);
    }

    /**
     * 新增影厅管理
     * 
     * @param sessionInfo 影厅管理
     * @return 结果
     */
    @Override
    public int insertSessionInfo(SessionInfo sessionInfo)
    {
        return sessionInfoMapper.insertSessionInfo(sessionInfo);
    }

    /**
     * 修改影厅管理
     * 
     * @param sessionInfo 影厅管理
     * @return 结果
     */
    @Override
    public int updateSessionInfo(SessionInfo sessionInfo)
    {
        return sessionInfoMapper.updateSessionInfo(sessionInfo);
    }

    /**
     * 批量删除影厅管理
     * 
     * @param ids 需要删除的影厅管理主键
     * @return 结果
     */
    @Override
    public int deleteSessionInfoByIds(Long[] ids)
    {
        return sessionInfoMapper.deleteSessionInfoByIds(ids);
    }

    /**
     * 删除影厅管理信息
     * 
     * @param id 影厅管理主键
     * @return 结果
     */
    @Override
    public int deleteSessionInfoById(Long id)
    {
        return sessionInfoMapper.deleteSessionInfoById(id);
    }
}
