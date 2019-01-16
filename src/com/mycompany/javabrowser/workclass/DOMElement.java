package com.mycompany.javabrowser.workclass;

import java.util.ArrayList;
import java.util.List;

public class DOMElement {

	private List<TAGElement> TAGElements;
	
	public DOMElement() {
		this.TAGElements = new ArrayList<TAGElement>();
	}
	
	public List<TAGElement> getTAGElements() {
		return this.TAGElements;
	}
	
	public void transformHTMLToDOM(String html) {
		// Initialize TAGs list
		this.TAGElements = new ArrayList<TAGElement>();
		// Start to parse html to dom
	}
}
