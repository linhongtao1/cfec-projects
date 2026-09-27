package com.cfec.antiepidemic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cfec.antiepidemic.entity.User;
import com.cfec.antiepidemic.mapper.UserMapper;
import com.cfec.antiepidemic.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User saveReUser(User user) {
        userMapper.saveReUser(user);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        return userMapper.selectList(queryWrapper).get(0);
    }

    @Override
    public void deleteById(Long userId) {
        userMapper.deleteById(userId);
    }
}
