package com.mycompany.javabrowser.workclass;

import java.util.ArrayList;
import java.util.List;

public class ParseHelper {

	public static List<CSSElement> getCSSElementsFromTagText(String tagText) { // Example what to write in parameter : <div style='margin:15px;'> 
		List<CSSElement> CSSElements = new ArrayList<CSSElement>();
		
		// Look if style property exist
		
		return CSSElements;
	}
	
	public static List<PropertyElement> getPropertiesElementsFromTagText(String tagText) { // Example what to write in parameter : <a href='url'>
		List<PropertyElement> propertiesElements = new ArrayList<PropertyElement>();
		
		// Look if properties (without style property) exists
		
		return propertiesElements;
	}
}