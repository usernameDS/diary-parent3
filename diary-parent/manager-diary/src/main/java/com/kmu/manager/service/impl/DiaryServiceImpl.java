package com.kmu.manager.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kmu.manager.entity.Diary;
import com.kmu.manager.mapper.DiaryMapper;
import com.kmu.manager.service.DiaryService;
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
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements DiaryService {

}
