package com.kmu.service.impl;

import com.kmu.entity.User;
import com.kmu.mapper.UserMapper;
import com.kmu.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-08-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
