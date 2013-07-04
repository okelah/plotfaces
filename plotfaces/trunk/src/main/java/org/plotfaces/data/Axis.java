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
import org.apache.commons.lang3.StringUtils;
import org.plotfaces.PlotUtilities;
import org.plotfaces.renderer.AxisRenderer;
import org.plotfaces.renderer.LabelRenderer;
import org.plotfaces.renderer.TickRenderer;

/**
 * Display options for an axis. An axis must be given a name from the AxisName
 * enumeration. All settings are optional, a value of null (or the empty string
 * for string options) indicates that the default value given by jqPlot should
 * be used. The only exception to this is the show settings which is defaulted
 * to true (displayed) if not specified explicitely.
 *
 * @author Graham Smith
 */
public class Axis implements Plotable {

	public static enum AxisName {

		axisDefaults, xaxis, x2axis, yaxis, y2axis, y3axis, y4axis, y5axis, y6axis, y7axis, y8axis, y9axis;
	}
	private static final String SHOW = "show";
	private static final String LABEL = "label";
	private static final String SHOW_LABEL = "showLabel";
	private static final String MIN = "min";
	private static final String MAX = "max";
	private static final String AUTOSCALE = "autoscale";
	private static final String PAD = "pad";
	private static final String PAD_MIN = "padMin";
	private static final String PAD_MAX = "padMax";
	private static final String TICKS = "ticks";
	private static final String NUMBER_TICKS = "numberTicks";
	private static final String TICK_INTERVAL = "tickInterval";
	private static final String SHOW_TICKS = "showTicks";
	private static final String SHOW_TICK_MARKS = "showTickMarks";
	private static final String SHOW_MINOR_TICKS = "showMinorTicks";
	private static final String USE_SERIES_COLOR = "useSeriesColor";
	private static final String BORDER_WIDTH = "borderWidth";
	private static final String BORDER_COLOR = "borderColor";
	private static final String SYNC_TICKS = "syncTicks";
	private static final String TICK_SPACING = "tickSpacing";
	private AxisName axisName;
	private Boolean show = Boolean.TRUE;
	//private TickRenderer tickRenderer;
	private String tickRenderer;
	private TickRenderer tickOptions;
	//private LabelRenderer labelRenderer;
	private String labelRenderer;
	private LabelRenderer labelOptions;
	private String label;
	private Boolean showLabel;
	private Number min;
	private Number max;
	private Boolean autoScale;
	private Double pad;
	private Double padMax;
	private Double padMin;
	private List<String> ticks;
	private Integer numberTicks;
	private Integer tickInterval;
	//private AxisRenderer renderer;
	private String renderer;
	private AxisRenderer rendererOptions;
	private Boolean showTicks;
	private Boolean showTickMarks;
	private Boolean showMinorTicks;
	private Boolean useSeriesColor;
	private Integer borderWidth;
	private String borderColor;
	private Boolean syncTicks;
	private Integer tickSpacing;

	public Axis() {
	}

	public Axis(AxisName axisName) {
		this.axisName = axisName;
	}

	/**
	 * Used to encode these axis options for jqPlot.
	 *
	 * @return
	 */
	@Override
	public String plot() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");

		List<String> fragments = new ArrayList<>();
		fragments.add(PlotUtilities.createVariable(SHOW, getShow()));

//		if (getTickRenderer() != null) {
//			fragments.add(getTickRenderer().plot());
//		}

//		if (getLabelRenderer() != null) {
//			fragments.add(getLabelRenderer().plot());
//		}

		if (getLabel() != null && !getLabel().isEmpty()) {
			fragments.add(PlotUtilities.createVariable(LABEL, getLabel()));
		}

		if (getShowLabel() != null) {
			fragments.add(PlotUtilities.createVariable(SHOW_LABEL, getShowLabel()));
		}

		if (getMin() != null) {
			fragments.add(PlotUtilities.createVariable(MIN, getMin()));
		}

		if (getMax() != null) {
			fragments.add(PlotUtilities.createVariable(MAX, getMax()));
		}

		if (getAutoScale() != null) {
			fragments.add(PlotUtilities.createVariable(AUTOSCALE, getAutoScale()));
		}

		if (getPad() != null) {
			fragments.add(PlotUtilities.createVariable(PAD, getPad()));
		}

		if (getPadMin() != null) {
			fragments.add(PlotUtilities.createVariable(PAD_MIN, getPadMin()));
		}

