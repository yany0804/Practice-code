package com.ym.service.impl;

import com.ym.entity.Category;
import com.ym.mapper.CategoryMapper;
import com.ym.mapper.CategoryMapper;
import com.ym.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangmin
 * @since 2025-06-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
