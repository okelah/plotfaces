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
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.plotfaces.PlotUtilities;
import org.plotfaces.renderer.AxisRenderer;
import org.plotfaces.renderer.LabelRenderer;
import org.plotfaces.renderer.TickRenderer;

/**
 * Display options for an axis. An axis must be given a name from the AxisName enum. All options
 * are optional, a value of null (or and empty string for string options) indicates that the
 * default value given by jqPlot should be used. The only exception to these rules is the show
 * option which is defaulted to true (displayed) if not specified explicitely.
 *
 * @author Graham Smith
 */
public class Axis {

	public static enum AxisName {
		axisDefaults, xaxis, x2axis, yaxis, y2axis, y3axis, y4axis, y5axis, y6axis, y7axis, y8axis, y9axis;
	}
	private AxisName axisName;
	private Boolean show = Boolean.TRUE;
	private TickRenderer tickRenderer;
	private LabelRenderer labelRenderer;
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
	private AxisRenderer renderer;
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
	 * @param out
	 * @throws IOException
	 */
	public String plot() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");
		boolean isCommaRequired = false; 

		if( getShow() == null ) {
			isCommaRequired = PlotUtilities.addVariable( builder, "show", getShow(), isCommaRequired);
		}

		if (getTickRenderer() != null) {
			if( isCommaRequired ) {
				builder.append(",");
			} else {
				isCommaRequired = true;
			}
			getTickRenderer().plot( builder, true );
		}

		if (getLabelRenderer() != null) {
			if( isCommaRequired ) {
				builder.append(",");
			} else {
				isCommaRequired = true;
			}
			getLabelRenderer().plot( builder );
		}

