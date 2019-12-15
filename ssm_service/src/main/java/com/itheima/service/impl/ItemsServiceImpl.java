package com.itheima.service.impl;

import com.itheima.dao.ItemsDao;
import com.itheima.domain.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;

    @Override
    @Transactional
    public List<Items> queryAll() {
        System.out.println("ItemsServiceImpl执行了");
        return itemsDao.queryAll();
    }

    @Override
    // @Transactional  //打开事务管理 玩玩，此处其实不需要
    public int save(Items items) {
        int line = itemsDao.save(items);
        System.out.println("影响行数line：" + line);
        return line;
    }

    @Override
    @Transactional
    public void Transactional(String from, String to, Float p) {
            Items fromI = itemsDao.findByName(from);
            Items toI = itemsDao.findByName(to);

            fromI.setPrice(fromI.getPrice() - p);
            toI.setPrice(toI.getPrice() + p);

            itemsDao.edit(fromI);
           // Integer a = 1 / 0;
            itemsDao.edit(toI);
            System.out.println("我是切点，执行了。。。。。。。。。。。");

    }
}
