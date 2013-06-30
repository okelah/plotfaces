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

import java.util.ArrayList;
import java.util.List;

/**
 * Encodes data as a simple array of values;
 *
 * @author Graham Smith
 */
public class SimpleData implements Data {

	private List<Number> values = new ArrayList<>();

	public SimpleData() {
	}

	@Override
	public String encode() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (Number n : values) {
			builder.append(n);
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append("]");
		return builder.toString();
	}

	public List<Number> getValues() {
		return values;
	}

	public void setValues(List<Number> values) {
		this.values = values;
	}

	public void addValue(Number value) {
		this.values.add(value);
	}
}
