package com.cinema.web.controller.movie;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.cinema.movie.domain.MovieInfo;
import com.cinema.movie.service.IMovieInfoService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 电影信息Controller
 * 
 * @author cinema
 * @date 2021-12-13
 */
@RestController
@RequestMapping("/movie/info")
public class MovieInfoController extends BaseController
{
    @Autowired
    private IMovieInfoService movieInfoService;

    /**
     * 查询电影信息列表
     */
    @PreAuthorize("@ss.hasPermi('movie:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(MovieInfo movieInfo)
    {
        startPage();
        List<MovieInfo> list = movieInfoService.selectMovieInfoList(movieInfo);
        return getDataTable(list);
    }

    /**
     * 导出电影信息列表
     */
    @PreAuthorize("@ss.hasPermi('movie:info:export')")
    @Log(title = "电影信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MovieInfo movieInfo)
    {
        List<MovieInfo> list = movieInfoService.selectMovieInfoList(movieInfo);
        ExcelUtil<MovieInfo> util = new ExcelUtil<MovieInfo>(MovieInfo.class);
        util.exportExcel(response, list, "电影信息数据");
    }

    /**
     * 获取电影信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('movie:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {

        return AjaxResult.success(movieInfoService.selectMovieInfoById(id));
    }

    /**
     * 新增电影信息
     */
    @PreAuthorize("@ss.hasPermi('movie:info:add')")
    @Log(title = "电影信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MovieInfo movieInfo)
    {
        movieInfo.setMovieId(generateMovieId());
        return toAjax(movieInfoService.insertMovieInfo(movieInfo));
    }

    public String generateMovieId(){
        List<MovieInfo> movieInfos = movieInfoService.selectMovieInfoList(null);
        if(movieInfos.size()==0){
            return "YP000001";
        }
        String movieId = movieInfos.get(movieInfos.size() - 1).getMovieId();
        long num = Long.parseLong(movieId.substring(3, 8)) + 1;
        return "YP" + String.format("%06d", num);
    }

    /**
     * 修改电影信息
     */
    @PreAuthorize("@ss.hasPermi('movie:info:edit')")
    @Log(title = "电影信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MovieInfo movieInfo)
    {
        return toAjax(movieInfoService.updateMovieInfo(movieInfo));
    }

    /**
     * 删除电影信息
     */
    @PreAuthorize("@ss.hasPermi('movie:info:remove')")
    @Log(title = "电影信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(movieInfoService.deleteMovieInfoByIds(ids));
    }
}