		isCommaRequired = PlotUtilities.addVariable( builder, "label", getLabel(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "showLabel", getShowLabel(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "min", getMin(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "max", getMax(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "autoscale", getAutoScale(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "pad", getPad(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "padMin", getPadMin(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "padMax", getPadMax(), isCommaRequired);
		if( getTicks() != null && getTicks().size() > 0 ) {
			isCommaRequired = PlotUtilities.addVariable( builder, "ticks", "['" + StringUtils.join( getTicks(), "','" ) + "']", isCommaRequired, false);
		}
		isCommaRequired = PlotUtilities.addVariable( builder, "numberTicks", getNumberTicks(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "tickInterval", getTickInterval(), isCommaRequired);
		
		if (getRenderer() != null) {
			if( isCommaRequired ) {
				builder.append(",");
			} else {
				isCommaRequired = true;
			}
			getRenderer().plot(builder, true );
		}

		isCommaRequired = PlotUtilities.addVariable( builder, "showTicks", getShowTicks(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "showTickMarks", getShowTickMarks(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "showMinorTicks", getShowMinorTicks(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "useSeriesColor", getUseSeriesColor(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "borderWidth", getBorderWidth(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "borderColor", getBorderColor(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "syncTicks", getSyncTicks(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "tickSpacing", getTickSpacing(), isCommaRequired);

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
	 * The name of this axis. Supports all of the current x (two), y (nine) and the default axes provided by jqPlot.
	 *
	 * @param axis
	 */
	public void setAxisName(AxisName axisName) {
		this.axisName = axisName;
	}

	/**
	 * Autoscale the axis min and max values to provide sensible tick spacing. 
	 * If axis min or max are set, autoscale will be turned off.  The numberTicks, tickInterval and pad 
	 * options do work with autoscale, although tickInterval has not been tested yet. padMin and 
	 * padMax do nothing when autoscale is on.
	 * 
	 * @return true to auto-scale this axis.
	 * 
	 */
	public Boolean getAutoScale() {
		return autoScale;
	}

	/**
	 * Autoscale the axis min and max values to provide sensible tick spacing. 
	 * If axis min or max are set, autoscale will be turned off.  The numberTicks, tickInterval and pad 
	 * options do work with autoscale, although tickInterval has not been tested yet. padMin and 
	 * padMax do nothing when autoscale is on.
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
	 * Color of the border adjacent to the axis. Defaults to grid border color. Should be specified as
	 * six hexidecimal digits similar to a CSS color e.g. de34a9.
	 * 
	 * @param borderColor the color of the border.
	 */
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	/**
	 * Width of line stroked at the border of the axis.  Defaults to the width of the grid border.
	 * 
	 * @return the width of the boarder.
	 */
	public Integer getBorderWidth() {
		return borderWidth;
	}

	/**
	 * Width of line stroked at the border of the axis.  Defaults to the width of the grid border.
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
	
	/**
	 * A class of a rendering engine for creating an axis label.
	 * 
	 * @return the renderer to use for labels.
	 */
	public LabelRenderer getLabelRenderer() {
		return labelRenderer;
	}

	/**
	 * A class of a rendering engine for creating an axis label.
	 * 
	 * @param labelRenderer the renderer to use for labels.
	 */
	public void setLabelRenderer(LabelRenderer labelRenderer) {
		this.labelRenderer = labelRenderer;
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
	 * Gets the number of ticks to display. This setting is mutually exclusive with the tickInterval setting.
	 * The numberTicks setting takes precedence.
	 * 
	 * @return the number of ticks to display.
	 */
	public Integer getNumberTicks() {
		return numberTicks;
	}

	/**
	 * Sets the number of ticks to display. This setting is mutually exclusive with the tickInterval setting.
	 * The numberTicks setting takes precedence.
	 * 
	 * @param numberTicks the number of ticks to display.
	 */
	public void setNumberTicks(Integer numberTicks) {
		this.numberTicks = numberTicks;
	}

	/**
	 * Padding to extend the range above and below the data bounds. 
	 * The data range is multiplied by this factor to determine minimum and maximum axis bounds. 
	 * A value of 0 will be interpreted to mean no padding, and pad will be set to 1.0.
	 * 
	 * @return how much to pad the axis.
	 */
	public Double getPad() {
		return pad;
	}

	/**
	 * Padding to extend the range above and below the data bounds. 
	 * The data range is multiplied by this factor to determine minimum and maximum axis bounds. 
	 * A value of 0 will be interpreted to mean no padding, and pad will be set to 1.0.
	 * 
	 * @param pad how much to pad the axis.
	 */
	public void setPad(Double pad) {
		this.pad = pad;
	}

	/**
	 * Padding to extend the range above data bounds.  The top of the data range is 
	 * multiplied by this factor to determine maximum axis bounds.  A value of 0 
	 * will be interpreted to mean no padding, and padMax will be set to 1.0.
	 * 
	 * @return how much to pad above the data range.
	 */
	public Double getPadMax() {
		return padMax;
	}

	/**
	 * Padding to extend the range above data bounds.  The top of the data range is 
	 * multiplied by this factor to determine maximum axis bounds.  A value of 0 
	 * will be interpreted to mean no padding, and padMax will be set to 1.0.
	 * 
	 * @param padMax how much to pad above the data range.
	 */
	public void setPadMax(Double padMax) {
		this.padMax = padMax;
	}

	/**
	 * Padding to extend the range below data bounds.  The bottom of the data range is multiplied 
	 * by this factor to determine minimum axis bounds.  A value of 0 will be interpreted to 
	 * mean no padding, and padMin will be set to 1.0.
	 * 
	 * @return how much to pad below the data range.
	 */
	public Double getPadMin() {
		return padMin;
	}

	/**
	 * Padding to extend the range below data bounds.  The bottom of the data range is multiplied 
	 * by this factor to determine minimum axis bounds.  A value of 0 will be interpreted to 
	 * mean no padding, and padMin will be set to 1.0.
	 * 
	 * @param padMin how much to pad below the data range.
	 */
	public void setPadMin(Double padMin) {
		this.padMin = padMin;
	}

	/**
	 * A class of a rendering engine that handles tick generation, 
	 * scaling input data to pixel grid units and drawing the axis element.
	 * 
	 * @return the renderer to use.
	 */
	public AxisRenderer getRenderer() {
		return renderer;
	}

	/**
	 * A class of a rendering engine that handles tick generation, 
	 * scaling input data to pixel grid units and drawing the axis element.
	 * <p>
	 * Default is currently: $.jqplot.LinearAxisRenderer
	 * 
	 * @param renderer the renderer to use.
	 */
	public void setRenderer(AxisRenderer renderer) {
		this.renderer = renderer;
	}

	/**
	 * Whether to display the axis on the graph.
	 * 
	 * @return true to show axis.
	 */
	public Boolean getShow() {
		return show;
	}

	/**
	 * Whether to display the axis on the graph.
	 * 
	 * @param show true to show axis.
	 */
	public void setShow(Boolean show) {
		this.show = show;
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
	 * Whether or not to show minor ticks.  This is renderer dependent.  
	 * The default $.jqplot.LinearAxisRenderer does not have minor ticks.
	 * 
	 * @return true if minor tick marks are displayed.
	 */
	public Boolean getShowMinorTicks() {
		return showMinorTicks;
	}

	/**
	 * Whether or not to show minor ticks.  This is renderer dependent.  
	 * The default $.jqplot.LinearAxisRenderer does not have minor ticks.
	 * 
	 * @param showMinorTicks true to show minor tick marks if supported.
	 */
	public void setShowMinorTicks(Boolean showMinorTicks) {
		this.showMinorTicks = showMinorTicks;
	}

	/**
	 * Whether to show the tick marks (line crossing grid) or not. 
	 * Overridden by showTicks and showMark option of tick itself.
	 * 
	 * @return true to show tick marks.
	 */
	public Boolean getShowTickMarks() {
		return showTickMarks;
	}

	/**
	 * Whether to show the tick marks (line crossing grid) or not. 
	 * Overridden by showTicks and showMark option of tick itself.
	 * 
	 * @param showTickMarks true to show tick marks.
	 */
	public void setShowTickMarks(Boolean showTickMarks) {
		this.showTickMarks = showTickMarks;
	}

	/**
	 * Whether to show the ticks (both marks and labels) or not. Will not override 
	 * showMark and showLabel options if specified on the ticks themselves.
	 * 
	 * @return true if ticks are shown.
	 */
	public Boolean getShowTicks() {
		return showTicks;
	}

	/**
	 * Whether to show the ticks (both marks and labels) or not. Will not override 
	 * showMark and showLabel options if specified on the ticks themselves.
	 * 
	 * @param showTicks true to show ticks.
	 */
	public void setShowTicks(Boolean showTicks) {
		this.showTicks = showTicks;
	}

	/**
	 * Whether to try and synchronize tick spacing across multiple axes so that ticks and grid lines line up.  
	 * This has an impact on autoscaling algorithm, however. In general, autoscaling an individual axis 
	 * will work better if it does not have to sync ticks.
	 * 
	 * @return true to try auto-sync across axes.
	 */
	public Boolean getSyncTicks() {
		return syncTicks;
	}

	/**
	 * Whether to try and synchronize tick spacing across multiple axes so that ticks and grid lines line up.  
	 * This has an impact on autoscaling algorithm, however. In general, autoscaling an individual axis 
	 * will work better if it does not have to sync ticks.
	 * 
	 * @param syncTicks true to try auto-sync across axes.
	 */
	public void setSyncTicks(Boolean syncTicks) {
		this.syncTicks = syncTicks;
	}

	/**
	 * Gets the interval between ticks. This setting is mutually exclusive with the numberTicks setting.
	 * The numberTicks setting takes precedence.
	 * 
	 * @return the interval between ticks.
	 */
	public Integer getTickInterval() {
		return tickInterval;
	}

	/**
	 * Sets the interval between ticks. This setting is mutually exclusive with the numberTicks setting.
	 * The numberTicks setting takes precedence.
	 * 
	 * @param tickInterval the interval between ticks.
	 */
	public void setTickInterval(Integer tickInterval) {
		this.tickInterval = tickInterval;
	}

	/**
	 * Approximate pixel spacing between ticks on graph. Used during autoscaling. This number will be an 
	 * upper bound, actual spacing will be less.
	 * 
	 * @return tick spacing in pixels.
	 */
	public Integer getTickSpacing() {
		return tickSpacing;
	}

	/**
	 * Approximate pixel spacing between ticks on graph. Used during autoscaling. This number will be an 
	 * upper bound, actual spacing will be less.
	 * 
	 * @param tickSpacing tick spacing in pixels.
	 */
	public void setTickSpacing(Integer tickSpacing) {
		this.tickSpacing = tickSpacing;
	}

	/**
	 * A 1D [val, val, ...] or 2D [[val, label], [val, label], ...] array of ticks for the axis.  
	 * If no label is specified, the value is formatted into an appropriate label.
	 * 
	 * @return ticks to use.
	 */
	public List<String> getTicks() {
		return ticks;
	}

	/**
	 * A 1D [val, val, ...] or 2D [[val, label], [val, label], ...] array of ticks for the axis.  
	 * If no label is specified, the value is formatted into an appropriate label.
	 * 
	 * @param ticks ticks to use.
	 */
	public void setTicks(List<String> ticks) {
		this.ticks = ticks;
	}

	/**
	 * Use the color of the first series associated with this axis for the tick marks and line bordering this axis.
	 * 
	 * @return true if the first series color is used.
	 */
	public Boolean getUseSeriesColor() {
		return useSeriesColor;
	}

	/**
	 * Use the color of the first series associated with this axis for the tick marks and line bordering this axis.
	 * 
	 * @param useSeriesColor true to use first series color.
	 */
	public void setUseSeriesColor(Boolean useSeriesColor) {
		this.useSeriesColor = useSeriesColor;
	}


	/**
	 * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
	 * 
	 * @return the tick renderer to use.
	 */
	public TickRenderer getTickRenderer() {
		return tickRenderer;
	}


	/**
	 * A class of a rendering engine for creating the ticks labels displayed on the plot, See $.jqplot.AxisTickRenderer.
	 * 
	 * @param tickRenderer the tick renderer to use.
	 */
	public void setTickRenderer(TickRenderer tickRenderer) {
		this.tickRenderer = tickRenderer;
	}
}
