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
package org.plotfaces.renderer;

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
public class CategoryAxisRendererTest {

	public CategoryAxisRendererTest() {
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
	public void testPlot() {
		CategoryAxisRenderer axisRenderer = new CategoryAxisRenderer();
		axisRenderer.setSortMergedLabels(true);
		axisRenderer.setTickRenderer(new AxisTickRenderer());
		String result = axisRenderer.plot();
//		System.out.println(result);
		String expected = "renderer: $.jqplot.CategoryAxisRenderer,\n"
				+ "rendererOptions: {sortMergedLabels:true,\n"
				+ "tickRenderer: $.jqplot.AxisTickRenderer,\n"
				+ "tickOptions: {}}";
		assertEquals(expected, result);
	}

	/**
	 * Test of getFragments method, of class CategoryAxisRenderer.
	 */
	@Test
	public void testGetFragments() {
	}

	/**
	 * Test of getSortMergedLabels method, of class CategoryAxisRenderer.
	 */
	@Test
	public void testGetSortMergedLabels() {
	}

	/**
	 * Test of setSortMergedLabels method, of class CategoryAxisRenderer.
	 */
	@Test
	public void testSetSortMergedLabels() {
	}

	/**
	 * Test of getTickRenderer method, of class CategoryAxisRenderer.
	 */
	@Test
	public void testGetTickRenderer() {
	}

	/**
	 * Test of setTickRenderer method, of class CategoryAxisRenderer.
	 */
	@Test
	public void testSetTickRenderer() {
	}

	/**
	 * Test of getRendererName method, of class CategoryAxisRenderer.
	 */
	@Test
	public void testGetRendererName() {
	}
}
