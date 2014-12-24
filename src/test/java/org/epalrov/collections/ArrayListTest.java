/*
 * ArrayListTest.java - unit test for Array List
 *
 * Copyright (C) 2014 Paolo Rovelli
 *
 * Author: Paolo Rovelli <paolorovelli@yahoo.it>
 */

package org.epalrov.collections;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Unit test for ArrayList.
 */
public class ArrayListTest 
	extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ArrayListTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ArrayListTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testLinkedList() {
		String[] a = { "Hello", "Mr.", "Paolo", "Rovelli" };
		List<String> l = new ArrayList<String>();

		// add
		for (int i = 0; i < a.length; i++)
			assertTrue(l.add(a[i]));
		assertThat(l.size(), is(a.length));

		// search
		for (int i = 0; i < a.length; i++) {
			assertThat(l.get(i), is(a[i]));
			assertThat(l.contains(a[i]), is(true));
			assertThat(l.indexOf(a[i]), is(i));
			assertThat(l.lastIndexOf(a[i]), is(i));
		}

		// equals
		assertThat(l.equals(java.util.Arrays.asList(a)), is(true));

		// remove
		for (int i = 0; i < a.length; i++)
			assertTrue(l.remove(a[i]));
		assertTrue(l.isEmpty());

		// add all
		l.addAll(java.util.Arrays.asList(a));
		assertThat(l.size(), is(a.length));

		// iterators
		ListIterator<String> it1 = l.listIterator();
		for (int i = 0; it1.hasNext(); i++)
			assertThat(it1.next(), is(a[i]));
		ListIterator<String> it2 = l.listIterator(l.size());
		for (int i = a.length - 1; it2.hasPrevious(); i--)
			assertThat(it2.previous(), is(a[i]));
	}

}
