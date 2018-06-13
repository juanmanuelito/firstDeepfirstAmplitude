package co.edu.ucentral.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Matriz {
	Stack[] matriz;

	public ArrayList<Nodo> generateNext(Stack[] stack, ArrayList<Nodo> closed,ArrayList<Nodo> open) {
		try {
			ArrayList<Nodo> generated = new ArrayList<Nodo>();
			for (int i = 0; i < 3; i++) {
				Stack[] newState = new Stack[3];
				newState = cloneStack(stack);
				for (int j = 0; j < 3 && !newState[i].empty(); j++) {
					if (i == j)
						continue;
					int disc = (int) newState[i].pop(), disc1;
					if (newState[j].empty()) {
						newState[j].push(disc);
						if (validateState(newState, closed,generated,open)) {
							Nodo generate = new Nodo();
							generate.setChild(cloneStack(newState));
							generated.add(generate);
							newState[i].push(newState[j].pop());
						} else
							newState[i].push(newState[j].pop());
					} else if (!newState[j].empty()) {
						if((disc1 = (int) newState[j].pop()) > disc){
							
							newState[j].push(disc1);
							newState[j].push(disc);
							if (validateState(newState, closed,generated,open)) {
								Nodo generate = new Nodo();
								generate.setChild(cloneStack(newState));
								generated.add(generate);
								newState[i].push(newState[j].pop());
							} else
								newState[i].push(newState[j].pop());
						}else if(disc1  < disc) {
							newState[i].push(disc);
							newState[j].push(disc1);
						}else newState[j].push(disc1);
					}
				}
			}
			return generated;
		}catch(Exception ex) {
			System.out.println("Error on printTrace");
			ex.printStackTrace();
			return null;
		}
	}

	public boolean validateState(Stack[] stack, ArrayList<Nodo> closed,ArrayList<Nodo> generated,ArrayList<Nodo> open) {
		try {
			for (Nodo matriz : closed) {
				if (Arrays.deepEquals(matriz.getChild(), stack))
					return false;
			}
			for (Nodo matriz : generated) {
				if (Arrays.deepEquals(matriz.getChild(), stack))
					return false;
			}
			for (Nodo matriz : open) {
				if (Arrays.deepEquals(matriz.getChild(), stack))
					return false;
			}
			return true;
		}catch(Exception ex) {
			System.out.println("Error on printTrace");
			ex.printStackTrace();
			return false;
		}
	}
	public Stack[] cloneStack(Stack[] stack) {
		try {
			Stack[] newState = new Stack[3];
			for (int x = 0; x < stack.length; x++) {
				newState[x] = new Stack();
				newState[x].addAll(stack[x]);
			}
			return newState;
		}catch(Exception ex) {
			System.out.println("Error on printTrace");
			ex.printStackTrace();
			return null;
		}
	}

}
