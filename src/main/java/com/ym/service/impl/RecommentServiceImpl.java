package com.ym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Recomment;
import com.ym.mapper.RecommentMapper;
import com.ym.service.IRecommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangmin
 * @since 2025-06-11
 */
@Service
public class RecommentServiceImpl extends ServiceImpl<RecommentMapper, Recomment> implements IRecommentService {
    @Resource
    private RecommentMapper recommentMapper;
    public IPage<Recomment> getRecommentByXML(Integer sid, Page<Recomment> pg){
        return recommentMapper.getRecommentByXML(sid,pg);
    }
}
