package com.cfec.antiepidemic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("部门id")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty("登录账号 学生学号登录")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("0高级管理员  1 辅导员  2学生")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("备注")
    @TableField("memo")
    private String memo;

    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("真实姓名")
    @TableField("nicename")
    private String nicename;

    @ApiModelProperty("联系方式")
    @TableField("phone")
    private String phone;


}
