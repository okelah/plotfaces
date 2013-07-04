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
package org.plotfacesdemo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.plotfaces.data.Legend;
import org.plotfaces.renderer.AxisTickRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;

/**
 *
 * @author Graham Smith
 */
@Named
@ApplicationScoped
public class EnumTypes {

	public EnumTypes() {
	}

	public AxisTickRenderer.Mark[] getAxisTickMarks() {
		return AxisTickRenderer.Mark.values();
	}

	public CanvasAxisTickRenderer.LabelPosition[] getAxisTickLabelPositions() {
		return CanvasAxisTickRenderer.LabelPosition.values();
	}

	public Legend.Location[] getLegendLocations() {
		return Legend.Location.values();
	}

	public Legend.Placement[] getLegendPlacements() {
		return Legend.Placement.values();
	}
}
