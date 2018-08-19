
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
 * Description: �ļ�����������
 * </p>
 *
 * @author zcy
 * @version 1.0

 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2016-9-2 ����01:35:48          zcy        1.0         To create
 * </p>
 *
 * @since 
 * @see
 */
public class FileUtilsn {

    /**
     * ��־
     */
    private static Logger logger = Logger.getLogger(FileUtils.class);

    /**
     * Ĭ�ϱ���
     */
    private final static String DEFAULT_ENCODE = "UTF-8";

    /**
     * �����ı��ļ�
     * @param filePath �ļ���ַ(��������)
     * @param text �ļ�����
     */
    public static void saveText(String filePath, List<String> text) {
        saveText(filePath, text, DEFAULT_ENCODE);
    }

    /**
     * �����ı��ļ�
     * @param filePath �ļ���ַ(��������)
     * @param text �ļ�����
     * @param encode ����
     */
    public static void saveText(String filePath, List<String> text, String encode) {
        try {
            //��鸸���Ƿ����,�����ڴ���Ŀ¼
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
            logger.info("�ļ�: " + filePath + ",����ɹ�!");
        } catch (FileNotFoundException e) {
            logger.error("�ļ�: " + filePath + ",����ʧ��!", e);
        } catch (IOException e) {
            logger.error("�ļ�: " + filePath + ",����ʧ��!", e);
        }
    }
    
   /**
    * @param filePath �ļ���ַ(��������)
    * @param text 	     �ļ�����
    * @param append   �Ƿ�׷��
    */
    public static void saveText(String filePath, String text,boolean append) {
    	List<String> list = new ArrayList<String>();
    	list.add(text);
    	saveText(filePath, list, append);
    }
    
   /**
    * @param filePath �ļ���ַ(��������)
    * @param text     �ļ�����
    * @param encode   �����ʽ
    * @param append   �Ƿ�׷��
    */
    public static void saveText(String filePath, List<String> text,boolean append) {
        try {
            //��鸸���Ƿ����,�����ڴ���Ŀ¼
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
            logger.info("�ļ�: " + filePath + ",����ɹ�!");
        } catch (FileNotFoundException e) {
            logger.error("�ļ�: " + filePath + ",����ʧ��!", e);
        } catch (IOException e) {
            logger.error("�ļ�: " + filePath + ",����ʧ��!", e);
        }
    }

    /**
     * 
     * @param text 				����
     * @param fileOutputStream  �ļ������
     */
     public static void saveText(List<String> text,FileOutputStream fileOutputStream) {
         try {
             //��鸸���Ƿ����,�����ڴ���Ŀ¼
             for (String line : text) {
                 if (line == null) {
                     continue;
                 }
                 fileOutputStream.write(line.getBytes(DEFAULT_ENCODE));
                 fileOutputStream.write("\n".getBytes(DEFAULT_ENCODE));
             }
             fileOutputStream.flush();
             logger.info("�ļ�: ����ɹ�!");
         } catch (FileNotFoundException e) {
             logger.error("�ļ�: ����ʧ��!", e);
         } catch (IOException e) {
             logger.error("�ļ�: ����ʧ��!", e);
         }
     }
    /**
     * �����ı��ļ�
     * @param filePath �ļ���ַ(��������)
     * @param text �ļ�����
     */
    public static void saveText(String filePath, String doc) {
        try {
            //��鸸���Ƿ����,�����ڴ���Ŀ¼
            createParentDir(filePath);

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(doc.getBytes("UTF-8"));
            fileOutputStream.write("\n".getBytes("UTF-8"));
            fileOutputStream.close();
            logger.info("�ļ�: " + filePath + ",����ɹ�!");
        } catch (FileNotFoundException e) {
            logger.error("�ļ�: " + filePath + ",����ʧ��!", e);
        } catch (IOException e) {
            logger.error("�ļ�: " + filePath + ",����ʧ��!", e);
        }
    }

    /**
     * ��ȡ�ı��ļ�
     * @param path �ļ���ַ
     */
    public static List<String> readText(String path) {
        return readText(path, DEFAULT_ENCODE);
    }

    /**
     * ��ȡ�ı��ļ�
     * @param path �ļ���ַ
     * @param encode ����
     */
    public static List<String> readText(String path, String encode) {
        try {
            if (path == null)
                return null;
            //��ȡ·��
            File file = new File(path);
            //·��ΪĿ¼,��ȡĿ¼��ȫ���ļ�
            if (file.isDirectory()) {
                List<String> allft = new ArrayList<String>();
                for (File f : file.listFiles()) {
                    List<String> ft = readText(f.getPath());
                    allft.addAll(ft);
                }
                return allft;
            }
            //·��Ϊ�ļ�,��ȡ�ļ�
            //ֻ��ȡtxt�ļ�
            //if (file.isFile() && (file.getName().endsWith(".txt") || file.getName().endsWith(".dic"))) {
            if (file.isFile()) {
                //�ļ��б�
                List<String> docs = new ArrayList<String>();
                //�ļ���ȡ
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encode));
                //��ȡ������
                String line = br.readLine();
                while (line != null) {
                    //ע�͹���
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
            logger.error("�ļ�: " + path + ",��ȡʧ��!", e);
            return null;
        }
    }

    /**
      * ��ȡ�ı��ļ�
      * @param file �ļ�
      */
    public static List<String> readText(File file) {
        return readText(file.getPath());
    }

