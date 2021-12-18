package com.cinema.ticket.service;

import java.util.List;
import com.cinema.ticket.domain.TicketComment;

/**
 * 影片评价Service接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface ITicketCommentService 
{
    /**
     * 查询影片评价
     * 
     * @param id 影片评价主键
     * @return 影片评价
     */
    public TicketComment selectTicketCommentById(Long id);

    /**
     * 查询影片评价列表
     * 
     * @param ticketComment 影片评价
     * @return 影片评价集合
     */
    public List<TicketComment> selectTicketCommentList(TicketComment ticketComment);

    /**
     * 新增影片评价
     * 
     * @param ticketComment 影片评价
     * @return 结果
     */
    public int insertTicketComment(TicketComment ticketComment);

    /**
     * 修改影片评价
     * 
     * @param ticketComment 影片评价
     * @return 结果
     */
    public int updateTicketComment(TicketComment ticketComment);

    /**
     * 批量删除影片评价
     * 
     * @param ids 需要删除的影片评价主键集合
     * @return 结果
     */
    public int deleteTicketCommentByIds(Long[] ids);

    /**
     * 删除影片评价信息
     * 
     * @param id 影片评价主键
     * @return 结果
     */
    public int deleteTicketCommentById(Long id);
}
