package com.cinema.ticket.service;

import java.util.List;
import com.cinema.ticket.domain.TicketDraw;

/**
 * 出票管理Service接口
 * 
 * @author cinema
 * @date 2021-12-11
 */
public interface ITicketDrawService 
{
    /**
     * 查询出票管理
     * 
     * @param id 出票管理主键
     * @return 出票管理
     */
    public TicketDraw selectTicketDrawById(Long id);

    /**
     * 查询出票管理列表
     * 
     * @param ticketDraw 出票管理
     * @return 出票管理集合
     */
    public List<TicketDraw> selectTicketDrawList(TicketDraw ticketDraw);

    /**
     * 新增出票管理
     * 
     * @param ticketDraw 出票管理
     * @return 结果
     */
    public int insertTicketDraw(TicketDraw ticketDraw);

    /**
     * 修改出票管理
     * 
     * @param ticketDraw 出票管理
     * @return 结果
     */
    public int updateTicketDraw(TicketDraw ticketDraw);

    /**
     * 批量删除出票管理
     * 
     * @param ids 需要删除的出票管理主键集合
     * @return 结果
     */
    public int deleteTicketDrawByIds(Long[] ids);

    /**
     * 删除出票管理信息
     * 
     * @param id 出票管理主键
     * @return 结果
     */
    public int deleteTicketDrawById(Long id);
}
