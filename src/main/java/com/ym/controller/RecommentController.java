package com.ym.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Recomment;
import com.ym.service.IRecommentService;
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
@RequestMapping("/recomment")
public class RecommentController {
    @Autowired
    private IRecommentService recommentService;

    @RequestMapping("/addRecomment")
    public Result addRecomment(Recomment recomment){
        QueryWrapper<Recomment>wrapper=new QueryWrapper<Recomment>();
        wrapper.eq("pid",recomment.getPid()).eq("sid",recomment.getSid());
        List<Recomment>list=recommentService.list(wrapper);
        Result result;
        if(list!=null&&list.size()>0){
            result=new Result(1,"不可重复推荐");
        }else{
            boolean jg=recommentService.save(recomment);
            if(jg){
                result=new Result(0,"推荐成功");
            }else{
                result=new Result(1,"推荐失败");
            }
        }

        return result;
    }

    @RequestMapping("/getRecmts")
    public Result getRecmts(Integer page,Integer limit,Integer sid){
        //创建分页对象
        Page<Recomment>pg=new Page<Recomment>(page,limit);
        IPage<Recomment>recmts=recommentService.getRecommentByXML(sid,pg);
        //获取当前页的记录
        List<Recomment>list=recmts.getRecords();
        //获取数据总条数
        int total=(int)recmts.getTotal();
        Result result;
        if(list!=null){
            result=new Result(0,"",total,list);
        }else{
            result=new Result(1,"无数据");
        }
        return result;
    }

    @RequestMapping("/updateRcmt")
    public Result updateRcmt(Recomment recomment,Integer oldsid){
        Result result;
        if(recomment.getSid()!=oldsid){
            QueryWrapper<Recomment>wrapper=new QueryWrapper<Recomment>();
            wrapper.eq("sid",recomment.getSid()).eq("pid",recomment.getPid());
            List<Recomment>list=recommentService.list(wrapper);
            if(list!=null&&list.size()>0){
                result=new Result(1,"该商品在该位置已推荐，不可重复推荐");
            }else{
                boolean jg=recommentService.saveOrUpdate(recomment);
                if(jg){
                    result=new Result(0,"修改成功");
                }else{
                    result=new Result(1,"修改失败");
                }
            }
        }else{
            boolean jg=recommentService.saveOrUpdate(recomment);
            if(jg){
                result=new Result(0,"修改成功");
            }else{
                result=new Result(1,"修改失败");
            }
        }
        return result;
    }

    @RequestMapping("/delRcmtById")
    public Result delRcmtById(Integer id){
        boolean jg= recommentService.removeById(id);
        Result result;
        if(jg){
            result=new Result(0,"删除成功");
        }else{
            result=new Result(1,"删除失败");
        }
        return result;
    }

}
