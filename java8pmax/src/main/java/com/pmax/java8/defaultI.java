package com.pmax.java8;

public interface defaultI {
	void a();

	default void b() {
		System.out.println("Pruebas B");
	}
}
