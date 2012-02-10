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
package org.plotfaces;

import java.io.IOException;
import java.util.List;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author Graham Smith
 */
public class Options implements Encodable {

	private String optionsVariable;
	private List<Axis> axes;
	private Legend legend;
	private Series seriesDefaults;
	private List<Series> series;
	
	public String encode() {
		StringBuilder builder = new StringBuilder();
		
		builder.append( "var " );
		builder.append( getOptionsVaraible() );
		builder.append( " = {\n" );
		
		//Series defaults must be the first piece of configuration output as it doens't prepend a comma.
		builder.append( encodeSeriesDefaults() );
		builder.append( encodeAxes() );
		
		builder.append( "};\n" );
		
		return builder.toString();
	}
	
	/**
	 * Slightly special first encoder. If no series defaults are supplied this method
	 * still creates an option with empty brackets. This is because it is the first
	 * item in the options array and doesn't prepend a comma.
	 * 
	 * @return
	 * @throws IOException 
	 */
	private String encodeSeriesDefaults() {
		StringBuilder builder = new StringBuilder();
		builder.append( "seriesDefaults:" );
		if( getSeriesDefaults() != null ) {
			builder.append( getSeriesDefaults().encode() );
		} else {
			builder.append( "{}" );
		}
		return builder.toString();
	}
	
	private String encodeAxes() {
		StringBuilder builder = new StringBuilder();
		if( getAxes() != null && !getAxes().isEmpty() ) {
			builder.append( ", axes:{\n" );
			for( int i = 0, n = axes.size(); i < n; i++ ) {
				if( i > 0 ) {
					builder.append( ",\n");
				}
				builder.append( getAxes().get( i ).encode() );
			}
			builder.append( "\n}\n" );
		}
		return builder.toString();
	}

	/**
	 * Returns the name of the variable that contains the plot options for the chart being
	 * drawn. This is set by the plot renderer and should not be set manually.
	 * 
	 * @return variable name for the plot options.
	 */
	public String getOptionsVaraible() {
		return optionsVariable;
	}

	/**
	 * Sets the name of the variable that contains the plot options for the chart being
	 * drawn. This is set by the plot renderer and should not be set manually.
	 * 
	 * @param optionsVaraible variable name for the plot options.
	 */
	public void setOptionsVariable(String optionsVariable) {
		this.optionsVariable = optionsVariable;
	}

	public List<Axis> getAxes() {
		return axes;
	}

	public void setAxes(List<Axis> axes) {
		this.axes = axes;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

	public Series getSeriesDefaults() {
		return seriesDefaults;
	}

	public void setSeriesDefaults(Series seriesDefaults) {
		this.seriesDefaults = seriesDefaults;
	}
	
}
