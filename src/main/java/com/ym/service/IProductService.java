package com.ym.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangmin
 * @since 2025-06-04
 */
public interface IProductService extends IService<Product> {
    public IPage<Product> getProductByXML(Map<String,Object> param, Page<Product> pg);
}
