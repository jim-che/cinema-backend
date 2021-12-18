package com.cinema.movie.domain;

import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 电影类型对象 movie_type
 * 
 * @author cinema
 * @date 2021-12-13
 */
public class MovieType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    @Excel(name = "自增主键")
    private Long id;

    /** 电影种类 */
    @Excel(name = "电影种类")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .toString();
    }
}
