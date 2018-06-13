package co.edu.ucentral.algorithm;

import java.util.ArrayList;
import java.util.Stack;

import co.edu.ucentral.objects.Nodo;

public class firstAplitude extends algorithm{
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
					if(!compareTo(sub,current,meta))open.addAll(0,sub);
					else return meta2;
				}else return meta2;
			}
		}catch(Exception ex) {
			System.out.println("Error algorithm");
			ex.printStackTrace();
		}
		return null;
		
	}
}
