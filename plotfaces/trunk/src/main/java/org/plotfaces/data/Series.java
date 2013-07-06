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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.plotfaces.renderer.MarkerRenderer;
import org.plotfaces.renderer.SeriesRenderer;

/**
 *
 * @author Graham Smith
 */
public class Series implements Comparable<Series> {

	private static final int NULL_INDEX = 1000000;
	private static final int DISABLE_STACK = 2000000;

	public enum FillAxis {

		x, y
	};

	public enum LineJoin {

		miter, round, bevel
	};

	public enum LineCap {

		butt, round, square
	};
	private Boolean show = Boolean.TRUE;
	private Axis.AxisName xAxis;
	private Axis.AxisName yAxis;
	private String renderer;
	private SeriesRenderer rendererOptions;
	private String label;
	private Boolean showLabel;
	private String color;
	private Double lineWidth;
	private LineJoin lineJoin;
	private LineCap lineCap;
	private Boolean shadow;
	private Integer shadowAngle;
	private Double shadowOffset;
	private Integer shadowDepth;
	private Double shadowAlpha;
	private Boolean breakOnNull;
	private String markerRenderer;
	private MarkerRenderer markerRendererOptions; //Supplies markerOptions
	private Boolean showLine;
	private Boolean showMarker;
	private Integer index;
	private Boolean fill;
	private String fillColor;
	private Double fillAlpha;
	private Boolean fillAndStroke;
	private Boolean disableStack;
	private Integer neighborThreshold;
	private Boolean fillToZero;
	private Integer fillToValue;
	private FillAxis fillAxis;
	private Boolean useNegativeColors;
	private Data data;
	private transient Set<SeriesOrderListener> seriesOrderListeners = new HashSet<>();

	public Series() {
	}

	public Series(Integer index, String label) {
		this.index = index;
		this.label = label;
	}

	/**
	 * Whether or not to draw the series. default true
	 *
	 * @return the show
	 */
	public Boolean getShow() {
		return show;
	}

	/**
	 * Whether or not to draw the series. If null is provided it is silently
	 * converted to true, the default value.
	 *
	 * @param show the show to set
	 */
	public void setShow(Boolean show) {
		if (show == null) {
			this.show = true;
		} else {
			this.show = show;
		}
	}

	/**
	 * which x axis to use with this series, either ‘xaxis’ or ‘x2axis’. default
	 * xaxis
	 *
	 * @return the xAxis
	 */
	public Axis.AxisName getxAxis() {
		return xAxis;
	}

	/**
	 * which x axis to use with this series, either ‘xaxis’ or ‘x2axis’. default
	 * xaxis
	 *
	 * @param xAxis the xAxis to set
	 */
	public void setxAxis(Axis.AxisName xAxis) {
		this.xAxis = xAxis;
	}

	/**
	 * which y axis to use with this series, either ‘yaxis’ or ‘y2axis’. default
	 * yAxis
	 *
	 * @return the yAxis
	 */
	public Axis.AxisName getyAxis() {
		return yAxis;
	}

	/**
	 * which y axis to use with this series, either ‘yaxis’ or ‘y2axis’. default
	 * yAxis
	 *
	 * @param yAxis the yAxis to set
	 */
	public void setyAxis(Axis.AxisName yAxis) {
		this.yAxis = yAxis;
	}

	/**
	 * Line label to use in the legend. default ''
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Line label to use in the legend. default ''
	 *
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * true to show label for this series in the legend. default true
	 *
	 * @return the showLabel
	 */
	public Boolean getShowLabel() {
		return showLabel;
	}

	/**
	 * true to show label for this series in the legend. default true
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
	 * width of the line in pixels. May have different meanings depending on
	 * renderer. default 2.5
	 *
	 * @return the lineWidth
	 */
	public Double getLineWidth() {
		return lineWidth;
	}

	/**
	 * width of the line in pixels. May have different meanings depending on
	 * renderer. default 2.5
	 *
	 * @param lineWidth the lineWidth to set
	 */
	public void setLineWidth(Double lineWidth) {
		this.lineWidth = lineWidth;
	}

	/**
	 * Canvas lineCap style at ends of line. default round
	 *
	 * @return the lineCap
	 */
	public LineCap getLineCap() {
		return lineCap;
	}

	/**
	 * Canvas lineCap style at ends of line. default round
	 *
	 * @param lineCap the lineCap to set
	 */
	public void setLineCap(LineCap lineCap) {
		this.lineCap = lineCap;
	}

