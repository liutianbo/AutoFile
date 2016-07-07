package com.ltb.autfile.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * io工具类
 * @author ltb
 *
 */
public class IoUtils {
	
	/**
	 * 根据内容个路径生成文件
	 * @param fileContent 生成内容
	 * @param path 文件路径
	 * @param name 文件名称
	 * @param newflag true 重新写文件  false  追加文件
	 */
	public static void WriteFile(String fileContent,String path,String name,boolean newflag){
		try {
			File file = new File(path+File.separator+name);
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			if(newflag){
				if(file.exists()){
					file.delete();
				}
			}
			file.createNewFile();
			
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(fileContent);
			bw.flush();
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
