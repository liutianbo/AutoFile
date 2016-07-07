package com.ltb.autfile;

import java.io.File;

import com.ltb.autfile.exception.InfoException;
import com.ltb.autfile.file.MakeEntity;
import com.ltb.autfile.utils.IoUtils;
import com.ltb.autfile.xml.XmlParse;

public class Index {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		path = path + File.separator + "files\\Student.xml";
		
		XmlParse xmlp = new XmlParse(path);
		
		MakeEntity me = new MakeEntity(xmlp.parse());
		
		try {
			String file = me.creatFile();
			IoUtils.WriteFile(file, Const.ROOT_PATH,me.getFileName(),true);
		} catch (InfoException e) {
			e.printStackTrace();
		}
	}
}
