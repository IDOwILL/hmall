package com.hmall.item.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmall.item.dto.ItemDTO;
import com.hmall.item.dto.PageDTO;
import com.hmall.item.pojo.Item;
import com.hmall.item.result.PageVO;
import com.hmall.item.result.Result;
import com.hmall.item.service.IItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("item")
@Slf4j
public class ItemController {

    @Autowired
    private IItemService itemService;

    /**
     * 新增商品(题目一）
     *
     * @return
     */
    @PostMapping
    public Result save(@RequestBody ItemDTO dto) {
        log.info("新增商品：{}", dto);
        Item item = new Item();
        BeanUtils.copyProperties(dto, item);
        itemService.save(item);
        return Result.success();
    }

    /**
     * 设置上架下架题目二
     *
     * @param id
     * @param status
     * @return
     */
    @PutMapping("/status/{id}/{status}")
    public Result startOrStop(@PathVariable Long id, @PathVariable Integer status) {
        log.info("设置上架下架:id：{},status:{}", id, status);
        Item item = Item.builder().id(id).status(status).build();
        itemService.updateById(item);
        return Result.success();
    }

    /**
     * 根据id修改商品
     *
     * @param dto
     * @return
     */
    @PutMapping
    public Result update(@RequestBody ItemDTO dto) {
        log.info("修改商品：{}", dto);
        Item item = new Item();
        BeanUtils.copyProperties(dto, item);
        itemService.updateById(item);
        return Result.success();
    }

    /**
     * 分页查询问题五
     * @return
     */
    @GetMapping("/list")
    public Result queryPageList(PageDTO dto) {
        log.info("商品分页查询：{}", dto);
        Page<Item> page = itemService.page(new Page<>(dto.getPage(), dto.getSize()));
        return Result.success(new PageVO<>(page.getTotal(), page.getRecords()));
    }
}
