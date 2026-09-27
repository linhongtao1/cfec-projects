package com.cfec.antiepidemic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
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
  @TableName("sys_antiepidemic")
@ApiModel(value = "Antiepidemic对象", description = "")
public class Antiepidemic implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("外键 学生信息")
      @TableField("stu_id")
    private Long stuId;

      @ApiModelProperty("采样时间")
      @TableField("sample_time")
    private Date sampleTime;

      @ApiModelProperty("检测时间")
      @TableField("test_time")
    private Date testTime;

      @ApiModelProperty("检测地点")
      @TableField("test_unit")
    private String testUnit;

      @ApiModelProperty("0阴性  1阳性")
      @TableField("result")
    private Integer result;

      @ApiModelProperty("检测地点")
      @TableField("test_address")
    private String testAddress;

      @ApiModelProperty("备注")
      @TableField("memo")
    private String memo;

      @ApiModelProperty("提交时间")
      @TableField("submit_time")
    private Date submitTime;


}
