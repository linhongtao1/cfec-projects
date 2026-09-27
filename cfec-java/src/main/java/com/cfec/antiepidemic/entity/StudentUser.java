package com.cfec.antiepidemic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @Title: StudentUser
 * @Package com.cfec.antiepidemic.entity
 * @Author 肉松小贝
 * @Date 2022/11/22 15:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUser {
    private static final long serialVersionUID = 1L;

    private Long Userid;

    @TableField("dept_id")
    private String deptId;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("avatar")
    private String avatar;

    @TableField("status")
    private Integer status;

    @TableField("memo")
    private String memo;

    @TableLogic
    private Integer deleted;

    private String nicename;

    private String phone;

    private Long stuId;

    @ApiModelProperty("账号外键")
    private Long userId;

    @ApiModelProperty("学号")
    private String code;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("家庭住址")
    private String address;

    @ApiModelProperty("监护人姓名")
    private String guardianName;

    @ApiModelProperty("监护人联系方式")
    private String guardianPhone;

    @ApiModelProperty("身份证")
    private String idCode;

    @ApiModelProperty("班级id")
    private String lessonId;
}