	/**
	 * whether or not to draw a shadow on the line default true
	 *
	 * @return the shadow
	 */
	public Boolean getShadow() {
		return shadow;
	}

	/**
	 * whether or not to draw a shadow on the line default true
	 *
	 * @param shadow the shadow to set
	 */
	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
	}

	/**
	 * Shadow angle in degrees default 45
	 *
	 * @return the shadowAngle
	 */
	public Integer getShadowAngle() {
		return shadowAngle;
	}

	/**
	 * Shadow angle in degrees default 45
	 *
	 * @param shadowAngle the shadowAngle to set
	 */
	public void setShadowAngle(Integer shadowAngle) {
		this.shadowAngle = shadowAngle;
	}

	/**
	 * Shadow offset from line in pixels default 1.25
	 *
	 * @return the shadowOffset
	 */
	public Double getShadowOffset() {
		return shadowOffset;
	}

	/**
	 * Shadow offset from line in pixels default 1.25
	 *
	 * @param shadowOffset the shadowOffset to set
	 */
	public void setShadowOffset(Double shadowOffset) {
		this.shadowOffset = shadowOffset;
	}

	/**
	 * Number of times shadow is stroked, each stroke offset shadowOffset from
	 * the last. default 3
	 *
	 * @return the shadowDepth
	 */
	public Integer getShadowDepth() {
		return shadowDepth;
	}

	/**
	 * Number of times shadow is stroked, each stroke offset shadowOffset from
	 * the last. default 3
	 *
	 * @param shadowDepth the shadowDepth to set
	 */
	public void setShadowDepth(Integer shadowDepth) {
		this.shadowDepth = shadowDepth;
	}

	/**
	 * Alpha channel transparency of shadow. 0 = transparent. default 0.1
	 *
	 * @return the shadowAlpha
	 */
	public Double getShadowAlpha() {
		return shadowAlpha;
	}

	/**
	 * Alpha channel transparency of shadow. 0 = transparent. default 0.1
	 *
	 * @param shadowAlpha the shadowAlpha to set
	 */
	public void setShadowAlpha(Double shadowAlpha) {
		this.shadowAlpha = shadowAlpha;
	}

	/**
	 * Whether line segments should be be broken at null value. False will join
	 * point on either side of line. default false
	 *
	 * @return the breakOnNull
	 */
	public Boolean getBreakOnNull() {
		return breakOnNull;
	}

	/**
	 * Whether line segments should be be broken at null value. False will join
	 * point on either side of line. default false
	 *
	 * @param breakOnNull the breakOnNull to set
	 */
	public void setBreakOnNull(Boolean breakOnNull) {
		this.breakOnNull = breakOnNull;
	}

	/**
	 * whether to actually draw the line or not. Series will still be
	 * renderered, even if no line is drawn. default true
	 *
	 * @return the showLine
	 */
	public Boolean getShowLine() {
		return showLine;
	}

	/**
	 * whether to actually draw the line or not. Series will still be
	 * renderered, even if no line is drawn. default true
	 *
	 * @param showLine the showLine to set
	 */
	public void setShowLine(Boolean showLine) {
		this.showLine = showLine;
	}

	/**
	 * whether or not to show the markers at the data points. default true
	 *
	 * @return the showMarker
	 */
	public Boolean getShowMarker() {
		return showMarker;
	}

	/**
	 * wether or not to show the markers at the data points. default true
	 *
	 * @param showMarker the showMarker to set
	 */
	public void setShowMarker(Boolean showMarker) {
		this.showMarker = showMarker;
	}

	/**
	 * 0 based index of this series in the plot series array. default 0
	 *
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * 0 based index of this series in the plot series array. default 0
	 *
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
		fireSeriesOrderEvent();
	}

	/**
	 * true or false, wether to fill under lines or in bars. May not be
	 * implemented in all renderers. default false
	 *
	 * @return the fill
	 */
	public Boolean getFill() {
		return fill;
	}

	/**
	 * true or false, wether to fill under lines or in bars. May not be
	 * implemented in all renderers. default false
	 *
	 * @param fill the fill to set
	 */
	public void setFill(Boolean fill) {
		this.fill = fill;
	}

	/**
	 * If true will stroke the line (with color this.color) as well as fill
	 * under it. Applies only when fill is true. default false
	 *
	 * @return the fillAndStroke
	 */
	public Boolean getFillAndStroke() {
		return fillAndStroke;
	}

	/**
	 * If true will stroke the line (with color this.color) as well as fill
	 * under it. Applies only when fill is true. default false
	 *
	 * @param fillAndStroke the fillAndStroke to set
	 */
	public void setFillAndStroke(Boolean fillAndStroke) {
		this.fillAndStroke = fillAndStroke;
	}

	/**
	 * CSS color spec to use for fill under line. Defaults to line color.
	 *
	 * @return the fillColor
	 */
	public String getFillColor() {
		return fillColor;
	}

	/**
	 * CSS color spec to use for fill under line. Defaults to line color.
	 *
	 * @param fillColor the fillColor to set
	 */
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	/**
	 * Alpha transparency to apply to the fill under the line. Use this to
	 * adjust alpha separate from fill color.
	 *
	 * @return the fillAlpha
	 */
	public Double getFillAlpha() {
		return fillAlpha;
	}

	/**
	 * Alpha transparency to apply to the fill under the line. Use this to
	 * adjust alpha separate from fill color.
	 *
	 * @param fillAlpha the fillAlpha to set
	 */
	public void setFillAlpha(Double fillAlpha) {
		this.fillAlpha = fillAlpha;
	}

	/**
	 * true to not stack this series with other series in the plot. To render
	 * properly, non-stacked series must come after any stacked series in the
	 * plot’s data series array. So, the plot’s data series array would look
	 * like:
	 *
	 * [stackedSeries1, stackedSeries2, ..., nonStackedSeries1,
	 * nonStackedSeries2, ...]
	 *
	 * disableStack will put a gap in the stacking order of series, and
	 * subsequent stacked series will not fill down through the non-stacked
	 * series and will most likely not stack properly on top of the non-stacked
	 * series. default false
	 *
	 * @return the disableStack
	 */
	public Boolean getDisableStack() {
		return disableStack;
	}

	/**
	 * True to not stack this series with other series in the plot. To render
	 * properly, non-stacked series must come after any stacked series in the
	 * plot’s data series array. So, the plot’s data series array would look
	 * like:
	 *
	 * [stackedSeries1, stackedSeries2, ..., nonStackedSeries1,
	 * nonStackedSeries2, ...]
	 *
	 * disableStack will put a gap in the stacking order of series, and
	 * subsequent stacked series will not fill down through the non-stacked
	 * series and will most likely not stack properly on top of the non-stacked
	 * series. default false
	 *
	 * @param disableStack the disableStack to set
	 */
	public void setDisableStack(Boolean disableStack) {
		this.disableStack = disableStack;
		fireSeriesOrderEvent();
	}

	/**
	 * how close or far (in pixels) the cursor must be from a point marker to
	 * detect the point. default 4
	 *
	 * @return the neighbourThreshold
	 */
	public Integer getNeighborThreshold() {
		return neighborThreshold;
	}

	/**
	 * how close or far (in pixels) the cursor must be from a point marker to
	 * detect the point. default 4
	 *
	 * @param neighbourThreshold the neighbourThreshold to set
	 */
	public void setNeighborThreshold(Integer neighborThreshold) {
		this.neighborThreshold = neighborThreshold;
	}

	/**
	 * true will force bar and filled series to fill toward zero on the fill
	 * Axis.
	 *
	 * @return the fillToZero
	 */
	public Boolean getFillToZero() {
		return fillToZero;
	}

	/**
	 * true will force bar and filled series to fill toward zero on the fill
	 * Axis.
	 *
	 * @param fillToZero the fillToZero to set
	 */
	public void setFillToZero(Boolean fillToZero) {
		this.fillToZero = fillToZero;
	}

	/**
	 * fill a filled series to this value on the fill axis. Works in conjunction
	 * with fillToZero, so that must be true. default 0
	 *
	 * @return the fillToValue
	 */
	public Integer getFillToValue() {
		return fillToValue;
	}

	/**
	 * fill a filled series to this value on the fill axis. Works in conjunction
	 * with fillToZero, so that must be true. default 0
	 *
	 * @param fillToValue the fillToValue to set
	 */
	public void setFillToValue(Integer fillToValue) {
		this.fillToValue = fillToValue;
	}

	/**
	 * Either ‘x’ or ‘y’. Which axis to fill the line toward if fillToZero is
	 * true. ‘y’ means fill up/down to 0 on the y axis for this series. default
	 * y
	 *
	 * @return the fillAxis
	 */
	public FillAxis getFillAxis() {
		return fillAxis;
	}

	/**
	 * Either ‘x’ or ‘y’. Which axis to fill the line toward if fillToZero is
	 * true. ‘y’ means fill up/down to 0 on the y axis for this series. default
	 * y
	 *
	 * @param fillAxis the fillAxis to set
	 */
	public void setFillAxis(FillAxis fillAxis) {
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
	 * A class of a renderer which will draw the series, see
	 * $.jqplot.LineRenderer. default LineRenderer
	 *
	 * @return the renderer
	 */
	protected String getRenderer() {
		return renderer;
	}

	/**
	 * A class of a renderer which will draw the series, see
	 * $.jqplot.LineRenderer. default LineRenderer
	 *
	 * @param renderer the renderer to set
	 */
	protected void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	public SeriesRenderer getRendererOptions() {
		return rendererOptions;
	}

	public void setRendererOptions(SeriesRenderer rendererOptions) {
		this.rendererOptions = rendererOptions;
		if (this.rendererOptions == null) {
			setRenderer(null);
		} else {
			setRenderer(this.rendererOptions.getRendererName());
		}
	}

	/**
	 * A class of a renderer which will draw marker (e.g. circle, square, ...)
	 * at the data points, see $.jqplot.MarkerRenderer
	 *
	 * @return the markerRenderer
	 */
	protected String getMarkerRenderer() {
		return markerRenderer;
	}

	/**
	 * A class of a renderer which will draw marker (e.g. circle, square, ...)
	 * at the data points, see $.jqplot.MarkerRenderer
	 *
	 * @param markerRenderer the markerRenderer to set
	 */
	protected void setMarkerRenderer(String markerRenderer) {
		this.markerRenderer = markerRenderer;
	}

	public MarkerRenderer getMarkerRendererOptions() {
		return markerRendererOptions;
	}

	public void setMarkerRendererOptions(MarkerRenderer markerRendererOptions) {
		this.markerRendererOptions = markerRendererOptions;
		if (this.markerRendererOptions == null) {
			setMarkerRenderer(null);
		} else {
			setMarkerRenderer(this.markerRendererOptions.getRendererName());
		}
	}

	/**
	 * Canvas lineJoin style between segments of series. default round
	 *
	 * @return the lineJoin
	 */
	public LineJoin getLineJoin() {
		return lineJoin;
	}

	/**
	 * Canvas lineJoin style between segments of series. default round
	 *
	 * @param lineJoin the lineJoin to set
	 */
	public void setLineJoin(LineJoin lineJoin) {
		this.lineJoin = lineJoin;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	/**
	 * Note: this class has a natural ordering that is inconsistent with equals.
	 * See {@code ChartModel.addSeries} for a detailed explanation of why.
	 *
	 * @param s
	 * @return
	 */
	@Override
	public int compareTo(Series s) {
		return this.getComparisonIndex() - s.getComparisonIndex();
	}

	protected Integer getComparisonIndex() {
		//The simplest most common case where the series have indexes set
		//and disable stack is null or false.
		if (getIndex() != null && (getDisableStack() == null || !getDisableStack())) {
			return getIndex();
		}

		//The series doesn't have an index so at a minium it's going to have
		//the null index. This might be overidden if disable stack is set though.
		int index = NULL_INDEX;

		//If disable stack is set it trumps not having an index set so assign it
		//a larger index to push it further to the back. If there is an index
		//set try to honor it while still pushing this series to the end.
		if (getDisableStack() != null && getDisableStack()) {
			index = DISABLE_STACK;
			if (getIndex() != null) {
				index += getIndex();
			}
		}

		return index;
	}

	Set<SeriesOrderListener> getSeriesOrderListeners() {
		return seriesOrderListeners;
	}

	void setSeriesOrderListeners(Set<SeriesOrderListener> seriesOrderListeners) {
		this.seriesOrderListeners = seriesOrderListeners;
	}

	void addSeriesOrderListener(SeriesOrderListener sol) {
		this.seriesOrderListeners.add(sol);
	}

	void removeSeriesOrderListener(SeriesOrderListener sol) {
		this.seriesOrderListeners.remove(sol);
	}

	private void fireSeriesOrderEvent() {
		SeriesOrderEvent soe = new SeriesOrderEvent(this);
		for (SeriesOrderListener sol : getSeriesOrderListeners()) {
			sol.seriesOrderChanged(soe);
		}
	}
}
