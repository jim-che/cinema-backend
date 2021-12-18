package com.cinema.compensation.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.cinema.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cinema.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 基本工资管理对象 compensation_base
 * 
 * @author cinema
 * @date 2021-12-11
 */
public class CompensationBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    private Long id;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private String employeeId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String employeeName;

    /** 发放时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发放时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issueTime;

    /** 员工类型 */
    @Excel(name = "员工类型")
    private String employeeType;

    /** 工资 */
    @Excel(name = "工资")
    private BigDecimal salary;

    /** 是否删除 */
    private Long isDeleted;

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
    public void setIssueTime(Date issueTime) 
    {
        this.issueTime = issueTime;
    }

    public Date getIssueTime() 
    {
        return issueTime;
    }
    public void setEmployeeType(String employeeType) 
    {
        this.employeeType = employeeType;
    }

    public String getEmployeeType() 
    {
        return employeeType;
    }
    public void setSalary(BigDecimal salary) 
    {
        this.salary = salary;
    }

    public BigDecimal getSalary() 
    {
        return salary;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("issueTime", getIssueTime())
            .append("employeeType", getEmployeeType())
            .append("salary", getSalary())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
