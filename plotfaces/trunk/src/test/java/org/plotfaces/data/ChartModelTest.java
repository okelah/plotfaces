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
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.plotfaces.JsonEmptyStringSerializer;
import org.plotfaces.PlotUtilities;
import org.plotfaces.component.FunctionFixer;
import org.plotfaces.renderer.AxisLabelRenderer;
import org.plotfaces.renderer.AxisTickRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.CategoryAxisRenderer;
import org.plotfaces.renderer.DefaultMarkerRenderer;
import org.plotfaces.renderer.TableLegendRenderer;
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
	 * The simple case where we add a number of series and see if they are
	 * ordered correctly.
	 *
	 */
	@Test
	public void testAddSeries_1() {
		ChartModel chartModel = new ChartModel();

		chartModel.addSeries(new Series(3, "Series 3"));
		chartModel.addSeries(new Series(1, "Series 1"));
		chartModel.addSeries(new Series(4, "Series 4"));
		chartModel.addSeries(new Series(2, "Series 2"));
		chartModel.addSeries(new Series(5, "Series 5"));

		int count = 0;
		String[] order = {"Series 1", "Series 2", "Series 3", "Series 4", "Series 5"};
		for (Series s : chartModel.getSeries()) {
			assertEquals(order[count], s.getLabel());
			count++;
		}
	}

	/**
	 * Test of compare method, of class SeriesComparator. This tests that the
	 * comparator maintains the contract that it is consistent with equals. This
	 * is hard to test for but the given case was known to break the original
	 * implementation.
	 */
	@Test
	public void testAddSeries_2() {
		ChartModel chartModel = new ChartModel();
		chartModel.addSeries(new Series(3, "Series 3"));
		chartModel.addSeries(new Series(1, "Series 1"));
		chartModel.addSeries(new Series(4, "Series 4"));
		Series s2 = new Series(2, "Series 2");
		chartModel.addSeries(s2);
		chartModel.addSeries(new Series(5, "Series 5"));

		int count = 0;
		String[] order = new String[]{"Series 1", "Series 2", "Series 3", "Series 4", "Series 5"};
		for (Series s : chartModel.getSeries()) {
			assertEquals(order[count], s.getLabel());
			count++;
		}

		//Checks that we can find the second series in the returned set.
		assertTrue(chartModel.getSeries().contains(s2));

		//Modify the index of the second series and then check that the
		//series are returned in the new correct order.
		s2.setIndex(6);
		count = 0;
		order = new String[]{"Series 1", "Series 3", "Series 4", "Series 5", "Series 2"};
		for (Series s : chartModel.getSeries()) {
			assertEquals(order[count], s.getLabel());
			count++;
		}

		//Check that we can still find the second series. This paranoia about
		//finding items in the set is because the ordering of the set can cause
		//items to not be found if the ordering changes while items are in the
		//set. To clarify, the ordering is based in the index of the series. If
		//the index of a series changes _while_it_is_in_the_set_ the correct
		//ordering will be different to the ordering the set contains. This will
		//cause the set to fail to find the item. To get around this a new set
		//is created everytime getSeries is called.
		assertTrue(chartModel.getSeries().contains(s2));
	}

	/**
	 * This tests the situation where one series doesn't have an index. It
	 * should be pushed to the back of the list. If more than one series has a
	 * null index the order of the items with no index is undetermined but they
	 * should come after the items with indexes.
	 */
	@Test
	public void testAddSeries_3() {
		ChartModel chartModel = new ChartModel();
		chartModel.addSeries(new Series(3, "Series 3"));
		chartModel.addSeries(new Series(1, "Series 1"));
		chartModel.addSeries(new Series(null, "Series 4"));
		chartModel.addSeries(new Series(2, "Series 2"));
		chartModel.addSeries(new Series(5, "Series 5"));

		int count = 0;
		String[] order = {"Series 1", "Series 2", "Series 3", "Series 5", "Series 4"};
		for (Series s : chartModel.getSeries()) {
			assertEquals(order[count], s.getLabel());
			count++;
		}
	}

	/**
	 * This tests the situation where one series has disable stack set.
	 */
	@Test
	public void testAddSeries_4() {
		ChartModel chartModel = new ChartModel();
		chartModel.addSeries(new Series(3, "Series 3"));
		chartModel.addSeries(new Series(1, "Series 1"));
		chartModel.addSeries(new Series(4, "Series 4"));
		Series s2 = new Series(2, "Series 2");
		s2.setDisableStack(true);
		chartModel.addSeries(s2);
		chartModel.addSeries(new Series(5, "Series 5"));

		int count = 0;
		String[] order = {"Series 1", "Series 3", "Series 4", "Series 5", "Series 2"};
		for (Series s : chartModel.getSeries()) {
			assertEquals(order[count], s.getLabel());
			count++;
		}
	}

	/**
	 * Test of compare method, of class SeriesComparator. This tests the complex
	 * situation where one series no index and two have disable stack set.
	 */
	@Test
	public void testAddSeries_5() {
		ChartModel chartModel = new ChartModel();
		chartModel.addSeries(new Series(null, "Series 3"));
		Series s1 = new Series(1, "Series 1");
		s1.setDisableStack(true);
		chartModel.addSeries(s1);
		Series s4 = new Series(4, "Series 4");
		s4.setDisableStack(true);
		chartModel.addSeries(s4);
		chartModel.addSeries(new Series(2, "Series 2"));
		chartModel.addSeries(new Series(5, "Series 5"));

		int count = 0;
		String[] order = {"Series 2", "Series 5", "Series 3", "Series 1", "Series 4"};
		for (Series s : chartModel.getSeries()) {
			assertEquals(order[count], s.getLabel());
			count++;
		}
	}

	/**
	 * Tests that we can have more than one series with no index set. This is
	 * important if the chart model uses a set behind the scenes to hold the
	 * series.
	 */
	@Test
	public void testAddSeries_6() {
		ChartModel chartModel = new ChartModel();
		chartModel.addSeries(new Series(null, "Series 3"));
		chartModel.addSeries(new Series(null, "Series 2"));

		assertEquals(2, chartModel.getSeries().size());
	}

	@Test
	public void testGson() {
		ChartModel chartModel = new ChartModel();

		setSeriesDefaults(chartModel);
		setSeriesOne(chartModel);
		setXAxis(chartModel);
		setYAxis(chartModel);
		setLegend(chartModel);

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.registerTypeAdapter(String.class, new JsonEmptyStringSerializer());
		Gson gson = gsonBuilder.create();
		String result = gson.toJson(chartModel);
		FunctionFixer fixer = new FunctionFixer();
		fixer.setPrettyPrint(true);
		result = fixer.fix(chartModel, result);
		System.out.println(result);
	}

	private void setSeriesDefaults(ChartModel chartModel) {
		Series seriesDefaults = new Series();
		seriesDefaults.setxAxis(Axis.AxisName.xaxis);
		seriesDefaults.setyAxis(Axis.AxisName.yaxis);
		chartModel.setSeriesDefaults(seriesDefaults);
	}

	private void setSeriesOne(ChartModel chartModel) {
		Series series = new Series();
		series.setLabel("Series 1");
		series.setRendererOptions(new LineRenderer());
		series.setMarkerRendererOptions(new DefaultMarkerRenderer());

		//Some data for series 1
		SimpleData data = new SimpleData();
		data.addValue(2);
		data.addValue(1);
		data.addValue(3);
		data.addValue(6);
		data.addValue(8);
		series.setData(data);

		chartModel.addSeries(series);
	}

	private void setXAxis(ChartModel chartModel) {
		Axis x = new Axis(Axis.AxisName.xaxis);
		x.setLabel("X-Axis");
		CanvasAxisTickRenderer xTickRenderer = new CanvasAxisTickRenderer();
		xTickRenderer.setFormatterOptions(new DefaultTickFormatter());
		x.setTickOptions(xTickRenderer);
		x.setLabelOptions(new AxisLabelRenderer());
		LinearAxisRenderer xAxisRenderer = new LinearAxisRenderer();
		//Tests that empty strings get set to null.
		xAxisRenderer.setBreakTickLabel("");
		x.setRendererOptions(xAxisRenderer);
		chartModel.getAxes().setXaxis(x);
	}

	private void setYAxis(ChartModel chartModel) {
		Axis y = new Axis(Axis.AxisName.yaxis);
		y.setLabel("Y-Axis");
		AxisTickRenderer yTickRenderer = new AxisTickRenderer();
		y.setTickOptions(yTickRenderer);
		y.setLabelOptions(new AxisLabelRenderer());
		y.setRendererOptions(new CategoryAxisRenderer());
		chartModel.getAxes().setYaxis(y);
	}

	private void setLegend(ChartModel chartModel) {
		Legend legend = new Legend();
		legend.setShow(true);
		legend.setPlacement(Legend.Placement.insideGrid);
		legend.setRendererOptions(new TableLegendRenderer());
		chartModel.setLegend(legend);
	}
}
