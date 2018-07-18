package com.cn.run.kpi.utils;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.run.framework.excel.exception.InvalidExtensionNameException;
import com.run.framework.excel.exception.NullExcelHeaderException;

public class ExcelUtil<T> {
	
	private final static String XLS = "xls";  
    private final static String XLSX = "xlsx";  
    private final static String CSV = "csv";  
    
    /**
     * Excel标题和字段对应类
     * @author dfg
     *
     */
    static class ExcelHeader{
    	/**列编号*/
    	int index;
    	/**标题*/
		String title;	
		/**字段*/
		String field;
		
		ExcelHeader(String title, String field){
			this.title = title;
			this.field = field;
		}
		
		ExcelHeader(int index, String field){
			this.index = index;
			this.field = field;
		}
	}
    
    public static List<ExcelHeader> headers = new ArrayList<ExcelHeader>();
	
	/**
	 * @param title
	 * @param filed
	 */
	public void addHeader(String title,String field){
		headers.add(new ExcelHeader(title, field));
	}
	
	/**
	 * @param title
	 * @param filed
	 */
	public void addHeader(int index,String field){
		headers.add(new ExcelHeader(index, field));
	}
	
	/**
	 * @param index
	 * @return
	 */
	private String getField(int index){
		for(ExcelHeader eh : headers){
			if(eh.index==index){
				return eh.field;
			}
		}
		return null;
	}
	
	
	/**
	 * @param dataList    数据集
	 * @param sheetName   sheet页名称
	 * @param datePattern 日期格式
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private HSSFWorkbook generateExcelFile(List<T> dataList,String sheetName,String datePattern){
		if(headers.isEmpty()){
			throw new NullExcelHeaderException("ExcelHeader is Empty!");
		}else{
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(sheetName);
			sheet.setColumnWidth(0, 16 * 256);	//设置宽度
			
			try{
				for(int j=0;j<=dataList.size();j++){
					HSSFRow row = sheet.createRow(j);
					int i = 0;
					for(ExcelHeader eh: headers){
						HSSFCell cell = row.createCell(i); // 创建第i列
						if(0==j){
							cell.setCellValue(new HSSFRichTextString(eh.title));
						}else{
							Object value;
							String text;
							T t = dataList.get(j-1);
							if(t instanceof Map){
								value = ((Map) t).get(eh.field);
							}else{
								Field field = t.getClass().getDeclaredField(eh.field);
								String fieldName = field.getName();
								String getMethodName = "get"
										+ fieldName.substring(0, 1).toUpperCase()
										+ fieldName.substring(1);
								Class<? extends Object> tCls = t.getClass();
								Method getMethod = tCls.getMethod(getMethodName,
										new Class[] {});
								value = getMethod.invoke(t);
							}
							if (value instanceof Date) {
								text = value==null?"":new SimpleDateFormat(datePattern).format((Date) value);
							}else {
								text = value==null?"":String.valueOf(value);
							}
							cell.setCellValue(new HSSFRichTextString(text));
						}
						i++;
					}
				}
				headers.clear();  //清空表头
			}catch (NoSuchFieldException e){
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return workbook;
		}
	}
	
	/**
	 * 返回数据流
	 * @param dataList
	 * @param sheetName
	 * @param datePattern
	 * @param os
	 */
	public void generateExcelFile(List<T> dataList,String sheetName,String datePattern,OutputStream os){ 
		HSSFWorkbook workbook = generateExcelFile(dataList,sheetName, datePattern);
		try {
			workbook.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * @param file   		文件
	 * @param sheetNum      Excel页码
	 * @return
	 * @throws IOException
	 */
	public List<Map<String, Object>> exportListFromExcel(File file, int sheetNum) throws IOException{  
		String extensionName = getExtensionName(file.getName(), "\\."); //获取excel的拓展名
        return exportListFromExcel(new FileInputStream(file), extensionName, sheetNum);  
    }  
  
    /**
     * @param is   input数据流
     * @param extensionName 文件后缀名
     * @param sheetNum  Excel页码
     * @return
     * @throws IOException
     */
    public List<Map<String, Object>> exportListFromExcel(InputStream is, String extensionName, int sheetNum) throws IOException {  
    	 Workbook workbook = null; 
    	if (extensionName.toLowerCase().equals(XLS)||extensionName.toLowerCase().equals(CSV)) {  
            workbook = new HSSFWorkbook(is);  
        } else if (extensionName.toLowerCase().equals(XLSX)) {  
            workbook = new XSSFWorkbook(is);  
        } else{
			throw new InvalidExtensionNameException("文件后缀名错误！");
		}
    	return readCell(workbook, sheetNum);  
    }  
  
    /**
     * @param workbook
     * @param sheetNum
     * @return
     */
    private List<Map<String, Object>> readCell(Workbook workbook, int sheetNum) {  
        Sheet sheet = workbook.getSheetAt(sheetNum);  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        //过滤第一行数据表头
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
            Row row = sheet.getRow(i);  
            Map<String, Object> map = new HashMap<String, Object>();  
            for (Cell cell : row) {  
            	int index = cell.getColumnIndex();
            	String key = getField(index); 
            	if(StringUtils.isNotBlank(key)){
            		switch (cell.getCellType()) {  
                    case Cell.CELL_TYPE_STRING:  
                        map.put(key, cell.getRichStringCellValue().getString());  
                        break;  
                    case Cell.CELL_TYPE_NUMERIC:  
                        if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {  
                            map.put(key, cell.getDateCellValue());  
                        } else {
                        	DecimalFormat dfs = new DecimalFormat("0");
                            map.put(key, dfs.format(cell.getNumericCellValue()));  
                        }  
                        break;  
                    case Cell.CELL_TYPE_BOOLEAN:  
                        map.put(key, cell.getBooleanCellValue());  
                        break;  
                    case Cell.CELL_TYPE_FORMULA:  
                        map.put(key, cell.getCellFormula());  
                        break;  
                    case Cell.CELL_TYPE_BLANK:  
                        break;  
                    case Cell.CELL_TYPE_ERROR:  
                        break;  
                    default:  
                        map.put(key, "");  
                    }  
            	}
            }  
            list.add(map);  
        }  
        return list;  
    } 
    
    /**
	 * 以某个字符截取字符串 ,返回最后一部分 
	 * 
	 * @param value 需要截取的字符串
	 * @param chart 截取的字符
	 * @param num 返回的那部分
	 * @return
	 */
	public String getExtensionName(String value, String chart){
		String str[] = value.split(chart);
		return str[str.length-1];
	}
    
    /**
     * @param is   input数据流
     * @param extensionName 文件后缀名
     * @param sheetNum  Excel页码
     * @return
     * @throws Exception 
     * @throws IllegalAccessException 
     */
    public List<T> exportListFromExcel(InputStream is, String extensionName, int sheetNum,Class<T> clazz) throws IllegalAccessException, Exception {  
    	 Workbook workbook = null; 
    	if (extensionName.toLowerCase().equals(XLS)||extensionName.toLowerCase().equals(CSV)) {  
            workbook = new HSSFWorkbook(is);  
        } else if (extensionName.toLowerCase().equals(XLSX)) {  
            workbook = new XSSFWorkbook(is);  
        } else{
			throw new InvalidExtensionNameException("文件后缀名错误！");
		}
    	return readCellForObject(workbook,sheetNum,clazz);  
    }
    
    
    private List<T> readCellForObject(Workbook workbook, int sheetNum,Class<T> clazz) throws Exception, IllegalAccessException {  
        Sheet sheet = workbook.getSheetAt(sheetNum);  
        List<T> list = new ArrayList<T>();  
        //过滤第一行数据表头
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);  
            T obj = clazz.newInstance();
            for (Cell cell : row) {  
            	int index = cell.getColumnIndex();
            	String key = getField(index); 
            	if(StringUtils.isNotBlank(key)){
            		switch (cell.getCellType()) { 
                    case Cell.CELL_TYPE_STRING:
                    	copyProperty(obj, key, cell.getRichStringCellValue().getString());
                        break;  
                    case Cell.CELL_TYPE_NUMERIC:  
                        if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {  
                        	copyProperty(obj, key, cell.getDateCellValue());
                        } else {
                        	DecimalFormat dfs = new DecimalFormat("0");
                        	copyProperty(obj, key, dfs.format(cell.getNumericCellValue()));
                        }  
                        break;  
                    case Cell.CELL_TYPE_BOOLEAN: 
                    	copyProperty(obj, key, cell.getBooleanCellValue());
                        break;  
                    case Cell.CELL_TYPE_FORMULA:  
                    	copyProperty(obj, key, cell.getCellFormula());
                        break;  
                    case Cell.CELL_TYPE_BLANK:  
                        break;  
                    case Cell.CELL_TYPE_ERROR:  
                        break;  
                    default:  
                    	copyProperty(obj, key, "");
                    }  
            	}
            }  
            list.add(obj); 
        }  
        return list;  
    } 
    
    /**
     * 设值
     * @param bean
     * @param name
     * @param value
     * @throws Exception
     */
    private static void copyProperty(Object bean, String name,Object value) throws Exception{
    	if(name==null||value==null){
    		return;
    	}
    	//获取属性
    	Field field = matchClassField(bean.getClass(), name);
    	if(field==null){
    		return;
    	}
    	//获取setter方法
    	Method method = getSetterMethod(bean.getClass(), name);
    	if(method==null){
    		return;
    	}
    	if(value.getClass()==field.getType()){
    		method.invoke(bean, value);
    	}else{
    		method.invoke(bean, str2TargetClass(String.valueOf(value),field.getType()));
    	}
    }
    
    /**
     * string转成对应类型
     * @param strField
     * @param clazz
     * @return
     * @throws Exception
     */
	private static Object str2TargetClass(String strField, Class<?> clazz) throws Exception{
		if(StringUtils.isEmpty(strField)){
       		return null;
       	}
		if((Long.class == clazz)||(long.class)==clazz){
			return Long.parseLong(strField);
		}
		if((Integer.class == clazz)||(int.class)==clazz){
			return Integer.parseInt(strField);
		}
		if((Float.class == clazz)||(float.class)==clazz){
			return Float.parseFloat(strField);
		}
		if((Double.class == clazz)||(double.class)==clazz){
			return Double.parseDouble(strField);
		}
		if((Character.class == clazz)||(char.class)==clazz){
			return strField.toCharArray()[0];
		}
		if((Boolean.class == clazz)||(boolean.class)==clazz){
			return Boolean.parseBoolean(strField);
		}
		if(Date.class == clazz){
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strField);
		}
		
		return strField;
    }
    
	/**
	 * 获取setter方法
	 * @param clazz
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
    @SuppressWarnings("rawtypes")
   	private static Method getSetterMethod(Class clazz,String fieldName) throws Exception{
       	if(StringUtils.isEmpty(fieldName)){
       		return null;
       	}
       	PropertyDescriptor prop = new PropertyDescriptor(fieldName, clazz);
       	return prop.getWriteMethod();
    }
    
    /**
     * 获取属性字段
     * @param cla
     * @param fieldName
     * @return
     */
    @SuppressWarnings("rawtypes")
	private static Field matchClassField(Class cla,String fieldName){
    	Class clazz = cla;
    	List<Field> fields = new ArrayList<Field>();
    	for(;clazz!=Object.class;clazz = clazz.getSuperclass()){
    		fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
    	}
    	for(Field field:fields){
    		if(fieldName.equals(field.getName())){
    			return field;
    		}
    	}
    	return null;
    }
}
