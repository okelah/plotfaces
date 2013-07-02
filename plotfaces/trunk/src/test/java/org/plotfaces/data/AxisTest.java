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
import java.util.List;
import junit.framework.TestCase;
import org.plotfaces.renderer.AxisLabelRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.AxisTickRenderer;
import org.plotfaces.renderer.DefaultTickFormatter;
import org.plotfaces.renderer.LinearAxisRenderer;

/**
 *
 * @author Graham Smith
 */
public class AxisTest extends TestCase {

	public AxisTest(String testName) {
		super(testName);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test of plot method, of class Axis.
	 */
	public void testPlot_1() {
		Axis axis = new Axis();
		axis.setShow(true);

		//*** Tick Renderer Start ***
		CanvasAxisTickRenderer tickRenderer = new CanvasAxisTickRenderer();
		axis.setTickRenderer(tickRenderer);

		//AxisTickRenderer Options
		tickRenderer.setMark(AxisTickRenderer.Mark.outside);
		tickRenderer.setShowMark(true);
		tickRenderer.setShowGridline(true);
		tickRenderer.setIsMinorTick(true);
		tickRenderer.setSize(15);
		tickRenderer.setMarkSize(16);
		tickRenderer.setShow(true);
		tickRenderer.setShowLabel(true);
		tickRenderer.setFormatter(new DefaultTickFormatter());
		tickRenderer.setPrefix("pre");
		tickRenderer.setFormatString("format");
		tickRenderer.setFontFamily("font_family");
		tickRenderer.setFontSize("17");
		tickRenderer.setTextColor("#AABBCC");
		tickRenderer.setEscapeHTML(false);

		//CanvasAxisTickRenderer Options
		tickRenderer.setAngle(45);
		tickRenderer.setLabelPosition(CanvasAxisTickRenderer.LabelPosition.middle);
		tickRenderer.setFontWeight("normal");
		tickRenderer.setFontStretch(1.0);
		tickRenderer.setEnableFontSupport(true);
		tickRenderer.setPt2px(2.0);

		//*** Tick Renderer End ***

		//*** Label Renderer Start ***

		AxisLabelRenderer labelRenderer = new AxisLabelRenderer();
		axis.setLabelRenderer(labelRenderer);
		labelRenderer.setShow(true);
		labelRenderer.setLabel("Axis Label");
		labelRenderer.setEscapeHTML(true);

		//*** Label Renderer End ***

		axis.setLabel("Label");
		axis.setShowLabel(true);
		axis.setMin(10);
		axis.setMax(100);
		axis.setAutoScale(true);
		axis.setPad(11.0);
		axis.setPadMax(20.0);
		axis.setPadMin(5.0);
		List<String> ticks = new ArrayList<>();
		ticks.add("Foo");
		ticks.add("Bar");
		ticks.add("Baz");
		axis.setTicks(ticks);
		axis.setNumberTicks(15);
		axis.setTickInterval(16);

		//*** Axis Renderer Start ***
		LinearAxisRenderer axisRenderer = new LinearAxisRenderer();
		axis.setRenderer(axisRenderer);
		axisRenderer.setBreakTickLabel("break");
		axisRenderer.setForceTickAtZero(true);
		axisRenderer.setForceTickAtOneHundred(true);
		//*** Axis Renderer End ***

		axis.setShowTicks(true);
		axis.setShowTickMarks(true);
		axis.setShowMinorTicks(true);
		axis.setUseSeriesColor(true);
		axis.setBorderWidth(18);
		axis.setBorderColor("#AABBCC");
		axis.setSyncTicks(true);
		axis.setTickSpacing(75);

		String result = axis.plot();
		//System.out.println(result);
		String expected = "{\n"
				+ "show:true,\n"
				+ "tickRenderer: $.jqplot.CanvasAxisTickRenderer,\n"
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
				+ "escapeHTML:false,\n"
				+ "angle:45,\n"
				+ "labelPosition:'middle',\n"
				+ "fontWeight:'normal',\n"
				+ "fontStretch:1.0,\n"
				+ "enableFontSupport:true,\n"
				+ "pt2px:2.0},\n"
				+ "labelRenderer: $.jqplot.AxisLabelRenderer,\n"
				+ "labelOptions: {show:true,\n"
				+ "label:'Axis Label',\n"
				+ "escapeHTML:true},\n"
				+ "label:'Label',\n"
				+ "showLabel:true,\n"
				+ "min:10,\n"
				+ "max:100,\n"
				+ "autoscale:true,\n"
				+ "pad:11.0,\n"
				+ "padMin:5.0,\n"
				+ "padMax:20.0,\n"
				+ "ticks:['Foo','Bar','Baz'],\n"
				+ "numberTicks:15,\n"
				+ "renderer: $.jqplot.LinearAxisRenderer,\n"
				+ "rendererOptions: {breakTickLabel:'break',\n"
				+ "forceTickAt0:true,\n"
				+ "forceTickAt100:true},\n"
				+ "showTicks:true,\n"
				+ "showTickMarks:true,\n"
				+ "showMinorTicks:true,\n"
				+ "useSeriesColor:true,\n"
				+ "borderWidth:18,\n"
				+ "borderColor:'##AABBCC',\n"
				+ "syncTicks:true,\n"
				+ "tickSpacing:75\n"
				+ "}";

		assertEquals(expected, result);
	}

	/**
	 * Test of getAxisName method, of class Axis.
	 */
	public void testGetAxisName() {
	}

	/**
	 * Test of setAxisName method, of class Axis.
	 */
	public void testSetAxisName() {
	}

	/**
	 * Test of getAutoScale method, of class Axis.
	 */
	public void testGetAutoScale() {
	}

	/**
	 * Test of setAutoScale method, of class Axis.
	 */
	public void testSetAutoScale() {
	}

	/**
	 * Test of getBorderColor method, of class Axis.
	 */
	public void testGetBorderColor() {
	}

	/**
	 * Test of setBorderColor method, of class Axis.
	 */
	public void testSetBorderColor() {
	}

	/**
	 * Test of getBorderWidth method, of class Axis.
	 */
	public void testGetBorderWidth() {
	}

	/**
	 * Test of setBorderWidth method, of class Axis.
	 */
	public void testSetBorderWidth() {
	}

	/**
	 * Test of getLabel method, of class Axis.
	 */
	public void testGetLabel() {
	}

	/**
	 * Test of setLabel method, of class Axis.
	 */
	public void testSetLabel() {
	}

	/**
	 * Test of getLabelRenderer method, of class Axis.
	 */
	public void testGetLabelRenderer() {
	}

	/**
	 * Test of setLabelRenderer method, of class Axis.
	 */
	public void testSetLabelRenderer() {
	}

	/**
	 * Test of getMax method, of class Axis.
	 */
	public void testGetMax() {
	}

	/**
	 * Test of setMax method, of class Axis.
	 */
	public void testSetMax() {
	}

	/**
	 * Test of getMin method, of class Axis.
	 */
	public void testGetMin() {
	}

	/**
	 * Test of setMin method, of class Axis.
	 */
	public void testSetMin() {
	}

	/**
	 * Test of getNumberTicks method, of class Axis.
	 */
	public void testGetNumberTicks() {
	}

	/**
	 * Test of setNumberTicks method, of class Axis.
	 */
	public void testSetNumberTicks() {
	}

	/**
	 * Test of getPad method, of class Axis.
	 */
	public void testGetPad() {
	}

	/**
	 * Test of setPad method, of class Axis.
	 */
	public void testSetPad() {
	}

	/**
	 * Test of getPadMax method, of class Axis.
	 */
	public void testGetPadMax() {
	}

	/**
	 * Test of setPadMax method, of class Axis.
	 */
	public void testSetPadMax() {
	}

	/**
	 * Test of getPadMin method, of class Axis.
	 */
	public void testGetPadMin() {
	}

	/**
	 * Test of setPadMin method, of class Axis.
	 */
	public void testSetPadMin() {
	}

	/**
	 * Test of getRenderer method, of class Axis.
	 */
	public void testGetRenderer() {
	}

	/**
	 * Test of setRenderer method, of class Axis.
	 */
	public void testSetRenderer() {
	}

	/**
	 * Test of getShow method, of class Axis.
	 */
	public void testGetShow() {
	}

	/**
	 * Test of setShow method, of class Axis.
	 */
	public void testSetShow() {
	}

	/**
	 * Test of getShowLabel method, of class Axis.
	 */
	public void testGetShowLabel() {
	}

	/**
	 * Test of setShowLabel method, of class Axis.
	 */
	public void testSetShowLabel() {
	}

	/**
	 * Test of getShowMinorTicks method, of class Axis.
	 */
	public void testGetShowMinorTicks() {
	}

	/**
	 * Test of setShowMinorTicks method, of class Axis.
	 */
	public void testSetShowMinorTicks() {
	}

	/**
	 * Test of getShowTickMarks method, of class Axis.
	 */
	public void testGetShowTickMarks() {
	}

	/**
	 * Test of setShowTickMarks method, of class Axis.
	 */
	public void testSetShowTickMarks() {
	}

	/**
	 * Test of getShowTicks method, of class Axis.
	 */
	public void testGetShowTicks() {
	}

	/**
	 * Test of setShowTicks method, of class Axis.
	 */
	public void testSetShowTicks() {
	}

	/**
	 * Test of getSyncTicks method, of class Axis.
	 */
	public void testGetSyncTicks() {
	}

	/**
	 * Test of setSyncTicks method, of class Axis.
	 */
	public void testSetSyncTicks() {
	}

	/**
	 * Test of getTickInterval method, of class Axis.
	 */
	public void testGetTickInterval() {
	}

	/**
	 * Test of setTickInterval method, of class Axis.
	 */
	public void testSetTickInterval() {
	}

	/**
	 * Test of getTickSpacing method, of class Axis.
	 */
	public void testGetTickSpacing() {
	}

	/**
	 * Test of setTickSpacing method, of class Axis.
	 */
	public void testSetTickSpacing() {
	}

	/**
	 * Test of getTicks method, of class Axis.
	 */
	public void testGetTicks() {
	}

	/**
	 * Test of setTicks method, of class Axis.
	 */
	public void testSetTicks() {
	}

	/**
	 * Test of getUseSeriesColor method, of class Axis.
	 */
	public void testGetUseSeriesColor() {
	}

	/**
	 * Test of setUseSeriesColor method, of class Axis.
	 */
	public void testSetUseSeriesColor() {
	}

	/**
	 * Test of getTickRenderer method, of class Axis.
	 */
	public void testGetTickRenderer() {
	}

	/**
	 * Test of setTickRenderer method, of class Axis.
	 */
	public void testSetTickRenderer() {
	}
}
