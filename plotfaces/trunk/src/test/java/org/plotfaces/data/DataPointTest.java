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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
public class DataPointTest {

	public DataPointTest() {
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

	@Test
	public void testConstruct() {
		try {
			DataPoint dp = new DataPoint(null, 5);
			fail("Expected an exception because of a null key.");
		} catch (IllegalArgumentException ex) {
		}

		try {
			DataPoint dp = new DataPoint("foo", null);
			fail("Expected an exception because of a null value.");
		} catch (IllegalArgumentException ex) {
		}

		//Test we can create data points with null keys.
		DataPoint dp = new DataPoint("foo", 5);
		assertEquals("foo", dp.getKey());
		assertEquals(5, dp.getValue());

		//Test we can create DataPoints with Date keys.
		Date now = new Date();
		DataPoint<Date, Double> dp2 = new DataPoint<>(now, 3.4);
		assertEquals(3.4, dp2.getValue(), 0);
		assertEquals(now, dp2.getKey());
	}

	/**
	 * Test of getKey method, of class DataPoint.
	 */
	@Test
	public void testGetKey() {
		Date now = new Date();
		DataPoint<Date, Double> dp = new DataPoint<>(now, 3.4);
		assertEquals(now, dp.getKey());
	}

	/**
	 * Test of setKey method, of class DataPoint.
	 */
	@Test
	public void testSetKey() {
		Date now = new Date();
		DataPoint<Date, Double> dp = new DataPoint<>(now, 3.4);
		assertEquals(now, dp.getKey());
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, 1);
		now = c.getTime();
		dp.setKey(now);
		assertEquals(now, dp.getKey());

	}

	/**
	 * Test of getValue method, of class DataPoint.
	 */
	@Test
	public void testGetValue() {
		DataPoint<Date, Double> dp = new DataPoint<>(new Date(), 3.4);
		assertEquals(3.4, dp.getValue(), 0);
	}

	/**
	 * Test of setValue method, of class DataPoint.
	 */
	@Test
	public void testSetValue() {
		DataPoint<Date, Double> dp = new DataPoint<>(new Date(), 3.4);
		assertEquals(3.4, dp.getValue(), 0);
		dp.setValue(7.3);
		assertEquals(7.3, dp.getValue(), 0);
	}

	/**
	 * Test of setValue method, of class DataPoint.
	 */
	@Test
	public void testCompareTo() {
		List<DataPoint<String, Integer>> points = new ArrayList<>();
		String key = "foo";
		points.add(new DataPoint(key, 1));
		points.add(new DataPoint(key, 2));
		points.add(new DataPoint(key, 0));
		Collections.sort(points);
		int count = 0;
		for (DataPoint dp : points) {
			assertEquals(count, dp.getValue());
			count++;
		}

	}
}
