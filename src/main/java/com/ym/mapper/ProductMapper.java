package com.ym.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangmin
 * @since 2025-06-04
 */
public interface ProductMapper extends BaseMapper<Product> {
    public IPage<Product>getProductByXML(Map<String,Object>param, Page<Product>pg);
}
