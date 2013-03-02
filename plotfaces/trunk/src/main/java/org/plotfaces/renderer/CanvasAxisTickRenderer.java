package org.plotfaces.renderer;

import org.plotfaces.PlotUtilities;

public class CanvasAxisTickRenderer extends CommonTickRenderer {
	private Integer angle;
	private String labelPosition;
	private String fontWeight;
	private Double fontStretch;
	private Boolean enableFontSupport;
	private Double pt2px;
	
	@Override
	public boolean plot(StringBuilder builder, boolean isCloseOptions ) {
		boolean isCommaRequired = super.plot(builder, false );

		if (getAngle() != null) {
			isCommaRequired = PlotUtilities.addVariable( builder, "angle", String.valueOf( getAngle() ), isCommaRequired );
		}

		if (getLabelPosition() != null) {
			isCommaRequired = PlotUtilities.addVariable( builder, "labelPosition", getLabelPosition(), isCommaRequired, true );
		}

		if (getFontWeight() != null) {
			isCommaRequired = PlotUtilities.addVariable( builder, "fontWeight", getFontWeight(), isCommaRequired, true );
		}

		if (getFontStretch() != null) {
			isCommaRequired = PlotUtilities.addVariable( builder, "fontStretch", String.valueOf( getFontStretch() ), isCommaRequired );
		}

		if (getEnableFontSupport() != null) {
			isCommaRequired = PlotUtilities.addVariable( builder, "enableFontSupport", String.valueOf( getEnableFontSupport() ), isCommaRequired );
		}

		if (getPt2px() != null) {
			isCommaRequired = PlotUtilities.addVariable( builder, "pt2px", String.valueOf( getPt2px() ), isCommaRequired );
		}
		
		if( isCloseOptions ) {
			builder.append("}");
		}
		
		return isCommaRequired;
	}
	
	/**
	 * angle of text, measured clockwise from x axis.
	 * default 0
	 * 
	 * @return the angle
	 */
	public Integer getAngle() {
		return angle;
	}
	/**
	 * angle of text, measured clockwise from x axis.
	 * default 0
	 * 
	 * @param angle the angle to set
	 */
	public void setAngle(Integer angle) {
		this.angle = angle;
	}
	/**
	 * ’auto’, ‘start’, ‘middle’ or ‘end’.  Whether tick label should be positioned so the start, middle, or end of the tick mark.
	 * default 'auto'
	 * 
	 * @return the labelPosition
	 */
	public String getLabelPosition() {
		return labelPosition;
	}
	/**
	 * ’auto’, ‘start’, ‘middle’ or ‘end’.  Whether tick label should be positioned so the start, middle, or end of the tick mark.
	 * default 'auto'
	 * @param labelPosition the labelPosition to set
	 */
	public void setLabelPosition(String labelPosition) {
		this.labelPosition = labelPosition;
	}
	/**
	 * CSS spec for fontWeight
	 * default normal
	 * @return the fontWeight
	 */
	public String getFontWeight() {
		return fontWeight;
	}
	/**
	 * CSS spec for fontWeight
	 * default normal
	 * 
	 * @param fontWeight the fontWeight to set
	 */
	public void setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
	}
	/**
	 * Multiplier to condense or expand font width.  Applies only to browsers which don’t support canvas native font rendering.
	 * default 1.0
	 * 
	 * @return the fontStretch
	 */
	public Double getFontStretch() {
		return fontStretch;
	}
	/**
	 * Multiplier to condense or expand font width.  Applies only to browsers which don’t support canvas native font rendering.
	 * default 1.0
	 * 
	 * @param fontStretch the fontStretch to set
	 */
	public void setFontStretch(Double fontStretch) {
		this.fontStretch = fontStretch;
	}
	/**
	 * true to turn on native canvas font support in Mozilla 3.5+ and Safari 4+.  If true, tick label will be drawn with canvas tag native support for fonts.  If false, tick label will be drawn with Hershey font metrics.
	 * default true
	 * 
	 * @return the enableFontSupport
	 */
	public Boolean getEnableFontSupport() {
		return enableFontSupport;
	}
	/**
	 * true to turn on native canvas font support in Mozilla 3.5+ and Safari 4+.  If true, tick label will be drawn with canvas tag native support for fonts.  If false, tick label will be drawn with Hershey font metrics.
	 * default true
	 * 
	 * @param enableFontSupport the enableFontSupport to set
	 */
	public void setEnableFontSupport(Boolean enableFontSupport) {
		this.enableFontSupport = enableFontSupport;
	}
	/**
	 * Point to pixel scaling factor, used for computing height of bounding box around a label.  The labels text renderer has a default setting of 1.4, which should be suitable for most fonts.  Leave as null to use default.  If tops of letters appear clipped, increase this.  If bounding box seems too big, decrease.  This is an issue only with the native font renderering capabilities of Mozilla 3.5 and Safari 4 since they do not provide a method to determine the font height.
	 * default 1.4
	 * 
	 * @return the pt2px
	 */
	public Double getPt2px() {
		return pt2px;
	}
	/**
	 * Point to pixel scaling factor, used for computing height of bounding box around a label.  The labels text renderer has a default setting of 1.4, which should be suitable for most fonts.  Leave as null to use default.  If tops of letters appear clipped, increase this.  If bounding box seems too big, decrease.  This is an issue only with the native font renderering capabilities of Mozilla 3.5 and Safari 4 since they do not provide a method to determine the font height.
	 * default 1.4
	 * 
	 * @param pt2px the pt2px to set
	 */
	public void setPt2px(Double pt2px) {
		this.pt2px = pt2px;
	}
}
