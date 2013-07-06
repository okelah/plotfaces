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
package org.plotfaces.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Graham Smith
 */
public class Model implements SeriesOrderListener {

	private Axis axesDefaults;
	private Series seriesDefaults;
	private List<Series> series = new ArrayList<>();
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

	public Model() {
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

	public Series getSeriesDefaults() {
		return seriesDefaults;
	}

	public void setSeriesDefaults(Series seriesDefaults) {
		this.seriesDefaults = seriesDefaults;
	}

	/**
	 * Returns a read only copy of the series in this list.
	 *
	 * @return
	 */
	public List<Series> getSeries() {
		//Create a defensive sorted copy of the series.
		List<Series> copy = Collections.unmodifiableList(this.series);
		return copy;
	}

	/**
	 * Sets the {@code Series} for this {@code Model}. Doesn't not check
	 * for duplicates.
	 *
	 * @param series
	 */
	protected void setSeries(List<Series> series) {
		this.series.clear();
		Collections.copy(this.series, series);
		Collections.sort(this.series);
		for (Series s : this.series) {
			s.addSeriesOrderListener(this);
		}
	}

	/**
	 * <p>Adds the given {@code Series} to this {@code Model} if it doesn't
	 * already exist in this model. </p>
	 * <p>
	 * <b>Note:</b> This method registers this {@code Model} as a
	 * {@code SeriesOrderListener} on the {@code Series} being added. This is
	 * necessary so that the series can be maintained in the correct order when
	 * the index and disableStack options are changed in the {@code Series}. If
	 * the {@code SeriesOrderListener} is removed from the {@code Series} while
	 * the {@code Series} is still present in the {@code Model} it is
	 * highly likely that the ordering of the series presented to jqPlot will be
	 * incorrect. This probably won't cause jqPlot to fail but it may cause
	 * unexpected rendering results.</p>
	 * <p>Implementation Notes: Under normal circumstances it would be possible
	 * to simply sort the list before returning it from getSeries but Gson
	 * directly accesses the member variable via reflection so the list must be
	 * maintained in a sorted state at all times. Additionally, it is not
	 * possible to use a {@code Set} to hold the Series since the compareTo
	 * method must behave in a manner that is inconsistent with equals to
	 * achieve the sorting required.</p>
	 * </p>For example imagine a model with two Series representing different
	 * sets of data that both have null indexes and null disableStack. From a
	 * sorting point of view these two sets should simply appear in any order
	 * after any indexed sets and before any sets with disableStack. The
	 * compareTo method will (and should) return zero if these two sets are
	 * compared; the indexes have been compared and are the same and there is no
	 * other state left to compare to determine ordering. The problem is that
	 * the contract on compareTo states that if the result is zero then
	 * generally .equals should also return true but this is not the case for
	 * these two sets as they actually represent different data. This violation
	 * of the .equals condition means that Series can't be held in a set since a
	 * Set uses the compareTo method to determine membership - in other words
	 * only one Series with a null index would be allowed.
	 * </p>
	 *
	 * @param s the {@code Series} to add.
	 */
	public void addSeries(Series s) {
		if (this.series.contains(s)) {
			return;
		}
		this.series.add(s);
		s.addSeriesOrderListener(this);
		Collections.sort(this.series);
	}

	/**
	 * <p>Remove the given {@code Series} from this {@code Model}.</p>
	 * <p><b>Note:</b> The {@code SeriesOrderListener} (this) is removed from
	 * the {@code Series} if present.</p>
	 *
	 * @param s the {@code Series} to remove.
	 */
	public void removeSeries(Series s) {
		this.series.remove(s);
		Collections.sort(this.series);
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

	@Override
	public void seriesOrderChanged(SeriesOrderEvent e) {
		Collections.sort(this.series);
	}
}
