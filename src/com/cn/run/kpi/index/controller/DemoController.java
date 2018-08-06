package com.cn.run.kpi.index.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cn.run.kpi.utils.ExcelUtil;


@Controller
@RequestMapping("/excelDemo")
public class DemoController {
	
	/**
	 * 导入测试
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/testExport")
	public void testExport(HttpServletResponse response) throws Exception{
//		List<User> users = userService.listByKey("");
		
		System.out.println("testgithub");
		List<User> users = new ArrayList<User>();
		ExcelUtil<User> excelUtil = new ExcelUtil<User>();
		String fileName = "测试导出.xls";
		
		excelUtil.addHeader("id", "id");
		excelUtil.addHeader("用户名", "userName");
		excelUtil.addHeader("密码", "password");
		
		response.setContentType("octets/stream");  
        response.addHeader("Content-Disposition",  "attachment;filename=" + new String(fileName.getBytes("utf-8"),"iso-8859-1"));  
		
		excelUtil.generateExcelFile(users, "用户列表", "YYYY-MM-dd", response.getOutputStream());
	}
	
	
	/**
	 * 上传excel文件
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/testImport")
	@ResponseBody
	public void importBusinessRecord(MultipartFile file,HttpServletRequest request) throws Exception{
		ExcelUtil<User> excelUtil = new ExcelUtil<User>();
		
		excelUtil.addHeader(0, "id");
		excelUtil.addHeader(1, "userName");
		excelUtil.addHeader(2, "password");
		
//		List<Map<String, Object>> dataList = excelUtil.exportListFromExcel(file.getInputStream(), extensionName, 0);
		//System.out.println(dataList);
	}
	
	class User {
		private long id;
		
		private String username;
		
		private String password;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
}
