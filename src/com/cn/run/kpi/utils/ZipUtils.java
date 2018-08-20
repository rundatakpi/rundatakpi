package com.cn.run.kpi.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 
 * <p>
 * Description: zip�ļ�����
 * </p>
 *
 * @author zcy
 * @version 1.0

 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2016-11-8 ����2:37:58         zcy        1.0         To create
 * </p>
 *
 * @since 
 * @see
 */
public class ZipUtils {

	public static final String EXT = ".zip";
	private static final String BASE_DIR = "";

	// ����"/"������ΪĿ¼��ʶ�жϷ�
	private static final String PATH = "";
	private static final int BUFFER = 1024;

	/**
	 * ѹ��
	 * 
	 * @param srcFile
	 * @throws Exception
	 */
	public static void compress(File srcFile) throws Exception {
		String name = srcFile.getName();
		String basePath = srcFile.getParent();
		String destPath = basePath + name + EXT;
		compress(srcFile, destPath);
	}

	/**
	 * ѹ��
	 * 
	 * @param srcFile
	 *            Դ·��
	 * @param destPath
	 *            Ŀ��·��
	 * @throws Exception
	 */
	public static void compress(File srcFile, File destFile) throws Exception {
		
		if(destFile.exists())
			destFile.createNewFile();
		// ������ļ���CRC32У��
		CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
				destFile), new CRC32());

		ZipOutputStream zos = new ZipOutputStream(cos);

		compress(srcFile, zos, BASE_DIR);

		zos.flush();
		zos.close();
	}

	/**
	 * ѹ���ļ�
	 * 
	 * @param srcFile
	 * @param destPath
	 * @throws Exception
	 */
	public static void compress(File srcFile, String destPath) throws Exception {
		compress(srcFile, new File(destPath));
	}

	/**
	 * ѹ��
	 * 
	 * @param srcFile
	 *            Դ·��
	 * @param zos
	 *            ZipOutputStream
	 * @param basePath
	 *            ѹ���������·��
	 * @throws Exception
	 */
	private static void compress(File srcFile, ZipOutputStream zos,
			String basePath) throws Exception {
		if (srcFile.isDirectory()) {
			compressDir(srcFile, zos, basePath);
		} else {
			compressFile(srcFile, zos, basePath);
		}
	}

	/**
	 * ѹ��
	 * 
	 * @param srcPath
	 * @throws Exception
	 */
	public static void compress(String srcPath) throws Exception {
		File srcFile = new File(srcPath);

		compress(srcFile);
	}

	/**
	 * �ļ�ѹ��
	 * 
	 * @param srcPath
	 *            Դ�ļ�·��
	 * @param destPath
	 *            Ŀ���ļ�·��
	 * 
	 */
	public static void compress(String srcPath, String destPath)
			throws Exception {
		File srcFile = new File(srcPath);

		compress(srcFile, destPath);
	}

	/**
	 * ѹ��Ŀ¼
	 * 
	 * @param dir
	 * @param zos
	 * @param basePath
	 * @throws Exception
	 */
	private static void compressDir(File dir, ZipOutputStream zos,
			String basePath) throws Exception {

		File[] files = dir.listFiles();

		// ������Ŀ¼
		if (files.length < 1) {
			ZipEntry entry = new ZipEntry(basePath + dir.getName() + PATH);

			zos.putNextEntry(entry);
			zos.closeEntry();
		}

		for (File file : files) {

			// �ݹ�ѹ��
			compress(file, zos, basePath + PATH);

		}
	}

	/**
	 * �ļ�ѹ��
	 * 
	 * @param file
	 *            ��ѹ���ļ�
	 * @param zos
	 *            ZipOutputStream
	 * @param dir
	 *            ѹ���ļ��еĵ�ǰ·��
	 * @throws Exception
	 */
	private static void compressFile(File file, ZipOutputStream zos, String dir)
			throws Exception {

		/**
		 * ѹ�������ļ�������
		 * 
		 * <pre>
		 * ����ж༶Ŀ¼����ô�������Ҫ��������Ŀ¼���ļ���
		 * �����WinRAR��ѹ����������������ʾΪ����
		 * </pre>
		 */
		ZipEntry entry = new ZipEntry(dir + file.getName());

		zos.putNextEntry(entry);

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				file));

		int count;
		byte data[] = new byte[BUFFER];
		while ((count = bis.read(data, 0, BUFFER)) != -1) {
			zos.write(data, 0, count);
		}
		bis.close();

		zos.closeEntry();
	}
	
	
	/**
	 *  zip�ļ���ѹ��
	 * @param zipPath zip�ļ���·��  
	 * @param desDir  ��ѹ�ļ�λ��
	 */
	public static void unzip(String zipPath,String desDir) {
		long startTime=System.currentTimeMillis();
		try {
			ZipInputStream zip=new ZipInputStream(new FileInputStream(zipPath));
			BufferedInputStream Bin=new BufferedInputStream(zip);
			File fout=null;
			ZipEntry entry;
			
			try {
				while((entry = zip.getNextEntry())!=null){
					if (entry.isDirectory()) {
						continue;
					}
					fout=new File(desDir,entry.getName());
					if(!fout.exists()){
						(new File(fout.getParent())).mkdirs();
					}
					FileOutputStream out=new FileOutputStream(fout);
					BufferedOutputStream Bout=new BufferedOutputStream(out);
					int b;
					while((b=Bin.read())!=-1){
						Bout.write(b);
					}
					Bout.close();
					out.close();
					//System.out.println(fout+"��ѹ�ɹ�");	
				}
				Bin.close();
				zip.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		long endTime=System.currentTimeMillis();
		System.out.println("��ѹ��ʱ�� "+(endTime-startTime)+" ms");
	}

	
	
	
}
