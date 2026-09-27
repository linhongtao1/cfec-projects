package com.cfec.antiepidemic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cfec.antiepidemic.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cfec.antiepidemic.entity.StudentUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
public interface StudentService extends IService<Student> {

    <T> Object findPageByLesson(Page<T> page, String lessonId);
}
