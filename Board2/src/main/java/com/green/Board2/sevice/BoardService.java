package com.green.Board2.sevice;

import com.green.Board2.vo.BoardVO;
import com.green.Board2.vo.SearchVO;

import java.util.List;

public interface BoardService {
    void insertList(BoardVO boardVO);
    List<BoardVO> selectBoard(SearchVO searchVO);
    BoardVO detailBoard(BoardVO boardVO);
    void deleteBoard(BoardVO boardVO);
    void updateCnt(BoardVO boardVO);
    // 게시글 수 조회
    int selectBoardCnt();
}
