package com.ym.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Recomment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangmin
 * @since 2025-06-11
 */
public interface IRecommentService extends IService<Recomment> {
    public IPage<Recomment> getRecommentByXML(Integer sid, Page<Recomment> pg);

}
