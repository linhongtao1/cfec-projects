package com.cfec.antiepidemic.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cfec.antiepidemic.entity.User;
import com.cfec.antiepidemic.service.LessonService;
import com.cfec.antiepidemic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cfec.antiepidemic.utils.JsonData;
import com.cfec.antiepidemic.service.StudentService;
import com.cfec.antiepidemic.entity.Student;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Api(tags = "学生模块")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private UserService userService;

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
        return JsonData.buildSuccess(studentService.list());
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
        return JsonData.buildSuccess(studentService.getById(id));
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
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        return JsonData.buildSuccess(studentService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 新增和更新接口
     *
     * @param student
     * @return
     */
    @ApiOperation("新增和更新接口")
    @PostMapping
    public JsonData save(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
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
        studentService.removeById(id);
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
        studentService.removeByIds(ids);
        return JsonData.buildSuccess();
    }

    /**
     * 根据班级查询用户消息分页查询接口
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("根据班级查询用户分页查询接口")
    @GetMapping("/stuPage")
    public JsonData findPageByLesson(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(defaultValue = "1") String lessonId) {
        return JsonData.buildSuccess(studentService.findPageByLesson(new Page<>(pageNum, pageSize), lessonId));
    }

    /**
     * 新增学生，并且添加一个用户表，默认账号学号 密码学号后六位
     *
     * @param student
     * @return
     */
    @ApiOperation("新增学生并且添加一个用户表")
    @PostMapping("/saveStudentUser")
    public JsonData saveStudentUser(@RequestBody Student student) {
        User user = new User();
        user.setAvatar("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01639c586c91bba801219c77f6efc8.gif&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671469202&t=f1a62e4ee5f249028adf505a0bd289be");
        user.setPassword(DigestUtils.md5Hex(student.getCode().substring(4, 10)));
        user.setDeleted(0);
        user.setUsername(student.getCode());
        user.setMemo("学生");
        user.setNicename(student.getName());
        user.setPhone(student.getPhone());
        user.setStatus(2);
        user.setDeptId(lessonService.getDeptByLessonId(student.getLessonId()));
        user = userService.saveReUser(user);
        student.setUserId(user.getId());
        studentService.saveOrUpdate(student);
        return JsonData.buildSuccess();
    }


    /**
     * 删除用户账号和学生
     * @param code
     * @return
     */
    @ApiOperation("删除用户账号和学生")
    @DeleteMapping("/deleteStudentUser/{code}")
    public JsonData deleteStudentUser(@PathVariable Integer code) {
        Student byId = studentService.getById(code);
        Long userId = byId.getUserId();
        studentService.removeById(code);
        userService.deleteById(userId);
        return JsonData.buildSuccess();
    }
}
