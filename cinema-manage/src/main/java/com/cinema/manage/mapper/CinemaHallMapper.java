package com.cinema.manage.mapper;

import java.util.List;
import com.cinema.manage.domain.CinemaHall;

/**
 * 影厅管理Mapper接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface CinemaHallMapper 
{
    /**
     * 查询影厅管理
     * 
     * @param id 影厅管理主键
     * @return 影厅管理
     */
    public CinemaHall selectCinemaHallById(Long id);

    /**
     * 查询影厅管理列表
     * 
     * @param cinemaHall 影厅管理
     * @return 影厅管理集合
     */
    public List<CinemaHall> selectCinemaHallList(CinemaHall cinemaHall);

    public List<CinemaHall> selectByCinemaId(String cinemaId);
    /**
     * 新增影厅管理
     * 
     * @param cinemaHall 影厅管理
     * @return 结果
     */
    public int insertCinemaHall(CinemaHall cinemaHall);

    /**
     * 修改影厅管理
     * 
     * @param cinemaHall 影厅管理
     * @return 结果
     */
    public int updateCinemaHall(CinemaHall cinemaHall);

    /**
     * 删除影厅管理
     * 
     * @param id 影厅管理主键
     * @return 结果
     */
    public int deleteCinemaHallById(Long id);

    /**
     * 批量删除影厅管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCinemaHallByIds(Long[] ids);
}
