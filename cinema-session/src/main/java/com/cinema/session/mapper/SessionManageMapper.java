package com.cinema.session.mapper;

import java.util.List;
import com.cinema.session.domain.SessionManage;

/**
 * 场次管理Mapper接口
 * 
 * @author cinema
 * @date 2021-12-13
 */
public interface SessionManageMapper 
{
    /**
     * 查询场次管理
     * 
     * @param id 场次管理主键
     * @return 场次管理
     */
    public SessionManage selectSessionManageById(Long id);

    /**
     * 查询场次管理列表
     * 
     * @param sessionManage 场次管理
     * @return 场次管理集合
     */
    public List<SessionManage> selectSessionManageList(SessionManage sessionManage);

    public List<SessionManage> selectSessionManageListByCinemaId(String cinemaId);

    /**
     * 新增场次管理
     * 
     * @param sessionManage 场次管理
     * @return 结果
     */
    public int insertSessionManage(SessionManage sessionManage);

    /**
     * 修改场次管理
     * 
     * @param sessionManage 场次管理
     * @return 结果
     */
    public int updateSessionManage(SessionManage sessionManage);

    /**
     * 删除场次管理
     * 
     * @param id 场次管理主键
     * @return 结果
     */
    public int deleteSessionManageById(Long id);

    /**
     * 批量删除场次管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSessionManageByIds(Long[] ids);
}
