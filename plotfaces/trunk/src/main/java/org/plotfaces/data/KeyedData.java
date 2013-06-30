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
package org.plotfaces.data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Graham Smith
 */
public class KeyedData implements Data {

	private Map<Object, Number> values = new HashMap<>();

	public KeyedData() {
	}

	@Override
	public String encode() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		String processedMapKey;
		for (Map.Entry entry : values.entrySet()) {
			if (entry.getKey() instanceof Number) {
				processedMapKey = String.valueOf(entry.getKey());
			} else {
				processedMapKey = "'" + String.valueOf(entry.getKey()) + "'";
			}
			builder.append("[");
			builder.append(processedMapKey);
			builder.append(",");
			builder.append(entry.getValue());
			builder.append("],");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append("]");
		return builder.toString();
	}

	public Map<Object, Number> getValues() {
		return values;
	}

	public void setValues(Map<Object, Number> values) {
		this.values = values;
	}

	public void addValue(Object key, Number value) {
		this.values.put(key, value);
	}
}
