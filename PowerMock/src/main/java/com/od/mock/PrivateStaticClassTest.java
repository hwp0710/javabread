package com.od.mock;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DataProvider.class)
public class PrivateStaticClassTest {

	private static List<String> mockData = new ArrayList<String>();

	@BeforeClass
	public static void setUpOnce() {
		final String firstLine = "Line 1";
		final String secondLine = "Line 2";
		mockData.add(firstLine);
		mockData.add(secondLine);
	}

	@Before
	public void setUp() {
	}

	@Test
	public void testGetDataAsString() throws Exception {
		PowerMockito.spy(DataProvider.class);
		PowerMockito.doReturn(mockData).when(DataProvider.class, "readFile");

		final String expectedData = "[Line 1, Line 2]";
		final String returnedString = DataProvider.getData().toString();

		assertEquals(expectedData, returnedString);
	}

}

class DataProvider {

	public static List<String> getData() {
		try {
			return readFile();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @throws IOException  
	 */
	private static List<String> readFile() throws IOException {
		@SuppressWarnings("unused")
		File file = new File("/some/path/to/file");
		//do someting use file
		return Arrays.asList("aaa", "bbb");
	}

}
