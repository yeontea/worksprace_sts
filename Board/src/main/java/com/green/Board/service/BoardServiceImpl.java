package com.green.Board.service;

import com.green.Board.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardSer")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public int insertBoard(BoardVO boardVO) {
        sqlSession.insert("insertBoard", boardVO);
        return 0;
    }

    @Override
    public List<BoardVO> selectBoard() {
         List<BoardVO> list = sqlSession.selectList("selectBoard");

        return list;

    }

    @Override
    public BoardVO selectDetail(BoardVO boardVO) {

        return sqlSession.selectOne("selectDetail", boardVO);
    }

    @Override
    public int deleteBoard(BoardVO boardVO) {
        sqlSession.selectOne("deleteboard",boardVO);
        return 0;
    }

    @Override
    public int updateBoard(BoardVO boardVO) {
        sqlSession.update("updateDetail",boardVO);
        return 0;
    }
}
