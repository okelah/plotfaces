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
package org.plotfaces.model;

import java.util.List;
import org.plotfaces.PlotUtilities;
import org.plotfaces.renderer.LegendRenderer;

/**
 *
 * @author Graham Smith
 */
public class Legend {

	public enum Placement {

		insideGrid, outsideGrid, inside, outside
	};

	public enum Location {

		nw, n, ne, e, se, s, sw, w
	};
	private Boolean show;
	private Location location;
	private List<String> labels;
	private Boolean showLabels;
	private Boolean showSwatches;
	private Placement placement;
	private Integer xoffset;
	private Integer yoffset;
	private String border;
	private String background;
	private String textColor;
	private String fontFamily;
	private String fontSize;
	private String rowSpacing;
	private String renderer;
	private LegendRenderer rendererOptions;
	private Boolean predraw;
	private String marginTop;
	private String marginRight;
	private String marginBottom;
	private String marginLeft;
	private Boolean escapeHTML;

	public Legend() {
	}

	/**
	 * Whether to display the legend on the graph. default false
	 *
	 * @return the show
	 */
	public Boolean getShow() {
		return show;
	}

	/**
	 * Whether to display the legend on the graph. default false
	 *
	 * @param show the show to set
	 */
	public void setShow(Boolean show) {
		this.show = show;
	}

	/**
	 * Placement of the legend. one of the compass directions: nw, n, ne, e, se,
	 * s, sw, w default 'ne'
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Placement of the legend. one of the compass directions: nw, n, ne, e, se,
	 * s, sw, w default 'ne'
	 *
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Array of labels to use. By default the renderer will look for labels on
	 * the series. Labels specified in this array will override labels specified
	 * on the series. default null
	 *
	 * @return the labels
	 */
	public List<String> getLabels() {
		return labels;
	}

	/**
	 * Array of labels to use. By default the renderer will look for labels on
	 * the series. Labels specified in this array will override labels specified
	 * on the series. default null
	 *
	 * @param labels the labels to set
	 */
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	/**
	 * true to show the label text on the legend. default true
	 *
	 * @return the showLabels
	 */
	public Boolean getShowLabels() {
		return showLabels;
	}

	/**
	 * true to show the label text on the legend. default true
	 *
	 * @param showLabels the showLabels to set
	 */
	public void setShowLabels(Boolean showLabels) {
		this.showLabels = showLabels;
	}

	/**
	 * true to show the color swatches on the legend. default true
	 *
	 * @return the showSwatch
	 */
	public Boolean getShowSwatches() {
		return showSwatches;
	}

	/**
	 * true to show the color swatches on the legend. default true
	 *
	 * @param showSwatch the showSwatch to set
	 */
	public void setShowSwatches(Boolean showSwatches) {
		this.showSwatches = showSwatches;
	}

	/**
	 * ”insideGrid” places legend inside the grid area of the plot.
	 * “outsideGrid” places the legend outside the grid but inside the plot
	 * container, shrinking the grid to accomodate the legend. “inside” synonym
	 * for “insideGrid”, “outside” places the legend ouside the grid area, but
	 * does not shrink the grid which can cause the legend to overflow the plot
	 * container. default 'outsideGrid'
	 *
	 * @return the placement
	 */
	public Placement getPlacement() {
		return placement;
	}

	/**
	 * ”insideGrid” places legend inside the grid area of the plot.
	 * “outsideGrid” places the legend outside the grid but inside the plot
	 * container, shrinking the grid to accomodate the legend. “inside” synonym
	 * for “insideGrid”, “outside” places the legend ouside the grid area, but
	 * does not shrink the grid which can cause the legend to overflow the plot
	 * container. default 'outsideGrid'
	 *
	 * @param placement the placement to set
	 */
	public void setPlacement(Placement placement) {
		this.placement = placement;
	}

	/**
	 * @return the xoffset
	 */
	public Integer getXoffset() {
		return xoffset;
	}

	/**
	 * @param xoffset the xoffset to set
	 */
	public void setXoffset(Integer xoffset) {
		this.xoffset = xoffset;
	}

	/**
	 * DEPRECATED. Set the margins on the legend using the marginTop,
	 * marginLeft, etc. properties or via CSS margin styling of the
	 * .jqplot-table-legend class. default 0
	 *
	 * @return the yoffset
	 */
	public Integer getYoffset() {
		return yoffset;
	}

	/**
	 * DEPRECATED. Set the margins on the legend using the marginTop,
	 * marginLeft, etc. properties or via CSS margin styling of the
	 * .jqplot-table-legend class. default 0
	 *
	 * @param yoffset the yoffset to set
	 */
	public void setYoffset(Integer yoffset) {
		this.yoffset = yoffset;
	}

	/**
	 * css spec for the border around the legend box. default null
	 *
	 * @return the border
	 */
	public String getBorder() {
		return border;
	}

	/**
	 * css spec for the border around the legend box. default null
	 *
	 * @param border the border to set
	 */
	public void setBorder(String border) {
		this.border = border;
	}

	/**
	 * css spec for the background of the legend box. default null
	 *
	 * @return the background
	 */
	public String getBackground() {
		return background;
	}

	/**
	 * css spec for the background of the legend box. default null
	 *
	 * @param background the background to set
	 */
	public void setBackground(String background) {
		this.background = background;
	}

