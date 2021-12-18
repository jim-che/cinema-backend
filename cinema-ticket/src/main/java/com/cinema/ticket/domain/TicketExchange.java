package com.cinema.ticket.domain;

import java.math.BigDecimal;
import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 退换票管理对象 ticket_exchange
 * 
 * @author cinema
 * @date 2021-12-13
 */
public class TicketExchange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    private Long id;

    /** 影院编号 */
    @Excel(name = "影院编号")
    private String cinemaId;

    /** 影院名 */
    @Excel(name = "影院名")
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

    /** 影厅编号 */
    @Excel(name = "影厅编号")
    private String hallId;

    /** 座位号 */
    @Excel(name = "座位号")
    private String seatId;

    /** 距离开场时间 */
    @Excel(name = "距离开场时间")
    private BigDecimal distance;

    /** 是否批准 */
    @Excel(name = "是否批准")
    private Integer isApprove;

    /** 目前状态 */
    @Excel(name = "目前状态")
    private Integer status;

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
    public void setHallId(String hallId) 
    {
        this.hallId = hallId;
    }

    public String getHallId() 
    {
        return hallId;
    }
    public void setSeatId(String seatId) 
    {
        this.seatId = seatId;
    }

    public String getSeatId() 
    {
        return seatId;
    }
    public void setDistance(BigDecimal distance) 
    {
        this.distance = distance;
    }

    public BigDecimal getDistance() 
    {
        return distance;
    }
    public void setIsApprove(Integer isApprove) 
    {
        this.isApprove = isApprove;
    }

    public Integer getIsApprove() 
    {
        return isApprove;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
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
            .append("hallId", getHallId())
            .append("seatId", getSeatId())
            .append("distance", getDistance())
            .append("isApprove", getIsApprove())
            .append("status", getStatus())
            .toString();
    }
}
