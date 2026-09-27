package com.cfec.antiepidemic.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cfec.antiepidemic.utils.JsonData;
import com.cfec.antiepidemic.service.DeptService;
import com.cfec.antiepidemic.entity.Dept;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Api(tags = "部门模块")
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 查询所有学院
     *
     * @return
     */
    @ApiOperation("树形部门")
    @GetMapping("/tree")
    public JsonData gerDept() {
        return JsonData.buildSuccess(deptService.getDept());
    }

    /**
     * 查询所有接口
     *
     * @return
     */
    @ApiOperation("查询所有接口")
    @GetMapping
    public JsonData findAll() {
        return JsonData.buildSuccess(deptService.list());
    }

    /**
     * 根据id查询数据接口
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id查询数据接口")
    @GetMapping("/{id}")
    public JsonData findOne(@PathVariable Integer id) {
        return JsonData.buildSuccess(deptService.getById(id));
    }

    /**
     * 分页查询接口
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("分页查询接口")
    @GetMapping("/page")
    public JsonData findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        return JsonData.buildSuccess(deptService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 新增和更新接口
     *
     * @param dept
     * @return
     */
    @ApiOperation("新增和更新接口")
    @PostMapping
    public JsonData save(@RequestBody Dept dept) {
        deptService.saveOrUpdate(dept);
        return JsonData.buildSuccess();
    }

    /**
     * 删除接口
     *
     * @param id
     * @return
     */
    @ApiOperation("删除接口")
    @DeleteMapping("/{id}")
    public JsonData delete(@PathVariable Integer id) {
        deptService.removeById(id);
        return JsonData.buildSuccess();
    }

    /**
     * 批量删除接口
     *
     * @param ids
     * @return
     */
    @ApiOperation("批量删除接口")
    @PostMapping("/del/batch")
    public JsonData deleteBatch(@RequestBody List<Integer> ids) {
        deptService.removeByIds(ids);
        return JsonData.buildSuccess();
    }

    /**
     * 获取学院
     *
     * @return
     */
    @ApiOperation("获取学院")
    @GetMapping("/oneDept")
    public JsonData getOneDept() {
        return JsonData.buildSuccess(deptService.getOneDept());
    }

    /**
     * 根据学院id获取专业
     *
     * @return
     */
    @ApiOperation("根据学院id获取专业")
    @GetMapping("/twoDept/{code}")
    public JsonData getTwoDept(@PathVariable String code) {
        return JsonData.buildSuccess(deptService.getTwoDept(code));
    }

}
