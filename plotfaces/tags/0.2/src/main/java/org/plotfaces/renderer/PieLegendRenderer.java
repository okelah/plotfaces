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
 * A legend renderer specific to pie plots. This is set by default when a pie
 * chart is created.
 *
 * @author Graham Smith
 */
public class PieLegendRenderer extends TableLegendRenderer {

	private Integer numberRows;
	private Integer numberColumns;

	public PieLegendRenderer() {
	}

	public Integer getNumberRows() {
		return numberRows;
	}

	public void setNumberRows(Integer numberRows) {
		this.numberRows = numberRows;
	}

	public Integer getNumberColumns() {
		return numberColumns;
	}

	public void setNumberColumns(Integer numberColumns) {
		this.numberColumns = numberColumns;
	}
}
