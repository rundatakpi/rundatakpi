
package com.cn.run.kpi.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * <p>
 * Description: 文件操作工具类
 * </p>
 *
 * @author zcy
 * @version 1.0

 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2016-9-2 下午01:35:48          zcy        1.0         To create
 * </p>
 *
 * @since 
 * @see
 */
public class FileUtilsn {

    /**
     * 日志
     */
    private static Logger logger = Logger.getLogger(FileUtils.class);

    /**
     * 默认编码
     */
    private final static String DEFAULT_ENCODE = "UTF-8";

    /**
     * 保存文本文件
     * @param filePath 文件地址(包含名词)
     * @param text 文件内容
     */
    public static void saveText(String filePath, List<String> text) {
        saveText(filePath, text, DEFAULT_ENCODE);
    }

    /**
     * 保存文本文件
     * @param filePath 文件地址(包含名词)
     * @param text 文件内容
     * @param encode 编码
     */
    public static void saveText(String filePath, List<String> text, String encode) {
        try {
            //检查父级是否存在,不存在创建目录
            createParentDir(filePath);

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            for (String line : text) {
                if (line == null) {
                    continue;
                }
                fileOutputStream.write(line.getBytes(encode));
                fileOutputStream.write("\n".getBytes(encode));
            }
            fileOutputStream.close();
            logger.info("文件: " + filePath + ",保存成功!");
        } catch (FileNotFoundException e) {
            logger.error("文件: " + filePath + ",保存失败!", e);
        } catch (IOException e) {
            logger.error("文件: " + filePath + ",保存失败!", e);
        }
    }
    
   /**
    * @param filePath 文件地址(包含名词)
    * @param text 	     文件内容
    * @param append   是否追加
    */
    public static void saveText(String filePath, String text,boolean append) {
    	List<String> list = new ArrayList<String>();
    	list.add(text);
    	saveText(filePath, list, append);
    }
    
   /**
    * @param filePath 文件地址(包含名词)
    * @param text     文件内容
    * @param encode   编码格式
    * @param append   是否追加
    */
    public static void saveText(String filePath, List<String> text,boolean append) {
        try {
            //检查父级是否存在,不存在创建目录
            createParentDir(filePath);
            FileOutputStream fileOutputStream ;
            if(append)
            	fileOutputStream = new FileOutputStream(filePath,append);
            else
            	fileOutputStream = new FileOutputStream(filePath);
            for (String line : text) {
                if (line == null) {
                    continue;
                }
                fileOutputStream.write(line.getBytes(DEFAULT_ENCODE));
                fileOutputStream.write("\n".getBytes(DEFAULT_ENCODE));
            }
            fileOutputStream.close();
            logger.info("文件: " + filePath + ",保存成功!");
        } catch (FileNotFoundException e) {
            logger.error("文件: " + filePath + ",保存失败!", e);
        } catch (IOException e) {
            logger.error("文件: " + filePath + ",保存失败!", e);
        }
    }

    /**
     * 
     * @param text 				内容
     * @param fileOutputStream  文件输出流
     */
     public static void saveText(List<String> text,FileOutputStream fileOutputStream) {
         try {
             //检查父级是否存在,不存在创建目录
             for (String line : text) {
                 if (line == null) {
                     continue;
                 }
                 fileOutputStream.write(line.getBytes(DEFAULT_ENCODE));
                 fileOutputStream.write("\n".getBytes(DEFAULT_ENCODE));
             }
             fileOutputStream.flush();
             logger.info("文件: 保存成功!");
         } catch (FileNotFoundException e) {
             logger.error("文件: 保存失败!", e);
         } catch (IOException e) {
             logger.error("文件: 保存失败!", e);
         }
     }
    /**
     * 保存文本文件
     * @param filePath 文件地址(包含名词)
     * @param text 文件内容
     */
    public static void saveText(String filePath, String doc) {
        try {
            //检查父级是否存在,不存在创建目录
            createParentDir(filePath);

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(doc.getBytes("UTF-8"));
            fileOutputStream.write("\n".getBytes("UTF-8"));
            fileOutputStream.close();
            logger.info("文件: " + filePath + ",保存成功!");
        } catch (FileNotFoundException e) {
            logger.error("文件: " + filePath + ",保存失败!", e);
        } catch (IOException e) {
            logger.error("文件: " + filePath + ",保存失败!", e);
        }
    }

