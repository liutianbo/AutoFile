package com.ltb.autfile.file;

import java.io.File;
import java.util.List;

import com.ltb.autfile.Const;
import com.ltb.autfile.entity.ClassInfo;
import com.ltb.autfile.exception.InfoException;

/**
 * 根据字段信息生成entity文件
 * @author ltb
 *
 */
public class MakeEntity {
	
	private ClassInfo classInfo;// 类信息
	
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
		StringBuffer result = new StringBuffer();
		// ------------package部分--------------
		String entityPath = Const.ENTITY_PATH;// 获得类包路径
		if(entityPath == null || entityPath.equals("")){
			throw new InfoException("相对路径不能为空");
		}
		result.append(KeyConst.PACKAGE).append(entityPath);
		// import
		// class结构
		// 字段信息
		// get/set
		
		
		return result.toString();
	}
	
	
	
	
}
