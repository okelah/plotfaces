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
import org.plotfaces.model.Axis;
import org.plotfaces.model.Highlighter;
import org.plotfaces.model.Legend;
import org.plotfaces.model.Series;
import org.plotfaces.renderer.AxisTickRenderer;
import org.plotfaces.renderer.BarRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.DefaultMarkerRenderer;

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

	public Highlighter.Location[] getHighlighterLocations() {
		return Highlighter.Location.values();
	}

	public Highlighter.TooltipAxes[] getHighlighterTooltipAxes() {
		return Highlighter.TooltipAxes.values();
	}

	public DefaultMarkerRenderer.MarkerStyle[] getMarkerStyles() {
		return DefaultMarkerRenderer.MarkerStyle.values();
	}

	public BarRenderer.BarDirection[] getBarRendererBarDirection() {
		return BarRenderer.BarDirection.values();
	}

	public Series.FillAxis[] getSeriesFillAxes() {
		return Series.FillAxis.values();
	}

	public Axis.AxisName[] getXAxes() {
		Axis.AxisName[] x = {Axis.AxisName.xaxis, Axis.AxisName.x2axis};
		return x;
	}

	public Axis.AxisName[] getYAxes() {
		Axis.AxisName[] y = {Axis.AxisName.yaxis, Axis.AxisName.y2axis, Axis.AxisName.y3axis, Axis.AxisName.y4axis, Axis.AxisName.y5axis, Axis.AxisName.y6axis, Axis.AxisName.y7axis, Axis.AxisName.y8axis, Axis.AxisName.y9axis};
		return y;
	}

	public Series.LineJoin[] getSeriesLineJoins() {
		return Series.LineJoin.values();
	}

	public Series.LineCap[] getSeriesLineCaps() {
		return Series.LineCap.values();
	}
}
