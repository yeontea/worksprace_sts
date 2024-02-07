package com.green.Board2.controller;

import com.green.Board2.sevice.BoardService;
import com.green.Board2.sevice.ReplayService;
import com.green.Board2.vo.BoardVO;
import com.green.Board2.vo.MemberVO;
import com.green.Board2.vo.ReplayVO;
import com.green.Board2.vo.SearchVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController{
    // 목록조회, 글쓰기, 상세조회, 수정, 삭제
    @Resource(name="boardList")
    private BoardService boardService;
    @Resource(name="replay")
    private ReplayService replayService;


    @RequestMapping("/list")
    public String boardList(Model model
    , SearchVO searchVO){
        // 전체 데이터 수
        int totalDataCnt = boardService.selectBoardCnt();
        searchVO.setTotalDataCnt(totalDataCnt);


        //페이지 정보 세팅
        searchVO.setPageInfo();
        List<BoardVO> list = boardService.selectBoard(searchVO);
        model.addAttribute("list",list);



        return "list";
    }
    @GetMapping("/insert")
    public String insertWrite(){
        return "board_write_form";
    }
    @PostMapping("/insert2")
    public String insertBoardList(BoardVO boardVO
    , HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        boardVO.setWriter(loginInfo.getMemberId());
        boardService.insertList(boardVO);
        return "redirect:/board/list";
    }
    @GetMapping("/detail")
    public String selectDetail(BoardVO boardVO
    , Model model, ReplayVO replayVO){
       BoardVO bo = boardService.detailBoard(boardVO);
       model.addAttribute("bDetail",bo);
        List<ReplayVO> list = replayService.selectReplay(replayVO);
        model.addAttribute("list",list);
       boardService.updateCnt(boardVO);
        return "board_detail";
    }
    @GetMapping("/deleteRep")
    public String deleteReplay(ReplayVO replayVO){
        replayService.deleteReplay(replayVO);

        return "redirect:/board/detail?boardNum="+replayVO.getBoardNum();

    }
    @GetMapping("/delete")
    public String boardDelete(BoardVO boardVO){
        boardService.deleteBoard(boardVO);
        return "redirect:/board/list";
    }

    @PostMapping("/replayInsert")
    public String replayInsert(ReplayVO replayVO
    , HttpSession session){
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        replayVO.setWriter(loginInfo.getMemberId());
        replayService.insertReplay(replayVO);
        return "redirect:/board/detail?boardNum="+replayVO.getBoardNum();
    }






}
