/*
 * Copyright 2013 Graham Smith.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.plotfaces.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Graham Smith
 */
public class PlotDataTest {

	public PlotDataTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getDataPoints method, of class PlotData.
	 */
	@Test
	public void testGetDataPoints() {
	}

	/**
	 * Test of setDataPoints method, of class PlotData.
	 */
	@Test
	public void testSetDataPoints() {
	}

	/**
	 * Test of add method, of class PlotData.
	 */
	@Test
	public void testAddDataPoint_DataPoint() {
		PlotData<String, Integer> pd = new PlotData<>();
		pd.add(new DataPoint<>("foo", 12));
		DataPoint<String, Integer> dp = pd.getDataPoints().get(0);
		assertEquals("foo", dp.getKey());
		assertEquals(12, dp.getValue(), 0);
	}

	/**
	 * Test of add method, of class PlotData.
	 */
	@Test
	public void testAddDataPoint_GenericType() {
		PlotData<String, Integer> pd = new PlotData<>();
		pd.add(PlotData.NULL_KEY, 2);
		DataPoint<String, Integer> dp = pd.getDataPoints().get(0);
		assertEquals(PlotData.NULL_KEY, dp.getKey());
		assertEquals(2, dp.getValue(), 0);
	}

	/**
	 * Test of add method, of class PlotData.
	 */
	@Test
	public void testAddDataPoint_GenericType_GenericType() {
		PlotData<String, Integer> pd = new PlotData<>();
		pd.add("foo", 12);
		DataPoint<String, Integer> dp = pd.getDataPoints().get(0);
		assertEquals("foo", dp.getKey());
		assertEquals(12, dp.getValue(), 0);
	}

	/**
	 * Test of encode method, of class PlotData. Simple case of data points with
	 * String keys and Integer data.
	 */
	@Test
	public void testEncode_1() {
		PlotData<String, Integer> pd = new PlotData<>();
		pd.add("foo", 12);
		pd.add("bar", 13);
		pd.add("baz", 14);
		String result = pd.encode();
		//System.out.println(result);
		String expected = "[['foo',12],['bar',13],['baz',14]]";
		assertEquals(expected, result);
	}

	/**
	 * Test of encode method, of class PlotData. Case of data points with Date
	 * keys and Integer data.
	 */
	@Test
	public void testEncode_2() {
		PlotData<Date, Integer> pd = new PlotData<>();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MILLISECOND, 0);
		c.set(2013, 11, 25, 0, 0, 0);
		pd.add(c.getTime(), 12);
		c.add(Calendar.HOUR, 24);
		pd.add(c.getTime(), 13);
		c.add(Calendar.HOUR, 24);
		pd.add(c.getTime(), 14);
		String result = pd.encode();
		//System.out.println(result);
		String expected = "[['Wed Dec 25 00:00:00 GMT 2013',12],['Thu Dec 26 00:00:00 GMT 2013',13],['Fri Dec 27 00:00:00 GMT 2013',14]]";
		assertEquals(expected, result);
	}

	/**
	 * Test of encode method, of class PlotData. Case of data points with Date
	 * keys and Integer data and a Format applied.
	 */
	@Test
	public void testEncode_3() {
		PlotData<Date, Integer> pd = new PlotData<>();
		pd.setFormat(new SimpleDateFormat("yyyyMMdd"));
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MILLISECOND, 0);
		c.set(2013, 11, 25, 0, 0, 0);
		pd.add(c.getTime(), 12);
		c.add(Calendar.HOUR, 24);
		pd.add(c.getTime(), 13);
		c.add(Calendar.HOUR, 24);
		pd.add(c.getTime(), 14);
		String result = pd.encode();
		//System.out.println(result);
		String expected = "[['20131225',12],['20131226',13],['20131227',14]]";
		assertEquals(expected, result);
	}

	/**
	 * Test of encode method, of class PlotData. Case of data points with Date
	 * keys, Integer data, a Format applied and natural ordering used.
	 */
	@Test
	public void testEncode_4() {
		PlotData<Date, Integer> pd = new PlotData<>();
		pd.setFormat(new SimpleDateFormat("yyyyMMdd"));
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MILLISECOND, 0);
		c.set(2013, 11, 25, 0, 0, 0);
		pd.add(c.getTime(), 12);
		c.add(Calendar.HOUR, 24);
		pd.add(c.getTime(), 13);
		c.add(Calendar.HOUR, -48);
		pd.add(c.getTime(), 14);
		pd.sort();
		String result = pd.encode();
		//System.out.println(result);
		String expected = "[['20131224',14],['20131225',12],['20131226',13]]";
		assertEquals(expected, result);
	}

	/**
	 * Test of encode method, of class PlotData. Case of data points with Date
	 * keys, Integer data, a Format applied and a Comparator used.
	 */
	@Test
	public void testEncode_5() {
		PlotData<Date, Integer> pd = new PlotData<>();
		//This is a nonsense comparator but it shows that the comparator
		//override option is working.
		pd.setComparator(new Comparator<DataPoint<Date, Integer>>() {
			@Override
			public int compare(DataPoint<Date, Integer> dp1, DataPoint<Date, Integer> dp2) {
				return dp1.getValue().compareTo(dp2.getValue());
			}
		});
		pd.setFormat(new SimpleDateFormat("yyyyMMdd"));
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MILLISECOND, 0);
		c.set(2013, 11, 25, 0, 0, 0);
		pd.add(c.getTime(), 14);
		c.add(Calendar.HOUR, 24);
		pd.add(c.getTime(), 16);
		c.add(Calendar.HOUR, 24);
		pd.add(c.getTime(), 12);
		pd.sort();
		String result = pd.encode();
		//System.out.println(result);
		String expected = "[['20131227',12],['20131225',14],['20131226',16]]";
		assertEquals(expected, result);
	}

	/**
	 * Test of encode method, of class PlotData. Data with no keys.
	 */
	@Test
	public void testEncode_6() {
		//Use a String for the type of the key when a null key is wanted.
		PlotData<String, Integer> pd = new PlotData<>();
		pd.setEncodeKeys(false);
		pd.add(PlotData.NULL_KEY, 14);
		pd.add(PlotData.NULL_KEY, 16);
		pd.add(PlotData.NULL_KEY, 12);

		String result = pd.encode();
		System.out.println(result);
		String expected = "[14,16,12]";
		assertEquals(expected, result);

		pd.sort();

		result = pd.encode();
		System.out.println(result);
		expected = "[12,14,16]";
		assertEquals(expected, result);
	}

	/**
	 * Test of encode method, of class PlotData. Case of data points with Date
	 * keys and String values. Highly unlikley data format but technically
	 * allowed.
	 */
	@Test
	public void testEncode_7() {
		PlotData<Date, String> pd = new PlotData<>();
		pd.setFormat(new SimpleDateFormat("yyyyMMdd"));
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MILLISECOND, 0);
		c.set(2013, 11, 25, 0, 0, 0);
		pd.add(c.getTime(), "Foo");
		c.add(Calendar.HOUR, 24);
		pd.add(c.getTime(), "Bar");
		c.add(Calendar.HOUR, 24);
		pd.add(c.getTime(), "Baz");
		String result = pd.encode();
		//System.out.println(result);
		String expected = "[['20131225','Foo'],['20131226','Bar'],['20131227','Baz']]";
		assertEquals(expected, result);
	}
}
