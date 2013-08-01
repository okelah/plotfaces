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

/**
 * A general line holding class. This class is capable of holding all the built
 * in jqPlot canvas overlay line types. Only one of the available options must
 * be set at any one time all the others must be null - each line must have it's
 * own holder.
 *
 * @author Graham Smith
 */
public class GeneralLineHolder implements CanvasOverlayHolder {

	private Line line;
	private HorizontalLine horizontalLine;
	private DashedHorizontalLine dashedHorizontalLine;
	private VerticalLine verticalLine;
	private DashedVerticalLine dashedVerticalLine;
	private Rectangle rectangle;

	public GeneralLineHolder() {
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public HorizontalLine getHorizontalLine() {
		return horizontalLine;
	}

	public void setHorizontalLine(HorizontalLine horizontalLine) {
		this.horizontalLine = horizontalLine;
	}

	public DashedHorizontalLine getDashedHorizontalLine() {
		return dashedHorizontalLine;
	}

	public void setDashedHorizontalLine(DashedHorizontalLine dashedHorizontalLine) {
		this.dashedHorizontalLine = dashedHorizontalLine;
	}

	public VerticalLine getVerticalLine() {
		return verticalLine;
	}

	public void setVerticalLine(VerticalLine verticalLine) {
		this.verticalLine = verticalLine;
	}

	public DashedVerticalLine getDashedVerticalLine() {
		return dashedVerticalLine;
	}

	public void setDashedVerticalLine(DashedVerticalLine dashedVerticalLine) {
		this.dashedVerticalLine = dashedVerticalLine;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
}
