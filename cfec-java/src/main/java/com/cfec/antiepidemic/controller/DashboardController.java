package com.cfec.antiepidemic.controller;

import com.cfec.antiepidemic.entity.Dashboard;
import com.cfec.antiepidemic.service.*;
import com.cfec.antiepidemic.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @Title: DashboardController
 * @Package com.cfec.antiepidemic.controller
 * @Author 肉松小贝
 * @Date 2022/11/22 11:05
 */
@Api(tags = "菜单")
@RestController
@RequestMapping("/dashboard" )
public class DashboardController {
    @Resource
    private DeptService deptService;

    @Resource
    private UserService userService;

    @Resource
    private LessonService lessonService;

    @Resource
    private StudentService studentService;

    @Resource
    private AntiepidemicService antiepidemicService;

    @ApiOperation("菜单生成")
    @GetMapping()
    public JsonData getDashboard(){
        ArrayList<Dashboard> menuList = new ArrayList<>();
        menuList.add(new Dashboard(new Date(),"M",new ArrayList<>(),0,"系统管理","fa fa-adjust",null,2,1,"#"));
        menuList.get(0).getChildren().add(new Dashboard(new Date(),"C",new ArrayList<>(),1,"用户管理","#","system:user:index",1,4,"/system/user"));
        menuList.get(0).getChildren().add(new Dashboard(new Date(),"M",new ArrayList<>(),1,"通讯录管理","fa fa-address-book-o",null,1,73,"#"));
        menuList.get(0).getChildren().get(1).getChildren().add(new Dashboard(new Date(),"C",new ArrayList<>(),73,"人员通讯录",null,"system:person:index",1,74,"/system/book/person"));
        menuList.add(new Dashboard(new Date(),"M",new ArrayList<>(),0,"系统监控","fa fa-video-camera",null,5,2,"#"));
        menuList.get(1).getChildren().add(new Dashboard(new Date(),"C",new ArrayList<>(),2,"数据监控","#","monitor:data:view",3,15,"/system/druid/monitor"));

        return JsonData.buildSuccess(menuList);
    }
}
