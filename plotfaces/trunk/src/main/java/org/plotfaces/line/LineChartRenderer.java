/*
 * Copyright 2012 Graham Smith.
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
package org.plotfaces.line;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import org.plotfaces.Axis;
import org.plotfaces.ChartRenderer;
import org.plotfaces.Options;
import org.plotfaces.Series;
import org.plotfaces.UIPlot;

/**
 *
 * @author Graham Smith
 */
@FacesRenderer( componentFamily=UIPlot.FAMILY, rendererType="org.plotfaces.line.LineChartRenderer" )
public class LineChartRenderer extends ChartRenderer {

	public LineChartRenderer() {
	}

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		LineChart chart = (LineChart)component;
		
		encodeTag( context, chart );
		encodeScript( context, chart );
	}
	
	private void encodeScript( FacesContext context, LineChart chart ) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		
		encodeScriptBegin(out, chart.getClientId());		
		
		//Data
		String dataVariable = encodeData( context, chart );
		
		//Options
		String optionsVariable = getSafeClientId( context, chart ) + OPTIONS_SUFFIX;
		Options plotOptions = (Options)chart.getOptions();
		if( plotOptions != null ) {
			plotOptions.setOptionsVariable(optionsVariable);
			out.write( plotOptions.encode() );
		}
		//String optionsVariable = encodeOptions( context, chart );
		
		out.write( "    var " + getSafeClientId( context, chart ) + PLOT_SUFFIX + " = $.jqplot('" + getEscapedClientId( chart.getClientId() ) + "', [" + dataVariable + "], " + optionsVariable + ")\n" );
		
		encodeScriptEnd(out);
	}
	
	/**
	 * Encodes the chart data and returns the name of the variable the data is stored in.
	 * 
	 * @param context
	 * @param chart
	 * @return
	 * @throws IOException 
	 */
	private String encodeData(FacesContext context, LineChart chart ) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		String dataVariable = getSafeClientId( context, chart ) + DATA_SUFFIX;
		out.write( "    var " + dataVariable + " = [" );
		Random r = new Random();
		for( int i = 0, n = 10; i < n; i++ ) {
			out.write( "[" + i + "," + r.nextInt( 100 ) + "],");
		}
		out.write( "];\n" );
		return dataVariable;
	}
	
//	private String encodeOptions( FacesContext context, LineChart chart ) throws IOException {
//		ResponseWriter out = context.getResponseWriter();
//		String optionsVariable = getSafeClientId( context, chart ) + OPTIONS_SUFFIX;
//		out.write( "var " + optionsVariable + " = {\n" );
//		
//		//Must be the first set of configuration output as it doens't prepend a comma.
//		encodeSeriesDefaults(out, chart);
//		encodeAxes( out, chart );		
//		
//		out.write( "};\n" );
//		return optionsVariable;
//	}
	
	/**
	 * Does not prepend a comma!
	 * 
	 * @param out
	 * @param chart
	 * @throws IOException 
	 */
//	private void encodeSeriesDefaults( ResponseWriter out, LineChart chart ) throws IOException {
//		Series seriesDefaults = (Series)chart.getSeriesDefaults();
//		out.write( "seriesDefaults:" );
//		if( seriesDefaults != null ) {
//			seriesDefaults.encode(out);
//		} else {
//			out.write( "{}" );
//		}
//		
//	}
	
//	private void encodeAxes( ResponseWriter out, LineChart chart ) throws IOException {
//		List<Axis> axes = (List<Axis>)chart.getAxes();
//		if( axes != null && !axes.isEmpty() ) {
//			out.write( ", axes:{\n" );
//			for( int i = 0, n = axes.size(); i < n; i++ ) {
//				if( i > 0 ) {
//					out.write( ",\n");
//				}
//				axes.get( i ).encode(out);
//			}
//			out.write( "\n}\n" );
//		}
//	}
}
