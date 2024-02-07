package com.green.shop.member.controller;

import com.green.shop.member.service.MemberService;
import com.green.shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class memberController {
    @Resource(name="memberService")
    MemberService memberService;

    @PostMapping("/join")
    public String joinMember(MemberVO memberVO){

        memberVO.setMemberTel(memberVO.getMemberTel().replace(",","-"));
        memberVO.setMemberEmail(memberVO.getMemberEmail().replace(",",""));



        memberService.insertMember(memberVO);
        return "redirect:/item/list";
    }
    @GetMapping("/loginForm")
    public String loginForm(){
        return "content/member/login";
    }
    @PostMapping("/login")
    public String login(MemberVO memberVO, HttpSession session , Model model){
        MemberVO loginInfo = memberService.loginForm(memberVO);
        if(loginInfo != null){
            //세션에 로그인 정보를 저장
            session.setAttribute("loginInfo", loginInfo);


        }


            return "content/member/login_result";




    }

    @PostMapping("/loginFetch")
    @ResponseBody
    public String loginFetch(MemberVO memberVO , HttpSession session){
        MemberVO loginInfo = memberService.loginForm(memberVO);
        if(loginInfo != null){
            //세션에 로그인 정보를 저장
            session.setAttribute("loginInfo", loginInfo);


        }
        return loginInfo == null ? "" : loginInfo.getMemberId();


    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginInfo");
        return "redirect:/item/list";
    }

}
