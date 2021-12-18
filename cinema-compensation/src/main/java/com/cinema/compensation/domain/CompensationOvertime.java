package com.cinema.compensation.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.cinema.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cinema.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 加班薪资管理对象 compensation_overtime
 * 
 * @author cinema
 * @date 2021-12-11
 */
public class CompensationOvertime extends BaseEntity
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

    /** 加班日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "加班日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date overtimeDate;

    /** 加班时长 */
    @Excel(name = "加班时长")
    private Long overtimeLength;

    /** 加班工资 */
    @Excel(name = "加班工资")
    private BigDecimal overtimeWage;

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
    public void setOvertimeDate(Date overtimeDate) 
    {
        this.overtimeDate = overtimeDate;
    }

    public Date getOvertimeDate() 
    {
        return overtimeDate;
    }
    public void setOvertimeLength(Long overtimeLength) 
    {
        this.overtimeLength = overtimeLength;
    }

    public Long getOvertimeLength() 
    {
        return overtimeLength;
    }
    public void setOvertimeWage(BigDecimal overtimeWage) 
    {
        this.overtimeWage = overtimeWage;
    }

    public BigDecimal getOvertimeWage() 
    {
        return overtimeWage;
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
            .append("overtimeDate", getOvertimeDate())
            .append("overtimeLength", getOvertimeLength())
            .append("overtimeWage", getOvertimeWage())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
