package com.green.shop.member.controller;

import com.green.shop.item.service.ItemService;
import com.green.shop.item.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Resource(name="itemService")
    ItemService itemService;
    //상품 목록 페이지
    @GetMapping("/list")
    public String list(Model model){
        List<ItemVO> list = itemService.selectItemList();
        model.addAttribute("list",list);
        return "content/item/item_list";
    }
    @GetMapping("/detail")
    public String selectDetail(ItemVO itemVO, Model model){
        ItemVO itemDetail = itemService.selectDetail(itemVO);
        model.addAttribute("detail", itemDetail);

        return "content/item/item_detail";
    }

}
