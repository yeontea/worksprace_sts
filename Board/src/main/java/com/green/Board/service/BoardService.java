package com.green.Board.service;

import com.green.Board.vo.BoardVO;

import java.util.List;

public interface BoardService {
    int insertBoard(BoardVO boardVO);
    List<BoardVO> selectBoard();
    BoardVO selectDetail(BoardVO boardVO);
    int deleteBoard(BoardVO boardVO);
    int updateBoard(BoardVO boardVO);
}
