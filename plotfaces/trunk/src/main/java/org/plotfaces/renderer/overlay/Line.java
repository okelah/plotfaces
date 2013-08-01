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
public class Line extends AbstractLine {

	private Number[] start;
	private Number[] stop;

	public Line() {
	}

	public Number[] getStart() {
		return start;
	}

	/**
	 * A two element array indicating the start position of the line on null.
	 *
	 * @param start
	 */
	public void setStart(Number[] start) {
		if (start == null || start.length == 2) {
			this.start = start;
		} else {
			throw new IllegalArgumentException("Expected a two element array or null");
		}
	}

	public Number[] getStop() {
		return stop;
	}

	/**
	 * A two element array indicating the stop position of the line or null.
	 *
	 * @param stop
	 */
	public void setStop(Number[] stop) {
		if (stop == null || stop.length == 2) {
			this.stop = stop;
		} else {
			throw new IllegalArgumentException("Expected a two element array or null");
		}
	}

	public void setStop(Double[] stop) {
	}

	@Override
	public String getRendererName() {
		return DEFAULT_RENDERER_NAME_PREFIX + "Line";
	}
}
