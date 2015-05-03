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
import org.plotfaces.model.CanvasOverlay;
import org.plotfaces.model.Grid;
import org.plotfaces.model.Highlighter;
import org.plotfaces.model.Legend;
import org.plotfaces.model.Model;
import org.plotfaces.model.Series;
import org.plotfaces.model.Title;
import org.plotfaces.renderer.AxisLabelRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.CanvasGridRenderer;
import org.plotfaces.renderer.overlay.Line;
import org.plotfaces.renderer.DefaultMarkerRenderer;
import org.plotfaces.renderer.DefaultTickFormatter;
import org.plotfaces.renderer.DivTitleRenderer;
import org.plotfaces.renderer.EnhancedLegendRenderer;
import org.plotfaces.renderer.LineRenderer;
import org.plotfaces.renderer.LinearAxisRenderer;
import org.plotfaces.renderer.overlay.GeneralLineHolder;
import org.plotfaces.renderer.overlay.VerticalLine;
import org.plotfacesdemo.CollapseHandler;

/**
 *
 * @author Graham Smith
 */
public class LineChart implements ModelFactory {

	private Model model;

	public LineChart() {
	}

	@Override
	public Model getModel() {
		if (model == null) {
			model = new Model();
			setSeriesDefaults(model);
			setSeriesOne(model);
			setSeriesTwo(model);
			setAxesDefaults(model);
			setXAxis(model);
			setYAxis(model);
			setLegend(model);
			setTitle(model);
			setHighlighter(model);
			setGrid(model);
			setCanvasOverlay(model);
		}

		return model;
	}

	private void setSeriesDefaults(Model model) {
		Series seriesDefaults = new Series();
		seriesDefaults.setxAxis(Axis.AxisName.xaxis);
		seriesDefaults.setyAxis(Axis.AxisName.yaxis);
		seriesDefaults.setRendererOptions(new LineRenderer());
		model.setSeriesDefaults(seriesDefaults);
	}

	private void setSeriesOne(Model model) {
		Series series = new Series();
		series.setLabel("Series 1");
		series.setRendererOptions(new LineRenderer());
		series.setMarkerRendererOptions(new DefaultMarkerRenderer());

		//Some data for series 1
		PlotData<String, Integer> data = new PlotData<>();
		data.setEncodeKeys(false);
		data.add(PlotData.NULL_KEY, 2);
		data.add(PlotData.NULL_KEY, -3);
		data.add(PlotData.NULL_KEY, 3);
		data.add(PlotData.NULL_KEY, 6);
		data.add(PlotData.NULL_KEY, 7);
		series.setData(data);

		model.addSeries(series);
	}

	private void setSeriesTwo(Model model) {
		Series series = new Series();
		series.setLabel("Series 2");
		series.setRendererOptions(new LineRenderer());
		series.setMarkerRendererOptions(new DefaultMarkerRenderer());

		//Some data for series 2
		PlotData<String, Integer> data = new PlotData<>();
		data.setEncodeKeys(false);
		data.add(PlotData.NULL_KEY, 6);
		data.add(PlotData.NULL_KEY, 3);
		data.add(PlotData.NULL_KEY, 2);
		data.add(PlotData.NULL_KEY, 7);
		data.add(PlotData.NULL_KEY, 8);
		series.setData(data);

		model.addSeries(series);
	}

	private void setAxesDefaults(Model model) {
		Axis axis = new Axis(Axis.AxisName.axisDefaults);
		axis.setShow(false);
		model.setAxesDefaults(axis);
	}

	private void setXAxis(Model model) {
		Axis axis = new Axis(Axis.AxisName.xaxis);
		axis.setLabel("X-Axis");
		CanvasAxisTickRenderer tickRenderer = new CanvasAxisTickRenderer();
		tickRenderer.setFormatterOptions(new DefaultTickFormatter());
		axis.setTickOptions(tickRenderer);
		axis.setLabelOptions(new AxisLabelRenderer());
		axis.setRendererOptions(new LinearAxisRenderer());
		model.getAxes().setXaxis(axis);
	}

	private void setYAxis(Model model) {
		Axis axis = new Axis(Axis.AxisName.yaxis);
		axis.setLabel("Y-Axis");
		CanvasAxisTickRenderer tickRenderer = new CanvasAxisTickRenderer();
		tickRenderer.setFormatterOptions(new DefaultTickFormatter());
		axis.setTickOptions(tickRenderer);
		axis.setLabelOptions(new AxisLabelRenderer());
		axis.setRendererOptions(new LinearAxisRenderer());
		model.getAxes().setYaxis(axis);
	}

	private void setLegend(Model model) {
		Legend legend = new Legend();
		legend.setShow(true);
		legend.setRendererOptions(new EnhancedLegendRenderer());
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

	private void setGrid(Model model) {
		Grid grid = new Grid();
		grid.setDrawGridlines(true);
		grid.setRendererOptions(new CanvasGridRenderer());
		model.setGrid(grid);
	}

	private void setCanvasOverlay(Model model) {
		CanvasOverlay canvasOverlay = new CanvasOverlay();
		canvasOverlay.setShow(true);

		GeneralLineHolder lineHolder = new GeneralLineHolder();
		Line line = new Line();
		line.setShow(true);
		line.setStart(new Double[]{1.5, -2.0});
		line.setStop(new Double[]{4.5, 6.0});
		lineHolder.setLine(line);
		canvasOverlay.addObject(lineHolder);

		lineHolder = new GeneralLineHolder();
		VerticalLine verticalLine = new VerticalLine();
		verticalLine.setX(3.5);
		lineHolder.setVerticalLine(verticalLine);
		canvasOverlay.addObject(lineHolder);

		model.setCanvasOverlay(canvasOverlay);
	}
}
