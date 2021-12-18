package com.cinema.ticket.mapper;

import java.util.List;
import com.cinema.ticket.domain.TicketExchange;

/**
 * 退换票管理Mapper接口
 * 
 * @author cinema
 * @date 2021-12-13
 */
public interface TicketExchangeMapper 
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
     * 删除退换票管理
     * 
     * @param id 退换票管理主键
     * @return 结果
     */
    public int deleteTicketExchangeById(Long id);

    /**
     * 批量删除退换票管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTicketExchangeByIds(Long[] ids);
}
