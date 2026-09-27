package com.cfec.antiepidemic.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cfec.antiepidemic.entity.Lesson;
import com.cfec.antiepidemic.entity.Student;
import com.cfec.antiepidemic.service.LessonService;
import com.cfec.antiepidemic.service.StudentService;
import com.cfec.antiepidemic.service.UserService;
import com.cfec.antiepidemic.utils.MD5;
import com.cfec.antiepidemic.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cfec.antiepidemic.utils.JsonData;
import com.cfec.antiepidemic.entity.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private LessonService lessonService;
    @Resource
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public JsonData login(@RequestBody User User, HttpServletRequest request) throws IOException {
        // 用户信息
        User user = userService.findByUsername(User.getUsername());
        // 账号不存在、密码错误
        if (user == null) {
            return new JsonData(500, null, "账号不存在！");
        } else if (!(MD5.md5MinusSalt(MD5.md5PlusSalt(User.getPassword())).equals(user.getPassword()))) {
            return new JsonData(500, null, "密码错误！");
        } else {
            String token = TokenUtil.generateToken(user);
            return new JsonData(200, token, "登陆成功");
        }
    }

    /**
     * 查询所有接口
     *
     * @return
     */
    @ApiOperation("查询所有接口")
    @GetMapping
    public JsonData findAll() {
        return JsonData.buildSuccess(userService.list());
    }

    @ApiOperation("根据token获取用户信息")
    @GetMapping("/getInfo")
    public JsonData getInfo(HttpServletRequest request) {
        User user = TokenUtil.getUser(request.getHeader("Authentication"));
        ArrayList<Lesson> lessons;
        if(user.getStatus()==0){
            lessons = lessonService.queryByTeacher(null);
        }else {
            lessons = lessonService.queryByTeacher(user.getId());
        }

        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put("user", user);
        map.put("lesson", lessons);
        return JsonData.buildSuccess(map, "登陆成功");
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
        return JsonData.buildSuccess(userService.getById(id));
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
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return JsonData.buildSuccess(userService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 新增和更新接口
     *
     * @param User
     * @return
     */
    @ApiOperation("新增和更新接口")
    @PostMapping
    public JsonData save(@RequestBody User User) {
        User.setPassword(DigestUtils.md5Hex(User.getPassword()));
        userService.saveOrUpdate(User);
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
        userService.removeById(id);
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
        userService.removeByIds(ids);
        return JsonData.buildSuccess();
    }





}