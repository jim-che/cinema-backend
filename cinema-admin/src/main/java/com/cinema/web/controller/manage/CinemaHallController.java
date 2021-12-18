package com.cinema.web.controller.manage;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.manage.domain.CinemaInfo;
import com.cinema.manage.mapper.CinemaInfoMapper;
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
import com.cinema.manage.domain.CinemaHall;
import com.cinema.manage.service.ICinemaHallService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 影厅管理Controller
 * 
 * @author cinema
 * @date 2021-12-11
 */
@RestController
@RequestMapping("/manage/hall")
public class CinemaHallController extends BaseController
{
    @Autowired
    private ICinemaHallService cinemaHallService;

    @Resource
    private CinemaInfoMapper cinemaInfoMapper;

    /**
     * 查询影厅管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:hall:list')")
    @GetMapping("/list")
    public TableDataInfo list(CinemaHall cinemaHall)
    {
        startPage();
        List<CinemaHall> list = cinemaHallService.selectCinemaHallList(cinemaHall);
        return getDataTable(list);
    }

    /**
     * 导出影厅管理列表
     */
    @PreAuthorize("@ss.hasPermi('manage:hall:export')")
    @Log(title = "影厅管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CinemaHall cinemaHall)
    {
        List<CinemaHall> list = cinemaHallService.selectCinemaHallList(cinemaHall);
        ExcelUtil<CinemaHall> util = new ExcelUtil<CinemaHall>(CinemaHall.class);
        util.exportExcel(response, list, "影厅管理数据");
    }

    /**
     * 获取影厅管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:hall:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cinemaHallService.selectCinemaHallById(id));
    }

    /**
     * 新增影厅管理
     */
    @PreAuthorize("@ss.hasPermi('manage:hall:add')")
    @Log(title = "影厅管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CinemaHall cinemaHall)
    {
        List<CinemaInfo> cinemaInfos = cinemaInfoMapper.selectCinemaInfoList(null);
        boolean flag = cinemaInfos.stream().anyMatch(cinemaInfo -> cinemaInfo.getCinemaId().equals(cinemaHall.getCinemaId()));
        if(!flag){
            throw new RuntimeException("影院编号不存在!");
        }
        for (CinemaInfo cinemaInfo : cinemaInfos) {
            if (cinemaHall.getCinemaId().equals(cinemaInfo.getCinemaId())){
                cinemaHall.setCinemaName(cinemaInfo.getName());
                break;
            }
        }

        cinemaHall.setOpenHours("---don't need it---");

        String id = generateId(cinemaHall.getCinemaId());
        cinemaHall.setHallNumber(id);

        System.out.println("************");
        System.out.println(cinemaHall);
        System.out.println("************");

        return toAjax(cinemaHallService.insertCinemaHall(cinemaHall));
    }

    public String generateId(String cinemaId){
        List<CinemaHall> infos = cinemaHallService.selectCinemaHallList(null);
        if (infos.size() == 0){
            return cinemaId + "YT001";
        }
        CinemaHall cinemaHall = infos.get(infos.size() - 1);
        String id = cinemaHall.getHallNumber();
        String number = id.substring(8,10);
        Integer num = (Integer.parseInt(number)  + 1 );
        return cinemaId + "YT" + String.format("%03d", num);
    }

    /**
     * 修改影厅管理
     */
    @PreAuthorize("@ss.hasPermi('manage:hall:edit')")
    @Log(title = "影厅管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CinemaHall cinemaHall)
    {
        return toAjax(cinemaHallService.updateCinemaHall(cinemaHall));
    }

    /**
     * 删除影厅管理
     */
    @PreAuthorize("@ss.hasPermi('manage:hall:remove')")
    @Log(title = "影厅管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cinemaHallService.deleteCinemaHallByIds(ids));
    }
}
