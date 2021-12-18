package com.cinema.manage.domain;

import java.util.Date;

import com.cinema.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cinema.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 影院信息对象 cinema_info
 * 
 * @author cinema
 * @date 2021-12-12
 */
public class CinemaInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 影院编号 */
    @Excel(name = "影院编号")
    private String cinemaId;

    /** 影院所在城市 */
    @Excel(name = "影院所在城市")
    private String city;

    /** 影院名字 */
    @Excel(name = "影院名字")
    private String name;

    /** 含影厅数量 */
    @Excel(name = "含影厅数量")
    private Long number;

    /** 开始营业时间 */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "开始营业时间", width = 30, dateFormat = "HH:mm:ss")
    private Date startTime;

    /** 结束营业时间 */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "结束营业时间", width = 30, dateFormat = "HH:mm:ss")
    private Date endTime;

    /** 影院电话 */
    @Excel(name = "影院电话")
    private String phone;

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
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
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
            .append("city", getCity())
            .append("name", getName())
            .append("number", getNumber())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("phone", getPhone())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
