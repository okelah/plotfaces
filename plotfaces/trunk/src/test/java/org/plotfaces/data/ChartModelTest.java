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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.plotfaces.renderer.AxisLabelRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.DefaultTickFormatter;
import org.plotfaces.renderer.LineRenderer;
import org.plotfaces.renderer.LinearAxisRenderer;

/**
 *
 * @author Graham Smith
 */
public class ChartModelTest {

	public ChartModelTest() {
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
	 * Test of getModelVariable method, of class ChartModel.
	 */
	@Test
	public void testGetModelVariable() {
	}

	/**
	 * Test of setModelVariable method, of class ChartModel.
	 */
	@Test
	public void testSetModelVariable() {
	}

	@Test
	public void testGson() {
		ChartModel chartModel = new ChartModel();

		ChartSeries seriesDefaults = new ChartSeries();
		seriesDefaults.setxAxis(Axis.AxisName.xaxis);
		seriesDefaults.setyAxis(Axis.AxisName.yaxis);
		chartModel.setSeriesDefaults(seriesDefaults);

		ChartSeries series = new ChartSeries();
		series.setLabel("Series 1");
		series.setRenderer(new LineRenderer());

		//Some data for series 1
		SimpleData data = new SimpleData();
		data.addValue(2);
		data.addValue(1);
		data.addValue(3);
		data.addValue(6);
		data.addValue(8);
		series.setData(data);

		chartModel.addSeries(series);

		List<Axis> axes = new ArrayList<>();

		Axis x = new Axis(Axis.AxisName.xaxis);
		x.setLabel("X-Axis");
		CanvasAxisTickRenderer xTickRenderer = new CanvasAxisTickRenderer();
		xTickRenderer.setFormatter(new DefaultTickFormatter());
		x.setTickRenderer(xTickRenderer);
		x.setLabelRenderer(new AxisLabelRenderer());
		x.setRenderer(new LinearAxisRenderer());
		axes.add(x);

		Axis y = new Axis(Axis.AxisName.yaxis);
		y.setLabel("Y-Axis");
		CanvasAxisTickRenderer yTickRenderer = new CanvasAxisTickRenderer();
		yTickRenderer.setFormatter(new DefaultTickFormatter());
		y.setTickRenderer(yTickRenderer);
		x.setLabelRenderer(new AxisLabelRenderer());
		x.setRenderer(new LinearAxisRenderer());
		axes.add(y);

		chartModel.setAxes(axes);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String result = gson.toJson(chartModel);
		System.out.println(result);
	}

	/**
	 * Test of plot method, of class ChartModel.
	 */
	@Test
	public void testPlot() {
	}

	/**
	 * Test of getAxesDefaults method, of class ChartModel.
	 */
	@Test
	public void testGetAxesDefaults() {
	}

	/**
	 * Test of setAxesDefaults method, of class ChartModel.
	 */
	@Test
	public void testSetAxesDefaults() {
	}

	/**
	 * Test of getAxes method, of class ChartModel.
	 */
	@Test
	public void testGetAxes() {
	}

	/**
	 * Test of setAxes method, of class ChartModel.
	 */
	@Test
	public void testSetAxes() {
	}

	/**
	 * Test of getLegend method, of class ChartModel.
	 */
	@Test
	public void testGetLegend() {
	}

	/**
	 * Test of setLegend method, of class ChartModel.
	 */
	@Test
	public void testSetLegend() {
	}

	/**
	 * Test of getSeriesDefaults method, of class ChartModel.
	 */
	@Test
	public void testGetSeriesDefaults() {
	}

	/**
	 * Test of setSeriesDefaults method, of class ChartModel.
	 */
	@Test
	public void testSetSeriesDefaults() {
	}

	/**
	 * Test of getSeries method, of class ChartModel.
	 */
	@Test
	public void testGetSeries() {
	}

	/**
	 * Test of setSeries method, of class ChartModel.
	 */
	@Test
	public void testSetSeries() {
	}

	/**
	 * Test of addSeries method, of class ChartModel.
	 */
	@Test
	public void testAddSeries() {
	}
}
