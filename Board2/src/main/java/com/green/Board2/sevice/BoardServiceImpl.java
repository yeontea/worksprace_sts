package com.green.Board2.sevice;

import com.green.Board2.vo.BoardVO;
import com.green.Board2.vo.SearchVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardList")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public void insertList(BoardVO boardVO) {
        sqlSession.insert("insertList",boardVO);

    }

    @Override
    public List<BoardVO> selectBoard(SearchVO searchVO) {

        return sqlSession.selectList("boardMapper.selectBoard",searchVO);
    }

    @Override
    public BoardVO detailBoard(BoardVO boardVO) {
        return sqlSession.selectOne("selectDetail",boardVO);
    }

    @Override
    public void deleteBoard(BoardVO boardVO) {
        sqlSession.delete("deleteBoard",boardVO);
    }

    @Override
    public void updateCnt(BoardVO boardVO) {
        sqlSession.update("updateCnt",boardVO);

    }

    @Override
    public int selectBoardCnt() {
        return sqlSession.selectOne("selectBoardCnt");
    }
}
