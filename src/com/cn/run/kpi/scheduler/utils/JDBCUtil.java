package com.cn.run.kpi.scheduler.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cn.run.kpi.alarm.entity.AlarmData;
/**
 * JDBC工具类
 * @author q4189
 *
 */
public class JDBCUtil {
	public static Connection connection = null;
    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConn(){
		// 配置文件路径。
		String path = "/db.properties";
    	InputStream inputStream = JDBCUtil.class.getResourceAsStream(path);
    	Properties  pro= new Properties();
    	try {
			pro.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	// 获取3要素。
    	String url = pro.getProperty("jdbc.url");
    	String username = pro.getProperty("jdbc.user");
    	String password = pro.getProperty("jdbc.password");

		// 初始化连接。
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 1,加载数据库驱动。
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 2,获取数据库连接。
			 conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
    /**
     * 将结果集转换成实体对象集合
     * @param res 结果集
     * @param c 实体对象映射类
     * @return
    * @throws SQLException
    * @throws IllegalAccessException
    * @throws InstantiationException
     */
    public static List Populate(ResultSet rs,Class cc) throws SQLException, InstantiationException, IllegalAccessException{
        
        //结果集 中列的名称和类型的信息
        ResultSetMetaData rsm = rs.getMetaData();
        int colNumber = rsm.getColumnCount();
        List list = new ArrayList();
        Field[] fields = cc.getDeclaredFields();
        
        //遍历每条记录
        while(rs.next()){
            //实例化对象
            Object obj = cc.newInstance();
            //取出每一个字段进行赋值
            for(int i=1;i<=colNumber;i++){
                Object value = rs.getObject(i);
                //匹配实体类中对应的属性
                for(int j = 0;j<fields.length;j++){
                    Field f = fields[j];
                    if(f.getName().toLowerCase().equals(rsm.getColumnName(i).toLowerCase())){
                        boolean flag = f.isAccessible();
                        f.setAccessible(true);
                        f.set(obj, value);
                        f.setAccessible(flag);
                        break;
                    }
                }
                 
            }
            list.add(obj);
        }
        return list;
    }
}
