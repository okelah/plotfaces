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

import org.plotfaces.PlotUtilities;

/**
 * 
 * @author Graham Smith
 */
public class ChartModel {

	private Axis axesDefaults;
	private List<Axis> axes;
	private Legend legend;
	private ChartSeries seriesDefaults;
	private List<ChartSeries> series = new ArrayList<ChartSeries>();
	private List<String> dataTicks = new ArrayList<String>();
	
	private Boolean sortData;
	private String title;
	private String fontSize;
	private Boolean stackSeries;
	private Integer defaultAxisStart;

	public String plot(String optionsVariable) {
		StringBuilder builder = new StringBuilder();

		builder.append("var ");
		builder.append(optionsVariable);
		builder.append(" = {\n");
		boolean isCommaRequired = false; 


		isCommaRequired = PlotUtilities.addVariable( builder, "sortData", getSortData(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "title", getTitle(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "fontSize", getFontSize(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "stackSeries", getStackSeries(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "defaultAxisStart", getDefaultAxisStart(), isCommaRequired );

		if( isCommaRequired ) {
			builder.append( "," );
		}
		builder.append(plotSeriesDefaults());
		builder.append(plotSeries());
		builder.append(plotLegend());
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

	private String plotSeries() {
		StringBuilder builder = new StringBuilder();
		if (getSeries().size() > 0) {
			builder.append(", series:[");
			for( int i = 0, n = getSeries().size(); i < n; i++ ) {
				if (i > 0) {
					builder.append(",\n");
				}
				builder.append(getSeries().get( i ).plot());
			}
			builder.append("]");
		}
		return builder.toString();
	}

	private String plotLegend() {
		StringBuilder builder = new StringBuilder();
		if (getLegend() != null) {
			builder.append(", legend:");
			builder.append(getLegend().plot());
			builder.append("\n");
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
				builder.append(getAxes().get(i).getAxisName().name()).append(
						":");
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

	/**
	 * @return the sortData
	 */
	public Boolean getSortData() {
		return sortData;
	}

	/**
	 * @param sortData the sortData to set
	 */
	public void setSortData(Boolean sortData) {
		this.sortData = sortData;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the fontSize
	 */
	public String getFontSize() {
		return fontSize;
	}

	/**
	 * @param fontSize the fontSize to set
	 */
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	/**
	 * @return the stackSeries
	 */
	public Boolean getStackSeries() {
		return stackSeries;
	}

	/**
	 * @param stackSeries the stackSeries to set
	 */
	public void setStackSeries(Boolean stackSeries) {
		this.stackSeries = stackSeries;
	}

	/**
	 * @return the defaultAxisStart
	 */
	public Integer getDefaultAxisStart() {
		return defaultAxisStart;
	}

	/**
	 * @param defaultAxisStart the defaultAxisStart to set
	 */
	public void setDefaultAxisStart(Integer defaultAxisStart) {
		this.defaultAxisStart = defaultAxisStart;
	}

	/**
	 * @return the dataTicks
	 */
	public List<String> getDataTicks() {
		return dataTicks;
	}

	/**
	 * @param dataTicks the dataTicks to set
	 */
	public void setDataTicks(List<String> dataTicks) {
		this.dataTicks = dataTicks;
	}
}
