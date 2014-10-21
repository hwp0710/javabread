package com.od.mock;

import static org.mockito.Matchers.any;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
// 注意这里，这个是new FileInputStream所在的类  
@PrepareForTest({Child.class})
public class MockWhenNew {
	@Test
	public void test() throws Exception {
		// 模拟数据流  
		File file = PowerMockito.mock(File.class);

		FileInputStream is = PowerMockito.mock(FileInputStream.class);
		PowerMockito.whenNew(FileInputStream.class).withArguments(file).thenReturn(is);

		InputStreamReader ir = new InputStreamReader(new ByteArrayInputStream("123".getBytes()));
		PowerMockito.whenNew(InputStreamReader.class).withArguments(any(FileInputStream.class)).thenReturn(ir);

		Child spy = new Child();
		Assert.assertEquals("123", spy.methodA(file));
	}

	@Test
	public void test2() throws Exception {

		File file = PowerMockito.mock(File.class);
		PowerMockito.whenNew(File.class).withArguments("sdfsdffs").thenReturn(file);
		Child spy = new Child();
		Assert.assertEquals(file, spy.getFile("sdfsdffs"));

	}

}

class Parent {

	public FileInputStream getFileInputStreamInstance(File file) throws Exception {

		return new FileInputStream(file);
	}

	public File getFile(String a) {
		return new File(a);
	}

}

class Child extends Parent {

	public String methodA(File file) throws Exception {

		FileInputStream in = super.getFileInputStreamInstance(file);
		InputStreamReader is = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(is);
		String line = "";
		StringBuffer sb = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	@Override
	public File getFile(String path) {
		return super.getFile(path);
	}

}
