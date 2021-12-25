package com.cinema.web.controller.session;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.manage.domain.CinemaInfo;
import com.cinema.manage.mapper.CinemaInfoMapper;
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
import com.cinema.session.domain.SessionMaintain;
import com.cinema.session.service.ISessionMaintainService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 维护管理Controller
 * 
 * @author cinema
 * @date 2021-12-12
 */
@RestController
@RequestMapping("/session/session")
public class SessionMaintainController extends BaseController
{
    @Resource
    private ISessionMaintainService sessionMaintainService;

    @Resource
    private CinemaInfoMapper cinemaInfoMapper;

    @Resource
    private SessionManageMapper sessionManageMapper;
    /**
     * 查询维护管理列表
     */
    @PreAuthorize("@ss.hasPermi('session:session:list')")
    @GetMapping("/list")
    public TableDataInfo list(SessionMaintain sessionMaintain)
    {
        startPage();
        List<SessionMaintain> list = sessionMaintainService.selectSessionMaintainList(sessionMaintain);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('session:session:list')")
    @GetMapping("/list2")
    public AjaxResult getSessionIds(){
        List<String> result = new ArrayList<>();
        List<SessionManage> sessionManages = sessionManageMapper.selectSessionManageList(null);
        sessionManages.forEach(sessionManage -> {
            result.add(sessionManage.getSessionId());
        });
        return AjaxResult.success(result);
    }

    /**
     * 导出维护管理列表
     */
    @PreAuthorize("@ss.hasPermi('session:session:export')")
    @Log(title = "维护管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SessionMaintain sessionMaintain)
    {
        List<SessionMaintain> list = sessionMaintainService.selectSessionMaintainList(sessionMaintain);
        ExcelUtil<SessionMaintain> util = new ExcelUtil<SessionMaintain>(SessionMaintain.class);
        util.exportExcel(response, list, "维护管理数据");
    }

    /**
     * 获取维护管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('session:session:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sessionMaintainService.selectSessionMaintainById(id));
    }

    /**
     * 新增维护管理
     */
    @PreAuthorize("@ss.hasPermi('session:session:add')")
    @Log(title = "维护管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SessionMaintain sessionMaintain)
    {
        List<SessionManage> sessionManages = sessionManageMapper.selectSessionManageList(null);
        boolean flag = sessionManages.stream().anyMatch(sessionManage -> sessionManage.getSessionId().equals(sessionMaintain.getSessionId()));
        if (!flag){
            throw new RuntimeException("场次编号错误");
        }
        for (SessionManage sessionManage : sessionManages) {
            if(sessionMaintain.getSessionId().equals(sessionManage.getSessionId())){
                sessionMaintain.setCinemaName(sessionManage.getCinemaName());
                sessionMaintain.setHallName(sessionManage.getHallName());
                sessionMaintain.setCinemaId(sessionManage.getCinemaId());
                sessionMaintain.setHallId(sessionManage.getHallId());
                sessionMaintain.setMovieType(sessionManage.getMovieType());
            }
        }

        return toAjax(sessionMaintainService.insertSessionMaintain(sessionMaintain));
    }

    /**
     * 修改维护管理
     */
    @PreAuthorize("@ss.hasPermi('session:session:edit')")
    @Log(title = "维护管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SessionMaintain sessionMaintain)
    {
        return toAjax(sessionMaintainService.updateSessionMaintain(sessionMaintain));
    }

    /**
     * 删除维护管理
     */
    @PreAuthorize("@ss.hasPermi('session:session:remove')")
    @Log(title = "维护管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sessionMaintainService.deleteSessionMaintainByIds(ids));
    }
}
