package org.senai.cofipe.test;

public class TestClass {

	public static void main(String[] args) {
		try {
			testMethod();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void testMethod() throws Exception {
		throw new Exception("Teste");
	}
}
