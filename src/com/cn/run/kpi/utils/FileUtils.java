package com.cn.run.kpi.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.cn.run.kpi.commons.content.Constants;

public class FileUtils {
	
	private static final Logger LOG = Logger.getLogger(FileUtils.class);

	/**
	 * 生成JSON文件
	 * @param jsonString json字符串
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @throws IOException 
	 */
	public static void createJsonFile(String jsonString,String filePath,String fileName) {
		String fullPath = filePath + File.separator + fileName + ".json";
		try {
			File file = new File(fullPath);
			file.setWritable(true, false);//设置linux写权限
			
			//如果父目录不存在，创建目录
			if(!file.getParentFile().exists()){ 
				file.getParentFile().mkdirs();
			}
			//如果已存在文件，则删除旧文件
			if(file.exists()){
				file.delete();
			}
			file.createNewFile();
			
			Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
			write.write(jsonString);
			write.flush();
			write.close();
		} catch (Exception e) {
			LOG.error(">>>>>createJsonFile error", e);
		}
	}
	
	/**
	 * 获取文件路径
	 * @return
	 */
	public static String getFilePath(String directory) {
		return Constants.ROOT +  "dataJson" + File.separator + directory + File.separator + "day";
	}
	
	/**
	 * 获取文件名
	 */
	public static String getFileName() {
		Calendar calendar = Calendar.getInstance();
		return "" + calendar.get(Calendar.YEAR) + ((calendar.get(Calendar.MONTH) + 1)<10?("0"+(calendar.get(Calendar.MONTH) + 1)):(calendar.get(Calendar.MONTH) + 1)) + ((calendar.get(Calendar.DAY_OF_MONTH))<10?("0"+(calendar.get(Calendar.DAY_OF_MONTH))):(calendar.get(Calendar.DAY_OF_MONTH)));
	}

}
