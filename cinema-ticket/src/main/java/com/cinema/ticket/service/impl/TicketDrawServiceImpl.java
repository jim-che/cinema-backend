package com.cinema.ticket.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.ticket.mapper.TicketDrawMapper;
import com.cinema.ticket.domain.TicketDraw;
import com.cinema.ticket.service.ITicketDrawService;

/**
 * 出票管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-11
 */
@Service
public class TicketDrawServiceImpl implements ITicketDrawService 
{
    @Autowired
    private TicketDrawMapper ticketDrawMapper;

    /**
     * 查询出票管理
     * 
     * @param id 出票管理主键
     * @return 出票管理
     */
    @Override
    public TicketDraw selectTicketDrawById(Long id)
    {
        return ticketDrawMapper.selectTicketDrawById(id);
    }

    /**
     * 查询出票管理列表
     * 
     * @param ticketDraw 出票管理
     * @return 出票管理
     */
    @Override
    public List<TicketDraw> selectTicketDrawList(TicketDraw ticketDraw)
    {
        return ticketDrawMapper.selectTicketDrawList(ticketDraw);
    }

    /**
     * 新增出票管理
     * 
     * @param ticketDraw 出票管理
     * @return 结果
     */
    @Override
    public int insertTicketDraw(TicketDraw ticketDraw)
    {
        return ticketDrawMapper.insertTicketDraw(ticketDraw);
    }

    /**
     * 修改出票管理
     * 
     * @param ticketDraw 出票管理
     * @return 结果
     */
    @Override
    public int updateTicketDraw(TicketDraw ticketDraw)
    {
        return ticketDrawMapper.updateTicketDraw(ticketDraw);
    }

    /**
     * 批量删除出票管理
     * 
     * @param ids 需要删除的出票管理主键
     * @return 结果
     */
    @Override
    public int deleteTicketDrawByIds(Long[] ids)
    {
        return ticketDrawMapper.deleteTicketDrawByIds(ids);
    }

    /**
     * 删除出票管理信息
     * 
     * @param id 出票管理主键
     * @return 结果
     */
    @Override
    public int deleteTicketDrawById(Long id)
    {
        return ticketDrawMapper.deleteTicketDrawById(id);
    }
}
