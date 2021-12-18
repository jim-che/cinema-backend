package com.cinema.ticket.service;

import java.util.List;
import com.cinema.ticket.domain.TicketExchange;

/**
 * 退换票管理Service接口
 * 
 * @author cinema
 * @date 2021-12-13
 */
public interface ITicketExchangeService 
{
    /**
     * 查询退换票管理
     * 
     * @param id 退换票管理主键
     * @return 退换票管理
     */
    public TicketExchange selectTicketExchangeById(Long id);

    /**
     * 查询退换票管理列表
     * 
     * @param ticketExchange 退换票管理
     * @return 退换票管理集合
     */
    public List<TicketExchange> selectTicketExchangeList(TicketExchange ticketExchange);

    /**
     * 新增退换票管理
     * 
     * @param ticketExchange 退换票管理
     * @return 结果
     */
    public int insertTicketExchange(TicketExchange ticketExchange);

    /**
     * 修改退换票管理
     * 
     * @param ticketExchange 退换票管理
     * @return 结果
     */
    public int updateTicketExchange(TicketExchange ticketExchange);

    /**
     * 批量删除退换票管理
     * 
     * @param ids 需要删除的退换票管理主键集合
     * @return 结果
     */
    public int deleteTicketExchangeByIds(Long[] ids);

    /**
     * 删除退换票管理信息
     * 
     * @param id 退换票管理主键
     * @return 结果
     */
    public int deleteTicketExchangeById(Long id);
}
