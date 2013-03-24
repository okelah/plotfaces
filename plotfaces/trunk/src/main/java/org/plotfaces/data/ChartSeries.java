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

import java.util.LinkedHashMap;
import java.util.Map;
import org.plotfaces.PlotUtilities;
import org.plotfaces.renderer.ChartRenderer;
import org.plotfaces.renderer.MarkerRenderer;

/**
 *
 * @author Graham Smith
 */
public class ChartSeries {

	private Boolean show; 
	private Axis.AxisName xAxis;
	private Axis.AxisName yAxis;
	private String label;
	private Boolean showLabel; 
	private String color;
	private Double lineWidth; 
	private String lineJoin;
	private String lineCap; 
	private Boolean shadow; 
	private Integer shadowAngle; 
	private Double shadowOffset; 
	private Integer shadowDepth; 
	private Double shadowAlpha; 
	private Boolean breakOnNull;  
	private Boolean showLine; 
	private Boolean showMarker; 
	private Integer index; 
	private Boolean fill;  
	private Boolean fillAndStroke;  
	private String fillColor; 
	private String fillAlpha; 
	private Boolean disableStack;  
	private Integer neighbourThreshold;  
	private Boolean fillToZero;  
	private Integer fillToValue;  
	private String fillAxis;  
	private Boolean useNegativeColors;  
	private ChartRenderer renderer;  
	private MarkerRenderer markerRenderer;  
    private Number[] data;

	public ChartSeries() {
	}

	public String plot() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		boolean isCommaRequired = false; 

