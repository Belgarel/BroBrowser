package com.mycompany.javabrowser.workclass;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.javabrowser.Tag;

public class TAGElement {
	
	private Tag TAGname;

	private List<CSSElement> CSSElements;
	
	private TAGElement parentTAG;
	private List<TAGElement> childrensTAG;
	
	public TAGElement() {
		this.CSSElements = new ArrayList<CSSElement>();
		this.childrensTAG = new ArrayList<TAGElement>();
	}
	
	public void addCSSElement(CSSElement element) {
		this.CSSElements.add(element);
	}
	
	public void removeCSSElement(CSSElement element) {
		this.CSSElements.remove(element);
	}
	
	public List<CSSElement> getCSSElements() {
		return this.CSSElements;
	}
	
	public void addChildrenTAG(TAGElement element) {
		this.childrensTAG.add(element);
	}
	
	public void removeChildrenTAG(TAGElement element) {
		this.childrensTAG.remove(element);
	}
	
	public List<TAGElement> getChildrensTAG() {
		return this.childrensTAG;
	}
	
	public TAGElement getParentTAG() {
		return this.parentTAG;
	}
	
	public void setParentTAG(TAGElement element) {
		this.parentTAG = element;
	}
	
	public void setTAGName(Tag name) {
		this.TAGname = name;
	}
}
