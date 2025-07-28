package com.ym.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ym.entity.Product;
import com.ym.service.IProductService;
import com.ym.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangmin
 * @since 2025-06-04
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    //分页查询商品
    @RequestMapping("/getProducts")
    public Result getProducts(Integer page,Integer limit,String pname,Integer cid,Integer state){
        //创建分页对象
        Page<Product>pg=new Page<Product>(page,limit);
        Map<String,Object> map=new HashMap<String,Object>();
        //参数存入map中
        map.put("pname",pname);
        map.put("cid",cid);
        map.put("state",state);
        //调用自定义分页的方法
        IPage<Product> pros=productService.getProductByXML(map,pg);
        //获取当前页数据
        List<Product> productList=pros.getRecords();
        //获取数据总条数
        int total=(int)pros.getTotal();
        Result result;
        if(productList!=null){
            result=new Result(0,"",total,productList);
        }else{
            result=new Result(1,"无数据");
        }
        return result;
    }

    @RequestMapping("/shang")
    public Result shang(Product product){
        boolean jg=productService.saveOrUpdate(product);
        Result result;
        if(jg){
            result=new Result(0,"上架成功");
        }else{
            result=new Result(1,"上架失败");
        }
        return result;
    }

    @RequestMapping("/xia")
    public Result xia(Product product){
        boolean jg=productService.saveOrUpdate(product);
        Result result;
        if(jg){
            result=new Result(0,"下架成功");
        }else{
            result=new Result(1,"下架失败");
        }
        return result;
    }

    @RequestMapping("/addProduct")
    public Result addProduct(Product product){
        boolean jg=productService.save(product);
        Result result;
        if(jg){
            result=new Result(0,"添加成功");
        }else{
            result=new Result(1,"添加失败");
        }
        return result;
    }

    @RequestMapping("/updateProduct")
    public Result updateProduct(Product product){
        boolean jg=productService.saveOrUpdate(product);
        Result result;
        if(jg){
            result=new Result(0,"修改成功");
        }else{
            result=new Result(1,"修改失败");
        }
        return result;
    }
    @RequestMapping("/delProductById")
    public Result delProductById(Integer pid){
        Result result;
        boolean jg=productService.removeById(pid);
        if(jg){
            result=new Result(0,"删除成功");
        }else{
            result=new Result(1,"删除失败");
        }
        return result;
    }

    @RequestMapping("/image")
    public Result image(MultipartFile file) throws IOException {
        File imageFile = new File("");
        BufferedWriter bufferedWriter = null;
        String newFileName=file.getOriginalFilename();//图片名称
        try{
            String fileUrl = imageFile.getCanonicalPath()+ File.separator+"src\\main\\resources\\static\\images\\"+newFileName;
            imageFile = new File(fileUrl);
            if(!imageFile.getParentFile().exists()){
                imageFile.mkdirs();
            }
            if(imageFile.exists()){

            }else {
                imageFile.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(imageFile,true)));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bufferedWriter.flush();
            bufferedWriter.close();
        }

        Result result=new Result(0,newFileName);
        return result;
    }
}
