package com.od.mock.test1;

import junit.framework.TestCase;

import org.junit.Test;

public class SayHiExceptionTest extends TestCase {

	@Test
	public void testSayHi() {
		SayHi sh = new SayHi();
		assertTrue(sh.sayHi("abc", "def").equalsIgnoreCase("abc def"));
	}
}

class SayHi {

	public String sayHi(String a, String b) {
		Adder adder = new Adder();
		String result = "";
		try {
			//由于Adder类抛出了一个Exception，导致在使用这个类时必须加上try/catch。
			result = adder.add(a, b);
		} catch (Exception e) {
			result = "Failed";
		}
		return result;
	}
}

class Adder {
	public String add(String a, String b) throws Exception {
		return a + " " + b;
	}
}
