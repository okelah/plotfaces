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

import org.plotfaces.PlotUtilities;
import org.plotfaces.renderer.TitleRenderer;

/**
 * Represents a chart title and provides common settings for all title
 * renderers.
 *
 * @author Graham Smith
 */
public class Title {

	private String text;
	private Boolean show;
	private String fontFamily;
	private String fontSize;
	private String textAlign;
	private String textColor;
	private String renderer;
	private TitleRenderer rendererOptions;

	public Title() {
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public String getTextAlign() {
		return textAlign;
	}

	public void setTextAlign(String textAlign) {
		this.textAlign = textAlign;
	}

	public String getTextColor() {
		return textColor;
	}

	/**
	 * CSS color specification for the text. This method used
	 * {@code PlotUtilities.fixColor}.
	 *
	 * @param textColor
	 */
	public void setTextColor(String textColor) {
		this.textColor = PlotUtilities.fixColor(textColor);
	}

	protected String getRenderer() {
		return renderer;
	}

	protected void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	public TitleRenderer getRendererOptions() {
		return rendererOptions;
	}

	public void setRendererOptions(TitleRenderer rendererOptions) {
		this.rendererOptions = rendererOptions;
		if (this.rendererOptions == null) {
			setRenderer(null);
		} else {
			setRenderer(this.rendererOptions.getRendererName());
		}
	}
}
