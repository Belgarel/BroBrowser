package com.mycompany.javabrowser;

public class Tag {

	private String parentTag, parentStyle, content;
	
	public Tag(String parentTag, String parentStyle, String content) {
		this.parentTag = parentTag;
		this.parentStyle = parentStyle;
		this.content = content;
	}

	public String getParentTag() {
		return parentTag;
	}

	public String getParentStyle() {
		return parentStyle;
	}

	public String getContent() {
		return content;
	}
}
