package com.ym.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Category;
import com.ym.entity.Product;
import com.ym.service.ICategoryService;
import com.ym.service.IProductService;
import org.apache.poi.ss.formula.functions.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ym.utils.Result;
import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangmin
 * @since 2025-06-04
 */
@RestController//所有方法返回json格式
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;
    //后端进行分页查询的方法
    @RequestMapping("/getCates")
    public Result getCates(Integer page,Integer limit,String cname){
        //创建分页对象
        Page<Category>pg=new Page<Category>(page,limit);
        //创建查询条件对象
        QueryWrapper<Category>wrapper=new QueryWrapper<Category>();
        if(cname!=null && cname!="") {
            wrapper.like("cname",cname);
        }
        //分页查询
        Page<Category>cates=categoryService.page(pg,wrapper);
        //获取当前页数据
        List<Category>categories=cates.getRecords();
        //获取总条数
        int total = (int)cates.getTotal();
        //System.out.println(total);
        Result result;
        if(categories!=null){
            result=new Result(0,"",total,categories);
        }else{
            result=new Result(1,"无数据");
        }
        return result;
    }
    @RequestMapping("/addCate")
    public Result addCate(Category category){
        boolean jg=categoryService.save(category);
        Result result;
        if(jg){
            result=new Result(0,"添加成功");
        }else{
            result=new Result(1,"添加失败");
        }
        return result;
    }
    @RequestMapping("/updateCate")
    public Result updateCate(Category category){
        boolean jg=categoryService.saveOrUpdate(category);
        Result result;
        if(jg){
            result=new Result(0,"修改成功");
        }else{
            result=new Result(1,"修改失败");
        }
        return result;
    }
    @RequestMapping("/delCate")
    public Result delCate(Integer cid){
        //先查询该类别有没有商品在使用
        QueryWrapper<Product>wrapper=new QueryWrapper<Product>();
        wrapper.eq("cid",cid);
        List<Product>pros=productService.list(wrapper);
        Result result;
        if(pros!=null&&pros.size()>0){
            result=new Result(1,"该类别下有商品，不可删除");
        }else{
            boolean jg=categoryService.removeById(cid);
            if(jg){
                result=new Result(0,"删除成功");
            }else{
                result=new Result(1,"删除失败");
            }
        }
        return result;
    }
    //返回json格式的所有注解
    @RequestMapping("/getList")
    public List<Category> getList(){

        return categoryService.list();
    }
}
