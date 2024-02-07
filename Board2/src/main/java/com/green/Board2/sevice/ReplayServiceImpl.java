package com.green.Board2.sevice;

import com.green.Board2.vo.ReplayVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("replay")
public class ReplayServiceImpl implements ReplayService{
    @Autowired
    private SqlSessionTemplate sqlSessionRe;

    @Override
    public void insertReplay(ReplayVO replayVO) {
        sqlSessionRe.insert("replayMapper.insert", replayVO);
    }

    @Override
    public List<ReplayVO> selectReplay(ReplayVO replayVO) {
        return sqlSessionRe.selectList("replayMapper.selectRep",replayVO);
    }

    @Override
    public void deleteReplay(ReplayVO replayVO) {
        sqlSessionRe.delete("replayMapper.deleteRep", replayVO);
    }
}
