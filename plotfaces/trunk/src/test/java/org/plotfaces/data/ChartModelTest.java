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
