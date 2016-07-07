package com.ltb.autfile.file;


import com.ltb.autfile.Const;
import com.ltb.autfile.entity.ClassInfo;
import com.ltb.autfile.entity.FileInfo;
import com.ltb.autfile.exception.InfoException;
import com.ltb.autfile.utils.StringUtils;
import com.ltb.autfile.utils.StringWriterL;

/**
 * 根据字段信息生成entity文件
 * @author ltb
 *
 */
public class MakeEntity implements MakeFileInter{
	
	private ClassInfo classInfo;// 类信息
	
	public MakeEntity(){
		
	}
	
	/**
	 * 放置类信息
	 * @param classInfo
	 */
	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	/**
	 * 获取文件名称
	 * @return
	 */
	public String getFileName(){
		return StringUtils.FirstUpper(classInfo.getClassName())+".java";
	}
	
	/**
	 * 
	 * @param classInfo 实体信息
	 * @param path 相对路径（包名所包含的路径）
	 */
	public MakeEntity(ClassInfo classInfo){
		this.classInfo = classInfo;
	}
	// 创建文件
	public String creatFile() throws InfoException{
		StringWriterL result = new StringWriterL();
		// ------------package部分--------------
		String entityPath = Const.ENTITY_PATH;// 获得类包路径
		if(entityPath == null || entityPath.equals("")){
			throw new InfoException("相对路径不能为空");
		}
		result.appendPackage().appendSpace().append(entityPath).appendSemicolon().appendLineEnd();//package行
		
		// ------------import部分-----------------
		
		// ------------class结构开始部分--------------
		result.appendPublic().appendSpace().appendClass()
			.appendSpace().append(StringUtils.FirstUpper(classInfo.getClassName())).appendSpace().appendBrace_front().appendLineEnd();
		
		// ------------字段部分-----------------------
		for(FileInfo fi : classInfo.getFileInfos()){
			result.appendPublic().appendSpace().appendType(fi.getType()).appendSpace().append(fi.getName()).appendSemicolon().appendLineEnd();
		}
		// ------------get/set部分——------------------
		for(FileInfo fi : classInfo.getFileInfos()){
			result.appendGetter(fi.getType(), fi.getName());
			result.appendSetter(fi.getType(), fi.getName());
		}
		
		
		// -----------class结构结束部分
		result.appendBrace_back();
		System.out.println(result);
		return result.toString();
	}
	
	
	
	
}
