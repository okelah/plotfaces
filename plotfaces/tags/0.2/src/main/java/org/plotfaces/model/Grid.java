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
package org.plotfaces.model;

import org.plotfaces.renderer.GridRenderer;

/**
 * A base class for grid settings.
 *
 * @author Graham Smith
 */
public class Grid {

	private Boolean drawGridlines;
	private String gridLineColor;
	private Double gridLineWidth;
	private String background;
	private String borderColor;
	private Double borderWidth;
	private Boolean drawBorder;
	private Boolean shadow;
	private Integer shadowAngle;
	private Double shadowOffset;
	private Double shadowWidth;
	private Double shadowDepth;
	private String shadowColor;
	private String shadowAlpha;
	private String renderer;
	private GridRenderer rendererOptions;

	public Grid() {
	}

	public Boolean getDrawGridlines() {
		return drawGridlines;
	}

	public void setDrawGridlines(Boolean drawGridlines) {
		this.drawGridlines = drawGridlines;
	}

	public String getGridLineColor() {
		return gridLineColor;
	}

	public void setGridLineColor(String gridLineColor) {
		this.gridLineColor = gridLineColor;
	}

	public Double getGridLineWidth() {
		return gridLineWidth;
	}

	public void setGridLineWidth(Double gridLineWidth) {
		this.gridLineWidth = gridLineWidth;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public Double getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(Double borderWidth) {
		this.borderWidth = borderWidth;
	}

	public Boolean getDrawBorder() {
		return drawBorder;
	}

	public void setDrawBorder(Boolean drawBorder) {
		this.drawBorder = drawBorder;
	}

	public Boolean getShadow() {
		return shadow;
	}

	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
	}

	public Integer getShadowAngle() {
		return shadowAngle;
	}

	public void setShadowAngle(Integer shadowAngle) {
		this.shadowAngle = shadowAngle;
	}

	public Double getShadowOffset() {
		return shadowOffset;
	}

	public void setShadowOffset(Double shadowOffset) {
		this.shadowOffset = shadowOffset;
	}

	public Double getShadowWidth() {
		return shadowWidth;
	}

	public void setShadowWidth(Double shadowWidth) {
		this.shadowWidth = shadowWidth;
	}

	public Double getShadowDepth() {
		return shadowDepth;
	}

	public void setShadowDepth(Double shadowDepth) {
		this.shadowDepth = shadowDepth;
	}

	public String getShadowColor() {
		return shadowColor;
	}

	public void setShadowColor(String shadowColor) {
		this.shadowColor = shadowColor;
	}

	public String getShadowAlpha() {
		return shadowAlpha;
	}

	public void setShadowAlpha(String shadowAlpha) {
		this.shadowAlpha = shadowAlpha;
	}

	protected String getRenderer() {
		return renderer;
	}

	protected void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	public GridRenderer getRendererOptions() {
		return rendererOptions;
	}

	public void setRendererOptions(GridRenderer rendererOptions) {
		this.rendererOptions = rendererOptions;
		if (this.rendererOptions == null) {
			setRenderer(null);
		} else {
			setRenderer(this.rendererOptions.getRendererName());
		}
	}
}
