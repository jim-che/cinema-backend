package com.cinema.person.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.cinema.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cinema.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 员工管理对象 person_employee
 * 
 * @author cinema
 * @date 2021-12-11
 */
public class PersonEmployee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private String employeeId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private Integer sex;

    /** 身份证 */
    @Excel(name = "身份证")
    private String cardId;

    /** 薪资 */
    @Excel(name = "薪资")
    private BigDecimal salary;

    /** 影院编号 */
    @Excel(name = "影院编号")
    private String cinemaId;

    /** 影院名称 */
    @Excel(name = "影院名称")
    private String cinemaName;

    /** 入职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hiredate;

    /** 员工状态 */
    @Excel(name = "员工状态")
    private Integer status;

    /** 员工类型 */
    @Excel(name = "员工类型")
    private Integer employeeType;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(Integer sex) 
    {
        this.sex = sex;
    }

    public Integer getSex() 
    {
        return sex;
    }
    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public String getCardId() 
    {
        return cardId;
    }
    public void setSalary(BigDecimal salary) 
    {
        this.salary = salary;
    }

    public BigDecimal getSalary() 
    {
        return salary;
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
    public void setHiredate(Date hiredate) 
    {
        this.hiredate = hiredate;
    }

    public Date getHiredate() 
    {
        return hiredate;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setEmployeeType(Integer employeeType) 
    {
        this.employeeType = employeeType;
    }

    public Integer getEmployeeType() 
    {
        return employeeType;
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
            .append("name", getName())
            .append("sex", getSex())
            .append("cardId", getCardId())
            .append("salary", getSalary())
            .append("cinemaId", getCinemaId())
            .append("cinemaName", getCinemaName())
            .append("hiredate", getHiredate())
            .append("status", getStatus())
            .append("employeeType", getEmployeeType())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
