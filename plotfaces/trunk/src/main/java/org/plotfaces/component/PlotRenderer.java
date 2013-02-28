/*
 * Copyright 2012 Graham Smith.
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

import java.io.IOException;
import java.util.List;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import org.plotfaces.PlotUtilities;
import org.plotfaces.data.ChartModel;
import org.plotfaces.data.ChartSeries;

/**
 * 
 * @author Graham Smith
 */
@ResourceDependencies({
		@ResourceDependency(library = "plotfaces", name = "jquery.jqplot.css"),
		@ResourceDependency(library = "plotfaces", name = "jquery.jqplot.js"),
		@ResourceDependency(library = "plotfaces", name = "plugins/jqplot.barRenderer.js") })
@FacesRenderer(componentFamily = UIPlot.COMPONENT_FAMILY, rendererType = UIPlot.DEFAULT_REDERER)
public class PlotRenderer extends Renderer {

	public static final String DATA_SUFFIX = "_data";
	public static final String PLOT_SUFFIX = "_plot";
	public static final String OPTIONS_SUFFIX = "_options";

	public PlotRenderer() {
	}

	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		UIPlot plot = (UIPlot) component;

		String safeTargetId = PlotUtilities.getEscapedClientId(context, plot);
		String plotVariable = PlotUtilities.getSafeClientId(context, plot)
				+ PLOT_SUFFIX;
		String optionsVariable = PlotUtilities.getSafeClientId(context, plot)
				+ OPTIONS_SUFFIX;
		String dataVariable = PlotUtilities.getSafeClientId(context, plot)
				+ DATA_SUFFIX;

		ResponseWriter out = context.getResponseWriter();

		encodeTag(context, out, plot);
		encodeScriptBegin(out, plot.getClientId());
		encodeData(out, plot, dataVariable);
		encodeChartModel(out, plot, optionsVariable);
		encodePlot(out, plotVariable, safeTargetId, dataVariable,
				optionsVariable);
		encodeScriptEnd(out);
	}

	public void encodeTag(FacesContext context, ResponseWriter out, UIPlot plot)
			throws IOException {
		String id = plot.getClientId(context);

		out.startElement("div", plot);

		out.writeAttribute("id", id, "id");

		if (plot.getStyle() != null) {
			out.writeAttribute("style", plot.getStyle(), "style");
		}

		if (plot.getStyleClass() != null) {
			out.writeAttribute("class", plot.getStyleClass(), "class");
		}

		out.endElement("div");
	}

	protected void encodeScriptBegin(ResponseWriter out, String id)
			throws IOException {
		out.startElement("script", null);
		out.writeAttribute("id", id + "_script", null);
		out.writeAttribute("type", "text/javascript", "type");
		out.write("$(document).ready(function(){\n");
	}

	/**
	 * Encodes the chart data and returns the name of the variable the data is
	 * stored in.
	 * 
	 * @param context
	 * @param chart
	 * @return
	 * @throws IOException
	 */
	private void encodeData(ResponseWriter out, UIPlot plot, String dataVariable)
			throws IOException {
		out.write("var " + dataVariable + " = ");
		List<ChartSeries> chartSeries = plot.getChartModel().getSeries();
		String processedMapKey;
		for( int i = 0, n = chartSeries.size(); i < n; i++ ) {
			out.write( "[" );
			int count = 0;
			int keySetSize = chartSeries.get( i ).getData().keySet().size();
			for ( Object mapKey : chartSeries.get( i ).getData().keySet() ) {
				if( mapKey instanceof Number ) {
					processedMapKey = String.valueOf( mapKey );
				} else {
					processedMapKey = "'" + String.valueOf( mapKey ) + "'";
				}
				out.write("[" + processedMapKey + "," + chartSeries.get( i ).getData().get( mapKey ) + "]");
				if( ++count != keySetSize ) {
					out.write(",");
				}
			}
			out.write("]");
			if( i != (chartSeries.size() - 1) ) {
				out.write(",");
			}
		}
		out.write(";\n");
	}

	private void encodeChartModel(ResponseWriter out, UIPlot plot,
			String optionsVariable) throws IOException {
		ChartModel chartModel = (ChartModel) plot.getChartModel();
		if (chartModel != null) {
			out.write(chartModel.plot(optionsVariable));
		}
	}

	private void encodePlot(ResponseWriter out, String plotVariable,
			String safeTargetId, String dataVariable, String optionsVariable)
			throws IOException {
		out.write("var " + plotVariable + " = $.jqplot('" + safeTargetId
				+ "', [" + dataVariable + "], " + optionsVariable + ")\n");
	}

	protected void encodeScriptEnd(ResponseWriter out) throws IOException {
		out.write("});\n");
		out.endElement("script");
	}
}
