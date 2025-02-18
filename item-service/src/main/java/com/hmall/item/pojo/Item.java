package com.hmall.item.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@TableName("tb_item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @TableId(type = IdType.AUTO)
    private Long id;//商品id
    private String name;//商品名称
    private Long price;//价格（分）
    private Integer stock;//库存数量
    private String image;//商品图片
    private String category;//分类名称
    private String brand;//品牌名称
    private String spec;//规格
    private Integer sold;//销量
    private Integer commentCount;//评论数
    private Integer status;//商品状态 1-正常，2-下架
    @TableField("isAD")
    private Boolean ad;//商品状态 1-正常，2-下架
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;//创建时间
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;//更新时间
}
