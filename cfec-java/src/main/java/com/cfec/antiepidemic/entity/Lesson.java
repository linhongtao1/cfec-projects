package com.cfec.antiepidemic.entity;

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
@TableName("sys_lesson")
@ApiModel(value = "Lesson对象", description = "")
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("班级id")
    @TableId("id")
    private String id;

    @ApiModelProperty("部门id")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty("班级名称")
    @TableField("class_name")
    private String className;

    @ApiModelProperty("辅导员id")
    @TableField("user_id")
    private Long userId;


}
