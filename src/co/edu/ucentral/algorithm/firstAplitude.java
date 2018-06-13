package co.edu.ucentral.algorithm;

import java.util.ArrayList;
import java.util.Stack;

import co.edu.ucentral.objects.Nodo;

public class firstAplitude extends algorithm{
	public void addAt(ArrayList<Nodo> open,ArrayList<Nodo> sucesors) {
		try {
			open.addAll(0,sucesors);
		}catch(Exception ex) {
			System.out.println("Error algorithm");
			ex.printStackTrace();
		}
		
	}
}
