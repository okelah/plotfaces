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
import org.plotfaces.plugins.Highlighter;

/**
 *
 * @author Graham Smith
 */
public class ChartModel {

	private Axis axesDefaults;
	private Axes axes = new Axes();
	private Legend legend;
	private ChartSeries seriesDefaults;
	private List<ChartSeries> series = new ArrayList<>();
//	private List<String> dataTicks = new ArrayList<>();
//	private Boolean sortData;
	private Title title;
//	private String fontSize;
//	private Boolean stackSeries;
//	private Integer defaultAxisStart;
//	private Highlighter highlighter;
	private String modelVariable;

	public ChartModel() {
	}

	public String getModelVariable() {
		return modelVariable;
	}

	public void setModelVariable(String modelVariable) {
		this.modelVariable = modelVariable;
	}

	public Axis getAxesDefaults() {
		return axesDefaults;
	}

	public void setAxesDefaults(Axis axesDefaults) {
		this.axesDefaults = axesDefaults;
	}

	public Axes getAxes() {
		return axes;
	}

	public void setAxes(Axes axes) {
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

	public void addSeries(ChartSeries series) {
		this.series.add(series);
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
}
