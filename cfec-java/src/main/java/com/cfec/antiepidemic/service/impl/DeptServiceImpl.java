package com.cfec.antiepidemic.service.impl;

import com.cfec.antiepidemic.entity.Dept;
import com.cfec.antiepidemic.entity.DeptTree;
import com.cfec.antiepidemic.mapper.DeptMapper;
import com.cfec.antiepidemic.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public ArrayList<DeptTree> getDept() {
        ArrayList<DeptTree> lsTop = new ArrayList<>();
        String code = "";
        List<Dept> deptList = deptMapper.selectList(null);
        for (int i = 0; i < deptList.size(); i++) {
            if (deptList.get(i).getCode().length() == 2) {
                lsTop.add(new DeptTree(deptList.get(i).getId(), deptList.get(i).getCode(), deptList.get(i).getName(), deptList.get(i).getMemo(), deptList.get(i).getDeleted(), "/admin", "#", "/roles", deptList.get(i).getName(), "el-icon-s-help"));
            }
        }
        for (int i = 0; i < deptList.size(); i++) {
            for (int j = 0; j < lsTop.size(); j++) {
                if (deptList.get(i).getCode().substring(0, 2).equals(lsTop.get(j).getCode()) && deptList.get(i).getCode().length() != lsTop.get(j).getCode().length()) {
                    lsTop.get(j).getChildren().add(new DeptTree(deptList.get(i).getId(), deptList.get(i).getCode(), deptList.get(i).getName(), deptList.get(i).getMemo(), deptList.get(i).getDeleted(), "/roles", "admin//roles", deptList.get(i).getName()));
                }
            }
        }
        return lsTop;
    }

    @Override
    public ArrayList<Dept> getOneDept() {
        ArrayList<Dept> deptArrayList = new ArrayList<>();
        List<Dept> depts = deptMapper.selectList(null);
        for (int i = 0; i < depts.size(); i++) {
            if (depts.get(i).getCode().length() == 2) {
                deptArrayList.add(depts.get(i));
            }
        }
        return deptArrayList;
    }

    @Override
    public ArrayList<Dept> getTwoDept(String code) {
        ArrayList<Dept> deptArrayList = new ArrayList<>();
        List<Dept> depts = deptMapper.selectList(null);
        for (int i = 0; i < depts.size(); i++) {
            if (depts.get(i).getCode().substring(0, 2).equals(code) && depts.get(i).getCode().length() != code.length()) {
                deptArrayList.add(depts.get(i));
            }
        }
        return deptArrayList;
    }
}
