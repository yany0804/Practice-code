package com.ym.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangmin
 * @since 2025-06-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recomment  {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    @TableField(exist = false)
    private Product product;

    private Integer sid;

    @TableField(exist = false)
    private Recommentsite recommentsite;

    private Integer weigth;


}
