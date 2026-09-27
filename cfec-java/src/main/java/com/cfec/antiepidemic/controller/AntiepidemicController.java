package com.cfec.antiepidemic.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cfec.antiepidemic.utils.JsonData;
import com.cfec.antiepidemic.service.AntiepidemicService;
import com.cfec.antiepidemic.entity.Antiepidemic;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Api(tags = "防疫模块")
@RestController
@RequestMapping("/antiepidemic" )
public class AntiepidemicController {

    @Resource
    private AntiepidemicService antiepidemicService;

    /**
     * 查询所有接口
     * @return
     */
    @ApiOperation("查询所有接口")
    @GetMapping
    public JsonData findAll(){
            return JsonData.buildSuccess(antiepidemicService.list());
    }

    /**
     * 根据id查询数据接口
     * @param id
     * @return
     */
    @ApiOperation("根据id查询数据接口")
    @GetMapping("/{id}" )
    public JsonData findOne(@PathVariable Integer id){
            return JsonData.buildSuccess(antiepidemicService.getById(id));
    }

    /**
     * 分页查询接口
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("分页查询接口")
    @GetMapping("/page" )
    public JsonData findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
            QueryWrapper<Antiepidemic> queryWrapper=new QueryWrapper<>();
            return JsonData.buildSuccess(antiepidemicService.page(new Page<>(pageNum,pageSize),queryWrapper));
    }

    /**
     * 新增和更新接口
     * @param antiepidemic
     * @return
     */
    @ApiOperation("新增和更新接口")
    @PostMapping
    public JsonData save(@RequestBody Antiepidemic antiepidemic){
        antiepidemicService.saveOrUpdate(antiepidemic);
            return JsonData.buildSuccess();
    }

    /**
     * 删除接口
     * @param id
     * @return
     */
    @ApiOperation("删除接口")
    @DeleteMapping("/{id}" )
    public JsonData delete(@PathVariable Integer id){
        antiepidemicService.removeById(id);
            return JsonData.buildSuccess();
    }

    /**
     * 批量删除接口
     * @param ids
     * @return
     */
    @ApiOperation("批量删除接口")
    @PostMapping("/del/batch" )
    public JsonData deleteBatch(@RequestBody List<Integer> ids){
        antiepidemicService.removeByIds(ids);
            return JsonData.buildSuccess();
    }

}
