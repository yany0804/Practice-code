package com.ym.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class Category  {

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;
    private String cname;
}
