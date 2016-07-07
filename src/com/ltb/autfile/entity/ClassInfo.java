package com.ltb.autfile.entity;

import java.util.List;

public class ClassInfo {
	// 类名
	private String className;
	// 字段信息
	private List<FileInfo> fileInfos;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<FileInfo> getFileInfos() {
		return fileInfos;
	}
	public void setFileInfos(List<FileInfo> fileInfos) {
		this.fileInfos = fileInfos;
	}

}
