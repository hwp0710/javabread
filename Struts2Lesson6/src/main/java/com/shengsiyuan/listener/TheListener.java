package com.shengsiyuan.listener;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class TheListener implements PreResultListener
{
	@Override
	public void beforeResult(ActionInvocation invocation, String resultCode)
	{
		System.out.println("result code: " + resultCode);
	}
}
