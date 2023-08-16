package com.com.com.Controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.com.com.BoardService.BoardService;
import com.nexacro.java.xapi.data.DataSet;
import com.nexacro.java.xapi.data.DataTypes;
import com.nexacro.java.xapi.data.PlatformData;
import com.nexacro.java.xapi.tx.HttpPlatformRequest;
import com.nexacro.java.xapi.tx.HttpPlatformResponse;
import com.nexacro.java.xapi.tx.PlatformException;

import oracle.net.aso.f;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "nexa/post")
	public void list (HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("넥사크로 테스트중");
		HttpPlatformRequest req = new HttpPlatformRequest(request);
		try {
			req.receiveData();
		} catch (PlatformException e) {
			e.printStackTrace();
		}
		PlatformData data = req.getData();
		DataSet inds = data.getDataSet("inDataset");
		
		Map<String, Object> searchParam = new HashMap<String, Object>();
		
        searchParam.put("searchType", inds.getString(0, "searchType"));
        searchParam.put("keyword", inds.getString(0, "keyword"));
        searchParam.put("startDate", inds.getString(0, "startDate"));
        searchParam.put("endDate", inds.getString(0, "endDate"));
        
		System.out.println("searchType = " + searchParam.get("searchType"));
		System.out.println("keyword = " + searchParam.get("keyword"));
		System.out.println("startDate = " + searchParam.get("startDate"));
		System.out.println("endDate = " + searchParam.get("endDate"));
		
		DataSet outds = new DataSet("outDataset");
		
		
		List<Map<String, Object>> list = boardService.getListTest(searchParam);
		Iterator<Map<String, Object>> itr = list.iterator();
		
		
		outds.addColumn("seq",DataTypes.STRING, 100);
		outds.addColumn("name",DataTypes.STRING, 100);
		outds.addColumn("id",DataTypes.STRING, 100);
		outds.addColumn("title",DataTypes.STRING, 1000);
		outds.addColumn("content",DataTypes.STRING, 1000);
		outds.addColumn("regDate",DataTypes.STRING, 100);
		outds.addColumn("uptDate",DataTypes.STRING, 100);
		outds.addColumn("count",DataTypes.STRING, 20);
		
		while (itr.hasNext()) {
			Map<String, Object> str = itr.next();
//			System.out.println("boardSubject = " + str.get("boardSubject"));

			int row = outds.newRow(); 
			outds.set(row,"seq",str.get("seq"));
			outds.set(row,"name",str.get("memName"));
			outds.set(row,"id",str.get("memId"));
			outds.set(row,"title",str.get("boardSubject"));
			outds.set(row,"content",str.get("boardContent"));
			outds.set(row,"regDate",str.get("viewCnt"));
			outds.set(row,"uptDate",str.get("regDate"));
			outds.set(row,"count",str.get("uptDate"));
		}

		data.addDataSet(outds);

		HttpPlatformResponse res = new HttpPlatformResponse(response, req);
		res.setData(data);
		System.out.println("setData 성공");
		try {
			res.sendData();
			System.out.println("sendData 성공");
		} catch (PlatformException e) {
			e.printStackTrace();
		}
	}
}
