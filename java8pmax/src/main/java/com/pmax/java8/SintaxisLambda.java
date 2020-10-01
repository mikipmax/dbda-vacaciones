package com.pmax.java8;

public class SintaxisLambda {
	public static void main(String[] args) {
		SintaxisLambda sl = new SintaxisLambda();
		System.out.println(sl.s1());
		System.out.println(sl.s2());
		System.out.println(sl.s3());
		System.out.println(sl.s4());
		System.out.println(sl.s5());
	}

	// Sintaxis normal con parámetros y con una sola expresión
	public double s1() {
		Operacion op = (double x, double y) -> (x + y) / 2;
		return op.calcProm(2, 3);
	}

	// sintaxis sin declarar tipo de variable en los parámetros y con una sola
	// expresión
	public double s2() {
		Operacion op = (x, y) -> (x + y) / 2;
		return op.calcProm(2, 3);
	}

	// Sintaxis sin declarar tipo de variable en los parámetrosy con varias
	// expresiones, cuando va en llaves debemos color el return ya que el metodo de
	// la interfaz es retornable
	public double s3() {
		Operacion op = (x, y) -> {
			System.out.println("Para varias sentencias");
			return (x + y) / 2;
		};
		return op.calcProm(2, 3);
	}

	// Sintaxis sin parámetros y con una sola expresión sin llaves.
	public String s4() {
		MetodoSp msp = () -> "Sin parámetros";
		return msp.metodoSp();
	}

	// Sintaxis sin parametros y con varias expresiones
	public String s5() {
		MetodoSp msp = () -> {
			String st1 = "Michael";
			String st2 = " Fred";
			return st1 + st2;
		};
		return msp.metodoSp();
	}

}
