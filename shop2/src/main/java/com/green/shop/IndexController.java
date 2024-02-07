package com.green.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 프로잭트 실행 시 가장 처음 실행되는 컨트롤러
@Controller
public class IndexController {
    // 프로잭트 실행 시 상품 목록 페이지로 이동
    @GetMapping("/")
    public String main(){
        return"redirect:/item/list";
    }

}
