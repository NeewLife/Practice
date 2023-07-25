package com.com.com.BoardVO;

import lombok.Data;

@Data
public class BoardResponse {
//	DB로부터 받으려는 데이터 틀
	private int rn;
	private int seq;
	private String memName;
	private String memId;
	private String boardSubject;
	private String boardContent;
	private String regDate;
	private String uptDate;
	private int viewCnt;
	private String useYn;
}