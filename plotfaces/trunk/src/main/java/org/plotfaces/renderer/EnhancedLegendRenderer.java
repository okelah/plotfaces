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
 * A class to hold options for the enhanced table legend renderer.
 *
 * @author Graham Smith
 */
public class EnhancedLegendRenderer extends AbstractLegendRenderer {

	private Integer numberRows;
	private Integer numberColumns;
	private String seriesToggle;
	private Boolean disableIEFading;

	public EnhancedLegendRenderer() {
	}

	@Override
	public String getRendererName() {
		return RENDERER_NAME_PREFIX + "EnhancedLegendRenderer";
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

	public String getSeriesToggle() {
		return seriesToggle;
	}

	public void setSeriesToggle(String seriesToggle) {
		this.seriesToggle = seriesToggle;
	}

	public Boolean getDisableIEFading() {
		return disableIEFading;
	}

	public void setDisableIEFading(Boolean disableIEFading) {
		this.disableIEFading = disableIEFading;
	}
}
