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

import java.util.ArrayList;
import java.util.List;
import org.plotfaces.PlotUtilities;

public class BarRenderer extends AbstractSeriesRenderer {

	private Integer padding;
	private Integer barMargin;
	private String barDirection;
	private Integer barWidth;
	private Integer shadowOffset;
	private Integer shadowDepth;
	private Double shadowAlpha;
	private Boolean waterfall;
	private Integer groups;
	private Boolean varyByColor;

	public BarRenderer() {
	}

	@Override
	protected List<String> getFragments() {
		List<String> fragments = new ArrayList<>();


		return fragments;
	}

	@Override
	public String getRendererName() {
		return "BarRenderer";
	}

	/**
	 * Number of pixels between adjacent bars at the same axis value. default 8
	 *
	 * @return the padding
	 */
	public Integer getPadding() {
		return padding;
	}

	/**
	 * Number of pixels between adjacent bars at the same axis value. default 8
	 *
	 * @param padding the padding to set
	 */
	public void setPadding(Integer padding) {
		this.padding = padding;
	}

	/**
	 * Number of pixels between groups of bars at adjacent axis values. default
	 * 10
	 *
	 * @return the barMargin
	 */
	public Integer getBarMargin() {
		return barMargin;
	}

	/**
	 * Number of pixels between groups of bars at adjacent axis values. default
	 * 10
	 *
	 * @param barMargin the barMargin to set
	 */
	public void setBarMargin(Integer barMargin) {
		this.barMargin = barMargin;
	}

	/**
	 * ’vertical’ = up and down bars, ‘horizontal’ = side to side bars default
	 * 'vertical'
	 *
	 * @return the barDirection
	 */
	public String getBarDirection() {
		return barDirection;
	}

	/**
	 * ’vertical’ = up and down bars, ‘horizontal’ = side to side bars default
	 * 'vertical'
	 *
	 * @param barDirection the barDirection to set
	 */
	public void setBarDirection(String barDirection) {
		this.barDirection = barDirection;
	}

	/**
	 * Width of the bar in pixels (auto by devaul). null = calculated
	 * automatically.
	 *
	 * @return the barWidth
	 */
	public Integer getBarWidth() {
		return barWidth;
	}

	/**
	 * Width of the bar in pixels (auto by devaul). null = calculated
	 * automatically.
	 *
	 * @param barWidth the barWidth to set
	 */
	public void setBarWidth(Integer barWidth) {
		this.barWidth = barWidth;
	}

	/**
	 * offset of the shadow from the slice and offset of each succesive stroke
	 * of the shadow from the last. default 2
	 *
	 * @return the shadowOffset
	 */
	public Integer getShadowOffset() {
		return shadowOffset;
	}

	/**
	 * offset of the shadow from the slice and offset of each succesive stroke
	 * of the shadow from the last. default 2
	 *
	 * @param shadowOffset the shadowOffset to set
	 */
	public void setShadowOffset(Integer shadowOffset) {
		this.shadowOffset = shadowOffset;
	}

	/**
	 * number of strokes to apply to the shadow, each stroke offset shadowOffset
	 * from the last. default 5
	 *
	 * @return the shadowDepth
	 */
	public Integer getShadowDepth() {
		return shadowDepth;
	}

	/**
	 * number of strokes to apply to the shadow, each stroke offset shadowOffset
	 * from the last. default 5
	 *
	 * @param shadowDepth the shadowDepth to set
	 */
	public void setShadowDepth(Integer shadowDepth) {
		this.shadowDepth = shadowDepth;
	}

	/**
	 * transparency of the shadow (0 = transparent, 1 = opaque) default 0.08
	 *
	 * @return the shadowAlpha
	 */
	public Double getShadowAlpha() {
		return shadowAlpha;
	}

	/**
	 * transparency of the shadow (0 = transparent, 1 = opaque) default 0.08
	 *
	 * @param shadowAlpha the shadowAlpha to set
	 */
	public void setShadowAlpha(Double shadowAlpha) {
		this.shadowAlpha = shadowAlpha;
	}

	/**
	 * true to enable waterfall plot. default false
	 *
	 * @return the waterfall
	 */
	public Boolean getWaterfall() {
		return waterfall;
	}

	/**
	 * true to enable waterfall plot. default false
	 *
	 * @param waterfall the waterfall to set
	 */
	public void setWaterfall(Boolean waterfall) {
		this.waterfall = waterfall;
	}

	/**
	 * group bars into this many groups default 1
	 *
	 * @return the groups
	 */
	public Integer getGroups() {
		return groups;
	}

	/**
	 * group bars into this many groups default 1
	 *
	 * @param groups the groups to set
	 */
	public void setGroups(Integer groups) {
		this.groups = groups;
	}

	/**
	 * true to color each bar of a series separately rather than have every bar
	 * of a given series the same color. If used for non-stacked multiple series
	 * bar plots, user should specify a separate ‘seriesColors’ array for each
	 * series. Otherwise, each series will set their bars to the same color
	 * array. This option has no Effect for stacked bar charts and is disabled.
	 * default false
	 *
	 * @return the varyByColor
	 */
	public Boolean getVaryByColor() {
		return varyByColor;
	}

	/**
	 * true to color each bar of a series separately rather than have every bar
	 * of a given series the same color. If used for non-stacked multiple series
	 * bar plots, user should specify a separate ‘seriesColors’ array for each
	 * series. Otherwise, each series will set their bars to the same color
	 * array. This option has no Effect for stacked bar charts and is disabled.
	 * default false
	 *
	 * @param varyByColor the varyByColor to set
	 */
	public void setVaryByColor(Boolean varyByColor) {
		this.varyByColor = varyByColor;
	}
}
