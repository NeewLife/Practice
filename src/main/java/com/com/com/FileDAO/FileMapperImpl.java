package com.com.com.FileDAO;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.com.com.FileVO.FileRequest;
import com.com.com.FileVO.FileResponse;

@Repository("fileDao")
public class FileMapperImpl implements FileMapper{
	
	@Inject
	public SqlSessionTemplate sqlSession;
	
	@Override
	public void fileSave(FileRequest fileVO) {
		sqlSession.insert("mapper.fileSave", fileVO);
	};
	
	@Override
	public List<FileResponse> fileView(int seq) {
		return sqlSession.selectList("mapper.fileView", seq);
	}
}
