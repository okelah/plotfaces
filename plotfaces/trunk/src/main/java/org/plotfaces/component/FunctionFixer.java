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
package org.plotfaces.component;

import org.plotfaces.data.Axes;
import org.plotfaces.data.Axis;
import org.plotfaces.data.ChartModel;
import org.plotfaces.data.Grid;
import org.plotfaces.data.Highlighter;
import org.plotfaces.data.Legend;
import org.plotfaces.data.Title;
import org.plotfaces.renderer.AxisTickRenderer;

/**
 * The jqPlot settings are very close to, but not quite, JSON. They break the
 * specification in one way: they require a small number of values to be
 * function literals (names) rather than strings. This is strictly forbidden in
 * the JSON specification because it can (and does) lead to JSON that is
 * executable. This method "corrects" the JSON output produced by the Google
 * Gson library in those few places where a function literal is required. This
 * fixing is done by using string replacement on the final JSON produced by Gson
 * so there is a small chance that this could corrupt the output; for example if
 * an axis label was set to the name of renderer it could be replaced.
 *
 * @author Graham Smith
 */
public class FunctionFixer {

	private boolean prettyPrint;
	private String prettiness;

	public FunctionFixer() {
	}

	public boolean isPrettyPrint() {
		return prettyPrint;
	}

	/**
	 * Sets whether the <b>source</b> JSON is pretty printed. The default is to
	 * assume it isn't.
	 *
	 * @param prettyPrint
	 */
	public void setPrettyPrint(boolean prettyPrint) {
		this.prettyPrint = prettyPrint;
		prettiness = this.prettyPrint ? " " : "";
	}

	/**
	 *
	 *
	 * @param json
	 * @return
	 */
	public String fix(ChartModel model, final String original) {
		String fixed = original;

		fixed = fixAxes(model.getAxes(), fixed);
		fixed = fixLegend(model.getLegend(), fixed);
		fixed = fixTitle(model.getTitle(), fixed);
		fixed = fixHighlighter(model.getHighlighter(), fixed);
		fixed = fixGrid(model.getGrid(), fixed);
		return fixed;


	}

	private String fixAxes(Axes axes, final String original) {
		//String axisRendererMatch = "\"renderer\":\\s*\"\\" + model.getAxes().getXaxis().getRendererOptions().getRendererName() + "\"";
		//String axisRendererReplacement = "\"renderer\":\\" + axes.getXaxis().getRendererOptions().getRendererName() + "";
		String fixed = fixAxis(axes.getXaxis(), original);
		fixed = fixAxis(axes.getX2axis(), fixed);
		fixed = fixAxis(axes.getYaxis(), fixed);
		return fixed;
	}

	/**
	 * Fixes all the function values for the given axis. Since this performs a
	 * string replacement on the JSON it all axes that use the same function
	 * will be fixed in a single pass. Subsequent passes shouldn't then affect
	 * the JSON since the quotes will already have been removed.
	 *
	 * @param axis
	 * @param original
	 * @return
	 */
	private String fixAxis(Axis axis, final String original) {
		String fixed = original;
		if (axis == null) {
			return fixed;
		}

		//Fix the axis renderer
		if (axis.getRendererOptions() != null) {
			fixed = fix("renderer", axis.getRendererOptions().getRendererName(), fixed);
		}

		//Fix the tick renderer
		if (axis.getTickOptions() != null) {
			fixed = fix("tickRenderer", axis.getTickOptions().getRendererName(), fixed);

			//Fix the tick formatter
			//TODO: I think this probably makes it impossible to use a tick
			//renderer that doesn't extend from AxisTickRenderer.
			if (axis.getTickOptions() instanceof AxisTickRenderer) {
				AxisTickRenderer axisTickRenderer = (AxisTickRenderer) axis.getTickOptions();
				if (axisTickRenderer.getFormatterOptions() != null) {
					fixed = fix("formatter", axisTickRenderer.getFormatterOptions().getRendererName(), fixed);
				}
			}
		}

		//Fix the label renderer
		if (axis.getLabelOptions() != null) {
			fixed = fix("labelRenderer", axis.getLabelOptions().getRendererName(), fixed);
		}

		return fixed;
	}

	private String fixLegend(Legend legend, final String original) {
		String fixed = original;
		if (legend == null || legend.getRendererOptions() == null) {
			return fixed;
		}
		return fix("renderer", legend.getRendererOptions().getRendererName(), fixed);
	}

	private String fixTitle(Title title, final String original) {
		String fixed = original;
		if (title == null || title.getRendererOptions() == null) {
			return fixed;
		}
		return fix("renderer", title.getRendererOptions().getRendererName(), fixed);
	}

	/**
	 * TODO: Is there any way options could be passed into this function? They
	 * are available held under the variable markerRendererOptions. The function
	 * name must have a set of brackets appended to the end or JavaScript
	 * exception is thrown regarding it not having an init function.
	 *
	 * @param highlighter
	 * @param original
	 * @return
	 */
	private String fixHighlighter(Highlighter highlighter, final String original) {
		String fixed = original;
		if (highlighter == null || highlighter.getMarkerRendererOptions() == null) {
			return fixed;
		}
		return fix("markerRenderer", "", highlighter.getMarkerRendererOptions().getRendererName(), "()", fixed);
	}

	private String fixGrid(Grid grid, final String original) {
		String fixed = original;
		if (grid == null || grid.getRendererOptions() == null) {
			return fixed;
		}
		return fix("renderer", grid.getRendererOptions().getRendererName(), fixed);
	}

	private String fix(final String key, final String value, final String original) {
		return fix(key, "", value, "", original);
	}

	/**
	 *
	 * @param key the key
	 * @param valuePrefix and arbitrary string to append to the start of the
	 * value.
	 * @param value the value
	 * @param valueSuffix an arbitrary string to append to the end of the value.
	 * @param original
	 * @return
	 */
	private String fix(final String key, final String valuePrefix, final String value, final String valueSuffix, final String original) {
		String fixed = original;
		String match = "\"" + key + "\":" + prettiness + "\"" + value + "\"";
		String replacement = "\"" + key + "\":" + prettiness + valuePrefix + value + valueSuffix;
		fixed = fixed.replace(match, replacement);
		return fixed;
	}
}
