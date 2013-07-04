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
import org.apache.commons.lang3.StringUtils;
import org.plotfaces.PlotUtilities;

/**
 * Implements the options found in the CanvasAxisTickRenderer.
 *
 * @author Graham Smith
 */
public class CanvasAxisTickRenderer extends AxisTickRenderer {

	public enum LabelPosition {

		auto, start, middle, end
	};
	private static final String ANGLE = "angle";
	private static final String LABEL_POSITION = "labelPosition";
	private static final String FONT_WEIGHT = "fontWeight";
	private static final String FONT_STRETCH = "fontStretch";
	private static final String ENABLE_FONT_SUPPORT = "enableFontSupport";
	private static final String PT2PX = "pt2px";
	private Integer angle;
	private LabelPosition labelPosition;
	private String fontWeight;
	private Double fontStretch;
	private Boolean enableFontSupport;
	private Double pt2px;

	@Override
	protected List<String> getFragments() {
		List<String> fragments = super.getFragments();

		if (getAngle() != null) {
			fragments.add(PlotUtilities.createVariable(ANGLE, getAngle()));
		}

		if (getLabelPosition() != null) {
			fragments.add(PlotUtilities.createVariable(LABEL_POSITION, getLabelPosition()));
		}

		if (getFontWeight() != null && !getFontWeight().isEmpty()) {
			fragments.add(PlotUtilities.createVariable(FONT_WEIGHT, getFontWeight()));
		}

		if (getFontStretch() != null) {
			fragments.add(PlotUtilities.createVariable(FONT_STRETCH, getFontStretch()));
		}

		if (getEnableFontSupport() != null) {
			fragments.add(PlotUtilities.createVariable(ENABLE_FONT_SUPPORT, getEnableFontSupport()));
		}

		if (getPt2px() != null) {
			fragments.add(PlotUtilities.createVariable(PT2PX, getPt2px()));
		}

		return fragments;
	}

	@Override
	public String getRendererName() {
		return RENDERER_NAME_PREFIX + "CanvasAxisTickRenderer";
	}

	/**
	 * angle of text, measured clockwise from x axis. default 0
	 *
	 * @return the angle
	 */
	public Integer getAngle() {
		return angle;
	}

	/**
	 * angle of text, measured clockwise from x axis. default 0
	 *
	 * @param angle the angle to set
	 */
	public void setAngle(Integer angle) {
		this.angle = angle;
	}

	/**
	 * ’auto’, ‘start’, ‘middle’ or ‘end’. Whether tick label should be
	 * positioned so the start, middle, or end of the tick mark. default 'auto'
	 *
	 * @return the labelPosition
	 */
	public LabelPosition getLabelPosition() {
		return labelPosition;
	}

	/**
	 * ’auto’, ‘start’, ‘middle’ or ‘end’. Whether tick label should be
	 * positioned so the start, middle, or end of the tick mark. default 'auto'
	 *
	 * @param labelPosition the labelPosition to set
	 */
	public void setLabelPosition(LabelPosition labelPosition) {
		this.labelPosition = labelPosition;
	}

	/**
	 * CSS spec for fontWeight default normal
	 *
	 * @return the fontWeight
	 */
	public String getFontWeight() {
		return fontWeight;
	}

	/**
	 * CSS spec for fontWeight default normal
	 *
	 * @param fontWeight the fontWeight to set
	 */
	public void setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
	}

	/**
	 * Multiplier to condense or expand font width. Applies only to browsers
	 * which don’t support canvas native font rendering. default 1.0
	 *
	 * @return the fontStretch
	 */
	public Double getFontStretch() {
		return fontStretch;
	}

	/**
	 * Multiplier to condense or expand font width. Applies only to browsers
	 * which don’t support canvas native font rendering. default 1.0
	 *
	 * @param fontStretch the fontStretch to set
	 */
	public void setFontStretch(Double fontStretch) {
		this.fontStretch = fontStretch;
	}

	/**
	 * true to turn on native canvas font support in Mozilla 3.5+ and Safari 4+.
	 * If true, tick label will be drawn with canvas tag native support for
	 * fonts. If false, tick label will be drawn with Hershey font metrics.
	 * default true
	 *
	 * @return the enableFontSupport
	 */
	public Boolean getEnableFontSupport() {
		return enableFontSupport;
	}

	/**
	 * true to turn on native canvas font support in Mozilla 3.5+ and Safari 4+.
	 * If true, tick label will be drawn with canvas tag native support for
	 * fonts. If false, tick label will be drawn with Hershey font metrics.
	 * default true
	 *
	 * @param enableFontSupport the enableFontSupport to set
	 */
	public void setEnableFontSupport(Boolean enableFontSupport) {
		this.enableFontSupport = enableFontSupport;
	}

	/**
	 * Point to pixel scaling factor, used for computing height of bounding box
	 * around a label. The labels text renderer has a default setting of 1.4,
	 * which should be suitable for most fonts. Leave as null to use default. If
	 * tops of letters appear clipped, increase this. If bounding box seems too
	 * big, decrease. This is an issue only with the native font renderering
	 * capabilities of Mozilla 3.5 and Safari 4 since they do not provide a
	 * method to determine the font height. default 1.4
	 *
	 * @return the pt2px
	 */
	public Double getPt2px() {
		return pt2px;
	}

	/**
	 * Point to pixel scaling factor, used for computing height of bounding box
	 * around a label. The labels text renderer has a default setting of 1.4,
	 * which should be suitable for most fonts. Leave as null to use default. If
	 * tops of letters appear clipped, increase this. If bounding box seems too
	 * big, decrease. This is an issue only with the native font renderering
	 * capabilities of Mozilla 3.5 and Safari 4 since they do not provide a
	 * method to determine the font height. default 1.4
	 *
	 * @param pt2px the pt2px to set
	 */
	public void setPt2px(Double pt2px) {
		this.pt2px = pt2px;
	}
}
