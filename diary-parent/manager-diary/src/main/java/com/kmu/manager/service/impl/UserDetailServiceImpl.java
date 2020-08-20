package com.kmu.manager.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kmu.manager.entity.Manager;
import com.kmu.manager.mapper.AuthMapper;
import com.kmu.manager.mapper.ManagerMapper;
import com.kmu.manager.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @作者：Deng 时间：2020/8/19 17:56
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("m_account", username);
//        System.out.println("username:"+username);
        Manager manager = managerMapper.selectOne(queryWrapper);

//        System.out.println("getAccount():"+manager.getAccount());
//        System.out.println("getPassword():"+manager.getPassword());

        if (manager == null) {
            return null;
        }
//查询角色，根据用户和角色的中间表来进行查询
        List<String> roleNames = roleMapper.selectRoleNameByManagerId(manager.getId());
        //查询权限，根据用户的id，查询用户拥有的权限
        List<String> authNames = authMapper.selectAuthNameByManagerId(manager.getId());
        //封装角色和权限，角色前面加ROLE_作为表示，以便区分权限和角色
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String roleName : roleNames) {
            // 注意：一定要加“ROLE_”
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleName));
        }

        for (String authName : authNames) {
            authorities.add(new SimpleGrantedAuthority(authName));
        }

        //为用户分配权限和角色
        UserDetails build = User.withUsername(manager.getAccount()).password(manager.getPassword()).authorities(authorities).build();
        return build;

    }

}