    /**
     * 读取文本文件
     * @param path 文件地址
     */
    public static List<String> readText(String path) {
        return readText(path, DEFAULT_ENCODE);
    }

    /**
     * 读取文本文件
     * @param path 文件地址
     * @param encode 编码
     */
    public static List<String> readText(String path, String encode) {
        try {
            if (path == null)
                return null;
            //读取路径
            File file = new File(path);
            //路径为目录,读取目录下全部文件
            if (file.isDirectory()) {
                List<String> allft = new ArrayList<String>();
                for (File f : file.listFiles()) {
                    List<String> ft = readText(f.getPath());
                    allft.addAll(ft);
                }
                return allft;
            }
            //路径为文件,读取文件
            //只读取txt文件
            //if (file.isFile() && (file.getName().endsWith(".txt") || file.getName().endsWith(".dic"))) {
            if (file.isFile()) {
                //文件列表
                List<String> docs = new ArrayList<String>();
                //文件读取
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encode));
                //读取行内容
                String line = br.readLine();
                while (line != null) {
                    //注释过滤
                    if (line != null && line.length() > 0 && line.startsWith("/**") == false) {
                        docs.add(line);
                    }
                    line = br.readLine();
                }
                br.close();
                return docs;
            }
            return new ArrayList<String>(0);
        } catch (IOException e) {
            logger.error("文件: " + path + ",读取失败!", e);
            return null;
        }
    }

    /**
      * 读取文本文件
      * @param file 文件
      */
    public static List<String> readText(File file) {
        return readText(file.getPath());
    }

    /**
     * 读取文本文件
     * @param file 文件
     * @param encode 编码
     */
    public static List<String> readText(File file, String encode) {
        return readText(file.getPath(), encode);
    }

    /**
    * 获取所有文件
    * @param path 文件夹地址
    */
    public static File[] getFiles(String path) {
        try {
            if (path == null)
                return null;
            //读取路径
            File file = new File(path);
            //txt
            //路径为目录,读取目录下全部文件
            if (file.isDirectory()) {
                // 只有后缀为.txt的文件才会被列举出来形成数组
            	
            	File[] files = file.listFiles();
               /* File[] files = file.listFiles(new FileFilter() {

                    @Override
                    public boolean accept(File pathname) {
                        String filename = pathname.getName().toLowerCase();
                        if (filename.endsWith(".txt")) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                });*/
                return files;
            }
            if (file.exists()) {
                File[] f = { file };
                return f;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new File[0];
    }

    /**
     * 检查文件是否存在
     * @param path 路径
     * @return 是否存在
     */
    public static boolean exists(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * 检查父级是否存在,不存在创建目录
     * @param path 文件路径
     */
    public static void createParentDir(String path) {
        //父级目录是否存在,不存在创建目录
        if (new File(path).getParent() != null) {
            File parent = new File(new File(path).getParent());
            if (parent.exists() == false) {
                //继续检查父级
                createParentDir(parent.getPath());
                //创建目录
                parent.mkdir();
            }
        }
    }
    
    
    

    /**
     * 删除文件
     * @param path 文件地址
     */
    public static void delFile(String path) {
    	File file = new File(path);
        if(file.exists())
        	file.delete();
    }

    /**
     * 递归删除文件夹
     * @param dir
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
    /**
     * 递归删除文件夹下所有文件
     * @param dir
     * @return
     */
    public static boolean deleteDirFile(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return true;
    }
    /**
     * 创建文件夹
     * @param path
     */
    public static void createDirs(String path) {
        File file = new File(path);
        //如果文件夹不存在则创建    
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }
    

    /**
     * 修改文件地址为服务器地址
     * @param path 文件地址
     * @return 服务器文件地址
     */
    public static String setServerPath(String path) {
        String dir = FileUtils.class.getResource("").getPath();
        dir = dir.substring(0, dir.indexOf("WEB-INF"));
        //判断系统
        String os = System.getProperty("os.name");
        if (os.toLowerCase().indexOf("windows") != -1) {
            //windows去除前面的斜杠
            if (dir.startsWith("/") && dir.indexOf(":") == 2) {
                dir = dir.substring(1);
            }
        }
        return dir + path;
    }

    /**
     * 修改配置地址为服务器地址
     * @param path 文件地址
     * @return 服务器文件地址
     */
    public static String setServerConfPath(String path) {
        String dir = FileUtils.class.getResource("").getPath();
        dir = dir.substring(0, dir.indexOf("classes") + "classes".length() + 1);
        //判断系统
        String os = System.getProperty("os.name");
        if (os.toLowerCase().indexOf("windows") != -1) {
            //windows去除前面的斜杠
            if (dir.startsWith("/") && dir.indexOf(":") == 2) {
                dir = dir.substring(1);
            }
        }
        return dir + path;
    }

    /**
     * 将A文件夹下所有文件拷贝到B文件夹中
     * @param oldPath A文件夹路径
     * @param newPath B文件夹路径
     */
    public static void copyFiles(String oldPath, String newPath) {
        try {
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹 
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + File.separator + (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
            }
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();
        }
        System.out.println("copy success");

    }

    /**
     * 通道拷贝文件
     * @param spath 起始文件地址
     * @param tpath 目标文件地址
     */
    public static void copyFile(String spath, String tpath) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        //创建临时文件夹
        //判断目标文件所在的目录是否存在  
        File tFile = new File(tpath);
        if (!tFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录  
            tFile.getParentFile().mkdirs();
        }
        File sfile = new File(spath);
        File file= new File(tFile.getPath()+File.separator+sfile.getName());
        if(!file.exists()){
        	tFile.mkdirs();
     	 }
        try {
            fi = new FileInputStream(spath);
            fo = new FileOutputStream(file);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    
    /**
     * 保存File
     * @param file File文件 
     * @param addr 存放地址
     */
    public static void saveFile(File file,String addr) {
		File storeFile = new File(addr);
		InputStream input = null;
		FileOutputStream output = null;
			try {
				output = new FileOutputStream(storeFile);
			// 得到网络资源并写入文件
			input = new FileInputStream(file);
			byte b[] = new byte[1024];
			int j = 0;
			while ((j = input.read(b)) != -1) {
				output.write(b, 0, j);
			}
			output.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(input!=null)
					input.close();
					if(output!=null)
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
    /**
     * 将文件夹下所有的文件以及文件夹复制到指定的文件夹下
     * @param src
     * @param des
     */
    public static void copy(String src, String des) {  
        File file1=new File(src);  
        File[] fs=file1.listFiles();  
        File file2=new File(des);  
        if(!file2.exists()){  
            file2.mkdirs();  
        }  
        for (File f : fs) {  
            if(f.isFile()){ 
            	
            	copyFile(f.getPath(),des+File.separator+f.getName()); //调用文件拷贝的方法  
            }else if(f.isDirectory()){  
                copy(f.getPath(),des+File.separator+f.getName());  
            }  
        }  
          
    }  
  
    /** 
     * 文件拷贝的方法 
     */  
    private static void fileCopy(String src, String des) {  
      
        BufferedReader br=null;  
        PrintStream ps=null;  
          
        try {  
            br=new BufferedReader(new InputStreamReader(new FileInputStream(src)));  
            ps=new PrintStream(new FileOutputStream(des));  
            String s=null;  
            while((s=br.readLine())!=null){  
                ps.println(s);  
                ps.flush();  
            }  
              
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{  
              
                try {  
                    if(br!=null)  br.close();  
                    if(ps!=null)  ps.close();  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
                  
        }  
          
          
    }  
    
    public static void main(String[] args) {
		//读取properties
    	String path = "config.properties";
    	InputStream inputStream = FileUtils.class.getResourceAsStream(path);
    	Properties  pro= new Properties();
    	try {
			pro.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	String property = pro.getProperty("filetype");
    	System.out.println(property);
	}
}
