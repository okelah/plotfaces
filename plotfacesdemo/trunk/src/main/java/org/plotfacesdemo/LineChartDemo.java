package org.plotfacesdemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.plotfaces.data.Axis;
import org.plotfaces.data.ChartModel;
import org.plotfaces.data.ChartSeries;
import org.plotfaces.data.ChartSeries;
import org.plotfaces.enums.TickRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Graham Smith
 */
@ManagedBean
@ViewScoped
public class LineChartDemo implements Serializable {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private ChartModel chartModel;

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
			chartSeries.getData().put( "Funky", 5 );
			chartSeries.getData().put( "Spunky", 2 );
			chartSeries.getData().put( "Monkey", 9 );
			
			chartModel.getSeries().add( chartSeries );
		}
		return chartModel;
	}

	public void setChartModel(ChartModel chartModel) {
		this.chartModel = chartModel;
	}

	private List<Axis> getAxes() {
		Axis defaultAxis = new Axis();
		defaultAxis.setTickRenderer( TickRenderer.CanvasAxisTickRenderer );
		chartModel.setAxesDefaults(defaultAxis);
		
		List<Axis> axes = new ArrayList<Axis>();

		Axis x = new Axis(Axis.AxisName.xaxis);
		x.setLabel("X-Axis");
		List<String> ticks = new ArrayList<String>();
		ticks.add( "Funky" );
		ticks.add( "Spunky" );
		ticks.add( "Monkey" );
		x.setTicks( ticks );
		axes.add(x);

		Axis y = new Axis(Axis.AxisName.yaxis);
		y.setLabel("Y-Axis");
		axes.add(y);

		return axes;
	}

	private ChartSeries getSeriesDefaults() {
		ChartSeries series = new ChartSeries();
		series.setxAxis(Axis.AxisName.xaxis);
		series.setyAxis(Axis.AxisName.yaxis);
		// series.setRenderer("$.jqplot.BarRenderer");
		return series;
	}
}
