package com.cfec.antiepidemic.service;

import com.cfec.antiepidemic.entity.Lesson;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
public interface LessonService extends IService<Lesson> {

    ArrayList<Lesson> queryByTeacher(Long id);

    ArrayList<Lesson> queryByDeptCode(String code);

    String getDeptByLessonId(String lessonId);
}
