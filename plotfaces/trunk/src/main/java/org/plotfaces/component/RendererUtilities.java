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
 * A utility class for encoding the {@code Model} and data.
 *
 * @author Graham Smith
 */
public class RendererUtilities {

	private RendererUtilities() {
	}

	public static String encode(Model model) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.registerTypeAdapter(String.class, new JsonEmptyStringSerializer());
		Gson gson = gsonBuilder.create();
		String result = gson.toJson(model);
		FunctionFixer fixer = new FunctionFixer();
		fixer.setPrettyPrint(true);
		result = fixer.fix(model, result);
		return result;
	}

	public static String encode(List<Series> series) {
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
