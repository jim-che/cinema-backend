package com.cinema.ticket.domain;

import com.cinema.common.annotation.Excel;
import com.cinema.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 影片评价对象 ticket_comment
 * 
 * @author cinema
 * @date 2021-12-11
 */
public class TicketComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 影片编号 */
    @Excel(name = "影片编号")
    private String movieId;

    /** 片名 */
    @Excel(name = "片名")
    private String movieName;

    /** 用户评价 */
    @Excel(name = "用户评价")
    private String comment;

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
    public void setMovieId(String movieId) 
    {
        this.movieId = movieId;
    }

    public String getMovieId() 
    {
        return movieId;
    }
    public void setMovieName(String movieName) 
    {
        this.movieName = movieName;
    }

    public String getMovieName() 
    {
        return movieName;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
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
            .append("movieId", getMovieId())
            .append("movieName", getMovieName())
            .append("comment", getComment())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
