package com.kmu.manager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kmu.manager.util.ResultEntity;
import com.kmu.manager.entity.Manager;

import java.util.List;

/**
 * @作者：Deng 时间：2020/8/18 21:32
 */
public interface ManagerService extends IService<Manager> {

    Page<Manager> selectManagers(String account, Integer pageNum, Integer pageSize);

    ResultEntity insert(Manager manager);

    Manager findManagerById(String id);

    boolean deleteByIds(List<String> strings);


}
