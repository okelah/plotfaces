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
package org.plotfaces.renderer;

import java.util.List;

/**
 *
 * @author Graham Smith
 */
public class PieRenderer extends AbstractSeriesRenderer {

	public enum DataLabels {

		label, value, percent
	};
	private Double diameter;
	private Double padding;
	private Double sliceMargin;
	private Boolean fill;
	private Double shadowOffset;
	private Double shadowAlpha;
	private Integer shadowDepth;
	private Boolean highlightMouseOver;
	private Boolean highlightMouseDown;
	private List<String> highlightColors;
	private DataLabels dataLabels; //TODO: Doesn't support an array of labels.
	private Boolean showDataLabels;
	private String dataLabelFormatString;
	private Integer datLabelThreshold;
	private Double dataLabelPositionFactor;
	private Double dataLabelNudge;
	private Boolean dataLabelCenterOn;
	private Integer startAngle;

	public PieRenderer() {
	}

	@Override
	public String getRendererName() {
		return RENDERER_NAME_PREFIX + "PieRenderer";
	}

	public Double getDiameter() {
		return diameter;
	}

	public void setDiameter(Double diameter) {
		this.diameter = diameter;
	}

	public Double getPadding() {
		return padding;
	}

	public void setPadding(Double padding) {
		this.padding = padding;
	}

	public Double getSliceMargin() {
		return sliceMargin;
	}

	public void setSliceMargin(Double sliceMargin) {
		this.sliceMargin = sliceMargin;
	}

	public Boolean getFill() {
		return fill;
	}

	public void setFill(Boolean fill) {
		this.fill = fill;
	}

	public Double getShadowOffset() {
		return shadowOffset;
	}

	public void setShadowOffset(Double shadowOffset) {
		this.shadowOffset = shadowOffset;
	}

	public Double getShadowAlpha() {
		return shadowAlpha;
	}

	public void setShadowAlpha(Double shadowAlpha) {
		this.shadowAlpha = shadowAlpha;
	}

	public Integer getShadowDepth() {
		return shadowDepth;
	}

	public void setShadowDepth(Integer shadowDepth) {
		this.shadowDepth = shadowDepth;
	}

	public Boolean getHighlightMouseOver() {
		return highlightMouseOver;
	}

	public void setHighlightMouseOver(Boolean highlightMouseOver) {
		this.highlightMouseOver = highlightMouseOver;
	}

	public Boolean getHighlightMouseDown() {
		return highlightMouseDown;
	}

	public void setHighlightMouseDown(Boolean highlightMouseDown) {
		this.highlightMouseDown = highlightMouseDown;
	}

	public List<String> getHighlightColors() {
		return highlightColors;
	}

	public void setHighlightColors(List<String> highlightColors) {
		this.highlightColors = highlightColors;
	}

	public DataLabels getDataLabels() {
		return dataLabels;
	}

	public void setDataLabels(DataLabels dataLabels) {
		this.dataLabels = dataLabels;
	}

	public Boolean getShowDataLabels() {
		return showDataLabels;
	}

	public void setShowDataLabels(Boolean showDataLabels) {
		this.showDataLabels = showDataLabels;
	}

	public String getDataLabelFormatString() {
		return dataLabelFormatString;
	}

	public void setDataLabelFormatString(String dataLabelFormatString) {
		this.dataLabelFormatString = dataLabelFormatString;
	}

	public Integer getDatLabelThreshold() {
		return datLabelThreshold;
	}

	public void setDatLabelThreshold(Integer datLabelThreshold) {
		this.datLabelThreshold = datLabelThreshold;
	}

	public Double getDataLabelPositionFactor() {
		return dataLabelPositionFactor;
	}

	public void setDataLabelPositionFactor(Double dataLabelPositionFactor) {
		this.dataLabelPositionFactor = dataLabelPositionFactor;
	}

	public Double getDataLabelNudge() {
		return dataLabelNudge;
	}

	public void setDataLabelNudge(Double dataLabelNudge) {
		this.dataLabelNudge = dataLabelNudge;
	}

	public Boolean getDataLabelCenterOn() {
		return dataLabelCenterOn;
	}

	public void setDataLabelCenterOn(Boolean dataLabelCenterOn) {
		this.dataLabelCenterOn = dataLabelCenterOn;
	}

	public Integer getStartAngle() {
		return startAngle;
	}

	public void setStartAngle(Integer startAngle) {
		this.startAngle = startAngle;
	}
}
