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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.List;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.plotfaces.JsonEmptyStringSerializer;
import org.plotfaces.PlotUtilities;
import org.plotfaces.model.Model;
import org.plotfaces.model.Series;
import org.plotfaces.data.PlotData;

/**
 *
 * @author Graham Smith
 */
@ResourceDependencies({
	@ResourceDependency(library = "plotfaces", name = "jquery.jqplot.min.css"),
	@ResourceDependency(library = "plotfaces", name = "jquery.jqplot.cc.js")})
@FacesRenderer(componentFamily = UIPlot.COMPONENT_FAMILY, rendererType = UIPlot.DEFAULT_REDERER)
public class PlotRenderer extends Renderer {

	public static final String DATA_SUFFIX = "_data";
	public static final String PLOT_SUFFIX = "_plot";
	public static final String MODEL_SUFFIX = "_model";
	private Optimizer optimizer = new Optimizer();

	public PlotRenderer() {
	}

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		UIPlot plot = (UIPlot) component;

		String safeTargetId = PlotUtilities.getEscapedClientId(context, plot);
		String plotVariable = PlotUtilities.getSafeClientId(context, plot) + PLOT_SUFFIX;
		String modelVariable = PlotUtilities.getSafeClientId(context, plot) + MODEL_SUFFIX;
		String dataVariable = PlotUtilities.getSafeClientId(context, plot) + DATA_SUFFIX;

		ResponseWriter out = context.getResponseWriter();

		encodeChartTag(context, out, plot);
		encodeScriptBeginTag(out, dataVariable);

		//Produce the JavaScipt that will actually draw the chart. This must
		//all be built in one piece if it is to be optimized.
		StringBuilder builder = new StringBuilder();
		encodeScriptBegin(builder);
		encodeData(builder, plot, dataVariable);
		encodeChartModel(builder, plot, modelVariable);
		encodePlot(builder, plotVariable, safeTargetId, dataVariable, modelVariable);
		encodeScriptEnd(builder);
		String chart = builder.toString();

		System.out.println("********* Chart Start *********\n" + chart + "\n********* Chart End *********");

		out.write(chart);

		encodeScriptEndTag(out);
	}

	/**
	 * Creates the div that will hold the chart.
	 *
	 * @param context
	 * @param out
	 * @param plot
	 * @throws IOException
	 */
	private void encodeChartTag(FacesContext context, ResponseWriter out, UIPlot plot) throws IOException {
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

	/**
	 * Creates the opening tag for the script element. Should not include any
	 * JavaScript.
	 *
	 * @param out
	 * @param id
	 * @throws IOException
	 */
	private void encodeScriptBeginTag(ResponseWriter out, String id) throws IOException {
		out.startElement("script", null);
		out.writeAttribute("id", id + "_script", null);
		out.writeAttribute("type", "text/javascript", "type");
	}

	/**
	 * Creates the document ready function.
	 *
	 * @param out
	 * @param id
	 * @throws IOException
	 */
	private void encodeScriptBegin(StringBuilder builder) throws IOException {
		builder.append("$(document).ready(function(){\n");
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
	private void encodeData(StringBuilder builder, UIPlot plot, String dataVariable) throws IOException {
		builder.append("var ");
		builder.append(dataVariable);
		builder.append(" = [");
		for (Series chartSeries : plot.getModel().getSeries()) {
			PlotData data = chartSeries.getData();
			if (data != null) {
				builder.append(data.encode());
				builder.append(",");
			}
		}

		//There is a slight chance that there will be no data at all if the user
		//has forgotten to add data to every series being displayed.
		if (',' == (builder.charAt(builder.length() - 1))) {
			builder.deleteCharAt(builder.length() - 1);
		}

		builder.append("];\n");
	}

	private void encodeChartModel(StringBuilder builder, UIPlot plot, String modelVariable) throws IOException {
		Model chartModel = (Model) plot.getModel();
//		if (chartModel != null) {
//			chartModel.setModelVariable(modelVariable);
//			builder.append(chartModel.plot());
//		}

		if (chartModel != null) {
			builder.append("var ");
			builder.append(modelVariable);
			builder.append(" = ");

			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();
			gsonBuilder.registerTypeAdapter(String.class, new JsonEmptyStringSerializer());
			Gson gson = gsonBuilder.create();
			String result = gson.toJson(chartModel);
			FunctionFixer fixer = new FunctionFixer();
			fixer.setPrettyPrint(true);
			result = fixer.fix(chartModel, result);
			builder.append(result);

			builder.append(";\n");
		}
	}

	private void encodePlot(StringBuilder builder, String plotVariable, String safeTargetId, String dataVariable, String modelVariable) throws IOException {
		builder.append("var ");
		builder.append(plotVariable);
		builder.append(" = $.jqplot('");
		builder.append(safeTargetId);
		builder.append("', ");
		builder.append(dataVariable);
		builder.append(", ");
		builder.append(modelVariable);
		builder.append(");\n");
	}

	/**
	 * Closes the document ready function.
	 *
	 * @param out
	 * @throws IOException
	 */
	private void encodeScriptEnd(StringBuilder builder) throws IOException {
		builder.append("});\n");
	}

	/**
	 * Creates the closing tag for the script element. Should not include any
	 * JavaScript.
	 *
	 * @param out
	 * @throws IOException
	 */
	private void encodeScriptEndTag(ResponseWriter out) throws IOException {
		out.endElement("script");
	}
}