    /**
     * ��ȡ�ı��ļ�
     * @param file �ļ�
     * @param encode ����
     */
    public static List<String> readText(File file, String encode) {
        return readText(file.getPath(), encode);
    }

    /**
    * ��ȡ�����ļ�
    * @param path �ļ��е�ַ
    */
    public static File[] getFiles(String path) {
        try {
            if (path == null)
                return null;
            //��ȡ·��
            File file = new File(path);
            //txt
            //·��ΪĿ¼,��ȡĿ¼��ȫ���ļ�
            if (file.isDirectory()) {
                // ֻ�к�׺Ϊ.txt���ļ��Żᱻ�оٳ����γ�����
            	
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
     * ����ļ��Ƿ����
     * @param path ·��
     * @return �Ƿ����
     */
    public static boolean exists(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * ��鸸���Ƿ����,�����ڴ���Ŀ¼
     * @param path �ļ�·��
     */
    public static void createParentDir(String path) {
        //����Ŀ¼�Ƿ����,�����ڴ���Ŀ¼
        if (new File(path).getParent() != null) {
            File parent = new File(new File(path).getParent());
            if (parent.exists() == false) {
                //������鸸��
                createParentDir(parent.getPath());
                //����Ŀ¼
                parent.mkdir();
            }
        }
    }
    
    
    

    /**
     * ɾ���ļ�
     * @param path �ļ���ַ
     */
    public static void delFile(String path) {
    	File file = new File(path);
        if(file.exists())
        	file.delete();
    }

    /**
     * �ݹ�ɾ���ļ���
     * @param dir
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //�ݹ�ɾ��Ŀ¼�е���Ŀ¼��
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // Ŀ¼��ʱΪ�գ�����ɾ��
        return dir.delete();
    }
    /**
     * �ݹ�ɾ���ļ����������ļ�
     * @param dir
     * @return
     */
    public static boolean deleteDirFile(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //�ݹ�ɾ��Ŀ¼�е���Ŀ¼��
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // Ŀ¼��ʱΪ�գ�����ɾ��
        return true;
    }
    /**
     * �����ļ���
     * @param path
     */
    public static void createDirs(String path) {
        File file = new File(path);
        //����ļ��в������򴴽�    
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }
    

    /**
     * �޸��ļ���ַΪ��������ַ
     * @param path �ļ���ַ
     * @return �������ļ���ַ
     */
    public static String setServerPath(String path) {
        String dir = FileUtils.class.getResource("").getPath();
        dir = dir.substring(0, dir.indexOf("WEB-INF"));
        //�ж�ϵͳ
        String os = System.getProperty("os.name");
        if (os.toLowerCase().indexOf("windows") != -1) {
            //windowsȥ��ǰ���б��
            if (dir.startsWith("/") && dir.indexOf(":") == 2) {
                dir = dir.substring(1);
            }
        }
        return dir + path;
    }

    /**
     * �޸����õ�ַΪ��������ַ
     * @param path �ļ���ַ
     * @return �������ļ���ַ
     */
    public static String setServerConfPath(String path) {
        String dir = FileUtils.class.getResource("").getPath();
        dir = dir.substring(0, dir.indexOf("classes") + "classes".length() + 1);
        //�ж�ϵͳ
        String os = System.getProperty("os.name");
        if (os.toLowerCase().indexOf("windows") != -1) {
            //windowsȥ��ǰ���б��
            if (dir.startsWith("/") && dir.indexOf(":") == 2) {
                dir = dir.substring(1);
            }
        }
        return dir + path;
    }

    /**
     * ��A�ļ����������ļ�������B�ļ�����
     * @param oldPath A�ļ���·��
     * @param newPath B�ļ���·��
     */
    public static void copyFiles(String oldPath, String newPath) {
        try {
            (new File(newPath)).mkdirs(); //����ļ��в����� �������ļ��� 
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
            System.out.println("���������ļ������ݲ�������");
            e.printStackTrace();
        }
        System.out.println("copy success");

    }

    /**
     * ͨ�������ļ�
     * @param spath ��ʼ�ļ���ַ
     * @param tpath Ŀ���ļ���ַ
     */
    public static void copyFile(String spath, String tpath) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        //������ʱ�ļ���
        //�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����  
        File tFile = new File(tpath);
        if (!tFile.getParentFile().exists()) {
            //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼  
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
            in = fi.getChannel();//�õ���Ӧ���ļ�ͨ��
            out = fo.getChannel();//�õ���Ӧ���ļ�ͨ��
            in.transferTo(0, in.size(), out);//��������ͨ�������Ҵ�inͨ����ȡ��Ȼ��д��outͨ��
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
     * ����File
     * @param file File�ļ� 
     * @param addr ��ŵ�ַ
     */
    public static void saveFile(File file,String addr) {
		File storeFile = new File(addr);
		InputStream input = null;
		FileOutputStream output = null;
			try {
				output = new FileOutputStream(storeFile);
			// �õ�������Դ��д���ļ�
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
     * ���ļ��������е��ļ��Լ��ļ��и��Ƶ�ָ�����ļ�����
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
            	
            	copyFile(f.getPath(),des+File.separator+f.getName()); //�����ļ������ķ���  
            }else if(f.isDirectory()){  
                copy(f.getPath(),des+File.separator+f.getName());  
            }  
        }  
          
    }  
  
    /** 
     * �ļ������ķ��� 
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
		//��ȡproperties
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
