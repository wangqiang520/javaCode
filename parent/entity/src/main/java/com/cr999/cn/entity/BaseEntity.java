package com.cr999.cn.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 文件描述：
 * 基础实体类
 * @version 1.0
 * @author wangqiang
 * @date 2021/4/4 21:27 
 */
@Data
public class BaseEntity {

    @TableId("id")
    private String id;
    @Version
    @TableField(
            fill = FieldFill.INSERT
    )
    private Integer version;
    @TableField(
            value = "deleted",
            fill = FieldFill.INSERT
    )
    @TableLogic
    private Integer deleted;
    @TableField(
            fill = FieldFill.INSERT
    )
    private Date createTime;
    @TableField(
            fill = FieldFill.INSERT
    )
    private String createUserId;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private Date updateTime;
    @TableField(
            fill = FieldFill.INSERT_UPDATE
    )
    private String updateUserId;

    public BaseEntity() {
    }
}
