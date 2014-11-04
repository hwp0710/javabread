package com.javapatterns.adapter.iterenum;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Enumeration;

public class Enuterator implements Iterator
{
	Enumeration enumrtn;

    public Enuterator(Enumeration enumrtn)
    {
		this.enumrtn = enumrtn;
    }

    public boolean hasNext()
    {
		return enumrtn.hasMoreElements();
    }

    public Object next() throws NoSuchElementException
    {
        return enumrtn.nextElement();
    }

    public void remove()
    {
		throw new UnsupportedOperationException();
    }

}
