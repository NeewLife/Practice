package com.com.com.BoardVO;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardRequest {
//	Board 컨트롤러에서 DB로 삽입, 수정하기 위한 틀
	private int seq;
	private String memName;
	private String memId;
	private String boardSubject;
	private String boardContent;
}
