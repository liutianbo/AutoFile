package com.ltb.autfile.entity;

/**
 * 字段信息
 * @author ltb
 *
 */
public class FileInfo {
	private String name;// 字段名称
	private String type;// 字段类型
	private boolean isPrimary;// 是否是主键
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isPrimary() {
		return isPrimary;
	}
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	@Override
	public String toString() {
		return "[name:"+name+",type:"+type+",isPrimary:"+isPrimary+"]";
	}
}
