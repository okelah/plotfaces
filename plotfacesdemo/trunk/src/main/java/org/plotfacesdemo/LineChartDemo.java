package org.plotfacesdemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.plotfaces.component.RendererOptions;
import org.plotfaces.data.Axes;
import org.plotfaces.data.Axis;
import org.plotfaces.data.ChartModel;
import org.plotfaces.data.Series;
import org.plotfaces.data.Grid;
import org.plotfaces.data.Highlighter;
import org.plotfaces.data.Legend;
import org.plotfaces.data.SimpleData;
import org.plotfaces.data.Title;
import org.plotfaces.renderer.AxisLabelRenderer;
import org.plotfaces.renderer.AxisTickRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.CanvasGridRenderer;
import org.plotfaces.renderer.CategoryAxisRenderer;
import org.plotfaces.renderer.DefaultMarkerRenderer;
import org.plotfaces.renderer.TableLegendRenderer;
import org.plotfaces.renderer.DefaultTickFormatter;
import org.plotfaces.renderer.DivTitleRenderer;
import org.plotfaces.renderer.EnhancedLegendRenderer;
import org.plotfaces.renderer.LineRenderer;
import org.plotfaces.renderer.LinearAxisRenderer;
import org.plotfaces.renderer.MarkerRenderer;
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
	private ChartModel chartModel;
	private RendererOptions rendererOptions;
	private CollapseHandler collapseHandler = new CollapseHandler();

	public LineChartDemo() {
	}

	public ChartModel getChartModel() {
		if (chartModel == null) {
			chartModel = new ChartModel();
			setSeriesDefaults(chartModel);
			setSeriesOne(chartModel);
			setSeriesTwo(chartModel);
			setAxesDefaults(chartModel);
			setXAxis(chartModel);
			setYAxis(chartModel);
			setLegend(chartModel);
			setTitle(chartModel);
			setHighlighter(chartModel);
			setGrid(chartModel);
		}

		return chartModel;
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
		data.addValue(-3);
		data.addValue(3);
		data.addValue(6);
		data.addValue(7);
		series.setData(data);

		chartModel.addSeries(series);
	}

	private void setSeriesTwo(ChartModel chartModel) {
		Series series = new Series();
		series.setLabel("Series 2");
		series.setRendererOptions(new LineRenderer());
		series.setMarkerRendererOptions(new DefaultMarkerRenderer());

		//Some data for series 2
		SimpleData data = new SimpleData();
		data.addValue(6);
		data.addValue(3);
		data.addValue(2);
		data.addValue(7);
		data.addValue(8);
		series.setData(data);

		chartModel.addSeries(series);
	}

	private void setAxesDefaults(ChartModel chartModel) {
		Axis axis = new Axis(Axis.AxisName.axisDefaults);
		axis.setShow(false);
		chartModel.setAxesDefaults(axis);
	}

	private void setXAxis(ChartModel chartModel) {
		Axis axis = new Axis(Axis.AxisName.xaxis);
		axis.setLabel("X-Axis");
		CanvasAxisTickRenderer tickRenderer = new CanvasAxisTickRenderer();
		tickRenderer.setFormatterOptions(new DefaultTickFormatter());
		axis.setTickOptions(tickRenderer);
		axis.setLabelOptions(new AxisLabelRenderer());
		axis.setRendererOptions(new LinearAxisRenderer());
		chartModel.getAxes().setXaxis(axis);
	}

	private void setYAxis(ChartModel chartModel) {
		Axis axis = new Axis(Axis.AxisName.yaxis);
		axis.setLabel("Y-Axis");
		CanvasAxisTickRenderer tickRenderer = new CanvasAxisTickRenderer();
		tickRenderer.setFormatterOptions(new DefaultTickFormatter());
		axis.setTickOptions(tickRenderer);
		axis.setLabelOptions(new AxisLabelRenderer());
		axis.setRendererOptions(new LinearAxisRenderer());
		chartModel.getAxes().setYaxis(axis);
	}

	private void setLegend(ChartModel chartModel) {
		Legend legend = new Legend();
		legend.setShow(true);
		legend.setRendererOptions(new EnhancedLegendRenderer());
		chartModel.setLegend(legend);
	}

	private void setTitle(ChartModel chartModel) {
		Title title = new Title();
		title.setShow(true);
		title.setRendererOptions(new DivTitleRenderer());
		chartModel.setTitle(title);
	}

	private void setHighlighter(ChartModel chartModel) {
		Highlighter highlighter = new Highlighter();
		highlighter.setShow(true);
		highlighter.setMarkerRendererOptions(new DefaultMarkerRenderer());
		chartModel.setHighlighter(highlighter);
	}

	private void setGrid(ChartModel chartModel) {
		Grid grid = new Grid();
		grid.setDrawGridlines(true);
		grid.setRendererOptions(new CanvasGridRenderer());
		chartModel.setGrid(grid);
	}

	public RendererOptions getRendererOptions() {
		if (rendererOptions == null) {
			rendererOptions = new RendererOptions();
		}
		return rendererOptions;
	}

	public void setRendererOptions(RendererOptions rendererOptions) {
		this.rendererOptions = rendererOptions;
	}

	public CollapseHandler getCollapseHandler() {
		return collapseHandler;
	}
}
