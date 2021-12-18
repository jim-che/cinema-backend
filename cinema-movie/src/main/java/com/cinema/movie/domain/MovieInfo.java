package com.cinema.movie.domain;

import java.util.Date;

import com.cinema.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cinema.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 电影信息对象 movie_info
 * 
 * @author cinema
 * @date 2021-12-13
 */
public class MovieInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 影片编号 */
    @Excel(name = "影片编号")
    private String movieId;

    /** 电影名称 */
    @Excel(name = "电影名称")
    private String name;

    /** 电影类别 */
    @Excel(name = "电影类别")
    private Integer type;

    /** 电影时长 */
    @Excel(name = "电影时长")
    private String duration;

    /** 电影简介 */
    @Excel(name = "电影简介")
    private String intro;

    /** 播出地区 */
    @Excel(name = "播出地区")
    private String broadcastRegion;

    /** 上映时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上映时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseDate;

    /** 是否删除 */
    private Integer isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMovieId(String movieId) 
    {
        this.movieId = movieId;
    }

    public String getMovieId() 
    {
        return movieId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setDuration(String duration) 
    {
        this.duration = duration;
    }

    public String getDuration() 
    {
        return duration;
    }
    public void setIntro(String intro) 
    {
        this.intro = intro;
    }

    public String getIntro() 
    {
        return intro;
    }
    public void setBroadcastRegion(String broadcastRegion) 
    {
        this.broadcastRegion = broadcastRegion;
    }

    public String getBroadcastRegion() 
    {
        return broadcastRegion;
    }
    public void setReleaseDate(Date releaseDate) 
    {
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() 
    {
        return releaseDate;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("movieId", getMovieId())
            .append("name", getName())
            .append("type", getType())
            .append("duration", getDuration())
            .append("intro", getIntro())
            .append("broadcastRegion", getBroadcastRegion())
            .append("releaseDate", getReleaseDate())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
