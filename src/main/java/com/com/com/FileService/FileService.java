package com.com.com.FileService;

import java.util.List;

import com.com.com.FileVO.FileRequest;
import com.com.com.FileVO.FileResponse;

public interface FileService {
	
	public void fileSave(FileRequest fileVO);
	
	public List<FileResponse> fileView(int seq);
}
