package com.cfec.antiepidemic.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cfec.antiepidemic.entity.Student;
import com.cfec.antiepidemic.entity.StudentUser;
import com.cfec.antiepidemic.mapper.StudentMapper;
import com.cfec.antiepidemic.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public <T> Object findPageByLesson(Page<T> page, String lessonId) {
        return studentMapper.findPageByLesson((Page<StudentUser>) page,lessonId);
    }
}
