package com.ym.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Category;
import com.ym.entity.Product;
import com.ym.entity.Recommentsite;
import com.ym.service.IRecommentsiteService;
import com.ym.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangmin
 * @since 2025-06-11
 */
@RestController
@RequestMapping("/recommentsite")
public class RecommentsiteController {
    @Autowired
    private IRecommentsiteService recommentsiteService;

    @RequestMapping("/getRecommentsite")
    public Result getRecommentsite(Integer page,Integer limit,String site){
        //创建分页对象
        Page<Recommentsite> pg=new Page<Recommentsite>(page,limit);
        //创建查询条件对象
        QueryWrapper<Recommentsite> wrapper=new QueryWrapper<Recommentsite>();
        if(site!=null && site!="") {
            wrapper.like("site",site);
        }
        //分页查询
        Page<Recommentsite>sites=recommentsiteService.page(pg,wrapper);
        //获取当前页数据
        List<Recommentsite>sitesRecords=sites.getRecords();
        //获取总条数
        int total = (int)sites.getTotal();
        //System.out.println(total);
        Result result;
        if(sitesRecords!=null){
            result=new Result(0,"",total,sitesRecords);
        }else{
            result=new Result(1,"无数据");
        }
        return result;
    }

    @RequestMapping("/addRecommentsite")
    public Result addRecommentsite(Recommentsite recommentsite){
        boolean jg=recommentsiteService.save(recommentsite);
        Result result;
        if(jg){
            result=new Result(0,"添加成功");
        }else{
            result=new Result(1,"添加失败");
        }
        return result;
    }

    @RequestMapping("/updateRecommentsite")
    public Result updateRecommentsite(Recommentsite recommentsite){
        boolean jg=recommentsiteService.saveOrUpdate(recommentsite);
        Result result;
        if(jg){
            result=new Result(0,"修改成功");
        }else{
            result=new Result(1,"修改失败");
        }
        return result;
    }

    @RequestMapping("/getList")
    public List<Recommentsite>getList(){
        return recommentsiteService.list();
    }
}
