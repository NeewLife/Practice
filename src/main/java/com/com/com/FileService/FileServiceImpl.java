package com.com.com.FileService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.com.FileDAO.FileMapper;
import com.com.com.FileVO.FileRequest;
import com.com.com.FileVO.FileResponse;

@Service("fileService")
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileMapper fileMapper;
	
	@Override
	public void fileSave(FileRequest fileVO) {
		fileMapper.fileSave(fileVO);
	}
	
	@Override
	public List<FileResponse> fileView(int seq) {
		List<FileResponse> list = fileMapper.fileView(seq);
		for(FileResponse fr : list) {
			fr.setSavePath(fr.getSavePath().replace('\\', '/'));
			System.out.println("Service 변경된 savePath = " + fr.getSavePath());
		}
		return list;
	}
}
