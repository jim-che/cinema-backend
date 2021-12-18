package com.cinema.movie.mapper;

import java.util.List;
import com.cinema.movie.domain.MovieType;

/**
 * 电影类型Mapper接口
 * 
 * @author cinema
 * @date 2021-12-13
 */
public interface MovieTypeMapper 
{
    /**
     * 查询电影类型
     * 
     * @param id 电影类型主键
     * @return 电影类型
     */
    public MovieType selectMovieTypeById(Long id);

    /**
     * 查询电影类型列表
     * 
     * @param movieType 电影类型
     * @return 电影类型集合
     */
    public List<MovieType> selectMovieTypeList(MovieType movieType);

    /**
     * 新增电影类型
     * 
     * @param movieType 电影类型
     * @return 结果
     */
    public int insertMovieType(MovieType movieType);

    /**
     * 修改电影类型
     * 
     * @param movieType 电影类型
     * @return 结果
     */
    public int updateMovieType(MovieType movieType);

    /**
     * 删除电影类型
     * 
     * @param id 电影类型主键
     * @return 结果
     */
    public int deleteMovieTypeById(Long id);

    /**
     * 批量删除电影类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMovieTypeByIds(Long[] ids);
}
