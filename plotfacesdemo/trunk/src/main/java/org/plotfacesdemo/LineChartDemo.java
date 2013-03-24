package org.plotfacesdemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.plotfaces.component.RendererOptions;
import org.plotfaces.data.Axis;
import org.plotfaces.data.ChartModel;
import org.plotfaces.data.ChartSeries;
import org.plotfaces.renderer.BarRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.CategoryAxisRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Graham Smith
 */
@ManagedBean
@SessionScoped
public class LineChartDemo implements Serializable {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private ChartModel chartModel;
	private RendererOptions rendererOptions;

	public LineChartDemo() {
	}

	public String initializeField() {
		chartModel.getAxes().get(0).setShowLabel(true);
		return null;
	}

	public ChartModel getChartModel() {
		if (chartModel == null) {
			chartModel = new ChartModel();
			chartModel.setSeriesDefaults(getSeriesDefaults());
			chartModel.setAxes(getAxes());

			ChartSeries chartSeries = new ChartSeries();
			chartSeries.setData( new Number[] { 5, 2, 9 } );
			chartSeries.setRenderer( new BarRenderer() );
			chartModel.getSeries().add( chartSeries );
		}
		return chartModel;
	}

	public void setChartModel(ChartModel chartModel) {
		this.chartModel = chartModel;
	}

	public RendererOptions getRendererOptions() {
		if( rendererOptions == null ) {
			rendererOptions = new RendererOptions();
		}
		return rendererOptions;
	}

	public void setRendererOptions(RendererOptions rendererOptions) {
		this.rendererOptions = rendererOptions;
	}

	private List<Axis> getAxes() {
		Axis defaultAxis = new Axis();
		CanvasAxisTickRenderer canvasAxisTickRenderer = new CanvasAxisTickRenderer();
		canvasAxisTickRenderer.setAngle( -30 );
		canvasAxisTickRenderer.setFontSize( "10pt" );
		defaultAxis.setTickRenderer( canvasAxisTickRenderer );
		chartModel.setAxesDefaults(defaultAxis);
		
		List<Axis> axes = new ArrayList<Axis>();

		Axis x = new Axis(Axis.AxisName.xaxis);
//		x.setLabel("X-Axis");
		List<String> ticks = new ArrayList<String>();
		ticks.add( "Funky" );
		ticks.add( "Spunky" );
		ticks.add( "Monkey" );
		x.setTicks( ticks );
		CategoryAxisRenderer categoryAxisRenderer = new CategoryAxisRenderer();
		x.setRenderer(categoryAxisRenderer);
		axes.add(x);

//		Axis y = new Axis(Axis.AxisName.yaxis);
//		y.setLabel("Y-Axis");
//		axes.add(y);

		return axes;
	}

	private ChartSeries getSeriesDefaults() {
		ChartSeries series = new ChartSeries();
//		series.setxAxis(Axis.AxisName.xaxis);
//		series.setyAxis(Axis.AxisName.yaxis);
//		series.setRenderer( new BarRenderer() );
		return series;
	}
}
