package co.edu.ucentral.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import co.edu.ucentral.objects.Generator;
import co.edu.ucentral.objects.Nodo;

public class firstDeep extends algorithm {
	
	public void addAt(ArrayList<Nodo> open,ArrayList<Nodo> sucesors) {
		try {
			open.addAll(sucesors);
		}catch(Exception ex) {
			System.out.println("Error algorithm");
			ex.printStackTrace();
		}
		
	}

}
