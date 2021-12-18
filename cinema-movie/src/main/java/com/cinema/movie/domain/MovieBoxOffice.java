package com.cinema.movie.domain;

import java.util.Date;

import com.cinema.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cinema.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 票房管理对象 movie_box_office
 * 
 * @author cinema
 * @date 2021-12-11
 */
public class MovieBoxOffice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 电影编号 */
    @Excel(name = "电影编号")
    private String movieId;

    /** 电影名称 */
    @Excel(name = "电影名称")
    private String movieName;

    /** 上映时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上映时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseDate;

    /** 总票房 */
    @Excel(name = "总票房")
    private Long boxOffice;

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
    public void setMovieName(String movieName) 
    {
        this.movieName = movieName;
    }

    public String getMovieName() 
    {
        return movieName;
    }
    public void setReleaseDate(Date releaseDate) 
    {
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() 
    {
        return releaseDate;
    }
    public void setBoxOffice(Long boxOffice) 
    {
        this.boxOffice = boxOffice;
    }

    public Long getBoxOffice() 
    {
        return boxOffice;
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
            .append("movieName", getMovieName())
            .append("releaseDate", getReleaseDate())
            .append("boxOffice", getBoxOffice())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
