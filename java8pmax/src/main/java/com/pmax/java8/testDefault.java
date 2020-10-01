package com.pmax.java8;

public class testDefault implements defaultI, defaultI2 {
	public static void main(String[] args) {
		testDefault td = new testDefault();
		td.a();
		td.b();
	}

	@Override
	public void a() {
		System.out.println("Default A");

	}

	@Override
	public void b() {
		defaultI2.super.b();
	}

}
