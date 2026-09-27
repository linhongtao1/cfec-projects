package com.cfec.antiepidemic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("sys_student")
@ApiModel(value = "Student对象", description = "")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("账号外键")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("学号")
    @TableField("code")
    private String code;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("联系方式")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("家庭住址")
    @TableField("address")
    private String address;

    @ApiModelProperty("监护人姓名")
    @TableField("guardian_name")
    private String guardianName;

    @ApiModelProperty("监护人联系方式")
    @TableField("guardian_phone")
    private String guardianPhone;

    @ApiModelProperty("身份证")
    @TableField("id_code")
    private String idCode;

    @ApiModelProperty("备注")
    @TableField("memo")
    private String memo;

    @ApiModelProperty("班级id")
    @TableField("lesson_id")
    private String lessonId;


}
