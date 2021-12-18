package com.cinema.ticket.domain;

import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 出票管理对象 ticket_draw
 * 
 * @author cinema
 * @date 2021-12-11
 */
public class TicketDraw extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 影院编号 */
    @Excel(name = "影院编号")
    private String cinemaId;

    /** 影院名称 */
    @Excel(name = "影院名称")
    private String cinemaName;

    /** 影片编号 */
    @Excel(name = "影片编号")
    private String movieId;

    /** 影片名称 */
    @Excel(name = "影片名称")
    private String movieName;

    /** 场次编号 */
    @Excel(name = "场次编号")
    private String sessionId;

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
    public void setCinemaId(String cinemaId) 
    {
        this.cinemaId = cinemaId;
    }

    public String getCinemaId() 
    {
        return cinemaId;
    }
    public void setCinemaName(String cinemaName) 
    {
        this.cinemaName = cinemaName;
    }

    public String getCinemaName() 
    {
        return cinemaName;
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
    public void setSessionId(String sessionId) 
    {
        this.sessionId = sessionId;
    }

    public String getSessionId() 
    {
        return sessionId;
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
            .append("cinemaId", getCinemaId())
            .append("cinemaName", getCinemaName())
            .append("movieId", getMovieId())
            .append("movieName", getMovieName())
            .append("sessionId", getSessionId())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
