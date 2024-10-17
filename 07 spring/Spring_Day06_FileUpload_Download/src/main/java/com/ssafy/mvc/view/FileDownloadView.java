package com.ssafy.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView{

	@Autowired
	private ResourceLoader resourceLoader;

	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("renderMergedOutputModel 메서드 호출");
		String fileName = (String) model.get("fileName");
		Resource resource = resourceLoader.getResource("classpath:/static/img");
		File file = new File(resource.getFile(), fileName);
		////////사전 준비//////////
		
		//한글 같은게 다른 브라우저에서 깨질 수 있어서 추가해주는 거
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+fileName + "\";"); // 이건 그냥 약속임, 다운로드 받으려면
		response.setHeader("Content-Transfer-Encoding", "binary");
		///////////응답 header 설정 끝///
		
		try (FileInputStream fis = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				){
			FileCopyUtils.copy(fis, os);				
			
		}
		
		
		
	}

}
