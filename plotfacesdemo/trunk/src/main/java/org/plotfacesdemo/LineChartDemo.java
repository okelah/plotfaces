package org.plotfacesdemo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.plotfaces.Axis;
import org.plotfaces.Options;
import org.plotfaces.Series;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Graham Smith
 */
@Named
@SessionScoped
public class LineChartDemo implements Serializable {

    //@Inject
    private Logger logger = LoggerFactory.getLogger( getClass() );
    private Options options;

    public LineChartDemo() {
    }

    public CartesianChartModel getPFModel() {
	CartesianChartModel linearModel = new CartesianChartModel();

	LineChartSeries series1 = new LineChartSeries();
	series1.setLabel("Series 1");

	series1.set(1, 2);
	series1.set(2, 1);
	series1.set(3, 3);
	series1.set(4, 6);
	series1.set(5, 8);

	LineChartSeries series2 = new LineChartSeries();
	series2.setLabel("Series 2");
	series2.setMarkerStyle("diamond");

	series2.set(1, 6);
	series2.set(2, 3);
	series2.set(3, 2);
	series2.set(4, 7);
	series2.set(5, 9);

	linearModel.addSeries(series1);
	linearModel.addSeries(series2);

	return linearModel;
    }
	
	public String initializeField() {
		options.getAxes().get( 0 ).setShowLabel( true );
		return null;
	}

    public Options getOptions() {
	if (options == null) {
	    options = new Options();
	    options.setSeriesDefaults(getSeriesDefaults());
	    options.setAxes(getAxes());
	}
	return options;
    }
    
    public void setOptions( Options options ) {
	this.options = options;
    }

    private List<Axis> getAxes() {
	List<Axis> axes = new ArrayList<>();

	Axis x = new Axis(Axis.AxisName.xaxis);
	x.setLabel("X-Axis");
	axes.add(x);

	Axis y = new Axis(Axis.AxisName.yaxis);
	y.setLabel("Y-Axis");
	axes.add(y);
//
//	Axis y2 = new Axis(Axis.AxisName.y2axis);
//	y2.setLabel("Y2-Axis");
//	axes.add(y2);

	return axes;
    }

    private Series getSeriesDefaults() {
	Series series = new Series();
	series.setxAxis(Axis.AxisName.xaxis);
	series.setyAxis(Axis.AxisName.yaxis);
//	series.setRenderer("$.jqplot.BarRenderer");
	return series;
    }
}
