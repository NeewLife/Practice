package com.com.com.FileVO;

import lombok.Data;

@Data
public class FileRequest {
	
	/* 파일 이름 원본 */
	private String fileName;
	
	/* 파일 이름 */
	private String saveName;
	
	/* 경로 */
	private String savePath;
				
	/* 게시글 SEQ */
	private int listSeq;
}
