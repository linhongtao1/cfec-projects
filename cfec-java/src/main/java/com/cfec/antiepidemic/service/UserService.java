package com.cfec.antiepidemic.service;

import com.cfec.antiepidemic.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 林鸿涛
 * @since 2022-11-20
 */
public interface UserService extends IService<User> {

    User findByUsername(String username);

    User saveReUser(User user);

    void deleteById(Long userId);
}
