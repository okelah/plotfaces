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
package org.plotfaces.renderer.overlay;

import static org.plotfaces.renderer.Renderer.DEFAULT_RENDERER_NAME_PREFIX;

/**
 *
 * @author Graham Smith
 */
public class HorizontalLine extends AbstractLine {

	private Number y;
	private Number xmin;
	private Number xmax;
	private String xOffset;

	public HorizontalLine() {
	}

	public Number getY() {
		return y;
	}

	public void setY(Number y) {
		this.y = y;
	}

	public Number getXmin() {
		return xmin;
	}

	public void setXmin(Number xmin) {
		this.xmin = xmin;
	}

	public Number getXmax() {
		return xmax;
	}

	public void setXmax(Number xmax) {
		this.xmax = xmax;
	}

	public String getxOffset() {
		return xOffset;
	}

	public void setxOffset(String xOffset) {
		this.xOffset = xOffset;
	}

	@Override
	public String getRendererName() {
		return DEFAULT_RENDERER_NAME_PREFIX + "HorizontalLine";
	}
}
