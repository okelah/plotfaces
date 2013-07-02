/*
 * Copyright 2012 Anthony Mayfield.
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
package org.plotfaces.plugins;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.plotfaces.PlotUtilities;
import org.plotfaces.data.Axis.AxisName;
import org.plotfaces.renderer.AxisRenderer;
import org.plotfaces.renderer.LabelRenderer;
import org.plotfaces.renderer.MarkerRenderer;
import org.plotfaces.renderer.TickRenderer;

/**
 * Plugin which will highlight data points when they are moused over.
 *
 * @author Anthony Mayfield
 */
public class Highlighter {

	private Boolean show;
	private MarkerRenderer markerRenderer;
	private Boolean showMarker;
	private Double lineWidthAdjust;
	private Double sizeAdjust;
	private Boolean showTooltip;
	private String tooltipLocation;
	private Boolean fadeTooltip;
	private String tooltipFadeSpeed;
	private Integer tooltipOffset;
	private String tooltipAxes;
	private Boolean useAxesFormatters;
	private String tooltipFormatString;
	private String formatString;
	private Integer yValues;
	private Boolean bringSeriesToFront;

	public Highlighter() {
	}

	/**
	 * Used to encode these axis options for jqPlot.
	 *
	 * @param out
	 * @throws IOException
	 */
	public void plot(StringBuilder builder) {
		builder.append("{\n");
		boolean isCommaRequired = false;

//		isCommaRequired = PlotUtilities.addVariable(builder, "show", getShow(), isCommaRequired);

		if (getMarkerRenderer() != null) {
			if (isCommaRequired) {
				builder.append(",");
			} else {
				isCommaRequired = true;
			}
			//getMarkerRenderer().plot(builder, true);
		}

//		isCommaRequired = PlotUtilities.addVariable(builder, "showMarker", getShowMarker(), isCommaRequired);
//		isCommaRequired = PlotUtilities.addVariable(builder, "lineWidthAdjust", getLineWidthAdjust(), isCommaRequired);
//		isCommaRequired = PlotUtilities.addVariable(builder, "sizeAdjust", getSizeAdjust(), isCommaRequired);
//		isCommaRequired = PlotUtilities.addVariable(builder, "showTooltip", getShowTooltip(), isCommaRequired);
//		isCommaRequired = PlotUtilities.addVariable(builder, "tooltipLocation", getTooltipLocation(), isCommaRequired, true);
//		isCommaRequired = PlotUtilities.addVariable(builder, "fadeTooltip", getFadeTooltip(), isCommaRequired);
//		isCommaRequired = PlotUtilities.addVariable(builder, "tooltipFadeSpeed", getTooltipFadeSpeed(), isCommaRequired, true);
//		isCommaRequired = PlotUtilities.addVariable(builder, "tooltipOffset", getTooltipOffset(), isCommaRequired);
//		isCommaRequired = PlotUtilities.addVariable(builder, "tooltipAxes", getTooltipAxes(), isCommaRequired, true);
//		isCommaRequired = PlotUtilities.addVariable(builder, "useAxesFormatters", getUseAxesFormatters(), isCommaRequired);
//		isCommaRequired = PlotUtilities.addVariable(builder, "tooltipFormatString", getTooltipFormatString(), isCommaRequired, true);
//		isCommaRequired = PlotUtilities.addVariable(builder, "formatString", getFormatString(), isCommaRequired, true);
//		isCommaRequired = PlotUtilities.addVariable(builder, "yValues", getyValues(), isCommaRequired);
//		isCommaRequired = PlotUtilities.addVariable(builder, "bringSeriesToFront", getBringSeriesToFront(), isCommaRequired);

		builder.append("\n}");
	}

	/**
	 * true to show the highlight. default $.jqplot.config.enablePlugins
	 *
	 * @return the show
	 */
	public Boolean getShow() {
		return show;
	}

	/**
	 * true to show the highlight. default $.jqplot.config.enablePlugins
	 *
	 * @param show the show to set
	 */
	public void setShow(Boolean show) {
		this.show = show;
	}

	/**
	 * @return the markerRenderer
	 */
	public MarkerRenderer getMarkerRenderer() {
		return markerRenderer;
	}

	/**
	 * Renderer used to draw the marker of the highlighted point. Renderer will
	 * assimilate attributes from the data point being highlighted, so no
	 * attributes need set on the renderer directly. Default is to turn off
	 * shadow drawing on the highlighted point. default new
	 * $.jqplot.MarkerRenderer(	{shadow:false}	)
	 *
	 * @param markerRenderer the markerRenderer to set
	 */
	public void setMarkerRenderer(MarkerRenderer markerRenderer) {
		this.markerRenderer = markerRenderer;
	}

