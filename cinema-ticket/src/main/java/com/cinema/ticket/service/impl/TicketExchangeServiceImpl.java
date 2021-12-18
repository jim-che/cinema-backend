package com.cinema.ticket.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema.ticket.mapper.TicketExchangeMapper;
import com.cinema.ticket.domain.TicketExchange;
import com.cinema.ticket.service.ITicketExchangeService;

/**
 * 退换票管理Service业务层处理
 * 
 * @author cinema
 * @date 2021-12-13
 */
@Service
public class TicketExchangeServiceImpl implements ITicketExchangeService 
{
    @Autowired
    private TicketExchangeMapper ticketExchangeMapper;

    /**
     * 查询退换票管理
     * 
     * @param id 退换票管理主键
     * @return 退换票管理
     */
    @Override
    public TicketExchange selectTicketExchangeById(Long id)
    {
        return ticketExchangeMapper.selectTicketExchangeById(id);
    }

    /**
     * 查询退换票管理列表
     * 
     * @param ticketExchange 退换票管理
     * @return 退换票管理
     */
    @Override
    public List<TicketExchange> selectTicketExchangeList(TicketExchange ticketExchange)
    {
        return ticketExchangeMapper.selectTicketExchangeList(ticketExchange);
    }

    /**
     * 新增退换票管理
     * 
     * @param ticketExchange 退换票管理
     * @return 结果
     */
    @Override
    public int insertTicketExchange(TicketExchange ticketExchange)
    {
        return ticketExchangeMapper.insertTicketExchange(ticketExchange);
    }

    /**
     * 修改退换票管理
     * 
     * @param ticketExchange 退换票管理
     * @return 结果
     */
    @Override
    public int updateTicketExchange(TicketExchange ticketExchange)
    {
        return ticketExchangeMapper.updateTicketExchange(ticketExchange);
    }

    /**
     * 批量删除退换票管理
     * 
     * @param ids 需要删除的退换票管理主键
     * @return 结果
     */
    @Override
    public int deleteTicketExchangeByIds(Long[] ids)
    {
        return ticketExchangeMapper.deleteTicketExchangeByIds(ids);
    }

    /**
     * 删除退换票管理信息
     * 
     * @param id 退换票管理主键
     * @return 结果
     */
    @Override
    public int deleteTicketExchangeById(Long id)
    {
        return ticketExchangeMapper.deleteTicketExchangeById(id);
    }
}
