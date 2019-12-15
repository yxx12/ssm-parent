package com.itheima.controller;

import com.itheima.domain.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("queryAll")
    public String queryAll(Model model) {
        List<Items> items = itemsService.queryAll();
        model.addAttribute("items", items);
        return "success";
    }

    @RequestMapping("save")
    public String save(Items items) {
        itemsService.save(items);
        /*重定向到 查询全部的url*/
        return "redirect:/items/queryAll";
    }

    @RequestMapping("Transactional")
    public String Transactional() {
        String from = "传智播客web课程";
        String to = "黑马之路";
        Float p = 1000F;
        itemsService.Transactional(from, to, p);
        return "success";
    }
}
