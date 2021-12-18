package com.cinema.session.domain;

import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 影厅管理对象 session_info
 * 
 * @author cinema
 * @date 2021-12-12
 */
public class SessionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 场次编号 */
    @Excel(name = "场次编号")
    private String sessionId;

    /** 影院编号 */
    @Excel(name = "影院编号")
    private String cinemaId;

    /** 影院名称 */
    @Excel(name = "影院名称")
    private String cinemaName;

    /** 影厅编号 */
    @Excel(name = "影厅编号")
    private String hallId;

    /** 影厅名 */
    @Excel(name = "影厅名")
    private String hallName;

    /** 行数 */
    @Excel(name = "行数")
    private Long rowNumber;

    /** 每行座位 */
    @Excel(name = "每行座位")
    private Long rowSeats;

    /** 总座位数 */
    @Excel(name = "总座位数")
    private Long totalSeats;

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
    public void setSessionId(String sessionId) 
    {
        this.sessionId = sessionId;
    }

    public String getSessionId() 
    {
        return sessionId;
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
    public void setRowNumber(Long rowNumber) 
    {
        this.rowNumber = rowNumber;
    }

    public Long getRowNumber() 
    {
        return rowNumber;
    }
    public void setRowSeats(Long rowSeats) 
    {
        this.rowSeats = rowSeats;
    }

    public Long getRowSeats() 
    {
        return rowSeats;
    }
    public void setTotalSeats(Long totalSeats) 
    {
        this.totalSeats = totalSeats;
    }

    public Long getTotalSeats() 
    {
        return totalSeats;
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
            .append("sessionId", getSessionId())
            .append("cinemaId", getCinemaId())
            .append("cinemaName", getCinemaName())
            .append("hallId", getHallId())
            .append("hallName", getHallName())
            .append("rowNumber", getRowNumber())
            .append("rowSeats", getRowSeats())
            .append("totalSeats", getTotalSeats())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
