package com.pmax.java8;

public class Scopes {
	private double num1;
	private static double num2;

	public double probarVarLocal() {
		double n = 3;
		Operacion op = (x, y) -> {
			// n+= x + y; Se comenta puesto que "n" es una variable local
			// y dentro de una expresión lambda no puede ser modificada solo se puede usar
			// su valor
			// es decir n se convierte de tipo final
			// para poder modificar el valor de una variable debe ser global(estática o no
			// estática).
			num1 = 2;
			num2 = n + num1;
			return num2 + x + y;
		};
		return op.calcProm(1, 1);

	}

	public static void main(String[] args) {
		Scopes sc = new Scopes();
		System.out.println(sc.probarVarLocal());

	}

}
