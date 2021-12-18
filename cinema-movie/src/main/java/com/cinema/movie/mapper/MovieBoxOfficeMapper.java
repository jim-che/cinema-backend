package com.cinema.movie.mapper;

import java.util.List;
import com.cinema.movie.domain.MovieBoxOffice;

/**
 * 票房管理Mapper接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface MovieBoxOfficeMapper 
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
     * 删除票房管理
     * 
     * @param id 票房管理主键
     * @return 结果
     */
    public int deleteMovieBoxOfficeById(Long id);

    /**
     * 批量删除票房管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMovieBoxOfficeByIds(Long[] ids);
}
