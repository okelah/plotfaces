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
package org.plotfaces.renderer;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractSeriesRenderer implements SeriesRenderer {

	/**
	 * Provides the standard opening to the renderer block of options.
	 *
	 * @return
	 */
	protected String plotBegin() {
		StringBuilder builder = new StringBuilder();
		builder.append("renderer: $.jqplot.");
		builder.append(getRendererName());
		builder.append(",\nrendererOptions: ");
		builder.append("{");
		return builder.toString();

	}

	/**
	 * Closes the tickRenderer options block.
	 *
	 * @return
	 */
	protected String plotEnd() {
		return "}";
	}

	@Override
	public String plot() {
		StringBuilder builder = new StringBuilder();
		builder.append(plotBegin());
		builder.append(StringUtils.join(getFragments().toArray(), ",\n"));
		builder.append(plotEnd());
		return builder.toString();
	}

	@Override
	public abstract String getRendererName();

	protected abstract List<String> getFragments();
}
