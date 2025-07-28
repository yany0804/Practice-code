package com.ym.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangmin
 * @since 2025-06-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

    @TableId(value = "Uid", type = IdType.AUTO)
    private Integer uid;

    private String uname;

    private String upwd;

    private String usex;

    private String uphone;

    private Integer urole;


}
