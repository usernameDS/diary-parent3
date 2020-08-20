package com.kmu.manager.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kmu.manager.util.ResultEntity;
import com.kmu.manager.entity.Manager;
import com.kmu.manager.mapper.ManagerMapper;
import com.kmu.manager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者：Deng 时间：2020/8/18 21:32
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Page<Manager> selectManagers(String account, Integer pageNum, Integer pageSize) {
        try {
            QueryWrapper<Manager> qw = new QueryWrapper<>();
            if (account != null && !"".equals(account)){
                //模糊查询
                qw.like("m_account","%"+account+"%");
            }
            //分页设置
            Page<Manager> page = new Page<>();
            page.setSize(pageSize);
            page.setCurrent(pageNum);
            Page<Manager> page1 = managerMapper.selectPage(page, qw);
            return page1;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ResultEntity insert(Manager manager) {
        QueryWrapper<Manager> qw = new QueryWrapper<>();
//        new BCryptPas
        //判断帐号是否已存在
        qw.eq("m_account",manager.getAccount());
        List<Manager> managers = managerMapper.selectList(qw);
        if(managers.size() > 0 && manager != null){
//            return ResultEntity.failedWithData("该账号已注册!请重试",false);
            return ResultEntity.failed();
        }
        //插入
        String password = manager.getPassword();
        //加密
        String encode = passwordEncoder.encode(password);
        manager.setPassword(encode);
        //保存
        int insert = managerMapper.insert(manager);
        if(insert>0){
            return ResultEntity.success();
        }else {
            return ResultEntity.failed();
        }
    }

    @Override
    public Manager findManagerById(String id) {
        Manager manager = managerMapper.selectById(id);
        return manager;
    }

    @Override
    public boolean deleteByIds(List<String> strings) {
        int i = managerMapper.deleteBatchIds(strings);
        return i>0;
    }
}