	/**
	 * css color spec for the legend text.
	 *
	 * @return the textColor
	 */
	public String getTextColor() {
		return textColor;
	}

	/**
	 * CSS color spec for the legend text. Note: uses the
	 * {@code PlotUtilities.fixColor} method.
	 *
	 * @param textColor the textColor to set
	 */
	public void setTextColor(String textColor) {
		this.textColor = PlotUtilities.fixColor(textColor);

	}

	/**
	 * css font-family spec for the legend text.
	 *
	 * @return the fontFamily
	 */
	public String getFontFamily() {
		return fontFamily;
	}

	/**
	 * css font-family spec for the legend text.
	 *
	 * @param fontFamily the fontFamily to set
	 */
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	/**
	 * css font-size spec for the legend text.
	 *
	 * @return the fontSize
	 */
	public String getFontSize() {
		return fontSize;
	}

	/**
	 * css font-size spec for the legend text.
	 *
	 * @param fontSize the fontSize to set
	 */
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	/**
	 * css padding-top spec for the rows in the legend. default 0.5em
	 *
	 * @return the rowSpacing
	 */
	public String getRowSpacing() {
		return rowSpacing;
	}

	/**
	 * css padding-top spec for the rows in the legend. default 0.5em
	 *
	 * @param rowSpacing the rowSpacing to set
	 */
	public void setRowSpacing(String rowSpacing) {
		this.rowSpacing = rowSpacing;
	}

	protected String getRenderer() {
		return renderer;
	}

	protected void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	/**
	 * renderer specific options passed to the renderer.
	 *
	 * @return the rendererOptions
	 */
	public LegendRenderer getRendererOptions() {
		return rendererOptions;
	}

	/**
	 * renderer specific options passed to the renderer.
	 *
	 * @param rendererOptions the rendererOptions to set
	 */
	public void setRendererOptions(LegendRenderer rendererOptions) {
		this.rendererOptions = rendererOptions;
		if (this.rendererOptions == null) {
			setRenderer(null);
		} else {
			setRenderer(this.rendererOptions.getRendererName());
		}
	}

	/**
	 * Whether to draw the legend before the series or not. Used with series
	 * specific legend renderers for pie, donut, mekko charts, etc.
	 *
	 * @return the predraw
	 */
	public Boolean getPredraw() {
		return predraw;
	}

	/**
	 * Whether to draw the legend before the series or not. Used with series
	 * specific legend renderers for pie, donut, mekko charts, etc.
	 *
	 * @param predraw the predraw to set
	 */
	public void setPredraw(Boolean predraw) {
		this.predraw = predraw;
	}

	/**
	 * CSS margin for the legend DOM element. This will set an element CSS style
	 * for the margin which will override any style sheet setting. The default
	 * will be taken from the stylesheet.
	 *
	 * @return the marginTop
	 */
	public String getMarginTop() {
		return marginTop;
	}

	/**
	 * CSS margin for the legend DOM element. This will set an element CSS style
	 * for the margin which will override any style sheet setting. The default
	 * will be taken from the stylesheet.
	 *
	 * @param marginTop the marginTop to set
	 */
	public void setMarginTop(String marginTop) {
		this.marginTop = marginTop;
	}

	/**
	 * CSS margin for the legend DOM element. This will set an element CSS style
	 * for the margin which will override any style sheet setting. The default
	 * will be taken from the stylesheet.
	 *
	 * @return the marginRight
	 */
	public String getMarginRight() {
		return marginRight;
	}

	/**
	 * CSS margin for the legend DOM element. This will set an element CSS style
	 * for the margin which will override any style sheet setting. The default
	 * will be taken from the stylesheet.
	 *
	 * @param marginRight the marginRight to set
	 */
	public void setMarginRight(String marginRight) {
		this.marginRight = marginRight;
	}

	/**
	 * CSS margin for the legend DOM element. This will set an element CSS style
	 * for the margin which will override any style sheet setting. The default
	 * will be taken from the stylesheet.
	 *
	 * @return the marginBottom
	 */
	public String getMarginBottom() {
		return marginBottom;
	}

	/**
	 * CSS margin for the legend DOM element. This will set an element CSS style
	 * for the margin which will override any style sheet setting. The default
	 * will be taken from the stylesheet.
	 *
	 * @param marginBottom the marginBottom to set
	 */
	public void setMarginBottom(String marginBottom) {
		this.marginBottom = marginBottom;
	}

	/**
	 * CSS margin for the legend DOM element. This will set an element CSS style
	 * for the margin which will override any style sheet setting. The default
	 * will be taken from the stylesheet.
	 *
	 * @return the marginLeft
	 */
	public String getMarginLeft() {
		return marginLeft;
	}

	/**
	 * CSS margin for the legend DOM element. This will set an element CSS style
	 * for the margin which will override any style sheet setting. The default
	 * will be taken from the stylesheet.
	 *
	 * @param marginLeft the marginLeft to set
	 */
	public void setMarginLeft(String marginLeft) {
		this.marginLeft = marginLeft;
	}

	public Boolean getEscapeHTML() {
		return escapeHTML;
	}

	public void setEscapeHTML(Boolean escapeHTML) {
		this.escapeHTML = escapeHTML;
	}
}
