package co.edu.ucentral.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import co.edu.ucentral.objects.Generator;
import co.edu.ucentral.objects.Nodo;

public abstract class algorithm {
	protected ArrayList<Nodo> open = new ArrayList();
	protected ArrayList<Nodo> closed = new ArrayList();
	protected int nProfundidad = 100;
	protected Nodo meta2 = new Nodo();
	protected Generator matriz = new Generator();
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
	public Nodo algorithm(Stack[] initial,Stack[] meta,int nProfundidad) {
		try{
			Nodo current = new Nodo();
			current.setChild(initial);
			open.add(current);
			boolean finish = false;
			int a = 0;
			while(!open.isEmpty() && !finish) {
				current = (Nodo) open.get(0);
				open.remove(current);
				if(!inClosed(current.getChild()) && nProfundidad < this.nProfundidad) {
					closed.add(current);
					ArrayList<Nodo> sub =matriz.generateNext(current.getChild(), closed,open);
					if(!compareTo(sub,current,meta))addAt(open,sub);
					else return meta2;
				}else return meta2;
			}
		}catch(Exception ex) {
			System.out.println("Error algorithm");
			ex.printStackTrace();
		}
		return null;
		
	}
	public abstract void addAt(ArrayList<Nodo> open,ArrayList<Nodo> sucesors);
}
