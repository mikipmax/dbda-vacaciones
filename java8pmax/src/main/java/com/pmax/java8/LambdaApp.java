package com.pmax.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaApp {
	public static void main(String[] args) {
		LambdaApp app = new LambdaApp();
		app.ordenar();
		app.calcular();
	}

	public void ordenar() {
		List<String> lista = new ArrayList<>();
		lista.add("Mikipmax");
		lista.add("Winka");

		// Aqui usamos lo normal sin lambdas
//		Collections.sort(lista, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});

		// Esta línea reemplaza todo el codigo anterior comentado

		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2)); // Lambda
		for (String elemento : lista) {
			System.out.println(elemento);
		}
	}

	public void calcular() {
//		Operacion op = new Operacion() {
//
//			@Override
//			public double calcProm(double a, double b) {
//
//				return (a + b) / 2;
//			}
//		};
//		System.out.println(op.calcProm(2, 3));

		
		Operacion op = (double x, double y) -> (x + y) / 2;
		System.out.println(op.calcProm(2, 3));
	}

}