	/**
	 * Renderer used to draw the marker of the highlighted point. Renderer will
	 * assimilate attributes from the data point being highlighted, so no
	 * attributes need set on the renderer directly. Default is to turn off
	 * shadow drawing on the highlighted point. default new
	 * $.jqplot.MarkerRenderer(	{shadow:false}	)
	 *
	 * @return the showRenderer
	 */
	public Boolean getShowMarker() {
		return showMarker;
	}

	/**
	 * Renderer used to draw the marker of the highlighted point. Renderer will
	 * assimilate attributes from the data point being highlighted, so no
	 * attributes need set on the renderer directly. Default is to turn off
	 * shadow drawing on the highlighted point. default new
	 * $.jqplot.MarkerRenderer(	{shadow:false}	)
	 *
	 * @param showRenderer the showRenderer to set
	 */
	public void setShowMarker(Boolean showMarker) {
		this.showMarker = showMarker;
	}

	/**
	 * Pixels to add to the lineWidth of the highlight. default 2.5
	 *
	 * @return the lineWidthAdjust
	 */
	public Double getLineWidthAdjust() {
		return lineWidthAdjust;
	}

	/**
	 * Pixels to add to the lineWidth of the highlight. default 2.5
	 *
	 * @param lineWidthAdjust the lineWidthAdjust to set
	 */
	public void setLineWidthAdjust(Double lineWidthAdjust) {
		this.lineWidthAdjust = lineWidthAdjust;
	}

	/**
	 * Pixels to add to the overall size of the highlight. default 5
	 *
	 * @return the sizeAdjust
	 */
	public Double getSizeAdjust() {
		return sizeAdjust;
	}

	/**
	 * Pixels to add to the overall size of the highlight. default 5
	 *
	 * @param sizeAdjust the sizeAdjust to set
	 */
	public void setSizeAdjust(Double sizeAdjust) {
		this.sizeAdjust = sizeAdjust;
	}

	/**
	 * Show a tooltip with data point values. default true
	 *
	 * @return the showTooltip
	 */
	public Boolean getShowTooltip() {
		return showTooltip;
	}

	/**
	 * Show a tooltip with data point values. default true
	 *
	 * @param showTooltip the showTooltip to set
	 */
	public void setShowTooltip(Boolean showTooltip) {
		this.showTooltip = showTooltip;
	}

	/**
	 * Where to position tooltip, ‘n’, ‘ne’, ‘e’, ‘se’, ‘s’, ‘sw’, ‘w’, ‘nw’
	 * default 'nw'
	 *
	 * @return the tooltipLocation
	 */
	public String getTooltipLocation() {
		return tooltipLocation;
	}

	/**
	 * Where to position tooltip, ‘n’, ‘ne’, ‘e’, ‘se’, ‘s’, ‘sw’, ‘w’, ‘nw’
	 * default 'nw'
	 *
	 * @param tooltipLocation the tooltipLocation to set
	 */
	public void setTooltipLocation(String tooltipLocation) {
		this.tooltipLocation = tooltipLocation;
	}

	/**
	 * true = fade in/out tooltip, flase = show/hide tooltip default true
	 *
	 * @return the fadeTooltip
	 */
	public Boolean getFadeTooltip() {
		return fadeTooltip;
	}

	/**
	 * true = fade in/out tooltip, flase = show/hide tooltip default true
	 *
	 * @param fadeTooltip the fadeTooltip to set
	 */
	public void setFadeTooltip(Boolean fadeTooltip) {
		this.fadeTooltip = fadeTooltip;
	}

	/**
	 * ’slow’, ‘def’, ‘fast’, or number of milliseconds. default 'fast'
	 *
	 * @return the tooltipFadeSpeed
	 */
	public String getTooltipFadeSpeed() {
		return tooltipFadeSpeed;
	}

	/**
	 * ’slow’, ‘def’, ‘fast’, or number of milliseconds. default 'fast'
	 *
	 * @param tooltipFadeSpeed the tooltipFadeSpeed to set
	 */
	public void setTooltipFadeSpeed(String tooltipFadeSpeed) {
		this.tooltipFadeSpeed = tooltipFadeSpeed;
	}

	/**
	 * Pixel offset of tooltip from the highlight. default 2
	 *
	 * @return the tooltipOffset
	 */
	public Integer getTooltipOffset() {
		return tooltipOffset;
	}

	/**
	 * Pixel offset of tooltip from the highlight. default 2
	 *
	 * @param tooltipOffset the tooltipOffset to set
	 */
	public void setTooltipOffset(Integer tooltipOffset) {
		this.tooltipOffset = tooltipOffset;
	}

