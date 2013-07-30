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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.List;
import org.plotfaces.JsonEmptyStringSerializer;
import org.plotfaces.data.PlotData;
import org.plotfaces.model.Model;
import org.plotfaces.model.Series;

/**
 * A utility class for encoding the {@code Model} and data and producing the
 * JavaScript that is placed in the page. Typically these tasks would be carried
 * out in the renderer class but that realistically precludes the library from
 * being used in non-JSF projects. By performing the basic rendering tasks here
 * on just the model non-JSF projects can create a model, populate it with data
 * and then produce a chart. It is, of course, up to the application to include
 * the required resources and place the chart in the page.
 *
 * @author Graham Smith
 */
public class PlotFactory {

	private boolean useEmptyStringSerializer;

	public PlotFactory() {
	}

	public boolean isUseEmptyStringSerializer() {
		return useEmptyStringSerializer;
	}

	/**
	 * Whether to use the empty string serializer when encoding the chart model.
	 * When true empty strings in the model are treated as if they are null.
	 * This is useful when settings are coming from a JSF front end as it seems
	 * to have problems with settings string properties to null.
	 *
	 * @param useEmptyStringSerializer
	 */
	public void setUseEmptyStringSerializer(boolean useEmptyStringSerializer) {
		this.useEmptyStringSerializer = useEmptyStringSerializer;
	}

	public String encode(Model model) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		if (isUseEmptyStringSerializer()) {
			System.out.println("Using empty string serializer");
			gsonBuilder.registerTypeAdapter(String.class, new JsonEmptyStringSerializer());
		}
		Gson gson = gsonBuilder.create();
		String result = gson.toJson(model);
		FunctionFixer fixer = new FunctionFixer();
		fixer.setPrettyPrint(true);
		result = fixer.fix(model, result);
		return result;
	}

	public String encode(List<Series> series) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (Series chartSeries : series) {
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
		builder.append("]");

		return builder.toString();
	}
}
