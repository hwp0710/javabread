package com.od.mock;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MockFile.class)
public class MockFile {
	@Test
	public void testRegisterService() throws Exception {
		String filePath = "F:/aa.txt";
		File file = PowerMockito.mock(File.class);
		PowerMockito.whenNew(File.class).withArguments(Mockito.anyString()).thenReturn(file);
		PowerMockito.when(file.exists()).thenReturn(true);
		File a = new File(filePath);
		Assert.assertEquals(true, a.exists());
	}
}
