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
package org.plotfaces.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Graham Smith
 */
public class ChartModel {

    private Axis axesDefaults;
    private List<Axis> axes;
    private Legend legend;
    private ChartSeries seriesDefaults;
    private List<ChartSeries> series = new ArrayList<>();

    public String plot( String optionsVariable ) {
		StringBuilder builder = new StringBuilder();
	
		builder.append("var ");
		builder.append( optionsVariable );
		builder.append(" = {\n");
	
		//Series defaults must be the first piece of configuration output as it doens't prepend a comma.
		builder.append(plotSeriesDefaults());
		builder.append(plotAxesDefaults());
		builder.append(plotAxes());
	
		builder.append("};\n");
	
		return builder.toString();
    }

    /**
     * Slightly special first encoder. If no series defaults are supplied this
     * method still creates an option with empty brackets. This is because it is
     * the first item in the options array and doesn't prepend a comma.
     *
     * @return
     * @throws IOException
     */
    private String plotSeriesDefaults() {
	StringBuilder builder = new StringBuilder();
	builder.append("seriesDefaults:");
	if (getSeriesDefaults() != null) {
	    builder.append(getSeriesDefaults().plot());
	} else {
	    builder.append("{}");
	}
	return builder.toString();
    }

    private String plotAxesDefaults() {
	StringBuilder builder = new StringBuilder();
	if (getAxesDefaults() != null) {
	    builder.append(", axesDefaults:");
		builder.append(getAxesDefaults().plot());
	    builder.append("\n");
	}
	return builder.toString();
    }

    private String plotAxes() {
	StringBuilder builder = new StringBuilder();
	if (getAxes() != null && !getAxes().isEmpty()) {
	    builder.append(",\naxes:{\n");
	    
	    for (int i = 0, n = axes.size(); i < n; i++) {
		if (i > 0) {
		    builder.append(",\n");
		}
		builder.append( getAxes().get( i ).getAxisName().name() ).append( ":" );
		builder.append(getAxes().get(i).plot());
	    }
	    
	    builder.append("\n}\n");
	}
	return builder.toString();
    }

    public Axis getAxesDefaults() {
	return axesDefaults;
    }

    public void setAxesDefaults(Axis axesDefaults) {
	this.axesDefaults = axesDefaults;
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

    public ChartSeries getSeriesDefaults() {
	return seriesDefaults;
    }

    public void setSeriesDefaults(ChartSeries seriesDefaults) {
	this.seriesDefaults = seriesDefaults;
    }

	public List<ChartSeries> getSeries() {
		return series;
	}

	public void setSeries(List<ChartSeries> series) {
		this.series = series;
	}
}
