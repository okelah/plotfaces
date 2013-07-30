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

/**
 * A class to hold options for the default table legend renderer. There are no
 * options beyond those specified by {@code Legend}. The table legend renderer
 * doesn't support the hiding series.
 *
 * @author Graham Smith
 */
public class TableLegendRenderer extends AbstractLegendRenderer {

	public TableLegendRenderer() {
	}

	@Override
	public String getRendererName() {
		return DEFAULT_RENDERER_NAME_PREFIX + "TableLegendRenderer";
	}
}
