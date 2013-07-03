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
import org.plotfaces.data.SimpleData;
import org.plotfaces.renderer.AxisLabelRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.DefaultTickFormatter;
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
			chartModel.setSeriesDefaults(getSeriesDefaults());
			setAxes(chartModel);
			chartModel.addSeries(getSeries1());
			chartModel.addSeries(getSeries2());
		}

		return chartModel;
	}

	private ChartSeries getSeries1() {
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

		return series;
	}

	private ChartSeries getSeries2() {
		ChartSeries series = new ChartSeries();
		series.setLabel("Series 2");
		MarkerRenderer markerRenderer = new MarkerRenderer();
		markerRenderer.setStyle(MarkerRenderer.MarkerStyle.circle);
		series.setRenderer(new LineRenderer());

		//Some data for series 2
		SimpleData data = new SimpleData();
		data.addValue(6);
		data.addValue(3);
		data.addValue(2);
		data.addValue(7);
		data.addValue(8);
		series.setData(data);

		return series;
	}

	private void setAxes(ChartModel chartModel) {
		Axes axes = new Axes();

		Axis x = new Axis(Axis.AxisName.xaxis);
		x.setLabel("X-Axis");
		CanvasAxisTickRenderer xTickRenderer = new CanvasAxisTickRenderer();
		xTickRenderer.setFormatterOptions(new DefaultTickFormatter());
		x.setTickOptions(xTickRenderer);
		x.setLabelRenderer(new AxisLabelRenderer());
		x.setRendererOptions(new LinearAxisRenderer());
		axes.setXaxis(x);

		Axis y = new Axis(Axis.AxisName.yaxis);
		y.setLabel("Y-Axis");
		CanvasAxisTickRenderer yTickRenderer = new CanvasAxisTickRenderer();
		yTickRenderer.setFormatterOptions(new DefaultTickFormatter());
		y.setTickOptions(yTickRenderer);
		y.setLabelRenderer(new AxisLabelRenderer());
		y.setRendererOptions(new LinearAxisRenderer());
		axes.setYaxis(y);

		chartModel.setAxes(axes);
	}

	private ChartSeries getSeriesDefaults() {
		ChartSeries series = new ChartSeries();
		series.setxAxis(Axis.AxisName.xaxis);
		series.setyAxis(Axis.AxisName.yaxis);
		return series;
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
