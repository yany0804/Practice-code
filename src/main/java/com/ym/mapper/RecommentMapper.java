package com.ym.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Recomment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangmin
 * @since 2025-06-11
 */
public interface RecommentMapper extends BaseMapper<Recomment> {
    //注意还要在IRecommentService里定义一遍，再去RecommentServiceImpl里实现这个方法
    public IPage<Recomment>getRecommentByXML(Integer sid, Page<Recomment>pg);

}
