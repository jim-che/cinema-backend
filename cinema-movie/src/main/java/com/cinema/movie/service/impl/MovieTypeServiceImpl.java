package com.cinema.movie.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.movie.mapper.MovieTypeMapper;
import com.cinema.movie.domain.MovieType;
import com.cinema.movie.service.IMovieTypeService;

/**
 * 电影类型Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-13
 */
@Service
public class MovieTypeServiceImpl implements IMovieTypeService 
{
    @Autowired
    private MovieTypeMapper movieTypeMapper;

    /**
     * 查询电影类型
     * 
     * @param id 电影类型主键
     * @return 电影类型
     */
    @Override
    public MovieType selectMovieTypeById(Long id)
    {
        return movieTypeMapper.selectMovieTypeById(id);
    }

    /**
     * 查询电影类型列表
     * 
     * @param movieType 电影类型
     * @return 电影类型
     */
    @Override
    public List<MovieType> selectMovieTypeList(MovieType movieType)
    {
        return movieTypeMapper.selectMovieTypeList(movieType);
    }

    /**
     * 新增电影类型
     * 
     * @param movieType 电影类型
     * @return 结果
     */
    @Override
    public int insertMovieType(MovieType movieType)
    {
        return movieTypeMapper.insertMovieType(movieType);
    }

    /**
     * 修改电影类型
     * 
     * @param movieType 电影类型
     * @return 结果
     */
    @Override
    public int updateMovieType(MovieType movieType)
    {
        return movieTypeMapper.updateMovieType(movieType);
    }

    /**
     * 批量删除电影类型
     * 
     * @param ids 需要删除的电影类型主键
     * @return 结果
     */
    @Override
    public int deleteMovieTypeByIds(Long[] ids)
    {
        return movieTypeMapper.deleteMovieTypeByIds(ids);
    }

    /**
     * 删除电影类型信息
     * 
     * @param id 电影类型主键
     * @return 结果
     */
    @Override
    public int deleteMovieTypeById(Long id)
    {
        return movieTypeMapper.deleteMovieTypeById(id);
    }
}
