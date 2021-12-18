package com.cinema.web.controller.manage;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

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
import com.cinema.manage.domain.CinemaInfo;
import com.cinema.manage.service.ICinemaInfoService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 影院信息Controller
 * 
 * @author cinema
 * @date 2021-12-12
 */
@RestController
@RequestMapping("/manage/info")
public class CinemaInfoController extends BaseController
{
    @Autowired
    private ICinemaInfoService cinemaInfoService;

    @Resource
    private CinemaInfoMapper cinemaInfoMapper;

    /**
     * 查询影院信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(CinemaInfo cinemaInfo)
    {
        startPage();
        List<CinemaInfo> list = cinemaInfoService.selectCinemaInfoList(cinemaInfo);
        return getDataTable(list);
    }

    /**
     * 导出影院信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:info:export')")
    @Log(title = "影院信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CinemaInfo cinemaInfo)
    {
        List<CinemaInfo> list = cinemaInfoService.selectCinemaInfoList(cinemaInfo);
        ExcelUtil<CinemaInfo> util = new ExcelUtil<CinemaInfo>(CinemaInfo.class);
        util.exportExcel(response, list, "影院信息数据");
    }

    /**
     * 获取影院信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cinemaInfoService.selectCinemaInfoById(id));
    }

    /**
     * 新增影院信息
     */
    @PreAuthorize("@ss.hasPermi('manage:info:add')")
    @Log(title = "影院信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CinemaInfo cinemaInfo)
    {

        cinemaInfo.setCinemaId(generateId());

        if (cinemaInfo.getEndTime().before(cinemaInfo.getStartTime())){
           throw new RuntimeException("结束时间不能在起始时间之前");
        }

        if (cinemaInfo.getPhone().length()!=11){
            throw new RuntimeException("手机号位数不正确");
        }

        return toAjax(cinemaInfoService.insertCinemaInfo(cinemaInfo));
    }

    public String generateId(){
        List<CinemaInfo> infos = cinemaInfoService.selectCinemaInfoList(null);
        if(infos.size()==0){
            return "YY001";
        }
        CinemaInfo cinemaInfo = infos.get(infos.size() - 1);
        String id = cinemaInfo.getCinemaId();
        String number = id.substring(3,5);
        Integer num = (Integer.parseInt(number)  + 1 );

        return "YY" + String.format("%03d", num);
    }

    /**
     * 修改影院信息
     */
    @PreAuthorize("@ss.hasPermi('manage:info:edit')")
    @Log(title = "影院信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CinemaInfo cinemaInfo)
    {
        return toAjax(cinemaInfoService.updateCinemaInfo(cinemaInfo));
    }

    /**
     * 删除影院信息
     */
    @PreAuthorize("@ss.hasPermi('manage:info:remove')")
    @Log(title = "影院信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cinemaInfoService.deleteCinemaInfoByIds(ids));
    }
}
