package com.ltb.autfile.utils;

/**
 * 字符串工具类
 * @author ltb
 *
 */
public class StringUtils {
	
	/**
	 * 首字母变大写
	 * @param str
	 * @return
	 */
	public static String FirstUpper(String str){
		String[] strs = str.split("");
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < strs.length; i++){
			
			if(i == 1){
				strs[i] = strs[i].toUpperCase();
			}else if(i==0){
				continue;
			}else{
				strs[i] = strs[i].toLowerCase();
			}
			sb.append(strs[i]);
		}
		return sb.toString();
	}
}
