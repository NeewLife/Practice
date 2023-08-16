package com.com.com.FileDAO;

import java.util.List;

import com.com.com.FileVO.FileRequest;
import com.com.com.FileVO.FileResponse;

public interface FileMapper {
	public void fileSave(FileRequest fileVO);
	
	public List<FileResponse> fileView(int seq);
}
