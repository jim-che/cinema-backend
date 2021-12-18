package com.cinema.movie.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.movie.mapper.MovieInfoMapper;
import com.cinema.movie.domain.MovieInfo;
import com.cinema.movie.service.IMovieInfoService;

/**
 * 电影信息Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-13
 */
@Service
public class MovieInfoServiceImpl implements IMovieInfoService 
{
    @Autowired
    private MovieInfoMapper movieInfoMapper;

    /**
     * 查询电影信息
     * 
     * @param id 电影信息主键
     * @return 电影信息
     */
    @Override
    public MovieInfo selectMovieInfoById(Long id)
    {
        return movieInfoMapper.selectMovieInfoById(id);
    }

    /**
     * 查询电影信息列表
     * 
     * @param movieInfo 电影信息
     * @return 电影信息
     */
    @Override
    public List<MovieInfo> selectMovieInfoList(MovieInfo movieInfo)
    {
        return movieInfoMapper.selectMovieInfoList(movieInfo);
    }

    /**
     * 新增电影信息
     * 
     * @param movieInfo 电影信息
     * @return 结果
     */
    @Override
    public int insertMovieInfo(MovieInfo movieInfo)
    {
        return movieInfoMapper.insertMovieInfo(movieInfo);
    }

    /**
     * 修改电影信息
     * 
     * @param movieInfo 电影信息
     * @return 结果
     */
    @Override
    public int updateMovieInfo(MovieInfo movieInfo)
    {
        return movieInfoMapper.updateMovieInfo(movieInfo);
    }

    /**
     * 批量删除电影信息
     * 
     * @param ids 需要删除的电影信息主键
     * @return 结果
     */
    @Override
    public int deleteMovieInfoByIds(Long[] ids)
    {
        return movieInfoMapper.deleteMovieInfoByIds(ids);
    }

    /**
     * 删除电影信息信息
     * 
     * @param id 电影信息主键
     * @return 结果
     */
    @Override
    public int deleteMovieInfoById(Long id)
    {
        return movieInfoMapper.deleteMovieInfoById(id);
    }
}