	/**
	 * Which axes to display in tooltip, ‘x’, ‘y’ or ‘both’, ‘xy’ or ‘yx’ ‘both’
	 * and ‘xy’ are equivalent, ‘yx’ reverses order of labels. default 'both'
	 *
	 * @return the tooltipAxes
	 */
	public String getTooltipAxes() {
		return tooltipAxes;
	}

	/**
	 * Which axes to display in tooltip, ‘x’, ‘y’ or ‘both’, ‘xy’ or ‘yx’ ‘both’
	 * and ‘xy’ are equivalent, ‘yx’ reverses order of labels. default 'both'
	 *
	 * @param tooltipAxes the tooltipAxes to set
	 */
	public void setTooltipAxes(String tooltipAxes) {
		this.tooltipAxes = tooltipAxes;
	}

	/**
	 * Use the x and y axes formatters to format the text in the tooltip.
	 * default true
	 *
	 * @return the useAxesFormatters
	 */
	public Boolean getUseAxesFormatters() {
		return useAxesFormatters;
	}

	/**
	 * Use the x and y axes formatters to format the text in the tooltip.
	 * default true
	 *
	 * @param useAxesFormatters the useAxesFormatters to set
	 */
	public void setUseAxesFormatters(Boolean useAxesFormatters) {
		this.useAxesFormatters = useAxesFormatters;
	}

	/**
	 * sprintf format string for the tooltip. Uses Ash Searle’s javascript
	 * sprintf implementation found here:
	 * http://hexmen.com/blog/2007/03/printf-sprintf/ See
	 * http://perldoc.perl.org/functions/sprintf.html for reference. Additional
	 * “p” and “P” format specifiers added by Chris Leonello. default '%.5P'
	 *
	 * @return the tooltipFormatString
	 */
	public String getTooltipFormatString() {
		return tooltipFormatString;
	}

	/**
	 * sprintf format string for the tooltip. Uses Ash Searle’s javascript
	 * sprintf implementation found here:
	 * http://hexmen.com/blog/2007/03/printf-sprintf/ See
	 * http://perldoc.perl.org/functions/sprintf.html for reference. Additional
	 * “p” and “P” format specifiers added by Chris Leonello. default '%.5P'
	 *
	 * @param tooltipFormatString the tooltipFormatString to set
	 */
	public void setTooltipFormatString(String tooltipFormatString) {
		this.tooltipFormatString = tooltipFormatString;
	}

	/**
	 * alternative to tooltipFormatString will format the whole tooltip text,
	 * populating with x, y values as indicated by tooltipAxes option. So, you
	 * could have a tooltip like: ‘Date: %s, number of cats: %d’ to format the
	 * whole tooltip at one go. If useAxesFormatters is true, values will be
	 * formatted according to Axes formatters and you can populate your tooltip
	 * string with %s placeholders. default null
	 *
	 * @return the formatString
	 */
	public String getFormatString() {
		return formatString;
	}

	/**
	 * alternative to tooltipFormatString will format the whole tooltip text,
	 * populating with x, y values as indicated by tooltipAxes option. So, you
	 * could have a tooltip like: ‘Date: %s, number of cats: %d’ to format the
	 * whole tooltip at one go. If useAxesFormatters is true, values will be
	 * formatted according to Axes formatters and you can populate your tooltip
	 * string with %s placeholders. default null
	 *
	 * @param formatString the formatString to set
	 */
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}

	/**
	 * Number of y values to expect in the data point array. Typically this is
	 * 1. Certain plots, like OHLC, will have more y values in each data point
	 * array. default 1
	 *
	 * @return the yValues
	 */
	public Integer getyValues() {
		return yValues;
	}

	/**
	 * Number of y values to expect in the data point array. Typically this is
	 * 1. Certain plots, like OHLC, will have more y values in each data point
	 * array. default 1
	 *
	 * @param yValues the yValues to set
	 */
	public void setyValues(Integer yValues) {
		this.yValues = yValues;
	}

	/**
	 * This option requires jQuery 1.4+ True to bring the series of the
	 * highlighted point to the front of other series. default false
	 *
	 * @return the bringSeriesToFront
	 */
	public Boolean getBringSeriesToFront() {
		return bringSeriesToFront;
	}

	/**
	 * This option requires jQuery 1.4+ True to bring the series of the
	 * highlighted point to the front of other series. default false
	 *
	 * @param bringSeriesToFront the bringSeriesToFront to set
	 */
	public void setBringSeriesToFront(Boolean bringSeriesToFront) {
		this.bringSeriesToFront = bringSeriesToFront;
	}
}
