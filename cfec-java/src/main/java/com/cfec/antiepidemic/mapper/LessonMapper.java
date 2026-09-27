package com.cfec.antiepidemic.mapper;

import com.cfec.antiepidemic.entity.Lesson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Mapper
public interface LessonMapper extends BaseMapper<Lesson> {

    ArrayList<Lesson> queryByTeacher(Long id);

    ArrayList<Lesson> queryByDeptCode(String code);

    ArrayList<Lesson> queryByDeptCodeTwo(String code);

    String getDeptByLessonId(String lessonId);
}
