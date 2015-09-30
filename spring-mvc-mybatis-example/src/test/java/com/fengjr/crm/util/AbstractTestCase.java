package com.fengjr.crm.util;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractTestCase extends TestCase {
    protected ApplicationContext ctx = null;

    public AbstractTestCase() {
        ctx = new ClassPathXmlApplicationContext("classpath*:/spring/*-config.xml");
    }
}