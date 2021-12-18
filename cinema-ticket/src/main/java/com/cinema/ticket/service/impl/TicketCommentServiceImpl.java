package com.cinema.ticket.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.ticket.mapper.TicketCommentMapper;
import com.cinema.ticket.domain.TicketComment;
import com.cinema.ticket.service.ITicketCommentService;

/**
 * 影片评价Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-11
 */
@Service
public class TicketCommentServiceImpl implements ITicketCommentService 
{
    @Autowired
    private TicketCommentMapper ticketCommentMapper;

    /**
     * 查询影片评价
     * 
     * @param id 影片评价主键
     * @return 影片评价
     */
    @Override
    public TicketComment selectTicketCommentById(Long id)
    {
        return ticketCommentMapper.selectTicketCommentById(id);
    }

    /**
     * 查询影片评价列表
     * 
     * @param ticketComment 影片评价
     * @return 影片评价
     */
    @Override
    public List<TicketComment> selectTicketCommentList(TicketComment ticketComment)
    {
        return ticketCommentMapper.selectTicketCommentList(ticketComment);
    }

    /**
     * 新增影片评价
     * 
     * @param ticketComment 影片评价
     * @return 结果
     */
    @Override
    public int insertTicketComment(TicketComment ticketComment)
    {
        return ticketCommentMapper.insertTicketComment(ticketComment);
    }

    /**
     * 修改影片评价
     * 
     * @param ticketComment 影片评价
     * @return 结果
     */
    @Override
    public int updateTicketComment(TicketComment ticketComment)
    {
        return ticketCommentMapper.updateTicketComment(ticketComment);
    }

    /**
     * 批量删除影片评价
     * 
     * @param ids 需要删除的影片评价主键
     * @return 结果
     */
    @Override
    public int deleteTicketCommentByIds(Long[] ids)
    {
        return ticketCommentMapper.deleteTicketCommentByIds(ids);
    }

    /**
     * 删除影片评价信息
     * 
     * @param id 影片评价主键
     * @return 结果
     */
    @Override
    public int deleteTicketCommentById(Long id)
    {
        return ticketCommentMapper.deleteTicketCommentById(id);
    }
}
