package com.com.com.FileVO;

import lombok.Data;

@Data
public class FileResponse {
	
	/* 파일 번호 */
	private int fileSeq;
	
	/* 파일 이름 원본 */
	private String fileName;
	
	/* 파일 이름 */
	private String saveName;
	
	/* 생성 날짜 */
	private String regDate;
	
	/* 경로 */
	private String savePath;
				
	/* 게시글 SEQ */
	private int listSeq;
}
