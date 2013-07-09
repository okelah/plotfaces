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
package org.plotfacesdemo.models;

import org.plotfaces.data.PlotData;
import org.plotfaces.model.Axis;
import org.plotfaces.model.Grid;
import org.plotfaces.model.Highlighter;
import org.plotfaces.model.Legend;
import org.plotfaces.model.Model;
import org.plotfaces.model.Series;
import org.plotfaces.model.Title;
import org.plotfaces.renderer.BarRenderer;
import org.plotfaces.renderer.CanvasGridRenderer;
import org.plotfaces.renderer.CategoryAxisRenderer;
import org.plotfaces.renderer.DefaultMarkerRenderer;
import org.plotfaces.renderer.DivTitleRenderer;
import org.plotfaces.renderer.EnhancedLegendRenderer;
import org.plotfaces.renderer.PieLegendRenderer;
import org.plotfaces.renderer.PieRenderer;

/**
 * A simple pie chart with a single series of data. Pie charts don't render very
 * well if axes and grids are specified.
 *
 * @author Graham Smith
 */
public class PieChart implements ModelFactory {

	private Model model;

	public PieChart() {
	}

	@Override
	public Model getModel() {
		if (model == null) {
			model = new Model();
			setSeriesDefaults(model);
			setSeriesOne(model);
//			setSeriesTwo(model);
//			setAxesDefaults(model);
//			setXAxis(model);
//			setYAxis(model);
			setLegend(model);
			setTitle(model);
			setHighlighter(model);
//			setGrid(model);
		}
		return model;
	}

	private void setSeriesDefaults(Model model) {
		Series seriesDefaults = new Series();
		seriesDefaults.setxAxis(Axis.AxisName.xaxis);
		seriesDefaults.setyAxis(Axis.AxisName.yaxis);
		seriesDefaults.setRendererOptions(new PieRenderer());
		model.setSeriesDefaults(seriesDefaults);
	}

	private void setSeriesOne(Model model) {
		Series series = new Series();
		series.setLabel("Series 1");
		series.setRendererOptions(new PieRenderer());
		series.setMarkerRendererOptions(new DefaultMarkerRenderer());

		//Some data for series 1
		PlotData<String, Integer> data = new PlotData<>();
		data.add("Funky", 5);
		data.add("Spunky", 2);
		data.add("Monkey", 9);
		series.setData(data);

		model.addSeries(series);
	}

//	private void setSeriesTwo(Model model) {
//		Series series = new Series();
//		series.setLabel("Series 2");
//		series.setRendererOptions(new PieRenderer());
//		series.setMarkerRendererOptions(new DefaultMarkerRenderer());
//
//		//Some data for series 1
//		PlotData<String, Integer> data = new PlotData<>();
//		data.add("Funky", 9);
//		data.add("Spunky", 1);
//		data.add("Monkey", 3);
//		series.setData(data);
//
//		model.addSeries(series);
//	}
//	private void setAxesDefaults(Model model) {
//		Axis axis = new Axis(Axis.AxisName.axisDefaults);
//		axis.setShow(false);
//		model.setAxesDefaults(axis);
//	}
//	private void setXAxis(Model model) {
//		Axis axis = new Axis(Axis.AxisName.xaxis);
//		axis.setLabel("X-Axis");
//		CategoryAxisRenderer categoryAxisRenderer = new CategoryAxisRenderer();
//		axis.setRendererOptions(categoryAxisRenderer);
//		model.getAxes().setXaxis(axis);
//	}
//
//	private void setYAxis(Model model) {
//		Axis axis = new Axis(Axis.AxisName.yaxis);
//		axis.setLabel("Y-Axis");
//		model.getAxes().setYaxis(axis);
//	}
	private void setLegend(Model model) {
		Legend legend = new Legend();
		legend.setShow(true);
		legend.setRendererOptions(new PieLegendRenderer());
		model.setLegend(legend);
	}

	private void setTitle(Model model) {
		Title title = new Title();
		title.setShow(true);
		title.setRendererOptions(new DivTitleRenderer());
		model.setTitle(title);
	}

	private void setHighlighter(Model model) {
		Highlighter highlighter = new Highlighter();
		highlighter.setShow(true);
		highlighter.setMarkerRendererOptions(new DefaultMarkerRenderer());
		model.setHighlighter(highlighter);
	}
//	private void setGrid(Model model) {
//		Grid grid = new Grid();
//		grid.setDrawGridlines(true);
//		grid.setRendererOptions(new CanvasGridRenderer());
//		model.setGrid(grid);
//	}
}
