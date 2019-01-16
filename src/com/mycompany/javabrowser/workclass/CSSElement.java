package com.mycompany.javabrowser.workclass;

import javax.swing.text.html.CSS;

public class CSSElement {

	private CSS name;
	private String value;
	
	public CSSElement(CSS name, String value) {
		this.name = name;
		this.value = value;
	}

	public CSS getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
