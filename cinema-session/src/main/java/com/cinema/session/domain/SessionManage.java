package com.cinema.session.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.cinema.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cinema.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 场次管理对象 session_manage
 * 
 * @author cinema
 * @date 2021-12-13
 */
public class SessionManage extends BaseEntity
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

    /** 影厅名称 */
    @Excel(name = "影厅名称")
    private String hallName;

    /** 影片编号 */
    @Excel(name = "影片编号")
    private String movieId;

    /** 电影类型 */
    @Excel(name = "电影类型")
    private String movieType;

    /** 语言 */
    @Excel(name = "语言")
    private String language;

    /** 场次时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "场次时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sessionTime;

    /** 电影时长 */
    @Excel(name = "电影时长")
    private String length;

    /** 场次价格 */
    @Excel(name = "场次价格")
    private BigDecimal price;

    /** 已售座位 */
    @Excel(name = "已售座位")
    private Long soldSeat;

    /** 剩余座位 */
    @Excel(name = "剩余座位")
    private Long surplusSeat;

    /** 提示信息 */
    @Excel(name = "提示信息")
    private String tip;

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
    public void setMovieId(String movieId) 
    {
        this.movieId = movieId;
    }

    public String getMovieId() 
    {
        return movieId;
    }
    public void setMovieType(String movieType) 
    {
        this.movieType = movieType;
    }

    public String getMovieType() 
    {
        return movieType;
    }
    public void setLanguage(String language) 
    {
        this.language = language;
    }

    public String getLanguage() 
    {
        return language;
    }
    public void setSessionTime(Date sessionTime) 
    {
        this.sessionTime = sessionTime;
    }

    public Date getSessionTime() 
    {
        return sessionTime;
    }
    public void setLength(String length) 
    {
        this.length = length;
    }

    public String getLength() 
    {
        return length;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setSoldSeat(Long soldSeat) 
    {
        this.soldSeat = soldSeat;
    }

    public Long getSoldSeat() 
    {
        return soldSeat;
    }
    public void setSurplusSeat(Long surplusSeat) 
    {
        this.surplusSeat = surplusSeat;
    }

    public Long getSurplusSeat() 
    {
        return surplusSeat;
    }
    public void setTip(String tip) 
    {
        this.tip = tip;
    }

    public String getTip() 
    {
        return tip;
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
            .append("movieId", getMovieId())
            .append("movieType", getMovieType())
            .append("language", getLanguage())
            .append("sessionTime", getSessionTime())
            .append("length", getLength())
            .append("price", getPrice())
            .append("soldSeat", getSoldSeat())
            .append("surplusSeat", getSurplusSeat())
            .append("tip", getTip())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
