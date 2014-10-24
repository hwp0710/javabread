package com.od.mock;

import junit.framework.TestCase;

import org.junit.Test;

public class SayHiTest extends TestCase {

	@Test
	public void testSayHi() {
		SayHi sh = new SayHi();
		assertTrue(sh.sayHi("abc", "def").equalsIgnoreCase("abc def"));
	}
}

class SayHi {

	public String sayHi(String a, String b) {
		Adder adder = new Adder(); 
		String result = adder.add(a, b);
		return result;
	}
}

class Adder {
	public String add(String a, String b) {
		return a + " " + b;
	}
}
