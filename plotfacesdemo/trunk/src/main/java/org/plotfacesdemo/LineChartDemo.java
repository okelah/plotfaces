package org.plotfacesdemo;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
import org.slf4j.Logger;

/**
 *
 * @author Graham Smith
 */
@Named
@SessionScoped
public class LineChartDemo implements Serializable {

	@Inject
	private Logger logger;
	private Model model;
	private CollapseHandler collapseHandler = new CollapseHandler();

	public LineChartDemo() {
	}

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
		}

		return model;
	}

	private void setSeriesDefaults(Model model) {
		Series seriesDefaults = new Series();
		seriesDefaults.setxAxis(Axis.AxisName.xaxis);
		seriesDefaults.setyAxis(Axis.AxisName.yaxis);
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

	public CollapseHandler getCollapseHandler() {
		return collapseHandler;
	}
}
