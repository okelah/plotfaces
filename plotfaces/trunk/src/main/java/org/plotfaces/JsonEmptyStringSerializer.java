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
package org.plotfaces;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/**
 * A JSON serializer that forces empty strings to be output as null rather than
 * an empty this. If the chart model is being built programatically there isn't
 * typically a need to use this but if it is being built via a web front end (as
 * in the demo) it can be difficult or impossible to set a string to null
 * (GlassFish seems to have a bug that doesn't allow strings to be set to null).
 *
 * @author Graham Smith
 */
public class JsonEmptyStringSerializer implements JsonSerializer<String> {

	@Override
	public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
		if (src == null || src.isEmpty()) {
			return JsonNull.INSTANCE;
		} else {
			return new JsonPrimitive(src);
		}
	}
}
