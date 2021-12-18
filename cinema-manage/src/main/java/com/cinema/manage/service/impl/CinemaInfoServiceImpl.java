package com.cinema.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.manage.mapper.CinemaInfoMapper;
import com.cinema.manage.domain.CinemaInfo;
import com.cinema.manage.service.ICinemaInfoService;

import javax.annotation.Resource;

/**
 * 影院信息Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-12
 */
@Service
public class CinemaInfoServiceImpl implements ICinemaInfoService 
{
    @Resource
    private CinemaInfoMapper cinemaInfoMapper;

    /**
     * 查询影院信息
     * 
     * @param id 影院信息主键
     * @return 影院信息
     */
    @Override
    public CinemaInfo selectCinemaInfoById(Long id)
    {
        return cinemaInfoMapper.selectCinemaInfoById(id);
    }

    /**
     * 查询影院信息列表
     * 
     * @param cinemaInfo 影院信息
     * @return 影院信息
     */
    @Override
    public List<CinemaInfo> selectCinemaInfoList(CinemaInfo cinemaInfo)
    {
        return cinemaInfoMapper.selectCinemaInfoList(cinemaInfo);
    }

    /**
     * 新增影院信息
     * 
     * @param cinemaInfo 影院信息
     * @return 结果
     */
    @Override
    public int insertCinemaInfo(CinemaInfo cinemaInfo)
    {
        return cinemaInfoMapper.insertCinemaInfo(cinemaInfo);
    }

    /**
     * 修改影院信息
     * 
     * @param cinemaInfo 影院信息
     * @return 结果
     */
    @Override
    public int updateCinemaInfo(CinemaInfo cinemaInfo)
    {
        return cinemaInfoMapper.updateCinemaInfo(cinemaInfo);
    }

    /**
     * 批量删除影院信息
     * 
     * @param ids 需要删除的影院信息主键
     * @return 结果
     */
    @Override
    public int deleteCinemaInfoByIds(Long[] ids)
    {
        return cinemaInfoMapper.deleteCinemaInfoByIds(ids);
    }

    /**
     * 删除影院信息信息
     * 
     * @param id 影院信息主键
     * @return 结果
     */
    @Override
    public int deleteCinemaInfoById(Long id)
    {
        return cinemaInfoMapper.deleteCinemaInfoById(id);
    }
}
