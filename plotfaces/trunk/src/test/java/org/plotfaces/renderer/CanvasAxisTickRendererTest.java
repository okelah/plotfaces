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
public class CanvasAxisTickRendererTest {

	public CanvasAxisTickRendererTest() {
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
	public void testPlot_1() {
		CanvasAxisTickRenderer tickRenderer = new CanvasAxisTickRenderer();
		tickRenderer.setAngle(45);
		tickRenderer.setLabelPosition(CanvasAxisTickRenderer.LabelPosition.middle);
		tickRenderer.setFontWeight("normal");
		tickRenderer.setFontStretch(1.0);
		tickRenderer.setEnableFontSupport(true);
		tickRenderer.setPt2px(2.0);
		String result = tickRenderer.plot();
		//System.out.println(result);
		String expected = "tickRenderer: $.jqplot.CanvasAxisTickRenderer,\n"
				+ "tickOptions: {angle:45,\n"
				+ "labelPosition:'middle',\n"
				+ "fontWeight:'normal',\n"
				+ "fontStretch:1.0,\n"
				+ "enableFontSupport:true,\n"
				+ "pt2px:2.0}";
		assertEquals(expected, result);
	}

	/**
	 * Test of getFragments method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testGetFragments() {
	}

	/**
	 * Test of getRendererType method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testGetRendererName() {
		CanvasAxisTickRenderer tickRenderer = new CanvasAxisTickRenderer();
		assertEquals("$.jqplot.CanvasAxisTickRenderer", tickRenderer.getRendererName());
	}

	/**
	 * Test of getAngle method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testGetAngle() {
	}

	/**
	 * Test of setAngle method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testSetAngle() {
	}

	/**
	 * Test of getLabelPosition method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testGetLabelPosition() {
	}

	/**
	 * Test of setLabelPosition method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testSetLabelPosition() {
	}

	/**
	 * Test of getFontWeight method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testGetFontWeight() {
	}

	/**
	 * Test of setFontWeight method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testSetFontWeight() {
	}

	/**
	 * Test of getFontStretch method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testGetFontStretch() {
	}

	/**
	 * Test of setFontStretch method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testSetFontStretch() {
	}

	/**
	 * Test of getEnableFontSupport method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testGetEnableFontSupport() {
	}

	/**
	 * Test of setEnableFontSupport method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testSetEnableFontSupport() {
	}

	/**
	 * Test of getPt2px method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testGetPt2px() {
	}

	/**
	 * Test of setPt2px method, of class CanvasAxisTickRenderer.
	 */
	@Test
	public void testSetPt2px() {
	}
}
