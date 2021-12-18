package com.cinema.session.mapper;

import java.util.List;
import com.cinema.session.domain.SessionInfo;

/**
 * 影厅管理Mapper接口
 * 
 * @author cinema
 * @date 2021-12-12
 */
public interface SessionInfoMapper 
{
    /**
     * 查询影厅管理
     * 
     * @param id 影厅管理主键
     * @return 影厅管理
     */
    public SessionInfo selectSessionInfoById(Long id);

    /**
     * 查询影厅管理列表
     * 
     * @param sessionInfo 影厅管理
     * @return 影厅管理集合
     */
    public List<SessionInfo> selectSessionInfoList(SessionInfo sessionInfo);

    /**
     * 新增影厅管理
     * 
     * @param sessionInfo 影厅管理
     * @return 结果
     */
    public int insertSessionInfo(SessionInfo sessionInfo);

    /**
     * 修改影厅管理
     * 
     * @param sessionInfo 影厅管理
     * @return 结果
     */
    public int updateSessionInfo(SessionInfo sessionInfo);

    /**
     * 删除影厅管理
     * 
     * @param id 影厅管理主键
     * @return 结果
     */
    public int deleteSessionInfoById(Long id);

    /**
     * 批量删除影厅管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSessionInfoByIds(Long[] ids);
}
