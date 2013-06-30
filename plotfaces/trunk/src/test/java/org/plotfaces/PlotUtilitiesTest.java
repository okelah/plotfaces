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
package org.plotfaces;

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
public class PlotUtilitiesTest {

	public PlotUtilitiesTest() {
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
	 * Test of getEscapedClientId method, of class PlotUtilities.
	 */
	@Test
	public void testGetEscapedClientId() {
	}

	/**
	 * Test of addVariable method, of class PlotUtilities.
	 */
	@Test
	public void testAddVariable_4args() {
	}

	/**
	 * Test of addVariable method, of class PlotUtilities.
	 */
	@Test
	public void testAddVariable_5args() {
	}

	/**
	 * Test of createVariable method, of class PlotUtilities.
	 */
	@Test
	public void testCreateVariable() {
		assertEquals("foo:'bar'", PlotUtilities.createVariable("foo", "bar"));
		assertEquals("foo:true", PlotUtilities.createVariable("foo", Boolean.TRUE));
		assertEquals("foo:7", PlotUtilities.createVariable("foo", new Integer(7)));
	}

	/**
	 * Test of getSafeClientId method, of class PlotUtilities.
	 */
	@Test
	public void testGetSafeClientId() {
	}
}
