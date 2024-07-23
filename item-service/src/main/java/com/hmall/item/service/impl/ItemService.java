package com.hmall.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmall.item.mapper.ItemMapper;
import com.hmall.item.pojo.Item;
import com.hmall.item.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Autowired
    private ItemMapper itemMapper;
    /**
     * 扣减库存
     * @param itemId
     * @param num
     */
    @Override
    public void updateStock(Long itemId, Integer num) {
        Item item = getById(itemId);
        Item build = Item.builder().id(itemId).stock(item.getStock() - num).build();
        itemMapper.updateById(build);
    }
}