		if (getPadMax() != null) {
			fragments.add(PlotUtilities.createVariable(PAD_MAX, getPadMax()));
		}

		if (getTicks() != null && !getTicks().isEmpty()) {
			//TODO: This only supports a single dimension in the array but it can be a two dimensional array.
			fragments.add(PlotUtilities.createVariable(TICKS, "['" + StringUtils.join(getTicks(), "','") + "']", true));
		}

		//numberTicks and tickInterval are mutually exclusive.
		if (getNumberTicks() != null) {
			fragments.add(PlotUtilities.createVariable(NUMBER_TICKS, getNumberTicks()));
		}

		//numberTicks and tickInterval are mutually exclusive.
		if (getTickInterval() != null && getNumberTicks() == null) {
			fragments.add(PlotUtilities.createVariable(TICK_INTERVAL, getTickInterval()));
		}

//		if (getRenderer() != null) {
//			fragments.add(getRenderer().plot());
//		}

		if (getShowTicks() != null) {
			fragments.add(PlotUtilities.createVariable(SHOW_TICKS, getShowTicks()));
		}

		if (getShowTickMarks() != null) {
			fragments.add(PlotUtilities.createVariable(SHOW_TICK_MARKS, getShowTickMarks()));
		}

		if (getShowMinorTicks() != null) {
			fragments.add(PlotUtilities.createVariable(SHOW_MINOR_TICKS, getShowMinorTicks()));
		}

		if (getUseSeriesColor() != null) {
			fragments.add(PlotUtilities.createVariable(USE_SERIES_COLOR, getUseSeriesColor()));
		}

		if (getBorderWidth() != null) {
			fragments.add(PlotUtilities.createVariable(BORDER_WIDTH, getBorderWidth()));
		}

		if (getBorderColor() != null && !getBorderColor().isEmpty()) {
			fragments.add(PlotUtilities.createVariable(BORDER_COLOR, "#" + getBorderColor()));
		}

		if (getSyncTicks() != null) {
			fragments.add(PlotUtilities.createVariable(SYNC_TICKS, getSyncTicks()));
		}

		if (getTickSpacing() != null) {
			fragments.add(PlotUtilities.createVariable(TICK_SPACING, getTickSpacing()));
		}

		builder.append(StringUtils.join(fragments.toArray(), ",\n"));
		builder.append("\n}");
		return builder.toString();
	}

	/**
	 * The name of this axis.
	 *
	 * @return the axis name;
	 */
	public AxisName getAxisName() {
		return axisName;
	}

	/**
	 * The name of this axis. Supports all of the current x (two), y (nine) and
	 * the default axes provided by jqPlot.
	 *
	 * @param axisName
	 */
	public void setAxisName(AxisName axisName) {
		this.axisName = axisName;
	}

	/**
	 * Autoscale the axis min and max values to provide sensible tick spacing.
	 * If axis min or max are set, autoscale will be turned off. The
	 * numberTicks, tickInterval and pad options do work with autoscale,
	 * although tickInterval has not been tested yet. padMin and padMax do
	 * nothing when autoscale is on.
	 *
	 * NOTE: This setting is deprecated in jqPlot in favour of the default
	 * scaling algorithm
	 *
	 * @return true to auto-scale this axis.
	 *
	 */
	public Boolean getAutoScale() {
		return autoScale;
	}

	/**
	 * Autoscale the axis min and max values to provide sensible tick spacing.
	 * If axis min or max are set, autoscale will be turned off. The
	 * numberTicks, tickInterval and pad options do work with autoscale,
	 * although tickInterval has not been tested yet. padMin and padMax do
	 * nothing when autoscale is on.
	 *
	 * NOTE: This setting is deprecated in jqPlot in favour of the default
	 * scaling algorithm
	 *
	 * @param autoScale true to auto-scale this axis.
	 */
	public void setAutoScale(Boolean autoScale) {
		this.autoScale = autoScale;
	}

	/**
	 * Color of the border adjacent to the axis. Defaults to grid border color.
	 *
	 * @return the color of the border.
	 */
	public String getBorderColor() {
		return borderColor;
	}

	/**
	 * Color of the border adjacent to the axis. Defaults to grid border color.
	 * Should be specified as six hexidecimal digits similar to a CSS color e.g.
	 * de34a9.
	 *
	 * @param borderColor the color of the border.
	 */
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	/**
	 * Width of line stroked at the border of the axis. Defaults to the width of
	 * the grid border.
	 *
	 * @return the width of the boarder.
	 */
	public Integer getBorderWidth() {
		return borderWidth;
	}

	/**
	 * Width of line stroked at the border of the axis. Defaults to the width of
	 * the grid border.
	 *
	 * @param borderWidth the width of the border.
	 */
	public void setBorderWidth(Integer borderWidth) {
		this.borderWidth = borderWidth;
	}

	/**
	 * Label for the axis
	 *
	 * @return axis label.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Label for the axis
	 *
	 * @param label axis label.
	 */
	public void setLabel(String label) {
		this.label = label;
	}

