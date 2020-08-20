package com.kmu.manager.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kmu.manager.entity.Auth;
import com.kmu.manager.mapper.AuthMapper;
import com.kmu.manager.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Deng
 * @since 2020-07-25
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements AuthService {



}
