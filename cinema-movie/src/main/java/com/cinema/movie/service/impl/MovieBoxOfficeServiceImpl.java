package com.cinema.movie.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.movie.mapper.MovieBoxOfficeMapper;
import com.cinema.movie.domain.MovieBoxOffice;
import com.cinema.movie.service.IMovieBoxOfficeService;

/**
 * 票房管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-11
 */
@Service
public class MovieBoxOfficeServiceImpl implements IMovieBoxOfficeService 
{
    @Autowired
    private MovieBoxOfficeMapper movieBoxOfficeMapper;

    /**
     * 查询票房管理
     * 
     * @param id 票房管理主键
     * @return 票房管理
     */
    @Override
    public MovieBoxOffice selectMovieBoxOfficeById(Long id)
    {
        return movieBoxOfficeMapper.selectMovieBoxOfficeById(id);
    }

    /**
     * 查询票房管理列表
     * 
     * @param movieBoxOffice 票房管理
     * @return 票房管理
     */
    @Override
    public List<MovieBoxOffice> selectMovieBoxOfficeList(MovieBoxOffice movieBoxOffice)
    {
        return movieBoxOfficeMapper.selectMovieBoxOfficeList(movieBoxOffice);
    }

    /**
     * 新增票房管理
     * 
     * @param movieBoxOffice 票房管理
     * @return 结果
     */
    @Override
    public int insertMovieBoxOffice(MovieBoxOffice movieBoxOffice)
    {
        return movieBoxOfficeMapper.insertMovieBoxOffice(movieBoxOffice);
    }

    /**
     * 修改票房管理
     * 
     * @param movieBoxOffice 票房管理
     * @return 结果
     */
    @Override
    public int updateMovieBoxOffice(MovieBoxOffice movieBoxOffice)
    {
        return movieBoxOfficeMapper.updateMovieBoxOffice(movieBoxOffice);
    }

    /**
     * 批量删除票房管理
     * 
     * @param ids 需要删除的票房管理主键
     * @return 结果
     */
    @Override
    public int deleteMovieBoxOfficeByIds(Long[] ids)
    {
        return movieBoxOfficeMapper.deleteMovieBoxOfficeByIds(ids);
    }

    /**
     * 删除票房管理信息
     * 
     * @param id 票房管理主键
     * @return 结果
     */
    @Override
    public int deleteMovieBoxOfficeById(Long id)
    {
        return movieBoxOfficeMapper.deleteMovieBoxOfficeById(id);
    }
}
