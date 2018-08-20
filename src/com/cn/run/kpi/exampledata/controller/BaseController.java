package com.cn.run.kpi.exampledata.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * <p>
 * Description:controller的基类 
 * </p>
 *
 * @author zcy
 * @version 1.0

 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2017-5-9 上午11:17:17         zcy        1.0         To create
 * </p>
 *
 * @since 
 * @see
 */
public class BaseController {

	/**
	 * 把text文本写入页面
	 * @param json
	 * @param response
	 */
	protected void writeTxt(String txt,HttpServletResponse response){
		if(StringUtils.isEmpty(txt)){
			return;
		}
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		try {
			/*request.setCharacterEncoding("UTF-8");*/
			response.getWriter().write(txt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 把json写入页面
	 * @param json
	 * @param response
	 */
	protected void writeJson(String json,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf8");
		try {
			response.getWriter().write(json);
			response.getWriter().close();
		} catch (Exception e) {
			try {
				response.getWriter().close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
