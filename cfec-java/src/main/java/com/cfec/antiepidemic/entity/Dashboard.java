package com.cfec.antiepidemic.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

/**
 * @description: 菜单实体类
 * @Title: Dashboard
 * @Package com.cfec.antiepidemic.entity
 * @Author 肉松小贝
 * @Date 2022/11/22 11:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dashboard {

    private Date create_time;

    private String menu_type;

    private ArrayList<Dashboard> children;

    private Integer parent_id;

    private String menu_name;

    private String icon;

    private String perms;

    private Integer order_num;

    private Integer menu_id;

    private String url;

    public Dashboard(Date create_time, String menu_type, ArrayList<Dashboard> children) {
        this.create_time = create_time;
        this.menu_type = menu_type;
        this.children = children;
    }
}
