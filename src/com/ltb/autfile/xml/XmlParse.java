package com.ltb.autfile.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ltb.autfile.entity.ClassInfo;
import com.ltb.autfile.entity.FileInfo;
import com.ltb.autfile.exception.InfoException;

/**
 * xml解析
 * @author ltb
 *
 */
public class XmlParse {
	// xml路径
	private String xmlPath;
	// xml文档
	private Document document;
	
	public XmlParse(String path){
		this.xmlPath = path;
	}
	
	// 解析xml 生成字段信息
	@SuppressWarnings("rawtypes")
	public ClassInfo parse(){
		ClassInfo result = new ClassInfo();
		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(new File(xmlPath));
			// 获得根节点
			Element rootElm = document.getRootElement();
			
			Element className = rootElm.element("className");
			// 获取类名
			if(className != null){
				result.setClassName(className.getText());
			}else{
				throw new InfoException("类名不能为空");
			}
			// 遍历根节点下所有子节点 填充 result
			FileInfo info = null;
			boolean pflag = false;// 主键标识
			for(Iterator it=rootElm.elementIterator("param");it.hasNext();){
				Element elm = (Element)it.next();
				info = new FileInfo();
				// 获取名字属性
				Element nameElm = elm.element("name");
				if(nameElm != null){
					info.setName(nameElm.getText());
				}else{
					throw new  InfoException("字段名不能为空");
				}
				// 获取类型属性
				Element typeElm = elm.element("type");
				if(typeElm != null){
					info.setType(typeElm.getText());
				}else{
					throw new  InfoException("字段类型不能为空");
				}
				// 获取主键属性
				Element isPrimayElm = elm.element("isPrimay");
				if(isPrimayElm != null){
					info.setPrimary(Boolean.valueOf(isPrimayElm.getText()));
					pflag = true;
				}else{
					info.setPrimary(false);
				}
				if(!pflag){
					throw new  InfoException("未设置主键");
				}
				fileInfos.add(info);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		result.setFileInfos(fileInfos);
		return result;
	}
	
	public static void main(String[] args) {
//		String path = XmlParse.class.getResource("/").getFile().toString();
		String path = System.getProperty("user.dir");
		path = path + File.separator + "files\\Student.xml";
		System.out.println(path);
		XmlParse xp = new XmlParse(path);
		ClassInfo classInfo = xp.parse();
		for(FileInfo info : classInfo.getFileInfos()){
			System.out.println(info);
		}
	}
}
