package com.cinema.movie.mapper;

import java.util.List;
import com.cinema.movie.domain.MovieInfo;

/**
 * 电影信息Mapper接口
 * 
 * @author cinema
 * @date 2021-12-13
 */
public interface MovieInfoMapper 
{
    /**
     * 查询电影信息
     * 
     * @param id 电影信息主键
     * @return 电影信息
     */
    public MovieInfo selectMovieInfoById(Long id);

    /**
     * 查询电影信息列表
     * 
     * @param movieInfo 电影信息
     * @return 电影信息集合
     */
    public List<MovieInfo> selectMovieInfoList(MovieInfo movieInfo);

    /**
     * 新增电影信息
     * 
     * @param movieInfo 电影信息
     * @return 结果
     */
    public int insertMovieInfo(MovieInfo movieInfo);

    /**
     * 修改电影信息
     * 
     * @param movieInfo 电影信息
     * @return 结果
     */
    public int updateMovieInfo(MovieInfo movieInfo);

    /**
     * 删除电影信息
     * 
     * @param id 电影信息主键
     * @return 结果
     */
    public int deleteMovieInfoById(Long id);

    /**
     * 批量删除电影信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMovieInfoByIds(Long[] ids);
}
