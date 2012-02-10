package org.plotfacesdemo;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import org.plotfaces.Axis;
import org.plotfaces.Options;
import org.plotfaces.Series;

/**
 *
 * @author Graham Smith
 */
@Named
public class LineChartView {

	public LineChartView() {
	}
	
	public Options getOptions() {
		Options p = new Options();
		p.setSeriesDefaults( getSeriesDefaults() );
		p.setAxes( getAxes() );
		return p;
	}
	
	private List<Axis> getAxes() {
		List<Axis> axes = new ArrayList<>();
		
		Axis x = new Axis( Axis.AxisName.xaxis );
		x.setLabel( "X-Axis" );
		axes.add(x);
		
		Axis y = new Axis( Axis.AxisName.yaxis );
		y.setLabel( "Y-Axis" );
		axes.add(y);
		
		Axis y2 = new Axis( Axis.AxisName.y2axis );
		y2.setLabel( "Y2-Axis" );
		axes.add(y2);
		
		return axes;
	}
	
	private Series getSeriesDefaults() {
		Series series = new Series();
		series.setxAxis(Axis.AxisName.xaxis);
		series.setyAxis(Axis.AxisName.yaxis);
		series.setRenderer("$.jqplot.BarRenderer");
		return series;
	}
}
