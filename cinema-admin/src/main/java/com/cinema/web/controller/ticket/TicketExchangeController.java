package com.cinema.web.controller.ticket;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.movie.domain.MovieInfo;
import com.cinema.movie.mapper.MovieInfoMapper;
import com.cinema.session.domain.SessionManage;
import com.cinema.session.mapper.SessionManageMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cinema.common.annotation.Log;
import com.cinema.common.core.controller.BaseController;
import com.cinema.common.core.domain.AjaxResult;
import com.cinema.common.enums.BusinessType;
import com.cinema.ticket.domain.TicketExchange;
import com.cinema.ticket.service.ITicketExchangeService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 退换票管理Controller
 * 
 * @author cinema
 * @date 2021-12-13
 */
@RestController
@RequestMapping("/ticket/exchange")
public class TicketExchangeController extends BaseController
{
    @Autowired
    private ITicketExchangeService ticketExchangeService;

    @Resource
    private SessionManageMapper sessionManageMapper;

    @Resource
    private MovieInfoMapper movieInfoMapper;
    /**
     * 查询退换票管理列表
     */
    @PreAuthorize("@ss.hasPermi('ticket:exchange:list')")
    @GetMapping("/list")
    public TableDataInfo list(TicketExchange ticketExchange)
    {
        startPage();
        List<TicketExchange> list = ticketExchangeService.selectTicketExchangeList(ticketExchange);
        return getDataTable(list);
    }

    /**
     * 导出退换票管理列表
     */
    @PreAuthorize("@ss.hasPermi('ticket:exchange:export')")
    @Log(title = "退换票管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TicketExchange ticketExchange)
    {
        List<TicketExchange> list = ticketExchangeService.selectTicketExchangeList(ticketExchange);
        ExcelUtil<TicketExchange> util = new ExcelUtil<TicketExchange>(TicketExchange.class);
        util.exportExcel(response, list, "退换票管理数据");
    }

    /**
     * 获取退换票管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('ticket:exchange:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ticketExchangeService.selectTicketExchangeById(id));
    }

    /**
     * 新增退换票管理
     */
    @PreAuthorize("@ss.hasPermi('ticket:exchange:add')")
    @Log(title = "退换票管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TicketExchange ticketExchange)
    {
        List<SessionManage> sessionManages = sessionManageMapper.selectSessionManageList(null);
        List<MovieInfo> movieInfos = movieInfoMapper.selectMovieInfoList(null);
        boolean flag = false;
        for (SessionManage sessionManage : sessionManages) {
            if(sessionManage.getSessionId().equals(ticketExchange.getSessionId())){
                flag = true;
                ticketExchange.setCinemaId(sessionManage.getCinemaId());
                ticketExchange.setCinemaName(sessionManage.getCinemaName());
                ticketExchange.setHallId(sessionManage.getHallId());
                ticketExchange.setMovieId(sessionManage.getMovieId());
                break;
            }
        }
        for (MovieInfo movieInfo : movieInfos) {
            if(movieInfo.getMovieId().equals(ticketExchange.getMovieId())){
                ticketExchange.setMovieName(movieInfo.getName());
            }
        }

        return toAjax(ticketExchangeService.insertTicketExchange(ticketExchange));
    }

    /**
     * 修改退换票管理
     */
    @PreAuthorize("@ss.hasPermi('ticket:exchange:edit')")
    @Log(title = "退换票管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TicketExchange ticketExchange)
    {
        return toAjax(ticketExchangeService.updateTicketExchange(ticketExchange));
    }

    /**
     * 删除退换票管理
     */
    @PreAuthorize("@ss.hasPermi('ticket:exchange:remove')")
    @Log(title = "退换票管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ticketExchangeService.deleteTicketExchangeByIds(ids));
    }
}
