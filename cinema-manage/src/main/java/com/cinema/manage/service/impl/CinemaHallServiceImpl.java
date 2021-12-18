package com.cinema.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.manage.mapper.CinemaHallMapper;
import com.cinema.manage.domain.CinemaHall;
import com.cinema.manage.service.ICinemaHallService;

/**
 * 影厅管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-11
 */
@Service
public class CinemaHallServiceImpl implements ICinemaHallService 
{
    @Autowired
    private CinemaHallMapper cinemaHallMapper;

    /**
     * 查询影厅管理
     * 
     * @param id 影厅管理主键
     * @return 影厅管理
     */
    @Override
    public CinemaHall selectCinemaHallById(Long id)
    {
        return cinemaHallMapper.selectCinemaHallById(id);
    }

    /**
     * 查询影厅管理列表
     * 
     * @param cinemaHall 影厅管理
     * @return 影厅管理
     */
    @Override
    public List<CinemaHall> selectCinemaHallList(CinemaHall cinemaHall)
    {
        return cinemaHallMapper.selectCinemaHallList(cinemaHall);
    }

    /**
     * 新增影厅管理
     * 
     * @param cinemaHall 影厅管理
     * @return 结果
     */
    @Override
    public int insertCinemaHall(CinemaHall cinemaHall)
    {
        return cinemaHallMapper.insertCinemaHall(cinemaHall);
    }

    /**
     * 修改影厅管理
     * 
     * @param cinemaHall 影厅管理
     * @return 结果
     */
    @Override
    public int updateCinemaHall(CinemaHall cinemaHall)
    {
        return cinemaHallMapper.updateCinemaHall(cinemaHall);
    }

    /**
     * 批量删除影厅管理
     * 
     * @param ids 需要删除的影厅管理主键
     * @return 结果
     */
    @Override
    public int deleteCinemaHallByIds(Long[] ids)
    {
        return cinemaHallMapper.deleteCinemaHallByIds(ids);
    }

    /**
     * 删除影厅管理信息
     * 
     * @param id 影厅管理主键
     * @return 结果
     */
    @Override
    public int deleteCinemaHallById(Long id)
    {
        return cinemaHallMapper.deleteCinemaHallById(id);
    }
}
