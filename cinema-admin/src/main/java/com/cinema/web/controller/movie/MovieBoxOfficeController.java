package com.cinema.web.controller.movie;

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
import com.cinema.movie.domain.MovieBoxOffice;
import com.cinema.movie.service.IMovieBoxOfficeService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 票房管理Controller
 * 
 * @author cinema
 * @date 2021-12-11
 */
@RestController
@RequestMapping("/movie/office")
public class MovieBoxOfficeController extends BaseController
{
    @Autowired
    private IMovieBoxOfficeService movieBoxOfficeService;

    @Resource
    private MovieInfoMapper movieInfoMapper;

    /**
     * 查询票房管理列表
     */
    @PreAuthorize("@ss.hasPermi('movie:office:list')")
    @GetMapping("/list")
    public TableDataInfo list(MovieBoxOffice movieBoxOffice)
    {
        startPage();
        List<MovieBoxOffice> list = movieBoxOfficeService.selectMovieBoxOfficeList(movieBoxOffice);
        return getDataTable(list);
    }

    /**
     * 导出票房管理列表
     */
    @PreAuthorize("@ss.hasPermi('movie:office:export')")
    @Log(title = "票房管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MovieBoxOffice movieBoxOffice)
    {
        List<MovieBoxOffice> list = movieBoxOfficeService.selectMovieBoxOfficeList(movieBoxOffice);
        ExcelUtil<MovieBoxOffice> util = new ExcelUtil<MovieBoxOffice>(MovieBoxOffice.class);
        util.exportExcel(response, list, "票房管理数据");
    }

    /**
     * 获取票房管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('movie:office:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(movieBoxOfficeService.selectMovieBoxOfficeById(id));
    }

    /**
     * 新增票房管理
     */
    @PreAuthorize("@ss.hasPermi('movie:office:add')")
    @Log(title = "票房管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MovieBoxOffice movieBoxOffice)
    {
        String movieId = movieBoxOffice.getMovieId();
        boolean flag = false;
        List<MovieInfo> movieInfos = movieInfoMapper.selectMovieInfoList(null);
        for (MovieInfo movieInfo : movieInfos) {
            if(movieInfo.getMovieId().equals(movieId)){
                movieBoxOffice.setMovieName(movieInfo.getName());
                movieBoxOffice.setReleaseDate(movieInfo.getReleaseDate());
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("影片编号有误!");
        }
        return toAjax(movieBoxOfficeService.insertMovieBoxOffice(movieBoxOffice));
    }

    /**
     * 修改票房管理
     */
    @PreAuthorize("@ss.hasPermi('movie:office:edit')")
    @Log(title = "票房管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MovieBoxOffice movieBoxOffice)
    {
        return toAjax(movieBoxOfficeService.updateMovieBoxOffice(movieBoxOffice));
    }

    /**
     * 删除票房管理
     */
    @PreAuthorize("@ss.hasPermi('movie:office:remove')")
    @Log(title = "票房管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(movieBoxOfficeService.deleteMovieBoxOfficeByIds(ids));
    }
}
