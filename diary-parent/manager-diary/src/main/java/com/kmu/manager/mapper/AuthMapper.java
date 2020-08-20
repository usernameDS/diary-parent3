package com.kmu.manager.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kmu.manager.entity.Auth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Deng
 * @since 2020-07-25
 */
public interface AuthMapper extends BaseMapper<Auth> {

    List<String> selectAuthNameByManagerId(Integer id);


}
