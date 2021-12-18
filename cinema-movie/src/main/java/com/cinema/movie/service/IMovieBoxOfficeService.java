package com.cinema.movie.service;

import java.util.List;
import com.cinema.movie.domain.MovieBoxOffice;

/**
 * 票房管理Service接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface IMovieBoxOfficeService 
{
    /**
     * 查询票房管理
     * 
     * @param id 票房管理主键
     * @return 票房管理
     */
    public MovieBoxOffice selectMovieBoxOfficeById(Long id);

    /**
     * 查询票房管理列表
     * 
     * @param movieBoxOffice 票房管理
     * @return 票房管理集合
     */
    public List<MovieBoxOffice> selectMovieBoxOfficeList(MovieBoxOffice movieBoxOffice);

    /**
     * 新增票房管理
     * 
     * @param movieBoxOffice 票房管理
     * @return 结果
     */
    public int insertMovieBoxOffice(MovieBoxOffice movieBoxOffice);

    /**
     * 修改票房管理
     * 
     * @param movieBoxOffice 票房管理
     * @return 结果
     */
    public int updateMovieBoxOffice(MovieBoxOffice movieBoxOffice);

    /**
     * 批量删除票房管理
     * 
     * @param ids 需要删除的票房管理主键集合
     * @return 结果
     */
    public int deleteMovieBoxOfficeByIds(Long[] ids);

    /**
     * 删除票房管理信息
     * 
     * @param id 票房管理主键
     * @return 结果
     */
    public int deleteMovieBoxOfficeById(Long id);
}
