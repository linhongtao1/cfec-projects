package com.cfec.antiepidemic.service;

import com.cfec.antiepidemic.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cfec.antiepidemic.entity.DeptTree;

import java.util.ArrayList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
public interface DeptService extends IService<Dept> {

    ArrayList<DeptTree> getDept();

    ArrayList<Dept> getOneDept();

    ArrayList<Dept> getTwoDept(String code);
}
