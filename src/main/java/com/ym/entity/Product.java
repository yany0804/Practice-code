package com.ym.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangmin
 * @since 2025-06-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product  {
    @TableId(value = "pid", type = IdType.AUTO)//自增
    private Integer pid;

    private String pname;

    private Integer cid;

    @TableField(exist = false)
    private Category category;//类别对象

    private String pintro;

    private String ptext;

    private Integer pchoice;

    private Integer state;

    private String mpicture;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdop;

    private Integer sexp;

    private Integer sweight;

    private String sdrand;

    private String cahng;

    private Double xprice;

    private Double yprice;

    private String stock;

    private String taste;


}
