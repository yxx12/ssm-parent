package com.itheima.service;

import com.itheima.domain.Items;

import java.util.List;

public interface ItemsService {
    List<Items> queryAll();
    int save(Items items);
    void Transactional(String from, String to, Float p);
}
