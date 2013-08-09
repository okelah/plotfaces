/*
 * Copyright 2013 Graham Smith.
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
package org.plotfaces.renderer.overlay;

import org.plotfaces.model.Axis.AxisName;

/**
 *
 * @author Graham Smith
 */
public abstract class AbstractLine implements CanvasOverlayRenderer {

	public enum LineCap {

		round, butt, square
	};

	public enum TooltipLocation {

		n, ne, e, se, s, sw, w, nw
	}

	public enum TooltipFadeSpeed {

		slow, def, fast
	}
	private String name;
	private Boolean show;
	private Double lineWidth;
	private LineCap lineCap;
	private String color;
	private Boolean shadow;
	private Double shadowAngle;
	private Double shadowOffset;
	private Integer shadowDepth;
	private Double shadowAlpha;
	private AxisName xaxis;
	private AxisName yaxis;
	private Boolean showTooltip;
	private Double showTooltipPrecision;
	private TooltipLocation tooltipLocation;
	private Boolean fadeTooltip;
	private TooltipFadeSpeed tooltipFadeSpeed;
	private Double tooltipOffset;
	private String tooltipFormatString;

	public AbstractLine() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public Double getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(Double lineWidth) {
		this.lineWidth = lineWidth;
	}

	public LineCap getLineCap() {
		return lineCap;
	}

	public void setLineCap(LineCap lineCap) {
		this.lineCap = lineCap;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getShadow() {
		return shadow;
	}

	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
	}

	public Double getShadowAngle() {
		return shadowAngle;
	}

	public void setShadowAngle(Double shadowAngle) {
		this.shadowAngle = shadowAngle;
	}

	public Double getShadowOffset() {
		return shadowOffset;
	}

	public void setShadowOffset(Double shadowOffset) {
		this.shadowOffset = shadowOffset;
	}

	public Integer getShadowDepth() {
		return shadowDepth;
	}

	public void setShadowDepth(Integer shadowDepth) {
		this.shadowDepth = shadowDepth;
	}

	public Double getShadowAlpha() {
		return shadowAlpha;
	}

	public void setShadowAlpha(Double shadowAlpha) {
		this.shadowAlpha = shadowAlpha;
	}

	public AxisName getXaxis() {
		return xaxis;
	}

	public void setXaxis(AxisName xaxis) {
		this.xaxis = xaxis;
	}

	public AxisName getYaxis() {
		return yaxis;
	}

	public void setYaxis(AxisName yaxis) {
		this.yaxis = yaxis;
	}

	public Boolean getShowTooltip() {
		return showTooltip;
	}

	public void setShowTooltip(Boolean showTooltip) {
		this.showTooltip = showTooltip;
	}

	public Double getShowTooltipPrecision() {
		return showTooltipPrecision;
	}

	public void setShowTooltipPrecision(Double showTooltipPrecision) {
		this.showTooltipPrecision = showTooltipPrecision;
	}

	public TooltipLocation getTooltipLocation() {
		return tooltipLocation;
	}

	public void setTooltipLocation(TooltipLocation tooltipLocation) {
		this.tooltipLocation = tooltipLocation;
	}

	public Boolean getFadeTooltip() {
		return fadeTooltip;
	}

	public void setFadeTooltip(Boolean fadeTooltip) {
		this.fadeTooltip = fadeTooltip;
	}

	public TooltipFadeSpeed getTooltipFadeSpeed() {
		return tooltipFadeSpeed;
	}

	public void setTooltipFadeSpeed(TooltipFadeSpeed tooltipFadeSpeed) {
		this.tooltipFadeSpeed = tooltipFadeSpeed;
	}

	public Double getTooltipOffset() {
		return tooltipOffset;
	}

	public void setTooltipOffset(Double tooltipOffset) {
		this.tooltipOffset = tooltipOffset;
	}

	public String getTooltipFormatString() {
		return tooltipFormatString;
	}

	public void setTooltipFormatString(String tooltipFormatString) {
		this.tooltipFormatString = tooltipFormatString;
	}
}
