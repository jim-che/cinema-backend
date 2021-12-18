package com.cinema.session.domain;

import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 维护管理对象 session_maintain
 * 
 * @author cinema
 * @date 2021-12-12
 */
public class SessionMaintain extends BaseEntity
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

    /** 影厅编号 */
    @Excel(name = "影厅编号")
    private String hallId;

    /** 影厅名称 */
    @Excel(name = "影厅名称")
    private String hallName;

    /** 场次编号 */
    @Excel(name = "场次编号")
    private String sessionId;

    /** 影片类型 */
    @Excel(name = "影片类型")
    private String movieType;

    /** 问题情况 */
    @Excel(name = "问题情况")
    private String hallWrong;

    /** 维护情况 */
    @Excel(name = "维护情况")
    private String maintenance;

    /** 禁用座位 */
    @Excel(name = "禁用座位")
    private String disableSeat;

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
    public void setHallId(String hallId) 
    {
        this.hallId = hallId;
    }

    public String getHallId() 
    {
        return hallId;
    }
    public void setHallName(String hallName) 
    {
        this.hallName = hallName;
    }

    public String getHallName() 
    {
        return hallName;
    }
    public void setSessionId(String sessionId) 
    {
        this.sessionId = sessionId;
    }

    public String getSessionId() 
    {
        return sessionId;
    }
    public void setMovieType(String movieType) 
    {
        this.movieType = movieType;
    }

    public String getMovieType() 
    {
        return movieType;
    }
    public void setHallWrong(String hallWrong) 
    {
        this.hallWrong = hallWrong;
    }

    public String getHallWrong() 
    {
        return hallWrong;
    }
    public void setMaintenance(String maintenance) 
    {
        this.maintenance = maintenance;
    }

    public String getMaintenance() 
    {
        return maintenance;
    }
    public void setDisableSeat(String disableSeat) 
    {
        this.disableSeat = disableSeat;
    }

    public String getDisableSeat() 
    {
        return disableSeat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cinemaId", getCinemaId())
            .append("cinemaName", getCinemaName())
            .append("hallId", getHallId())
            .append("hallName", getHallName())
            .append("sessionId", getSessionId())
            .append("movieType", getMovieType())
            .append("hallWrong", getHallWrong())
            .append("maintenance", getMaintenance())
            .append("disableSeat", getDisableSeat())
            .toString();
    }
}
