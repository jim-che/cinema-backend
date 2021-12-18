package com.cinema.manage.service;

import java.util.List;
import com.cinema.manage.domain.CinemaInfo;

/**
 * 影院信息Service接口
 * 
 * @author cinema
 * @date 2021-12-12
 */
public interface ICinemaInfoService 
{
    /**
     * 查询影院信息
     * 
     * @param id 影院信息主键
     * @return 影院信息
     */
    public CinemaInfo selectCinemaInfoById(Long id);

    /**
     * 查询影院信息列表
     * 
     * @param cinemaInfo 影院信息
     * @return 影院信息集合
     */
    public List<CinemaInfo> selectCinemaInfoList(CinemaInfo cinemaInfo);

    /**
     * 新增影院信息
     * 
     * @param cinemaInfo 影院信息
     * @return 结果
     */
    public int insertCinemaInfo(CinemaInfo cinemaInfo);

    /**
     * 修改影院信息
     * 
     * @param cinemaInfo 影院信息
     * @return 结果
     */
    public int updateCinemaInfo(CinemaInfo cinemaInfo);

    /**
     * 批量删除影院信息
     * 
     * @param ids 需要删除的影院信息主键集合
     * @return 结果
     */
    public int deleteCinemaInfoByIds(Long[] ids);

    /**
     * 删除影院信息信息
     * 
     * @param id 影院信息主键
     * @return 结果
     */
    public int deleteCinemaInfoById(Long id);
}
