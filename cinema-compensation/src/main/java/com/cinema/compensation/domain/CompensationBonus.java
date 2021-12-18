package com.cinema.compensation.domain;

import java.math.BigDecimal;
import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 全勤奖金管理对象 compensation_bonus
 * 
 * @author cinema
 * @date 2021-12-13
 */
public class CompensationBonus extends BaseEntity
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

    /** 考勤天数 */
    @Excel(name = "考勤天数")
    private Integer checkDays;

    /** 是否删除 */
    private Integer isDeleted;

    /** 全勤奖金 */
    @Excel(name = "全勤奖金")
    private BigDecimal bonus;

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
    public void setCheckDays(Integer checkDays) 
    {
        this.checkDays = checkDays;
    }

    public Integer getCheckDays() 
    {
        return checkDays;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }
    public void setBonus(BigDecimal bonus) 
    {
        this.bonus = bonus;
    }

    public BigDecimal getBonus() 
    {
        return bonus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("checkDays", getCheckDays())
            .append("isDeleted", getIsDeleted())
            .append("bonus", getBonus())
            .toString();
    }
}
