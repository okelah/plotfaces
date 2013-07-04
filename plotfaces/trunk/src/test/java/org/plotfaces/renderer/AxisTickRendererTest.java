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
public class AxisTickRendererTest {

	public AxisTickRendererTest() {
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
	 * Test of getFragments method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetFragments() {
	}

	/**
	 * Test of plot method, of class AxisTickRenderer.
	 */
	@Test
	public void testPlot() {
		AxisTickRenderer tickRenderer = new AxisTickRenderer();
		tickRenderer.setMark(AxisTickRenderer.Mark.outside);
		tickRenderer.setShowMark(true);
		tickRenderer.setShowGridline(true);
		tickRenderer.setIsMinorTick(true);
		tickRenderer.setSize(15);
		tickRenderer.setMarkSize(16);
		tickRenderer.setShow(true);
		tickRenderer.setShowLabel(true);
		tickRenderer.setFormatterOptions(new DefaultTickFormatter());
		tickRenderer.setPrefix("pre");
		tickRenderer.setFormatString("format");
		tickRenderer.setFontFamily("font_family");
		tickRenderer.setFontSize("17");
		tickRenderer.setTextColor("#AABBCC");
		tickRenderer.setEscapeHTML(false);
		String result = tickRenderer.plot();
		//System.out.println(result);
		String expected = "tickRenderer: $.jqplot.AxisTickRenderer,\n"
				+ "tickOptions: {mark:'outside',\n"
				+ "showMark:true,\n"
				+ "showGridline:true,\n"
				+ "isMinorTick:true,\n"
				+ "markSize:16,\n"
				+ "show:true,\n"
				+ "showLabel:true,\n"
				+ "formatter:$.jqplot.DefaultTickFormatter,\n"
				+ "prefix:'pre',\n"
				+ "formatString:'format',\n"
				+ "fontFamily:'font_family',\n"
				+ "fontSize:'17',\n"
				+ "textColor:'#AABBCC',\n"
				+ "escapeHTML:false}";
		assertEquals(expected, result);
	}

	/**
	 * Test of getRendererName method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetRendererName() {
		AxisTickRenderer tickRenderer = new AxisTickRenderer();
		assertEquals("AxisTickRenderer", tickRenderer.getRendererName());
	}

	/**
	 * Test of getMark method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetMark() {
	}

	/**
	 * Test of setMark method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetMark() {
	}

	/**
	 * Test of getShowMark method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetShowMark() {
	}

	/**
	 * Test of setShowMark method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetShowMark() {
	}

	/**
	 * Test of getShowGridline method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetShowGridline() {
	}

	/**
	 * Test of setShowGridline method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetShowGridline() {
	}

	/**
	 * Test of getIsMinorTick method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetIsMinorTick() {
	}

	/**
	 * Test of setIsMinorTick method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetIsMinorTick() {
	}

	/**
	 * Test of getSize method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetSize() {
	}

	/**
	 * Test of setSize method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetSize() {
	}

	/**
	 * Test of getMarkSize method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetMarkSize() {
	}

	/**
	 * Test of setMarkSize method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetMarkSize() {
	}

	/**
	 * Test of getShow method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetShow() {
	}

	/**
	 * Test of setShow method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetShow() {
	}

	/**
	 * Test of getShowLabel method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetShowLabel() {
	}

	/**
	 * Test of setShowLabel method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetShowLabel() {
	}

	/**
	 * Test of getFormatter method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetFormatter() {
	}

	/**
	 * Test of setFormatter method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetFormatter() {
	}

	/**
	 * Test of getFormatString method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetFormatString() {
	}

	/**
	 * Test of setFormatString method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetFormatString() {
	}

	/**
	 * Test of getPrefix method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetPrefix() {
	}

	/**
	 * Test of setPrefix method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetPrefix() {
	}

	/**
	 * Test of getFontFamily method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetFontFamily() {
	}

	/**
	 * Test of setFontFamily method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetFontFamily() {
	}

	/**
	 * Test of getFontSize method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetFontSize() {
	}

	/**
	 * Test of setFontSize method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetFontSize() {
	}

	/**
	 * Test of getTextColor method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetTextColor() {
	}

	/**
	 * Test of setTextColor method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetTextColor() {
	}

	/**
	 * Test of getEscapeHTML method, of class AxisTickRenderer.
	 */
	@Test
	public void testGetEscapeHTML() {
	}

	/**
	 * Test of setEscapeHTML method, of class AxisTickRenderer.
	 */
	@Test
	public void testSetEscapeHTML() {
	}
}
