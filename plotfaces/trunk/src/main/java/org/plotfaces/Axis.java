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
package org.plotfaces;

import java.io.IOException;

/**
 * Display options for an axis. An axis must be given a name from the AxisName enum. All options
 * are optional, a value of null (or and empty string for string options) indicates that the
 * default value given by jqPlot should be used. The only exception to these rules is the show
 * option which is defaulted to true (displayed) if not specified explicitely.
 *
 * @author Graham Smith
 */
public class Axis implements Plotable {

	public static enum AxisName {

		axisDefaults, xaxis, x2axis, yaxis, y2axis, y3axis, y4axis, y5axis, y6axis, y7axis, y8axis, y9axis;
	}
	private AxisName axisName;
	private Boolean show;
	private String tickRenderer;
	//TODO: Should be a class e.g. AxisTickRendererOptions
	private String tickOptions;
	private String labelRenderer;
	//TODO: Should be a class e.g. AxisLabelRendererOptions
	private String labelOptions;
	private String label;
	private Boolean showLabel;
	private Number min;
	private Number max;
	private Boolean autoScale;
	private Double pad;
	private Double padMax;
	private Double padMin;
	//TODO: Should probably be a class that can hold one or two dimensional arrays.
	private String ticks;
	private Integer numberTicks;
	private Integer tickInterval;
	private String renderer;
	private String rendererOptions;
	private Boolean showTicks;
	private Boolean showTickMarks;
	private Boolean showMinorTicks;
	private Boolean useSeriesColor;
	private Integer borderWidth;
	//TODO: Could probabl be a class.
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
		builder.append(getAxisName().name());
		builder.append(":{\n");

		if( getShow() == null ) {
			builder.append("show: true");
		} else {
			builder.append("show: ");
			builder.append(getShow().toString());
		}

		if (getTickRenderer() != null && !getTickRenderer().isEmpty()) {
			builder.append(",\ntickRender: ");
			builder.append(getTickRenderer());
		}

		if (getTickOptions() != null && !getTickOptions().isEmpty()) {
			builder.append(",\ntickOptions: ");
			builder.append(getTickOptions());
		}

		if (getLabelRenderer() != null && !getLabelRenderer().isEmpty()) {
			builder.append(",\nlabelRender: ");
			builder.append(getTickRenderer());
		}

		if (getLabelOptions() != null && !getLabelOptions().isEmpty()) {
			builder.append(",\nlabelOptions: ");
			builder.append(getLabelOptions());
		}

		if (getLabel() != null && !getLabel().isEmpty()) {
			builder.append(",\nlabel: '");
			builder.append(getLabel());
			builder.append("'");
		}

		if (getShowLabel() != null) {
			builder.append(",\nshowLabel: ");
			builder.append(getShowLabel().toString());
		}

		if (getMin() != null) {
			builder.append(",\nmin: ");
			builder.append(getMin().toString());
		}

		if (getMax() != null) {
			builder.append(",\nmax: ");
			builder.append(getMax().toString());
		}
		
		if( getAutoScale() != null ) {
			builder.append(",\nautoscale: ");
			builder.append(getAutoScale().toString());
		}
		
		if( getPad() != null ) {
			builder.append( ",\npad: " );
			builder.append( getPad().toString() );
		}
		
		if( getPadMin() != null ) {
			builder.append( ",\npadMin: " );
			builder.append( getPadMin().toString() );
		}
		
		if( getPadMax() != null ) {
			builder.append( ",\npadMax: " );
			builder.append( getPadMax().toString() );
		}
		
		if (getTicks() != null && !getTicks().isEmpty()) {
			builder.append(",\nticks: ");
			builder.append(getTicks());
		}
		
		if( getNumberTicks() != null ) {
			builder.append( ",\nnumberTicks: " );
			builder.append( getNumberTicks().toString() );
		}

		if (getShowTicks() != null) {
			builder.append(",\nshowTicks: ");
			builder.append(getShowTicks().toString());
		}

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

	public Boolean getAutoScale() {
		return autoScale;
	}

	public void setAutoScale(Boolean autoScale) {
		this.autoScale = autoScale;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public Integer getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(Integer borderWidth) {
		this.borderWidth = borderWidth;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelOptions() {
		return labelOptions;
	}

	public void setLabelOptions(String labelOptions) {
		this.labelOptions = labelOptions;
	}

	public String getLabelRenderer() {
		return labelRenderer;
	}

	public void setLabelRenderer(String labelRenderer) {
		this.labelRenderer = labelRenderer;
	}

	public Number getMax() {
		return max;
	}

	public void setMax(Number max) {
		this.max = max;
	}

	public Number getMin() {
		return min;
	}

	public void setMin(Number min) {
		this.min = min;
	}

	public Integer getNumberTicks() {
		return numberTicks;
	}

	public void setNumberTicks(Integer numberTicks) {
		this.numberTicks = numberTicks;
	}

	public Double getPad() {
		return pad;
	}

	public void setPad(Double pad) {
		this.pad = pad;
	}

	public Double getPadMax() {
		return padMax;
	}

	public void setPadMax(Double padMax) {
		this.padMax = padMax;
	}

	public Double getPadMin() {
		return padMin;
	}

	public void setPadMin(Double padMin) {
		this.padMin = padMin;
	}

	public String getRenderer() {
		return renderer;
	}

	public void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	public String getRendererOptions() {
		return rendererOptions;
	}

	public void setRendererOptions(String rendererOptions) {
		this.rendererOptions = rendererOptions;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public Boolean getShowLabel() {
		return showLabel;
	}

	public void setShowLabel(Boolean showLabel) {
		this.showLabel = showLabel;
	}

	public Boolean getShowMinorTicks() {
		return showMinorTicks;
	}

	public void setShowMinorTicks(Boolean showMinorTicks) {
		this.showMinorTicks = showMinorTicks;
	}

	public Boolean getShowTickMarks() {
		return showTickMarks;
	}

	public void setShowTickMarks(Boolean showTickMarks) {
		this.showTickMarks = showTickMarks;
	}

	public Boolean getShowTicks() {
		return showTicks;
	}

	public void setShowTicks(Boolean showTicks) {
		this.showTicks = showTicks;
	}

	public Boolean getSyncTicks() {
		return syncTicks;
	}

	public void setSyncTicks(Boolean syncTicks) {
		this.syncTicks = syncTicks;
	}

	public Integer getTickInterval() {
		return tickInterval;
	}

	public void setTickInterval(Integer tickInterval) {
		this.tickInterval = tickInterval;
	}

	public String getTickOptions() {
		return tickOptions;
	}

	public void setTickOptions(String tickOptions) {
		this.tickOptions = tickOptions;
	}

	public String getTickRenderer() {
		return tickRenderer;
	}

	public void setTickRenderer(String tickRenderer) {
		this.tickRenderer = tickRenderer;
	}

	public Integer getTickSpacing() {
		return tickSpacing;
	}

	public void setTickSpacing(Integer tickSpacing) {
		this.tickSpacing = tickSpacing;
	}

	public String getTicks() {
		return ticks;
	}

	public void setTicks(String ticks) {
		this.ticks = ticks;
	}

	public Boolean getUseSeriesColor() {
		return useSeriesColor;
	}

	public void setUseSeriesColor(Boolean useSeriesColor) {
		this.useSeriesColor = useSeriesColor;
	}
}
