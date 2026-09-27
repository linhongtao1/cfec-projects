package com.cfec.antiepidemic.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cfec.antiepidemic.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cfec.antiepidemic.entity.StudentUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    Page<StudentUser> findPageByLesson(Page<StudentUser> page,String lessonId);

}
