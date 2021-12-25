package com.cinema.web.controller.session;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.manage.domain.CinemaHall;
import com.cinema.manage.domain.CinemaInfo;
import com.cinema.manage.mapper.CinemaHallMapper;
import com.cinema.manage.mapper.CinemaInfoMapper;
import com.cinema.movie.domain.MovieInfo;
import com.cinema.movie.mapper.MovieInfoMapper;
import com.cinema.session.mapper.SessionManageMapper;
import com.cinema.web.controller.session.dto.ManageDto;
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
import com.cinema.session.domain.SessionManage;
import com.cinema.session.service.ISessionManageService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 场次管理Controller
 * 
 * @author cinema
 * @date 2021-12-13
 */
@RestController
@RequestMapping("/session/manage")
public class SessionManageController extends BaseController
{
    @Autowired
    private ISessionManageService sessionManageService;

    @Resource
    private SessionManageMapper sessionManageMapper;

    @Resource
    private MovieInfoMapper movieInfoMapper;

    @Resource
    private CinemaInfoMapper cinemaInfoMapper;

    @Resource
    private CinemaHallMapper cinemaHallMapper;
    /**
     * 查询场次管理列表
     */
    @PreAuthorize("@ss.hasPermi('session:manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(SessionManage sessionManage)
    {
        startPage();
        List<SessionManage> list = sessionManageService.selectSessionManageList(sessionManage);
        return getDataTable(list);
    }

    /**
     * 导出场次管理列表
     */
    @PreAuthorize("@ss.hasPermi('session:manage:export')")
    @Log(title = "场次管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SessionManage sessionManage)
    {
        List<SessionManage> list = sessionManageService.selectSessionManageList(sessionManage);
        ExcelUtil<SessionManage> util = new ExcelUtil<SessionManage>(SessionManage.class);
        util.exportExcel(response, list, "场次管理数据");
    }

    /**
     * 获取场次管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('session:manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sessionManageService.selectSessionManageById(id));
    }


    @PreAuthorize("@ss.hasPermi('session:manage:list')")
    @GetMapping("/list2")
    public AjaxResult getInfo2()
    {
        ManageDto manageDto = new ManageDto();
        List<String> cinemaIds = new ArrayList<>();
        List<String> hallIds = new ArrayList<>();
        List<String> movieIds = new ArrayList<>();
        List<MovieInfo> movieInfos = movieInfoMapper.selectMovieInfoList(null);
        List<CinemaInfo> cinemaInfoList = cinemaInfoMapper.selectCinemaInfoList(null);
        List<CinemaHall> cinemaHalls = cinemaHallMapper.selectCinemaHallList(null);
        for (CinemaInfo cinemaInfo : cinemaInfoList) {
            cinemaIds.add(cinemaInfo.getCinemaId().toString());
        }
        for (CinemaHall cinemaHall : cinemaHalls) {
            hallIds.add(cinemaHall.getHallNumber().toString());
        }
        for (MovieInfo movieInfo : movieInfos) {
            movieIds.add(movieInfo.getMovieId().toString());
        }
        manageDto.setHallIds(hallIds);
        manageDto.setCinemaIds(cinemaIds);
        manageDto.setMovieIds(movieIds);
        return AjaxResult.success(manageDto);
    }

    /**
     * 新增场次管理
     */
    @PreAuthorize("@ss.hasPermi('session:manage:add')")
    @Log(title = "场次管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SessionManage sessionManage)
    {
        List<CinemaInfo> cinemaInfos = cinemaInfoMapper.selectCinemaInfoList(null);
        boolean flag = false;
        for (CinemaInfo cinemaInfo : cinemaInfos) {
            if(cinemaInfo.getCinemaId().equals(sessionManage.getCinemaId())){
                flag = true;
                sessionManage.setCinemaName(cinemaInfo.getName());
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("影院编号不存在!");
        }
        flag = false;

        List<CinemaHall> cinemaHalls = cinemaHallMapper.selectByCinemaId(sessionManage.getCinemaId());
        for (CinemaHall cinemaHall : cinemaHalls) {
            if(cinemaHall.getHallNumber().equals(sessionManage.getHallId())){
                flag = true;
                sessionManage.setHallName(cinemaHall.getName());
                break;
            }
        }
        flag = false;

        List<MovieInfo> movieInfos = movieInfoMapper.selectMovieInfoList(null);
        for (MovieInfo movieInfo : movieInfos) {
            if(movieInfo.getMovieId().equals(sessionManage.getMovieId())){
                sessionManage.setMovieType(movieInfo.getType().toString());
                sessionManage.setLength(movieInfo.getDuration());
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("影片编号不存在!");
        }

        sessionManage.setSessionId(generateSessionId(sessionManage.getCinemaId()));
        return toAjax(sessionManageService.insertSessionManage(sessionManage));
    }

    public String generateSessionId(String cinemaId){
        List<SessionManage> sessionManages = sessionManageMapper.selectSessionManageListByCinemaId(cinemaId);
        if(sessionManages.size() == 0){
            return cinemaId + "CC00001";
        }

        int num = Integer.parseInt(sessionManages.get(sessionManages.size()-1).getSessionId().substring(8,12)) + 1;
        return cinemaId + "CC" + String.format("%05d", num);
    }
    /**
     * 修改场次管理
     */
    @PreAuthorize("@ss.hasPermi('session:manage:edit')")
    @Log(title = "场次管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SessionManage sessionManage)
    {
        return toAjax(sessionManageService.updateSessionManage(sessionManage));
    }

    /**
     * 删除场次管理
     */
    @PreAuthorize("@ss.hasPermi('session:manage:remove')")
    @Log(title = "场次管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sessionManageService.deleteSessionManageByIds(ids));
    }
}
