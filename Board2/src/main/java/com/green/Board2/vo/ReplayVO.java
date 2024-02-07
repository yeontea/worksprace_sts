package com.green.Board2.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplayVO {
    private int replayNum;
    private String content;
    private String createDate;
    private String writer;
    private int boardNum;

}
