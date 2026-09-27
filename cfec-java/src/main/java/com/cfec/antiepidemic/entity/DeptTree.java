package com.cfec.antiepidemic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Title: DeptTree
 * @Package com.cfec.antiepidemic.entity
 * @Author 肉松小贝
 * @Date 2022/11/21 14:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptTree extends Dept {

    private List<DeptTree> children;

    private String path;
    private String component;
    private String redirect;
    private String title;
    private String icon;


    public DeptTree(Long id, String code, String name, String memo, Integer deleted,String path,String component,String redirect,String title,String icon) {
        this.setId(id);
        this.setCode(code);
        this.setName(name);
        this.setMemo(memo);
        this.setDeleted(deleted);
        this.setPath(path);
        this.setComponent(component);
        this.setRedirect(redirect);
        this.setTitle(title);
        this.setIcon(icon);
        this.setChildren(new ArrayList<>());
    }

    public DeptTree(Long id, String code, String name, String memo, Integer deleted,String path,String component,String title) {
        this.setId(id);
        this.setCode(code);
        this.setName(name);
        this.setMemo(memo);
        this.setPath(path);
        this.setComponent(component);
        this.setTitle(title);
        this.setDeleted(deleted);
    }
}