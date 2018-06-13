package co.edu.ucentral.execute;

import java.util.Stack;

import co.edu.ucentral.algorithm.firstAplitude;
import co.edu.ucentral.algorithm.firstDeep;
import co.edu.ucentral.objects.Nodo;

public class execute {

	public static void main(String[] args) {
		firstDeep algorithm = new firstDeep();
		Stack[] initial = new Stack[3];
		Stack[] meta = new Stack[3];
		initial[0] = new Stack();
		initial[1] = new Stack();
		initial[2] = new Stack();
		initial[0].push(3);
		initial[0].push(2);
		initial[0].push(1);
		meta[0] = new Stack();
		meta[1] = new Stack();
		meta[2] = new Stack();
		meta[2].push(3);
		meta[2].push(2);
		meta[2].push(1);
		System.out.println("inicia");
		Nodo trace = algorithm.algorithm(initial, meta, 1);
		algorithm.printTrace(trace);
		firstAplitude algorithm1 = new firstAplitude();
		Nodo trace1 = algorithm1.algorithm(initial, meta, 1);
		algorithm.printTrace(trace1);
	}
	

}
