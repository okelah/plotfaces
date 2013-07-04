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
import org.plotfaces.data.ChartSeries;
import org.plotfaces.data.Legend;
import org.plotfaces.data.SimpleData;
import org.plotfaces.data.Title;
import org.plotfaces.renderer.AxisLabelRenderer;
import org.plotfaces.renderer.AxisTickRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.CategoryAxisRenderer;
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
			setXAxis(chartModel);
			setYAxis(chartModel);
			setLegend(chartModel);
			setTitle(chartModel);
		}

		return chartModel;
	}

	private void setSeriesDefaults(ChartModel chartModel) {
		ChartSeries seriesDefaults = new ChartSeries();
		seriesDefaults.setxAxis(Axis.AxisName.xaxis);
		seriesDefaults.setyAxis(Axis.AxisName.yaxis);
		chartModel.setSeriesDefaults(seriesDefaults);
	}

	private void setSeriesOne(ChartModel chartModel) {
		ChartSeries series = new ChartSeries();
		series.setLabel("Series 1");
//		series.setRenderer(new LineRenderer());

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

	private void setSeriesTwo(ChartModel chartModel) {
		ChartSeries series = new ChartSeries();
		series.setLabel("Series 2");
		MarkerRenderer markerRenderer = new MarkerRenderer();
		markerRenderer.setStyle(MarkerRenderer.MarkerStyle.circle);
//		series.setRenderer(new LineRenderer());

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
