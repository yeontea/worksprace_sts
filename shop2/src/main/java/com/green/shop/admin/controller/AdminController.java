package com.green.shop.admin.controller;

import com.green.shop.admin.service.AdminService;
import com.green.shop.item.service.ItemService;
import com.green.shop.item.vo.CategoryVO;
import com.green.shop.item.vo.ImgVO;
import com.green.shop.item.vo.ItemVO;
import com.green.shop.util.ConstantVariable;
import com.green.shop.util.UploadUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource(name="adminService")
    AdminService adminService;
    @Resource(name="itemService")
    ItemService itemService;

    // 상품 등록 페이지로 이동
    @GetMapping("/lagItemForm")
    public String lagItemForm(CategoryVO categoryVO,
                              Model model){
        List<CategoryVO> data = itemService.select();
        model.addAttribute("cateData", data);

        return "content/admin/reg_item_form";
    }
    @PostMapping("/insert")
    public String insertItem(ItemVO itemVO,
                             @RequestParam(name="img1") MultipartFile img1,
                             @RequestParam(name="img2") MultipartFile[] img2){



        // 자바의 상수
        final int NUM = 10;



        // 상품 등록 쿼리 실행
        int itemCode = adminService.selectNextItemCode();
        itemVO.setItemCode(itemCode);

        // 현재 itemVO에는 상품명, 가격, 상품소개, 카테코드
        // 이미지 등록 시 채워줘야 하는 모든 데이터를 갖는 리스트 생성
        List<ImgVO> imgList = new ArrayList<>();

        ImgVO mainImgVO = UploadUtil.uploadFile(img1);
        mainImgVO.setItemCode(itemCode);
         imgList = UploadUtil.multiUploadFile(img2);
        for(ImgVO img : imgList){
            img.setItemCode(itemCode);
        }
        imgList.add(mainImgVO);

        itemVO.setImgList(imgList);

        System.out.println(itemVO);

        adminService.insertItem(itemVO);


//

        return "redirect:/admin/lagItemForm";
    }


}
