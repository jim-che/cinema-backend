package com.cinema.manage.domain;

import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 影厅管理对象 cinema_hall
 * 
 * @author cinema
 * @date 2021-12-11
 */
public class CinemaHall extends BaseEntity
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
    private String hallNumber;

    /** 影厅名 */
    @Excel(name = "影厅名")
    private String name;

    /** 开放时间 */
    @Excel(name = "开放时间")
    private String openHours;

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
    public void setHallNumber(String hallNumber) 
    {
        this.hallNumber = hallNumber;
    }

    public String getHallNumber() 
    {
        return hallNumber;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setOpenHours(String openHours) 
    {
        this.openHours = openHours;
    }

    public String getOpenHours() 
    {
        return openHours;
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
            .append("hallNumber", getHallNumber())
            .append("name", getName())
            .append("openHours", getOpenHours())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
