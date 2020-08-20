package com.kmu.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kmu.manager.entity.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @作者：Deng 时间：2020/8/18 21:30
 */
public interface ManagerMapper extends BaseMapper<Manager> {
    //查询总数
    public Long countManager(@Param("likeName") String likeName);

    List<Manager> selectMapsPage(@Param("likeName")String likeName, @Param("begin")Integer begin, @Param("size")Integer size);
}
