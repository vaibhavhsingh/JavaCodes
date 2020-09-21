package com.ds.problems;

interface BaseI {
	void method();
}

class BaseC {
	public void method() {
		System.out.println("Inside BaseC::method");
	}
}

class TestAbstract extends BaseC implements BaseI {
	public static void main(String[] s) {
		(new TestAbstract()).method();
	}
}
