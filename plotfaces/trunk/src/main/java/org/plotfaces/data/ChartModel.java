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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Graham Smith
 */
public class ChartModel {

	private Axis axesDefaults;
	private ChartSeries seriesDefaults;
	private List<ChartSeries> series = new ArrayList<>();
	private Axes axes = new Axes();
	private Grid grid;
	private Legend legend;
	private List<String> seriesColors;
	private Boolean sortData;
	private String fontSize;
	private Boolean stackSeries;
	private Integer defaultAxisStart;
	private Title title;
	private Highlighter highlighter;

	public ChartModel() {
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

	public Boolean getSortData() {
		return sortData;
	}

	public void setSortData(Boolean sortData) {
		this.sortData = sortData;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public Boolean getStackSeries() {
		return stackSeries;
	}

	public void setStackSeries(Boolean stackSeries) {
		this.stackSeries = stackSeries;
	}

	public Integer getDefaultAxisStart() {
		return defaultAxisStart;
	}

	public void setDefaultAxisStart(Integer defaultAxisStart) {
		this.defaultAxisStart = defaultAxisStart;
	}

	public Highlighter getHighlighter() {
		return highlighter;
	}

	public void setHighlighter(Highlighter highlighter) {
		this.highlighter = highlighter;
	}

	public List<String> getSeriesColors() {
		return seriesColors;
	}

	public void setSeriesColors(List<String> seriesColors) {
		this.seriesColors = seriesColors;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
}
