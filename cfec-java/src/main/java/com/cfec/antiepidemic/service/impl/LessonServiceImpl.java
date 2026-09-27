package com.cfec.antiepidemic.service.impl;

import com.cfec.antiepidemic.entity.Lesson;
import com.cfec.antiepidemic.mapper.LessonMapper;
import com.cfec.antiepidemic.service.LessonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Service
public class LessonServiceImpl extends ServiceImpl<LessonMapper, Lesson> implements LessonService {

    @Resource
    private LessonMapper lessonMapper;

    @Override
    public ArrayList<Lesson> queryByTeacher(Long id) {
        if(id == null){
            return (ArrayList<Lesson>) lessonMapper.selectList(null);
        }else {
            return lessonMapper.queryByTeacher(id);
        }
    }

    @Override
    public ArrayList<Lesson> queryByDeptCode(String code) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        if(code.length() == 4){
            lessons = lessonMapper.queryByDeptCode(code);
        }else {
            lessons = lessonMapper.queryByDeptCodeTwo(code);
        }
        return lessons;
    }

    @Override
    public String getDeptByLessonId(String lessonId) {
        return lessonMapper.getDeptByLessonId(lessonId);
    }
}
