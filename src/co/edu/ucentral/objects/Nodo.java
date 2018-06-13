package co.edu.ucentral.objects;

import java.util.Stack;

public class Nodo {
	Nodo parent;
	Stack[] child ;
	public void setChild(Stack[] child) {
		this.child = child;
	}
	public Stack[] getChild() {
		return child;
	}
	public void setParent(Nodo parent) {
		this.parent = parent;
	}
	public Nodo getParent() {
		return parent;
	}
}
