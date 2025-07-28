package com.ym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Product;
import com.ym.mapper.ProductMapper;
import com.ym.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangmin
 * @since 2025-06-04
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Resource
    private ProductMapper productMapper;

    public IPage<Product> getProductByXML(Map<String,Object> param, Page<Product> pg){
        return productMapper.getProductByXML(param,pg);
    }

}
