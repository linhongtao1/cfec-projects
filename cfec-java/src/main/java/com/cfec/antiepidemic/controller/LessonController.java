package com.cfec.antiepidemic.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cfec.antiepidemic.entity.User;
import com.cfec.antiepidemic.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cfec.antiepidemic.utils.JsonData;
import com.cfec.antiepidemic.service.LessonService;
import com.cfec.antiepidemic.entity.Lesson;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Api(tags = "班级模板")
@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Resource
    private LessonService lessonService;

    /**
     * 查询所有接口
     *
     * @return
     */
    @ApiOperation("查询所有接口")
    @GetMapping
    public JsonData findAll() {
        return JsonData.buildSuccess(lessonService.list());
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
        return JsonData.buildSuccess(lessonService.getById(id));
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
        QueryWrapper<Lesson> queryWrapper = new QueryWrapper<>();
        return JsonData.buildSuccess(lessonService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 新增和更新接口
     *
     * @param lesson
     * @return
     */
    @ApiOperation("新增和更新接口")
    @PostMapping
    public JsonData save(@RequestBody Lesson lesson) {
        lessonService.saveOrUpdate(lesson);
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
        lessonService.removeById(id);
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
        lessonService.removeByIds(ids);
        return JsonData.buildSuccess();
    }

    /**
     * 根据登录辅导员获取对应班级
     *
     * @return
     */
    @ApiOperation("根据辅导员id获取班级")
    @GetMapping("/byTeacher")
    public JsonData getLessonByTeacher(HttpServletRequest request) {
        User user = TokenUtil.getUser(request.getHeader("Authentication"));
        ArrayList<Lesson> lessons = lessonService.queryByTeacher(user.getId());
        return JsonData.buildSuccess(lessons, "获取成功！");
    }

    /**
     * 根据部门id查询班级
     *
     * @param code 部门编号
     * @return
     */
    @ApiOperation("根据部门id查询班级")
    @GetMapping("/byDept/{code}")
    public JsonData getLessonByDept(@PathVariable String code) {
        ArrayList<Lesson> lessonArrayList = lessonService.queryByDeptCode(code);
        return JsonData.buildSuccess(lessonArrayList, "获取成功！");

    }


}
