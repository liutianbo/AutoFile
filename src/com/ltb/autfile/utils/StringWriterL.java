package com.ltb.autfile.utils;

import com.ltb.autfile.exception.InfoException;

/**
 * 文件写入对象
 * @author ltb
 *
 */
public class StringWriterL {
	private StringBuffer sb;
	
	public static final String PACKAGE ="package";
	public static final String LINEEND = "\r\n";
	public static final String SPACE = " ";
	public static final String PUBLIC = "public";
	public static final String CLASS = "class";
	/** 大括号(前) */
	public static final String BRACE_FRONT= "{";
	/** 大括号(后) */
	public static final String BRACE_BACK= "}";
	/** 括号(前) */
	public static final String BRACKET_FRONT= "(";
	/** 括号(后) */
	public static final String BRACKET_BACK= ")";
	public static final String PRIVATE= "private";
	/** 分号 */
	public static final String SEMICOLON= ";";
	public static final String VOID= "void";
	public static final String THIS= "this";
	public static final String POINT= ".";
	public static final String EQUALMARK= "=";
	public static final String RETURN= "return";
	
	
	
	
	private String[] inttype = {"int","Integer","ineger"};
	private String[] stringtype = {"string","String"};
	private String[] booleantype = {"boolean","Boolean"};
	
	/**
	 * 添加type
	 * @param typeStr
	 * @return
	 */
	public StringWriterL appendType(String typeStr) throws InfoException{
		sb.append(pdType(typeStr));
		return this;
	}
	
	/**
	 * 判断类型
	 * @param typeName
	 * @return
	 * @throws InfoException
	 */
	private String pdType(String typeName) throws InfoException{
		String result = "";
		if(hasCode(inttype, typeName)){
			sb.append("Integer");
		}else if(hasCode(stringtype, typeName)){
			sb.append("String");
		}else if(hasCode(booleantype, typeName)){
			sb.append("Boolean");
		}else{
			throw new InfoException("未知类型："+ typeName);
		}
		return result;
	}
	
	/**
	 * 添加set方法
	 * @param typeName 类型名称
	 * @param name 字段名称
	 * @return
	 */
	public StringWriterL appendSetter(String typeName,String name) throws InfoException{
		sb.append(PUBLIC).append(SPACE).append(VOID).append(SPACE).append("set").append(StringUtils.FirstUpper(name))
			.append(BRACKET_FRONT).append(pdType(typeName))
			.append(SPACE).append(name).append(BRACKET_BACK).append(BRACE_FRONT).append(LINEEND);
		sb.append(SPACE).append(THIS).append(POINT).append(name).append(SPACE).append(EQUALMARK).append(SPACE).append(name).append(SEMICOLON).append(LINEEND);
		sb.append(BRACE_BACK).append(LINEEND);
		return this;
	}
	
	/**
	 * 添加get方法
	 * @param typeName 类型名称
	 * @param name 字段名称
	 * @return
	 */
	public StringWriterL appendGetter(String typeName,String name)throws InfoException{
		sb.append(PUBLIC).append(SPACE).append(pdType(typeName)).append(SPACE).append("get")
			.append(StringUtils.FirstUpper(name)).append(BRACKET_FRONT).append(BRACKET_BACK).append(SPACE).append(BRACE_FRONT).append(LINEEND);
		sb.append(SPACE).append(RETURN).append(SPACE).append(name).append(SEMICOLON).append(LINEEND);
		sb.append(BRACE_BACK).append(LINEEND);
		return this;
	}
	
	
	public StringWriterL appendSemicolon(){
		sb.append(SEMICOLON);
		return this;
	}
	
	public StringWriterL(){
		sb = new StringBuffer();
	}
	
	public StringWriterL appendPackage(){
		sb.append(PACKAGE);
		return this;
	}
	
	public StringWriterL appendLineEnd(){
		sb.append(LINEEND);
		return this;
	}
	
	public StringWriterL appendSpace(){
		sb.append(SPACE);
		return this;
	}
	
	public StringWriterL append(String str){
		sb.append(str);
		return this;
	}
	
	public StringWriterL appendPublic(){
		sb.append(PUBLIC);
		return this;
	}
	
	public StringWriterL appendClass(){
		sb.append(CLASS);
		return this;
	}
	
	
	public StringWriterL appendBrace_front(){
		sb.append(BRACE_FRONT);
		return this;
	}
	
	public StringWriterL appendBrace_back(){
		sb.append(BRACE_BACK);
		return this;
	}
	
	
	public String toString(){
		return sb.toString();
	}
	
	/**
	 * 判断数组中是否有目标值
	 * @param strs
	 * @param value
	 * @return
	 */
	private boolean hasCode(String[] strs,String value){
		if(strs == null || strs.length == 0){
			return false;
		}
		for(int i = 0; i < strs.length; i++){
			if(strs[i].equals(value)){
				return true;
			}
		}
		return false;
	}
}