//	/**
//	 * A class of a rendering engine for creating an axis label.
//	 *
//	 * @return the renderer to use for labels.
//	 */
//	public LabelRenderer getLabelRenderer() {
//		return labelRenderer;
//	}
//
//	/**
//	 * A class of a rendering engine for creating an axis label.
//	 *
//	 * @param labelRenderer the renderer to use for labels.
//	 */
//	public void setLabelRenderer(LabelRenderer labelRenderer) {
//		this.labelRenderer = labelRenderer;
//	}
	public String getLabelRenderer() {
		return labelRenderer;
	}

	public void setLabelRenderer(String labelRenderer) {
		this.labelRenderer = labelRenderer;
	}

	public LabelRenderer getLabelOptions() {
		return labelOptions;
	}

	public void setLabelOptions(LabelRenderer labelOptions) {
		this.labelOptions = labelOptions;
		if (this.labelOptions == null) {
			setLabelRenderer(null);
		} else {
			setLabelRenderer(this.labelOptions.getRendererName());
		}
	}

	/**
	 * Maximum value of the axis in data units.
	 *
	 * @return axis maximum.
	 */
	public Number getMax() {
		return max;
	}

	/**
	 * Maximum value of the axis in data units.
	 *
	 * @param max axis maximum.
	 */
	public void setMax(Number max) {
		this.max = max;
	}

	/**
	 * Minimum value of the axis in data units.
	 *
	 * @return axis minimum
	 */
	public Number getMin() {
		return min;
	}

	/**
	 * Minimum value of the axis in data units.
	 *
	 * @param min axis minimum
	 */
	public void setMin(Number min) {
		this.min = min;
	}

	/**
	 * Gets the number of ticks to display. This setting is mutually exclusive
	 * with the tickInterval setting. The numberTicks setting takes precedence.
	 *
	 * @return the number of ticks to display.
	 */
	public Integer getNumberTicks() {
		return numberTicks;
	}

	/**
	 * Sets the number of ticks to display. This setting is mutually exclusive
	 * with the tickInterval setting. The numberTicks setting takes precedence.
	 *
	 * @param numberTicks the number of ticks to display.
	 */
	public void setNumberTicks(Integer numberTicks) {
		this.numberTicks = numberTicks;
	}

	/**
	 * Padding to extend the range above and below the data bounds. The data
	 * range is multiplied by this factor to determine minimum and maximum axis
	 * bounds. A value of 0 will be interpreted to mean no padding, and pad will
	 * be set to 1.0.
	 *
	 * @return how much to pad the axis.
	 */
	public Double getPad() {
		return pad;
	}

	/**
	 * Padding to extend the range above and below the data bounds. The data
	 * range is multiplied by this factor to determine minimum and maximum axis
	 * bounds. A value of 0 will be interpreted to mean no padding, and pad will
	 * be set to 1.0.
	 *
	 * @param pad how much to pad the axis.
	 */
	public void setPad(Double pad) {
		this.pad = pad;
	}

	/**
	 * Padding to extend the range above data bounds. The top of the data range
	 * is multiplied by this factor to determine maximum axis bounds. A value of
	 * 0 will be interpreted to mean no padding, and padMax will be set to 1.0.
	 *
	 * @return how much to pad above the data range.
	 */
	public Double getPadMax() {
		return padMax;
	}

	/**
	 * Padding to extend the range above data bounds. The top of the data range
	 * is multiplied by this factor to determine maximum axis bounds. A value of
	 * 0 will be interpreted to mean no padding, and padMax will be set to 1.0.
	 *
	 * @param padMax how much to pad above the data range.
	 */
	public void setPadMax(Double padMax) {
		this.padMax = padMax;
	}

	/**
	 * Padding to extend the range below data bounds. The bottom of the data
	 * range is multiplied by this factor to determine minimum axis bounds. A
	 * value of 0 will be interpreted to mean no padding, and padMin will be set
	 * to 1.0.
	 *
	 * @return how much to pad below the data range.
	 */
	public Double getPadMin() {
		return padMin;
	}

	/**
	 * Padding to extend the range below data bounds. The bottom of the data
	 * range is multiplied by this factor to determine minimum axis bounds. A
	 * value of 0 will be interpreted to mean no padding, and padMin will be set
	 * to 1.0.
	 *
	 * @param padMin how much to pad below the data range.
	 */
	public void setPadMin(Double padMin) {
		this.padMin = padMin;
	}

	//	/**
	//	 * A class of a rendering engine that handles tick generation, scaling input
	//	 * data to pixel grid units and drawing the axis element.
	//	 *
	//	 * @return the renderer to use.
	//	 */
	//	public AxisRenderer getRenderer() {
	//		return renderer;
	//	}
	//
	//	/**
	//	 * A class of a rendering engine that handles tick generation, scaling input
	//	 * data to pixel grid units and drawing the axis element.
	//	 * <p>
	//	 * Default is currently: $.jqplot.LinearAxisRenderer
	//	 *
	//	 * @param renderer the renderer to use.
	//	 */
	//	public void setRenderer(AxisRenderer renderer) {
	//		this.renderer = renderer;
	//	}
	protected String getRenderer() {
		return renderer;
	}

	protected void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	public AxisRenderer getRendererOptions() {
		return rendererOptions;
	}

	public void setRendererOptions(AxisRenderer rendererOptions) {
		this.rendererOptions = rendererOptions;
		if (this.rendererOptions == null) {
			setRenderer(null);
		} else {
			setRenderer(this.rendererOptions.getRendererName());
		}
	}

	/**
	 * Whether to display the axis on the graph. Defaults to true.
	 *
	 * NOTE: The x-axis and y-axis are always shown regardless of the value of
	 * the show settings, only the secondary axes can be hidden.
	 *
	 * @return true to show axis.
	 */
	public Boolean getShow() {
		return show;
	}

	/**
	 * Whether to display the axis on the graph. If null is provided it is
	 * silently converted to true, the default value.
	 *
	 * @param show true to show axis.
	 */
	public void setShow(Boolean show) {
		if (show == null) {
			this.show = true;
		} else {
			this.show = show;
		}
	}

	/**
	 * Whether to show the axis label.
	 *
	 * @return true if the label is shown.
	 */
	public Boolean getShowLabel() {
		return showLabel;
	}

	/**
	 * Whether to show the axis label.
	 *
	 * @param showLabel true to show the label.
	 */
	public void setShowLabel(Boolean showLabel) {
		this.showLabel = showLabel;
	}

	/**
	 * Whether or not to show minor ticks. This is renderer dependent. The
	 * default $.jqplot.LinearAxisRenderer does not have minor ticks.
	 *
	 * @return true if minor tick marks are displayed.
	 */
	public Boolean getShowMinorTicks() {
		return showMinorTicks;
	}

	/**
	 * Whether or not to show minor ticks. This is renderer dependent. The
	 * default $.jqplot.LinearAxisRenderer does not have minor ticks.
	 *
	 * @param showMinorTicks true to show minor tick marks if supported.
	 */
	public void setShowMinorTicks(Boolean showMinorTicks) {
		this.showMinorTicks = showMinorTicks;
	}

	/**
	 * Whether to show the tick marks (line crossing grid) or not. Overridden by
	 * showTicks and showMark option of tick itself.
	 *
	 * @return true to show tick marks.
	 */
	public Boolean getShowTickMarks() {
		return showTickMarks;
	}

	/**
	 * Whether to show the tick marks (line crossing grid) or not. Overridden by
	 * showTicks and showMark option of tick itself.
	 *
	 * @param showTickMarks true to show tick marks.
	 */
	public void setShowTickMarks(Boolean showTickMarks) {
		this.showTickMarks = showTickMarks;
	}

	/**
	 * Whether to show the ticks (both marks and labels) or not. Will not
	 * override showMark and showLabel options if specified on the ticks
	 * themselves.
	 *
	 * @return true if ticks are shown.
	 */
	public Boolean getShowTicks() {
		return showTicks;
	}

	/**
	 * Whether to show the ticks (both marks and labels) or not. Will not
	 * override showMark and showLabel options if specified on the ticks
	 * themselves.
	 *
	 * @param showTicks true to show ticks.
	 */
	public void setShowTicks(Boolean showTicks) {
		this.showTicks = showTicks;
	}

	/**
	 * Whether to try and synchronize tick spacing across multiple axes so that
	 * ticks and grid lines line up. This has an impact on autoscaling
	 * algorithm, however. In general, autoscaling an individual axis will work
	 * better if it does not have to sync ticks.
	 *
	 * @return true to try auto-sync across axes.
	 */
	public Boolean getSyncTicks() {
		return syncTicks;
	}

	/**
	 * Whether to try and synchronize tick spacing across multiple axes so that
	 * ticks and grid lines line up. This has an impact on autoscaling
	 * algorithm, however. In general, autoscaling an individual axis will work
	 * better if it does not have to sync ticks.
	 *
	 * @param syncTicks true to try auto-sync across axes.
	 */
	public void setSyncTicks(Boolean syncTicks) {
		this.syncTicks = syncTicks;
	}

	/**
	 * Gets the interval between ticks. This setting is mutually exclusive with
	 * the numberTicks setting. The numberTicks setting takes precedence.
	 *
	 * @return the interval between ticks.
	 */
	public Integer getTickInterval() {
		return tickInterval;
	}

	/**
	 * Sets the interval between ticks. This setting is mutually exclusive with
	 * the numberTicks setting. The numberTicks setting takes precedence.
	 *
	 * @param tickInterval the interval between ticks.
	 */
	public void setTickInterval(Integer tickInterval) {
		this.tickInterval = tickInterval;
	}

	/**
	 * Approximate pixel spacing between ticks on graph. Used during
	 * autoscaling. This number will be an upper bound, actual spacing will be
	 * less.
	 *
	 * @return tick spacing in pixels.
	 */
	public Integer getTickSpacing() {
		return tickSpacing;
	}

	/**
	 * Approximate pixel spacing between ticks on graph. Used during
	 * autoscaling. This number will be an upper bound, actual spacing will be
	 * less.
	 *
	 * @param tickSpacing tick spacing in pixels.
	 */
	public void setTickSpacing(Integer tickSpacing) {
		this.tickSpacing = tickSpacing;
	}

	/**
	 * A 1D [val, val, ...] or 2D [[val, label], [val, label], ...] array of
	 * ticks for the axis. If no label is specified, the value is formatted into
	 * an appropriate label.
	 *
	 * @return ticks to use.
	 */
	public List<String> getTicks() {
		return ticks;
	}

	/**
	 * A 1D [val, val, ...] or 2D [[val, label], [val, label], ...] array of
	 * ticks for the axis. If no label is specified, the value is formatted into
	 * an appropriate label.
	 *
	 * @param ticks ticks to use.
	 */
	public void setTicks(List<String> ticks) {
		this.ticks = ticks;
	}

	/**
	 * Use the color of the first series associated with this axis for the tick
	 * marks and line bordering this axis.
	 *
	 * @return true if the first series color is used.
	 */
	public Boolean getUseSeriesColor() {
		return useSeriesColor;
	}

	/**
	 * Use the color of the first series associated with this axis for the tick
	 * marks and line bordering this axis.
	 *
	 * @param useSeriesColor true to use first series color.
	 */
	public void setUseSeriesColor(Boolean useSeriesColor) {
		this.useSeriesColor = useSeriesColor;
	}

	//	/**
	//	 * A class of a rendering engine for creating the ticks labels displayed on
	//	 * the plot, See $.jqplot.AxisTickRenderer.
	//	 *
	//	 * @return the tick renderer to use.
	//	 */
	//	public TickRenderer getTickRenderer() {
	//		return tickRenderer;
	//	}
	//
	//	/**
	//	 * A class of a rendering engine for creating the ticks labels displayed on
	//	 * the plot, See $.jqplot.AxisTickRenderer.
	//	 *
	//	 * @param tickRenderer the tick renderer to use.
	//	 */
	//	public void setTickRenderer(TickRenderer tickRenderer) {
	//		this.tickRenderer = tickRenderer;
	//	}
	protected String getTickRenderer() {
		return tickRenderer;
	}

	protected void setTickRenderer(String tickRenderer) {
		this.tickRenderer = tickRenderer;
	}

	public TickRenderer getTickOptions() {
		return tickOptions;
	}

	public void setTickOptions(TickRenderer tickOptions) {
		this.tickOptions = tickOptions;
		if (this.tickOptions == null) {
			setTickRenderer(null);
		} else {
			setTickRenderer(this.tickOptions.getRendererName());
		}
	}
}
