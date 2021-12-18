package com.cinema.manage.domain;

import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 员工管理对象 cinema_employee
 * 
 * @author cinema
 * @date 2021-12-11
 */
public class CinemaEmployee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 影院编号 */
    @Excel(name = "影院编号")
    private String cinemaId;

    /** 影院名字 */
    @Excel(name = "影院名字")
    private String cinemaName;

    /** 员工工种 */
    @Excel(name = "员工工种")
    private Integer employeeType;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private String employeeId;

    /** 上班时间 */
    @Excel(name = "上班时间")
    @JsonFormat(pattern = "HH:mm:ss")
    private String workHours;

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
    public void setEmployeeType(Integer employeeType) 
    {
        this.employeeType = employeeType;
    }

    public Integer getEmployeeType() 
    {
        return employeeType;
    }
    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() 
    {
        return employeeId;
    }
    public void setWorkHours(String workHours) 
    {
        this.workHours = workHours;
    }

    public String getWorkHours() 
    {
        return workHours;
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
            .append("employeeType", getEmployeeType())
            .append("employeeId", getEmployeeId())
            .append("workHours", getWorkHours())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