		isCommaRequired = PlotUtilities.addVariable( builder, "show", getShow(), isCommaRequired);
		if( getxAxis() != null ) {
			isCommaRequired = PlotUtilities.addVariable( builder, "xaxis", getxAxis().name(), isCommaRequired, true );
		}
		if( getyAxis() != null ) {
			isCommaRequired = PlotUtilities.addVariable( builder, "yaxis", getyAxis().name(), isCommaRequired, true );
		}
		isCommaRequired = PlotUtilities.addVariable( builder, "label", getLabel(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "showLabel", getShowLabel(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "color", getColor(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "lineWidth", getLineWidth(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "lineJoin", getLineJoin(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "lineCap", getLineCap(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "shadow", getShadow(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "shadowAngle", getShadowAngle(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "shadowOffset", getShadowOffset(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "shadowDepth", getShadowDepth(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "shadowAlpha", getShadowAlpha(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "breakOnNull", getBreakOnNull(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "showLine", getShowLine(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "showMarker", getShowMarker(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "index", getIndex(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "fill", getFill(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "fillAndStroke", getFillAndStroke(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "fillColor", getFillColor(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "fillAlpha", getFillAlpha(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "disableStack", getDisableStack(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "neighbourThreshold", getNeighbourThreshold(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "fillToValue", getFillToValue(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "fillAxis", getFillAxis(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "useNegativeColors", getUseNegativeColors(), isCommaRequired );
		
		if( getRenderer() != null ) {
			if( isCommaRequired ) {
				builder.append(",");
			} else {
				isCommaRequired = true;
			}
			getRenderer().plot( builder, true );
		}

		if( getMarkerRenderer() != null ) {
			if( isCommaRequired ) {
				builder.append(",");
			} else {
				isCommaRequired = true;
			}
			getMarkerRenderer().plot( builder, true );
		} 
		
		builder.append("\n}");
		return builder.toString();
	}

	/**
	 * whether or not to draw the series.
	 * default true
	 * 
	 * @return the show
	 */
	public Boolean getShow() {
		return show;
	}

	/**
	 * whether or not to draw the series.
	 * default true
	 * 
	 * @param show the show to set
	 */
	public void setShow(Boolean show) {
		this.show = show;
	}

	/**
	 * which x axis to use with this series, either ‘xaxis’ or ‘x2axis’.
	 * default xaxis
	 * 
	 * @return the xAxis
	 */
	public Axis.AxisName getxAxis() {
		return xAxis;
	}

	/**
	 * which x axis to use with this series, either ‘xaxis’ or ‘x2axis’.
	 * default xaxis
	 * 
	 * @param xAxis the xAxis to set
	 */
	public void setxAxis(Axis.AxisName xAxis) {
		this.xAxis = xAxis;
	}

	/**
	 * which y axis to use with this series, either ‘yaxis’ or ‘y2axis’.
	 * default yAxis
	 * 
	 * @return the yAxis
	 */
	public Axis.AxisName getyAxis() {
		return yAxis;
	}

	/**
	 * which y axis to use with this series, either ‘yaxis’ or ‘y2axis’.
	 * default yAxis
	 * 
	 * @param yAxis the yAxis to set
	 */
	public void setyAxis(Axis.AxisName yAxis) {
		this.yAxis = yAxis;
	}

	/**
	 * Line label to use in the legend.
	 * default ''
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Line label to use in the legend.
	 * default ''
	 * 
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * true to show label for this series in the legend.
	 * default true
	 * 
	 * @return the showLabel
	 */
	public Boolean getShowLabel() {
		return showLabel;
	}

	/**
	 * true to show label for this series in the legend.
	 * default true
	 * 
	 * @param showLabel the showLabel to set
	 */
	public void setShowLabel(Boolean showLabel) {
		this.showLabel = showLabel;
	}

	/**
	 * css color spec for the series
	 * 
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * css color spec for the series
	 * 
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * width of the line in pixels.  May have different meanings depending on renderer.
	 * default 2.5
	 * 
	 * @return the lineWidth
	 */
	public Double getLineWidth() {
		return lineWidth;
	}

	/**
	 * width of the line in pixels.  May have different meanings depending on renderer.
	 * default 2.5
	 * 
	 * @param lineWidth the lineWidth to set
	 */
	public void setLineWidth(Double lineWidth) {
		this.lineWidth = lineWidth;
	}

	/**
	 * Canvas lineCap style at ends of line.
	 * default round
	 * 
	 * @return the lineCap
	 */
	public String getLineCap() {
		return lineCap;
	}

	/**
	 * Canvas lineCap style at ends of line.
	 * default round
	 * 
	 * @param lineCap the lineCap to set
	 */
	public void setLineCap(String lineCap) {
		this.lineCap = lineCap;
	}

	/**
	 * whether or not to draw a shadow on the line
	 * default true
	 * 
	 * @return the shadow
	 */
	public Boolean getShadow() {
		return shadow;
	}

	/**
	 * whether or not to draw a shadow on the line
	 * default true
	 * 
	 * @param shadow the shadow to set
	 */
	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
	}

	/**
	 * Shadow angle in degrees
	 * default 45
	 * 
	 * @return the shadowAngle
	 */
	public Integer getShadowAngle() {
		return shadowAngle;
	}

	/**
	 * Shadow angle in degrees
	 * default 45
	 * 
	 * @param shadowAngle the shadowAngle to set
	 */
	public void setShadowAngle(Integer shadowAngle) {
		this.shadowAngle = shadowAngle;
	}

	/**
	 * Shadow offset from line in pixels
	 * default 1.25
	 * 
	 * @return the shadowOffset
	 */
	public Double getShadowOffset() {
		return shadowOffset;
	}

	/**
	 * Shadow offset from line in pixels
	 * default 1.25
	 * 
	 * @param shadowOffset the shadowOffset to set
	 */
	public void setShadowOffset(Double shadowOffset) {
		this.shadowOffset = shadowOffset;
	}

	/**
	 * Number of times shadow is stroked, each stroke offset shadowOffset from the last.
	 * default 3
	 * 
	 * @return the shadowDepth
	 */
	public Integer getShadowDepth() {
		return shadowDepth;
	}

	/**
	 * Number of times shadow is stroked, each stroke offset shadowOffset from the last.
	 * default 3
	 * 
	 * @param shadowDepth the shadowDepth to set
	 */
	public void setShadowDepth(Integer shadowDepth) {
		this.shadowDepth = shadowDepth;
	}

	/**
	 * Alpha channel transparency of shadow.  0 = transparent.
	 * default 0.1
	 * 
	 * @return the shadowAlpha
	 */
	public Double getShadowAlpha() {
		return shadowAlpha;
	}

	/**
	 * Alpha channel transparency of shadow.  0 = transparent.
	 * default 0.1
	 * 
	 * @param shadowAlpha the shadowAlpha to set
	 */
	public void setShadowAlpha(Double shadowAlpha) {
		this.shadowAlpha = shadowAlpha;
	}

	/**
	 * Whether line segments should be be broken at null value.  False will join point on either side of line.
	 * default false
	 * 
	 * @return the breakOnNull
	 */
	public Boolean getBreakOnNull() {
		return breakOnNull;
	}

	/**
	 * Whether line segments should be be broken at null value.  False will join point on either side of line.
	 * default false
	 * 
	 * @param breakOnNull the breakOnNull to set
	 */
	public void setBreakOnNull(Boolean breakOnNull) {
		this.breakOnNull = breakOnNull;
	}

	/**
	 * whether to actually draw the line or not.  Series will still be renderered, even if no line is drawn.
	 * default true
	 * 
	 * @return the showLine
	 */
	public Boolean getShowLine() {
		return showLine;
	}

	/**
	 * whether to actually draw the line or not.  Series will still be renderered, even if no line is drawn.
	 * default true
	 * 
	 * @param showLine the showLine to set
	 */
	public void setShowLine(Boolean showLine) {
		this.showLine = showLine;
	}

	/**
	 * whether or not to show the markers at the data points.
	 * default true
	 * 
	 * @return the showMarker
	 */
	public Boolean getShowMarker() {
		return showMarker;
	}

	/**
	 * wether or not to show the markers at the data points.
	 * default true
	 * 
	 * @param showMarker the showMarker to set
	 */
	public void setShowMarker(Boolean showMarker) {
		this.showMarker = showMarker;
	}

	/**
	 * 0 based index of this series in the plot series array.
	 * default 0
	 * 
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * 0 based index of this series in the plot series array.
	 * default 0
	 * 
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * true or false, wether to fill under lines or in bars.  May not be implemented in all renderers.
	 * default false
	 * 
	 * @return the fill
	 */
	public Boolean getFill() {
		return fill;
	}

	/**
	 * true or false, wether to fill under lines or in bars.  May not be implemented in all renderers.
	 * default false
	 * 
	 * @param fill the fill to set
	 */
	public void setFill(Boolean fill) {
		this.fill = fill;
	}

	/**
	 * If true will stroke the line (with color this.color) as well as fill under it.  Applies only when fill is true.
	 * default false
	 * 
	 * @return the fillAndStroke
	 */
	public Boolean getFillAndStroke() {
		return fillAndStroke;
	}

	/**
	 * If true will stroke the line (with color this.color) as well as fill under it.  Applies only when fill is true.
	 * default false
	 * 
	 * @param fillAndStroke the fillAndStroke to set
	 */
	public void setFillAndStroke(Boolean fillAndStroke) {
		this.fillAndStroke = fillAndStroke;
	}

	/**
	 * CSS color spec to use for fill under line.  Defaults to line color.
	 * 
	 * @return the fillColor
	 */
	public String getFillColor() {
		return fillColor;
	}

	/**
	 * CSS color spec to use for fill under line.  Defaults to line color.
	 * 
	 * @param fillColor the fillColor to set
	 */
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	/**
	 * Alpha transparency to apply to the fill under the line.  Use this to adjust alpha separate from fill color.
	 * 
	 * @return the fillAlpha
	 */
	public String getFillAlpha() {
		return fillAlpha;
	}

	/**
	 * Alpha transparency to apply to the fill under the line.  Use this to adjust alpha separate from fill color.
	 * 
	 * @param fillAlpha the fillAlpha to set
	 */
	public void setFillAlpha(String fillAlpha) {
		this.fillAlpha = fillAlpha;
	}

	/**
	 * true to not stack this series with other series in the plot.  To render properly, non-stacked series must come after any stacked series in the plot’s data series array.  So, the plot’s data series array would look like:
	 *
     * [stackedSeries1, stackedSeries2, ..., nonStackedSeries1, nonStackedSeries2, ...]
	 *
	 * disableStack will put a gap in the stacking order of series, and subsequent stacked series will not fill down through the non-stacked series and will most likely not stack properly on top of the non-stacked series.
	 * default false
	 * 
	 * @return the disableStack
	 */
	public Boolean getDisableStack() {
		return disableStack;
	}

	/**
	 * true to not stack this series with other series in the plot.  To render properly, non-stacked series must come after any stacked series in the plot’s data series array.  So, the plot’s data series array would look like:
	 *
     * [stackedSeries1, stackedSeries2, ..., nonStackedSeries1, nonStackedSeries2, ...]
	 *
	 * disableStack will put a gap in the stacking order of series, and subsequent stacked series will not fill down through the non-stacked series and will most likely not stack properly on top of the non-stacked series.
	 * default false
	 * 
	 * @param disableStack the disableStack to set
	 */
	public void setDisableStack(Boolean disableStack) {
		this.disableStack = disableStack;
	}

	/**
	 * how close or far (in pixels) the cursor must be from a point marker to detect the point.
	 * default 4
	 * 
	 * @return the neighbourThreshold
	 */
	public Integer getNeighbourThreshold() {
		return neighbourThreshold;
	}

	/**
	 * how close or far (in pixels) the cursor must be from a point marker to detect the point.
	 * default 4
	 * 
	 * @param neighbourThreshold the neighbourThreshold to set
	 */
	public void setNeighbourThreshold(Integer neighbourThreshold) {
		this.neighbourThreshold = neighbourThreshold;
	}

	/**
	 * true will force bar and filled series to fill toward zero on the fill Axis.
	 * 
	 * @return the fillToZero
	 */
	public Boolean getFillToZero() {
		return fillToZero;
	}

	/**
	 * true will force bar and filled series to fill toward zero on the fill Axis.
	 * 
	 * @param fillToZero the fillToZero to set
	 */
	public void setFillToZero(Boolean fillToZero) {
		this.fillToZero = fillToZero;
	}

	/**
	 * fill a filled series to this value on the fill axis.  Works in conjunction with fillToZero, so that must be true.
	 * default 0
	 * 
	 * @return the fillToValue
	 */
	public Integer getFillToValue() {
		return fillToValue;
	}

	/**
	 * fill a filled series to this value on the fill axis.  Works in conjunction with fillToZero, so that must be true.
	 * default 0
	 * 
	 * @param fillToValue the fillToValue to set
	 */
	public void setFillToValue(Integer fillToValue) {
		this.fillToValue = fillToValue;
	}

	/**
	 * Either ‘x’ or ‘y’.  Which axis to fill the line toward if fillToZero is true.  ‘y’ means fill up/down to 0 on the y axis for this series.
	 * default y
	 * 
	 * @return the fillAxis
	 */
	public String getFillAxis() {
		return fillAxis;
	}

	/**
	 * Either ‘x’ or ‘y’.  Which axis to fill the line toward if fillToZero is true.  ‘y’ means fill up/down to 0 on the y axis for this series.
	 * default y
	 * 
	 * @param fillAxis the fillAxis to set
	 */
	public void setFillAxis(String fillAxis) {
		this.fillAxis = fillAxis;
	}

	/**
	 * true to color negative values differently in filled and bar charts.
	 * default true
	 * 
	 * @return the useNegativeColors
	 */
	public Boolean getUseNegativeColors() {
		return useNegativeColors;
	}

	/**
	 * true to color negative values differently in filled and bar charts.
	 * default true
	 * 
	 * @param useNegativeColors the useNegativeColors to set
	 */
	public void setUseNegativeColors(Boolean useNegativeColors) {
		this.useNegativeColors = useNegativeColors;
	}

	/**
	 * A class of a renderer which will draw the series, see $.jqplot.LineRenderer.
	 * default LineRenderer
	 * 
	 * @return the renderer
	 */
	public ChartRenderer getRenderer() {
		return renderer;
	}

	/**
	 * A class of a renderer which will draw the series, see $.jqplot.LineRenderer.
	 * default LineRenderer 
	 * 
	 * @param renderer the renderer to set
	 */
	public void setRenderer(ChartRenderer renderer) {
		this.renderer = renderer;
	}

	/**
	 * A class of a renderer which will draw marker (e.g. circle, square, ...) at the data points, see $.jqplot.MarkerRenderer
	 * 
	 * @return the markerRenderer
	 */
	public MarkerRenderer getMarkerRenderer() {
		return markerRenderer;
	}

	/**
	 * A class of a renderer which will draw marker (e.g. circle, square, ...) at the data points, see $.jqplot.MarkerRenderer
	 * 
	 * @param markerRenderer the markerRenderer to set
	 */
	public void setMarkerRenderer(MarkerRenderer markerRenderer) {
		this.markerRenderer = markerRenderer;
	}

	/**
	 * @return the data
	 */
	public Number[] getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Number[] data) {
		this.data = data;
	}

	/**
	 * Canvas lineJoin style between segments of series.
	 * default round
	 * 
	 * @return the lineJoin
	 */
	public String getLineJoin() {
		return lineJoin;
	}

	/**
	 * Canvas lineJoin style between segments of series.
	 * default round
	 * @param lineJoin the lineJoin to set
	 */
	public void setLineJoin(String lineJoin) {
		this.lineJoin = lineJoin;
	}
}
