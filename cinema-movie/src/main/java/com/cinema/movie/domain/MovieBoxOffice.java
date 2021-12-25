package com.cinema.movie.domain;

import java.util.Date;

import com.cinema.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cinema.common.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 票房管理对象 movie_box_office
 * 
 * @author cinema
 * @date 2021-12-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MovieBoxOffice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增编号 */
    @Excel(name = "自增编号")
    private Long id;

    /** 电影编号 */
    @Excel(name = "电影编号")
    private String movieId;

    /** 电影名称 */
    @Excel(name = "电影名称")
    private String movieName;

    /** 上映时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上映时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseDate;

    /** 总票房 */
    @Excel(name = "总票房")
    private Double boxOffice;

    /** 是否删除 */
    private Integer isDeleted;

}
