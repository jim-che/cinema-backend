package com.cinema.web.controller.ticket;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.movie.domain.MovieInfo;
import com.cinema.movie.mapper.MovieInfoMapper;
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
import com.cinema.ticket.domain.TicketComment;
import com.cinema.ticket.service.ITicketCommentService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 影片评价Controller
 * 
 * @author cinema
 * @date 2021-12-11
 */
@RestController
@RequestMapping("/ticket/comment")
public class TicketCommentController extends BaseController
{
    @Resource
    private ITicketCommentService ticketCommentService;

    @Resource
    private MovieInfoMapper movieInfoMapper;

    /**
     * 查询影片评价列表
     */
    @PreAuthorize("@ss.hasPermi('ticket:comment:list')")
    @GetMapping("/list")
    public TableDataInfo list(TicketComment ticketComment)
    {
        startPage();
        List<TicketComment> list = ticketCommentService.selectTicketCommentList(ticketComment);
        return getDataTable(list);
    }

    /**
     * 导出影片评价列表
     */
    @PreAuthorize("@ss.hasPermi('ticket:comment:export')")
    @Log(title = "影片评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TicketComment ticketComment)
    {
        List<TicketComment> list = ticketCommentService.selectTicketCommentList(ticketComment);
        ExcelUtil<TicketComment> util = new ExcelUtil<TicketComment>(TicketComment.class);
        util.exportExcel(response, list, "影片评价数据");
    }

    /**
     * 获取影片评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('ticket:comment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ticketCommentService.selectTicketCommentById(id));
    }

    /**
     * 新增影片评价
     */
    @PreAuthorize("@ss.hasPermi('ticket:comment:add')")
    @Log(title = "影片评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TicketComment ticketComment)
    {
        List<MovieInfo> movieInfos = movieInfoMapper.selectMovieInfoList(null);
        boolean flag = false;
        for (MovieInfo movieInfo : movieInfos) {
            if (movieInfo.getMovieId().equals(ticketComment.getMovieId())){
                flag = true;
                ticketComment.setMovieName(movieInfo.getName());
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("影片编号不存在!");
        }
        return toAjax(ticketCommentService.insertTicketComment(ticketComment));
    }

    /**
     * 修改影片评价
     */
    @PreAuthorize("@ss.hasPermi('ticket:comment:edit')")
    @Log(title = "影片评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TicketComment ticketComment)
    {
        return toAjax(ticketCommentService.updateTicketComment(ticketComment));
    }

    /**
     * 删除影片评价
     */
    @PreAuthorize("@ss.hasPermi('ticket:comment:remove')")
    @Log(title = "影片评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ticketCommentService.deleteTicketCommentByIds(ids));
    }
}
