package com.cinema.web.controller.movie;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cinema.common.core.domain.entity.SysDictData;
import com.cinema.system.mapper.SysDictDataMapper;
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
import com.cinema.movie.domain.MovieType;
import com.cinema.movie.service.IMovieTypeService;
import com.cinema.common.utils.poi.ExcelUtil;
import com.cinema.common.core.page.TableDataInfo;

/**
 * 电影类型Controller
 * 
 * @author cinema
 * @date 2021-12-13
 */
@RestController
@RequestMapping("/movie/type")
public class MovieTypeController extends BaseController
{
    @Autowired
    private IMovieTypeService movieTypeService;

    @Resource
    private SysDictDataMapper sysDictDataMapper;

    /**
     * 查询电影类型列表
     */
    @PreAuthorize("@ss.hasPermi('movie:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(MovieType movieType)
    {
        startPage();
        List<MovieType> list = movieTypeService.selectMovieTypeList(movieType);
        return getDataTable(list);
    }

    /**
     * 导出电影类型列表
     */
    @PreAuthorize("@ss.hasPermi('movie:type:export')")
    @Log(title = "电影类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MovieType movieType)
    {
        List<MovieType> list = movieTypeService.selectMovieTypeList(movieType);
        ExcelUtil<MovieType> util = new ExcelUtil<MovieType>(MovieType.class);
        util.exportExcel(response, list, "电影类型数据");
    }

    /**
     * 获取电影类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('movie:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(movieTypeService.selectMovieTypeById(id));
    }

    /**
     * 新增电影类型
     */
    @PreAuthorize("@ss.hasPermi('movie:type:add')")
    @Log(title = "电影类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MovieType movieType)
    {
        SysDictData sysDictData = new SysDictData();
        sysDictData.setDictSort(0L);
        sysDictData.setDictLabel(movieType.getType());
        List<MovieType> movieTypes = movieTypeService.selectMovieTypeList(null);
        long value;
        if(movieTypes.size()==0){
            value = 1L;
        }else{
            value = movieTypes.get(movieTypes.size()-1).getId() + 1;
        }
        sysDictData.setDictValue(String.valueOf(value));
        sysDictData.setDictType("movie_type");
        sysDictDataMapper.insertDictData(sysDictData);
        movieType.setId(value);
        return toAjax(movieTypeService.insertMovieType(movieType));
    }

    /**
     * 修改电影类型
     */
    @PreAuthorize("@ss.hasPermi('movie:type:edit')")
    @Log(title = "电影类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MovieType movieType)
    {
        List<SysDictData> types = sysDictDataMapper.selectDictDataByType("movie_type");
        SysDictData sysDictData = new SysDictData();
        for (SysDictData type : types) {
            if(type.getDictValue().equals(movieType.getId().toString())){
                sysDictData = type;
            }
        }
        if (sysDictData.equals(new SysDictData())){
            throw new RuntimeException("类型编号不匹配!");
        }
        sysDictData.setDictValue(movieType.getType());
        sysDictDataMapper.updateDictData(sysDictData);
        return toAjax(movieTypeService.updateMovieType(movieType));
    }

    /**
     * 删除电影类型
     */
    @PreAuthorize("@ss.hasPermi('movie:type:remove')")
    @Log(title = "电影类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        List<SysDictData> types = sysDictDataMapper.selectDictDataByType("movie_type");
        MovieType movieType = movieTypeService.selectMovieTypeById(ids[0]);
        SysDictData sysDictData = new SysDictData();
        for (SysDictData type : types) {
            if(type.getDictValue().equals(movieType.getId().toString())){
                sysDictData = type;
            }
        }
        if (sysDictData.equals(new SysDictData())){
            throw new RuntimeException("类型编号不匹配!");
        }

        sysDictDataMapper.deleteDictDataById(sysDictData.getDictCode());
        return toAjax(movieTypeService.deleteMovieTypeByIds(ids));
    }
}
