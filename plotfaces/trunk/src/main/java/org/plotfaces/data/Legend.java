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

import org.apache.commons.lang.StringUtils;
import org.plotfaces.PlotUtilities;

/**
 *
 * @author Graham Smith
 */
public class Legend {
	private Boolean show;
	private String location;
	private String[] labels;
	private Boolean showLabels;
	private Boolean showSwatch;
	private String placement;
	private Integer xoffset;
	private Integer yoffset;
	private String border;
	private String background;
	private String textColor;
	private String fontFamily;
	private String fontSize;
	private String rowSpacing;
	private String[] rendererOptions;
	private Boolean predraw;
	private String marginTop;
	private String marginRight;
	private String marginBottom;
	private String marginLeft;


	public String plot() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		boolean isCommaRequired = false; 

		isCommaRequired = PlotUtilities.addVariable( builder, "show", getShow(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "location", getLocation(), isCommaRequired, true );

		if (getLabels() != null && getLabels().length > 0 ) {
			isCommaRequired = PlotUtilities.addVariable( builder, "labels", "{'" + StringUtils.join( getLabels(), "','" ) + "'}", isCommaRequired, false );
		} 

		isCommaRequired = PlotUtilities.addVariable( builder, "showLabels", getShowLabels(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "showSwatch", getShowSwatch(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "placement", getPlacement(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "xoffset", getXoffset(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "yoffset", getYoffset(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "border", getBorder(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "background", getBackground(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "textColor", getTextColor(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "fontFamily", getFontFamily(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "fontSize", getFontSize(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "rowSpacing", getRowSpacing(), isCommaRequired, true );
		if( getRendererOptions() != null && getRendererOptions().length > 0 ) {
			isCommaRequired = PlotUtilities.addVariable( builder, "rendererOptions", "{'" + StringUtils.join( getRendererOptions(), "','" ) + "'}", isCommaRequired, false );
		}
		isCommaRequired = PlotUtilities.addVariable( builder, "predraw", getPredraw(), isCommaRequired);
		isCommaRequired = PlotUtilities.addVariable( builder, "marginTop", getMarginTop(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "marginRight", getMarginRight(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "marginBottom", getMarginBottom(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "marginLeft", getMarginLeft(), isCommaRequired, true );
		
		builder.append("\n}");
		return builder.toString();
	}
	
	/**
	 * Whether to display the legend on the graph.
	 * default false
	 * 
	 * @return the show
	 */
	public Boolean getShow() {
		return show;
	}
	
	/**
	 * Whether to display the legend on the graph.
	 * default false
	 * 
	 * @param show the show to set
	 */
	public void setShow(Boolean show) {
		this.show = show;
	}
	
	/**
	 * Placement of the legend.  one of the compass directions: nw, n, ne, e, se, s, sw, w
	 * default 'ne'
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Placement of the legend.  one of the compass directions: nw, n, ne, e, se, s, sw, w
	 * default 'ne'
	 * 
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Array of labels to use.  By default the renderer will look for labels on the series.  Labels specified in this array will override labels specified on the series.
	 * default null
	 * 
	 * @return the labels
	 */
	public String[] getLabels() {
		return labels;
	}
	
	/**
	 * Array of labels to use.  By default the renderer will look for labels on the series.  Labels specified in this array will override labels specified on the series.
	 * default null
	 * 
	 * @param labels the labels to set
	 */
	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	
	/**
	 * true to show the label text on the legend.
	 * default true
	 * 
	 * @return the showLabels
	 */
	public Boolean getShowLabels() {
		return showLabels;
	}
	
	/**
	 * true to show the label text on the legend.
	 * default true
	 * 
	 * @param showLabels the showLabels to set
	 */
	public void setShowLabels(Boolean showLabels) {
		this.showLabels = showLabels;
	}
	
	/**
	 * true to show the color swatches on the legend.
	 * default true
	 * 
	 * @return the showSwatch
	 */
	public Boolean getShowSwatch() {
		return showSwatch;
	}

	/**
	 * true to show the color swatches on the legend.
	 * default true
	 * 
	 * @param showSwatch the showSwatch to set
	 */
	public void setShowSwatch(Boolean showSwatch) {
		this.showSwatch = showSwatch;
	}

	/**
	 * ”insideGrid” places legend inside the grid area of the plot.  “outsideGrid” places the legend outside the grid but inside the plot container, shrinking the grid to accomodate the legend.  “inside” synonym for “insideGrid”, “outside” places the legend ouside the grid area, but does not shrink the grid which can cause the legend to overflow the plot container.
	 * default 'outsideGrid'
	 * 
	 * @return the placement
	 */
	public String getPlacement() {
		return placement;
	}
	
	/**
	 * ”insideGrid” places legend inside the grid area of the plot.  “outsideGrid” places the legend outside the grid but inside the plot container, shrinking the grid to accomodate the legend.  “inside” synonym for “insideGrid”, “outside” places the legend ouside the grid area, but does not shrink the grid which can cause the legend to overflow the plot container.
	 * default 'outsideGrid'
	 *
	 * @param placement the placement to set
	 */
	public void setPlacement(String placement) {
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
	 * DEPRECATED.  Set the margins on the legend using the marginTop, marginLeft, etc. properties or via CSS margin styling of the .jqplot-table-legend class.
	 * default 0
	 * 
	 * @return the yoffset
	 */
	public Integer getYoffset() {
		return yoffset;
	}
	
	/**
	 * DEPRECATED.  Set the margins on the legend using the marginTop, marginLeft, etc. properties or via CSS margin styling of the .jqplot-table-legend class.
	 * default 0
	 * 
	 * @param yoffset the yoffset to set
	 */
	public void setYoffset(Integer yoffset) {
		this.yoffset = yoffset;
	}
	
	/**
	 * css spec for the border around the legend box.
	 * default null
	 * 
	 * @return the border
	 */
	public String getBorder() {
		return border;
	}
	
	/**
	 * css spec for the border around the legend box.
	 * default null
	 * 
	 * @param border the border to set
	 */
	public void setBorder(String border) {
		this.border = border;
	}
	
	/**
	 * css spec for the background of the legend box.
	 * default null
	 * 
	 * @return the background
	 */
	public String getBackground() {
		return background;
	}
	
	/**
	 * css spec for the background of the legend box.
	 * default null
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
	 * css color spec for the legend text.
	 * 
	 * @param textColor the textColor to set
	 */
	public void setTextColor(String textColor) {
		this.textColor = textColor;
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
	 * css padding-top spec for the rows in the legend.
	 * default 0.5em
	 * 
	 * @return the rowSpacing
	 */
	public String getRowSpacing() {
		return rowSpacing;
	}
	
	/**
	 * css padding-top spec for the rows in the legend.
	 * default 0.5em
	 * 
	 * @param rowSpacing the rowSpacing to set
	 */
	public void setRowSpacing(String rowSpacing) {
		this.rowSpacing = rowSpacing;
	}
	
	/**
	 * renderer specific options passed to the renderer.
	 * 
	 * @return the rendererOptions
	 */
	public String[] getRendererOptions() {
		return rendererOptions;
	}
	
	/**
	 * renderer specific options passed to the renderer.
	 * 
	 * @param rendererOptions the rendererOptions to set
	 */
	public void setRendererOptions(String[] rendererOptions) {
		this.rendererOptions = rendererOptions;
	}
	
	/**
	 * Whether to draw the legend before the series or not.  Used with series specific legend renderers for pie, donut, mekko charts, etc.
	 * 
	 * @return the predraw
	 */
	public Boolean getPredraw() {
		return predraw;
	}
	
	/**
	 * Whether to draw the legend before the series or not.  Used with series specific legend renderers for pie, donut, mekko charts, etc.
	 * 
	 * @param predraw the predraw to set
	 */
	public void setPredraw(Boolean predraw) {
		this.predraw = predraw;
	}
	
	/**
	 * CSS margin for the legend DOM element.  This will set an element CSS style for the margin which will override any style sheet setting.  The default will be taken from the stylesheet.
	 * 
	 * @return the marginTop
	 */
	public String getMarginTop() {
		return marginTop;
	}
	
	/**
	 * CSS margin for the legend DOM element.  This will set an element CSS style for the margin which will override any style sheet setting.  The default will be taken from the stylesheet.
	 * 
	 * @param marginTop the marginTop to set
	 */
	public void setMarginTop(String marginTop) {
		this.marginTop = marginTop;
	}
	
	/**
	 * CSS margin for the legend DOM element.  This will set an element CSS style for the margin which will override any style sheet setting.  The default will be taken from the stylesheet.
	 * 
	 * @return the marginRight
	 */
	public String getMarginRight() {
		return marginRight;
	}
	
	/**
	 * CSS margin for the legend DOM element.  This will set an element CSS style for the margin which will override any style sheet setting.  The default will be taken from the stylesheet.
	 * 
	 * @param marginRight the marginRight to set
	 */
	public void setMarginRight(String marginRight) {
		this.marginRight = marginRight;
	}
	
	/**
	 * CSS margin for the legend DOM element.  This will set an element CSS style for the margin which will override any style sheet setting.  The default will be taken from the stylesheet.
	 * 
	 * @return the marginBottom
	 */
	public String getMarginBottom() {
		return marginBottom;
	}
	
	/**
	 * CSS margin for the legend DOM element.  This will set an element CSS style for the margin which will override any style sheet setting.  The default will be taken from the stylesheet.
	 * 
	 * @param marginBottom the marginBottom to set
	 */
	public void setMarginBottom(String marginBottom) {
		this.marginBottom = marginBottom;
	}
	
	/**
	 * CSS margin for the legend DOM element.  This will set an element CSS style for the margin which will override any style sheet setting.  The default will be taken from the stylesheet.
	 * 
	 * @return the marginLeft
	 */
	public String getMarginLeft() {
		return marginLeft;
	}
	
	/**
	 * CSS margin for the legend DOM element.  This will set an element CSS style for the margin which will override any style sheet setting.  The default will be taken from the stylesheet.
	 * 
	 * @param marginLeft the marginLeft to set
	 */
	public void setMarginLeft(String marginLeft) {
		this.marginLeft = marginLeft;
	}
	
	
}
