package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpClient;
import java.util.List;

@Controller
public class BoardController {
    @Resource(name = "boardSer")
    private BoardService boardService;
@GetMapping("/a")
    public String board(Model model){
    List<BoardVO> list = boardService.selectBoard();
    model.addAttribute("boardList",list);
        return "board_list";
    }
    @GetMapping("/b")
    public String Input(){
    return "board_write_form";
    }
    @PostMapping("/c")
    public String insertBoard(BoardVO boardVO
    ){
    boardService.insertBoard(boardVO);
    return "redirect:/a";
    }
    @GetMapping("/Detail")
    public String selectDetail(BoardVO boardVO
    , Model model){
    BoardVO board = boardService.selectDetail(boardVO);
    model.addAttribute("bd", board);
    return "board_detail";
    }
    @GetMapping("/delete")
    public String deldeteBo(BoardVO boardVO){
    boardService.deleteBoard(boardVO);
    return "redirect:/a";
    }
    @PostMapping("/ub")
    public String goUb(BoardVO boardVO
    , Model model){

    model.addAttribute("update",boardVO);
    return "update_form";
    }


    @PostMapping("updateD")
    public String updateBoard (BoardVO boardVO
    ){
    boardService.updateBoard(boardVO);
    return "redirect:/Detail?boardNum=" + boardVO.getBoardNum();
    }


}
