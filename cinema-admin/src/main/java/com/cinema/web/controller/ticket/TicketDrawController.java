package com.cinema.web.controller.ticket;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.movie.domain.MovieBoxOffice;
import com.cinema.movie.domain.MovieInfo;
import com.cinema.movie.mapper.MovieBoxOfficeMapper;
import com.cinema.movie.mapper.MovieInfoMapper;
import com.cinema.movie.service.impl.MovieBoxOfficeServiceImpl;
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
import com.cinema.ticket.domain.TicketDraw;
import com.cinema.ticket.service.ITicketDrawService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 出票管理Controller
 * 
 * @author cinema
 * @date 2021-12-11
 */
@RestController
@RequestMapping("/ticket/draw")
public class TicketDrawController extends BaseController
{
    @Autowired
    private ITicketDrawService ticketDrawService;

    @Resource
    private SessionManageMapper sessionManageMapper;

    @Resource
    private MovieInfoMapper movieInfoMapper;

    @Resource
    private MovieBoxOfficeMapper movieBoxOfficeMapper;


    /**
     * 查询出票管理列表
     */
    @PreAuthorize("@ss.hasPermi('ticket:draw:list')")
    @GetMapping("/list")
    public TableDataInfo list(TicketDraw ticketDraw)
    {
        startPage();
        List<TicketDraw> list = ticketDrawService.selectTicketDrawList(ticketDraw);
        return getDataTable(list);
    }

    /**
     * 导出出票管理列表
     */
    @PreAuthorize("@ss.hasPermi('ticket:draw:export')")
    @Log(title = "出票管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TicketDraw ticketDraw)
    {
        List<TicketDraw> list = ticketDrawService.selectTicketDrawList(ticketDraw);
        ExcelUtil<TicketDraw> util = new ExcelUtil<TicketDraw>(TicketDraw.class);
        util.exportExcel(response, list, "出票管理数据");
    }

    /**
     * 获取出票管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('ticket:draw:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ticketDrawService.selectTicketDrawById(id));
    }

    /**
     * 新增出票管理
     */
    @PreAuthorize("@ss.hasPermi('ticket:draw:add')")
    @Log(title = "出票管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TicketDraw ticketDraw)
    {
        List<SessionManage> sessionManages = sessionManageMapper.selectSessionManageList(null);
        System.out.println("++++++++++++++");
        System.out.println(ticketDraw);
        System.out.println("++++++++++++++");
        List<MovieInfo> movieInfos = movieInfoMapper.selectMovieInfoList(null);
        boolean flag = false;
        for (SessionManage sessionManage : sessionManages) {
            if(sessionManage.getSessionId().equals(ticketDraw.getSessionId())){
                ticketDraw.setCinemaId(sessionManage.getCinemaId());
                ticketDraw.setCinemaName(sessionManage.getCinemaName());
                ticketDraw.setMovieId(sessionManage.getMovieId());
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("场次编号不存在!");
        }
        MovieInfo info = new MovieInfo();
        for (MovieInfo movieInfo : movieInfos) {
            if(movieInfo.getMovieId().equals(ticketDraw.getMovieId())){
                ticketDraw.setMovieName(movieInfo.getName());
                info = movieInfo;
                break;
            }
        }
        String movieId = ticketDraw.getMovieId();
        MovieBoxOffice movieBoxOffice = new MovieBoxOffice();
        List<MovieBoxOffice> offices = movieBoxOfficeMapper.selectMovieBoxOfficeList(null);
        for (MovieBoxOffice office : offices) {
            if(office.getMovieId().equals(movieId)){
                movieBoxOffice = office;
                movieBoxOffice.setBoxOffice(movieBoxOffice.getBoxOffice() +0.05);
                movieBoxOfficeMapper.updateMovieBoxOffice(movieBoxOffice);
            }
        }
        if(movieBoxOffice.equals(new MovieBoxOffice())){
            movieBoxOffice.setMovieName(info.getName());
            movieBoxOffice.setBoxOffice(0.05);
            movieBoxOffice.setReleaseDate(info.getReleaseDate());
            movieBoxOfficeMapper.insertMovieBoxOffice(movieBoxOffice);
        }
        return toAjax(ticketDrawService.insertTicketDraw(ticketDraw));
    }

    /**
     * 修改出票管理
     */
    @PreAuthorize("@ss.hasPermi('ticket:draw:edit')")
    @Log(title = "出票管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TicketDraw ticketDraw)
    {
        return toAjax(ticketDrawService.updateTicketDraw(ticketDraw));
    }

    /**
     * 删除出票管理
     */
    @PreAuthorize("@ss.hasPermi('ticket:draw:remove')")
    @Log(title = "出票管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ticketDrawService.deleteTicketDrawByIds(ids));
    }
}
