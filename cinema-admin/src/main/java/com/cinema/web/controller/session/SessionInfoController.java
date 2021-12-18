package com.cinema.web.controller.session;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.manage.domain.CinemaHall;
import com.cinema.manage.domain.CinemaInfo;
import com.cinema.manage.mapper.CinemaHallMapper;
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
import com.cinema.session.domain.SessionInfo;
import com.cinema.session.service.ISessionInfoService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 影厅管理Controller
 * 
 * @author cinema
 * @date 2021-12-12
 */
@RestController
@RequestMapping("/session/info")
public class SessionInfoController extends BaseController
{
    @Resource
    private ISessionInfoService sessionInfoService;

    @Resource
    private SessionManageMapper sessionManageMapper;

    @Resource
    private CinemaInfoMapper cinemaInfoMapper;

    @Resource
    private CinemaHallMapper cinemaHallMapper;

    /**
     * 查询影厅管理列表
     */
    @PreAuthorize("@ss.hasPermi('session:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(SessionInfo sessionInfo)
    {
        startPage();
        List<SessionInfo> list = sessionInfoService.selectSessionInfoList(sessionInfo);
        return getDataTable(list);
    }

    /**
     * 导出影厅管理列表
     */
    @PreAuthorize("@ss.hasPermi('session:info:export')")
    @Log(title = "影厅管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SessionInfo sessionInfo)
    {
        List<SessionInfo> list = sessionInfoService.selectSessionInfoList(sessionInfo);
        ExcelUtil<SessionInfo> util = new ExcelUtil<SessionInfo>(SessionInfo.class);
        util.exportExcel(response, list, "影厅管理数据");
    }

    /**
     * 获取影厅管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('session:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sessionInfoService.selectSessionInfoById(id));
    }

    /**
     * 新增影厅管理
     */
    @PreAuthorize("@ss.hasPermi('session:info:add')")
    @Log(title = "影厅管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SessionInfo sessionInfo)
    {

        List<SessionManage> sessionManages = sessionManageMapper.selectSessionManageList(null);
        boolean flag = sessionManages.stream().anyMatch(sessionManage -> sessionManage.getSessionId().equals(sessionInfo.getSessionId()));
        if (!flag){
            throw new RuntimeException("场次编号有误!");
        }

        for (SessionManage sessionManage : sessionManages) {
            if (sessionInfo.getSessionId().equals(sessionManage.getSessionId())){
                sessionInfo.setCinemaName(sessionManage.getCinemaName());
                sessionInfo.setHallName(sessionManage.getHallName());
                sessionInfo.setCinemaId(sessionManage.getCinemaId());
                sessionInfo.setHallId(sessionManage.getHallId());
                sessionInfo.setTotalSeats(sessionInfo.getRowSeats() * sessionInfo.getRowNumber());
            }
        }

        System.out.println("*****************");
        System.out.println(sessionInfo);
        System.out.println("*****************");


        return toAjax(sessionInfoService.insertSessionInfo(sessionInfo));
    }

    /**
     * 修改影厅管理
     */
    @PreAuthorize("@ss.hasPermi('session:info:edit')")
    @Log(title = "影厅管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SessionInfo sessionInfo)
    {
        return toAjax(sessionInfoService.updateSessionInfo(sessionInfo));
    }

    /**
     * 删除影厅管理
     */
    @PreAuthorize("@ss.hasPermi('session:info:remove')")
    @Log(title = "影厅管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sessionInfoService.deleteSessionInfoByIds(ids));
    }
}
