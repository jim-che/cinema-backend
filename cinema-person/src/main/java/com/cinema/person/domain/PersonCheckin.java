package com.cinema.person.domain;

import java.math.BigDecimal;
import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 考勤管理对象 person_checkin
 * 
 * @author cinema
 * @date 2021-12-11
 */
public class PersonCheckin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private String employeeId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String employeeName;

    /** 出勤次数 */
    @Excel(name = "出勤次数")
    private Integer attendanceTime;

    /** 出勤率 */
    @Excel(name = "出勤率")
    private BigDecimal attendanceRate;

    /** 休假时间 */
    @Excel(name = "休假时间")
    private Long daysOff;

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
    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() 
    {
        return employeeId;
    }
    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }
    public void setAttendanceTime(Integer attendanceTime) 
    {
        this.attendanceTime = attendanceTime;
    }

    public Integer getAttendanceTime() 
    {
        return attendanceTime;
    }
    public void setAttendanceRate(BigDecimal attendanceRate) 
    {
        this.attendanceRate = attendanceRate;
    }

    public BigDecimal getAttendanceRate() 
    {
        return attendanceRate;
    }
    public void setDaysOff(Long daysOff) 
    {
        this.daysOff = daysOff;
    }

    public Long getDaysOff() 
    {
        return daysOff;
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
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("attendanceTime", getAttendanceTime())
            .append("attendanceRate", getAttendanceRate())
            .append("daysOff", getDaysOff())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
