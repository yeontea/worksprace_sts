package com.green.Board2.sevice;

import com.green.Board2.vo.ReplayVO;

import java.util.List;

public interface ReplayService {
    void insertReplay(ReplayVO replayVO);
    List<ReplayVO>selectReplay(ReplayVO replayVO);
    void deleteReplay(ReplayVO replayVO);

}
