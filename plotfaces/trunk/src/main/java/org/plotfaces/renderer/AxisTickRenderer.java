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
import org.apache.commons.lang3.StringUtils;
import org.plotfaces.PlotUtilities;

/**
 * Implements the settings found in AxisTickRenderer.
 *
 * @author Graham Smith
 */
public class AxisTickRenderer extends AbstractTickRenderer {

	public enum Mark {

		inside, outside, cross, nothing
	};
	private Mark mark;
	private Boolean showMark;
	private Boolean showGridline;
	private Boolean isMinorTick;
	private Integer size;
	private Integer markSize;
	private Boolean show;
	private Boolean showLabel;
//	private TickFormatter formatter;
	private String formatter;
	private TickFormatter formatterOptions;
	private String prefix;
	private String formatString;
	private String fontFamily;
	private String fontSize;
	private String textColor;
	private Boolean escapeHTML;

	@Override
	public String getRendererName() {
		return RENDERER_NAME_PREFIX + "AxisTickRenderer";
	}

	/**
	 * Tick mark on the axis. One of {@code Mark} or null. Default 'outside'
	 *
	 * @return the mark
	 */
	public Mark getMark() {
		return mark;
	}

	/**
	 * Tick mark on the axis. One of {@code Mark} or null. Default 'outside'
	 *
	 * @param mark the mark to set
	 */
	public void setMark(Mark mark) {
		this.mark = mark;
	}

	/**
	 * whether or not to show the mark on the axis. default true
	 *
	 * @return the showMark
	 */
	public Boolean getShowMark() {
		return showMark;
	}

	/**
	 * whether or not to show the mark on the axis. default true
	 *
	 * @param showMark the showMark to set
	 */
	public void setShowMark(Boolean showMark) {
		this.showMark = showMark;
	}

	/**
	 * whether or not to draw the gridline on the grid at this tick. default
	 * true
	 *
	 * @return the showGridline
	 */
	public Boolean getShowGridline() {
		return showGridline;
	}

	/**
	 * whether or not to draw the gridline on the grid at this tick. default
	 * true
	 *
	 * @param showGridline the showGridline to set
	 */
	public void setShowGridline(Boolean showGridline) {
		this.showGridline = showGridline;
	}

	/**
	 * If this is a minor tick. default false
	 *
	 * @return the isMinorTick
	 */
	public Boolean getIsMinorTick() {
		return isMinorTick;
	}

	/**
	 * If this is a minor tick. default false
	 *
	 * @param isMinorTick the isMinorTick to set
	 */
	public void setIsMinorTick(Boolean isMinorTick) {
		this.isMinorTick = isMinorTick;
	}

	/**
	 * Length of the tick beyond the grid in pixels. This setting is deprecated
	 * in jqPlot and has been superceeded by markSize. If both size and markSize
	 * are non-null only markSize is output.
	 *
	 * @return
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * Length of the tick beyond the grid in pixels. This setting is deprecated
	 * in jqPlot and has been superceeded by markSize. If both size and markSize
	 * are non-null only markSize is output.
	 *
	 * @param size
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * Length of the tick marks in pixels. For ‘cross’ style, length will be
	 * stoked above and below axis, so total length will be twice this. default
	 * 6
	 * <p>If both size and markSize are non-null only markSize is output.
	 *
	 * @return the markSize
	 */
	public Integer getMarkSize() {
		return markSize;
	}

	/**
	 * Length of the tick marks in pixels. For ‘cross’ style, length will be
	 * stoked above and below axis, so total length will be twice this. default
	 * 6
	 * <p>If both size and markSize are non-null only markSize is output.
	 *
	 * @param markSize the markSize to set
	 */
	public void setMarkSize(Integer markSize) {
		this.markSize = markSize;
	}

	/**
	 * Whether or not to show the tick (mark and label). Setting this to false
	 * requires more testing. It is recommended to set showLabel and showMark to
	 * false instead. default true
	 *
	 * @return the show
	 */
	public Boolean getShow() {
		return show;
	}

	/**
	 * Whether or not to show the tick (mark and label). Setting this to false
	 * requires more testing. It is recommended to set showLabel and showMark to
	 * false instead. default true
	 *
	 * @param show the show to set
	 */
	public void setShow(Boolean show) {
		this.show = show;
	}

	/**
	 * whether or not to show the label. default true
	 *
	 * @return the showLabel
	 */
	public Boolean getShowLabel() {
		return showLabel;
	}

	/**
	 * whether or not to show the label. default true
	 *
	 * @param showLabel the showLabel to set
	 */
	public void setShowLabel(Boolean showLabel) {
		this.showLabel = showLabel;
	}

	//	/**
	//	 * A class of a formatter for the tick text. sprintf by default.
	//	 *
	//	 * @return the formatter
	//	 */
	//	public TickFormatter getFormatter() {
	//		return formatter;
	//	}
	//
	//	/**
	//	 * A class of a formatter for the tick text. sprintf by default.
	//	 *
	//	 * @param formatter the formatter to set
	//	 */
	//	public void setFormatter(TickFormatter formatter) {
	//		this.formatter = formatter;
	//	}
	protected String getFormatter() {
		return formatter;
	}

	protected void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	/**
	 * Non-standard options for the tick formatter.
	 *
	 * @return
	 */
	public TickFormatter getFormatterOptions() {
		return formatterOptions;
	}

	/**
	 * Non-standard options for the tick formatter.
	 *
	 * @param formatterOptions
	 */
	public void setFormatterOptions(TickFormatter formatterOptions) {
		this.formatterOptions = formatterOptions;
		if (formatterOptions == null) {
			setFormatter(null);
		} else {
			setFormatter(formatterOptions.getRendererName());
		}
	}

	/**
	 * string passed to the formatter.
	 *
	 * @return the formatString
	 */
	public String getFormatString() {
		return formatString;
	}

	/**
	 * string passed to the formatter.
	 *
	 * @param formatString the formatString to set
	 */
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}

	/**
	 * String to prepend to the tick label. Prefix is prepended to the formatted
	 * tick label.
	 *
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * String to prepend to the tick label. Prefix is prepended to the formatted
	 * tick label.
	 *
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * css spec for the font-family css attribute.
	 *
	 * @return the fontFamily
	 */
	public String getFontFamily() {
		return fontFamily;
	}

	/**
	 * css spec for the font-family css attribute.
	 *
	 * @param fontFamily the fontFamily to set
	 */
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	/**
	 * css spec for the font-size css attribute.
	 *
	 * @return the fontSize
	 */
	public String getFontSize() {
		return fontSize;
	}

	/**
	 * css spec for the font-size css attribute.
	 *
	 * @param fontSize the fontSize to set
	 */
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	/**
	 * css spec for the color attribute.
	 *
	 * @return the textColor
	 */
	public String getTextColor() {
		return textColor;
	}

	/**
	 * css spec for the color attribute.
	 *
	 * @param textColor the textColor to set
	 */
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	/**
	 * Set to true to escape HTML entities in the label.
	 *
	 * @return
	 */
	public Boolean getEscapeHTML() {
		return escapeHTML;
	}

	/**
	 * Set to true to escape HTML entities in the label.
	 *
	 * @param escapeHTML
	 */
	public void setEscapeHTML(Boolean escapeHTML) {
		this.escapeHTML = escapeHTML;
	}
}
