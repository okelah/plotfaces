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

/**
 *
 * @author Graham Smith
 */
public class DefaultMarkerRenderer extends AbstractMarkerRenderer {

	public enum MarkerStyle {

		diamond, circle, square, x, plus, dash, filledDiamond, filledCircle, filledSquare
	};
	private Boolean show;
	private MarkerStyle style;
	private Integer lineWidth;
	private Double size;
	private String color;
	private Boolean shadow;
	private Integer shadowAngle;
	private Integer shadowOffset;
	private Integer shadowDepth;
	private Double shadowAlpha;

	public DefaultMarkerRenderer() {
	}

	@Override
	public String getRendererName() {
		return DEFAULT_RENDERER_NAME_PREFIX + "MarkerRenderer";
	}

	/**
	 * whether or not to show the marker. default true
	 *
	 * @return the show
	 */
	public Boolean getShow() {
		return show;
	}

	/**
	 * whether or not to show the marker. default true
	 *
	 * @param show the show to set
	 */
	public void setShow(Boolean show) {
		this.show = show;
	}

	/**
	 * One of diamond, circle, square, x, plus, dash, filledDiamond,
	 * filledCircle, filledSquare default filledDiamond
	 *
	 * @return the style
	 */
	public MarkerStyle getStyle() {
		return style;
	}

	/**
	 * One of diamond, circle, square, x, plus, dash, filledDiamond,
	 * filledCircle, filledSquare default filledDiamond
	 *
	 * @param style the style to set
	 */
	public void setStyle(MarkerStyle style) {
		this.style = style;
	}

	/**
	 * size of the line for non-filled markers. default 2
	 *
	 * @return the lineWidth
	 */
	public Integer getLineWidth() {
		return lineWidth;
	}

	/**
	 * size of the line for non-filled markers. default 2
	 *
	 * @param lineWidth the lineWidth to set
	 */
	public void setLineWidth(Integer lineWidth) {
		this.lineWidth = lineWidth;
	}

	/**
	 * Size of the marker (diameter or circle, length of edge of square, etc.)
	 * default 9.0
	 *
	 * @return the size
	 */
	public Double getSize() {
		return size;
	}

	/**
	 * Size of the marker (diameter or circle, length of edge of square, etc.)
	 * default 9.0
	 *
	 * @param size the size to set
	 */
	public void setSize(Double size) {
		this.size = size;
	}

	/**
	 * color of marker. Will be set to color of series by default on init.
	 * default #666666
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * color of marker. Will be set to color of series by default on init.
	 * default #666666
	 *
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
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
	 * Shadow offset from line in pixels default 1
	 *
	 * @return the shadowOffset
	 */
	public Integer getShadowOffset() {
		return shadowOffset;
	}

	/**
	 * Shadow offset from line in pixels default 1
	 *
	 * @param shadowOffset the shadowOffset to set
	 */
	public void setShadowOffset(Integer shadowOffset) {
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
	 * Alpha channel transparency of shadow. 0 = transparent. default 0.07
	 *
	 * @return the shadowAlpha
	 */
	public Double getShadowAlpha() {
		return shadowAlpha;
	}

	/**
	 * Alpha channel transparency of shadow. 0 = transparent. default 0.07
	 *
	 * @param shadowAlpha the shadowAlpha to set
	 */
	public void setShadowAlpha(Double shadowAlpha) {
		this.shadowAlpha = shadowAlpha;
	}
}
