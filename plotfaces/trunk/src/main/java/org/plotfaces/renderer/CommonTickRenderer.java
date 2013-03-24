package org.plotfaces.renderer;

import org.plotfaces.PlotUtilities;

public abstract class CommonTickRenderer extends TickRenderer {
	private String mark; 
	private Boolean showMark; 
	private Boolean showGridline; 
	private Boolean isMinorTick; 
	private Integer markSize;
	private Boolean show;  
	private Boolean showLabel; 
	private TickFormatter formatter; 
	private String formatString;
	private String prefix;  
	private String fontFamily; 
	private String fontSize; 
	private String textColor;
	
	public boolean plot( StringBuilder builder, boolean isCloseOptions ) {
		boolean isCommaRequired = super.plot( builder, false );
		if (getMark() != null) {
			isCommaRequired = PlotUtilities.addVariable( builder, "mark", getMark(), isCommaRequired, true );
		}

		isCommaRequired = PlotUtilities.addVariable( builder, "showMark", getShowMark(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "showGridline", getShowGridline(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "isMinorTick", getIsMinorTick(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "markSize", getMarkSize(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "show", getShow(), isCommaRequired );
		isCommaRequired = PlotUtilities.addVariable( builder, "showLabel", getShowLabel(), isCommaRequired );

		if (getFormatter() != null) {
			getFormatter().plot( builder );
		}

		isCommaRequired = PlotUtilities.addVariable( builder, "formatString", getFormatString(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "prefix", getPrefix(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "fontFamily", getFontFamily(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "fontSize", getFontSize(), isCommaRequired, true );
		isCommaRequired = PlotUtilities.addVariable( builder, "textColor", getTextColor(), isCommaRequired, true );
		
		if( isCloseOptions ) {
			builder.append("}");
		}
		
		return isCommaRequired;
	}
	
	/**
	 * tick mark on the axis.  One of ‘inside’, ‘outside’, ‘cross’, ‘’ or null.
	 * default 'outside'
	 * 
	 * @return the mark
	 */
	public String getMark() {
		return mark;
	}
	/**
	 * tick mark on the axis.  One of ‘inside’, ‘outside’, ‘cross’, ‘’ or null.
	 * default 'outside'
	 * 
	 * @param mark the mark to set
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
	/**
	 * whether or not to show the mark on the axis.
	 * default true
	 * 
	 * @return the showMark
	 */
	public Boolean getShowMark() {
		return showMark;
	}
	/**
	 * whether or not to show the mark on the axis.
	 * default true
	 * 
	 * @param showMark the showMark to set
	 */
	public void setShowMark(Boolean showMark) {
		this.showMark = showMark;
	}
	/**
	 * whether or not to draw the gridline on the grid at this tick.
	 * default true
	 * 
	 * @return the showGridline
	 */
	public Boolean getShowGridline() {
		return showGridline;
	}
	/**
	 * whether or not to draw the gridline on the grid at this tick.
	 * default true
	 * 
	 * @param showGridline the showGridline to set
	 */
	public void setShowGridline(Boolean showGridline) {
		this.showGridline = showGridline;
	}
	/**
	 * if this is a minor tick.
	 * default false
	 * 
	 * @return the isMinorTick
	 */
	public Boolean getIsMinorTick() {
		return isMinorTick;
	}
	/**
	 * if this is a minor tick.
	 * default false
	 * 
	 * @param isMinorTick the isMinorTick to set
	 */
	public void setIsMinorTick(Boolean isMinorTick) {
		this.isMinorTick = isMinorTick;
	}
	/**
	 * Length of the tick marks in pixels.  For ‘cross’ style, length will be stoked above and below axis, so total length will be twice this.
	 * default 6
	 * 
	 * @return the markSize
	 */
	public Integer getMarkSize() {
		return markSize;
	}
	/**
	 * Length of the tick marks in pixels.  For ‘cross’ style, length will be stoked above and below axis, so total length will be twice this.
	 * default 6
	 * 
	 * @param markSize the markSize to set
	 */
	public void setMarkSize(Integer markSize) {
		this.markSize = markSize;
	}
	/**
	 * whether or not to show the tick (mark and label).  Setting this to false requires more testing.  It is recommended to set showLabel and showMark to false instead.
	 * default true
	 * 
	 * @return the show
	 */
	public Boolean getShow() {
		return show;
	}
	/**
	 * whether or not to show the tick (mark and label).  Setting this to false requires more testing.  It is recommended to set showLabel and showMark to false instead.
	 * default true
	 * 
	 * @param show the show to set
	 */
	public void setShow(Boolean show) {
		this.show = show;
	}
	/**
	 * whether or not to show the label.
	 * default true
	 * 
	 * @return the showLabel
	 */
	public Boolean getShowLabel() {
		return showLabel;
	}
	/**
	 * whether or not to show the label.
	 * default true
	 * 
	 * @param showLabel the showLabel to set
	 */
	public void setShowLabel(Boolean showLabel) {
		this.showLabel = showLabel;
	}
	/**
	 * A class of a formatter for the tick text.  sprintf by default.
	 * 
	 * @return the formatter
	 */
	public TickFormatter getFormatter() {
		return formatter;
	}
	/**
	 * A class of a formatter for the tick text.  sprintf by default.
	 * 
	 * @param formatter the formatter to set
	 */
	public void setFormatter(TickFormatter formatter) {
		this.formatter = formatter;
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
	 * String to prepend to the tick label.  Prefix is prepended to the formatted tick label.
	 * 
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * String to prepend to the tick label.  Prefix is prepended to the formatted tick label.
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
}
