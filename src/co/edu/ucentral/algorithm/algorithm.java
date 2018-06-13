package co.edu.ucentral.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import co.edu.ucentral.objects.Matriz;
import co.edu.ucentral.objects.Nodo;

public abstract class algorithm {
	protected ArrayList<Nodo> open = new ArrayList();
	protected ArrayList<Nodo> closed = new ArrayList();
	protected int nProfundidad = 100;
	protected Nodo meta2 = new Nodo();
	protected Matriz matriz = new Matriz();
	public boolean inClosed(Stack[] stack) {
		try{
			for(Nodo matriz: closed) {
				if(Arrays.deepEquals(matriz.getChild(), stack)) {
					return true;
				}
			}
			return false;
		}catch(Exception ex) {
			System.out.println("Error on closed");
			ex.printStackTrace();
			return false;
		}
		
	}
	public boolean compareTo(ArrayList<Nodo> list,Nodo parent,Stack[] stack) {
		try{
			for(Nodo child : list) {
				child.setParent(parent);
				if(Arrays.deepEquals(stack, child.getChild())) {
					meta2 = child; 
					return true;
				}
			}
			return false;
		}catch(Exception ex) {
			System.out.println("Error on compareTo");
			ex.printStackTrace();
			return false;
		}
	}
	public void printTrace(Nodo trace) {
		try {
			System.out.println("Print trace");
			while(trace != null) {
				System.out.println("generated child");
				printStack(trace.getChild());
				trace = trace.getParent();
			}
		}catch(Exception ex) {
			System.out.println("Error on printTrace");
			ex.printStackTrace();
		}
	}
	public void printStack(Stack[] stacks) {
		try {
			for(Stack stack : stacks) {
				System.out.println(stack);
			}
		}catch(Exception ex) {
			System.out.println("Error on printTrace");
			ex.printStackTrace();
		}
	}
}
