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

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.plotfaces.PlotUtilities;

/**
 *
 * @author Graham Smith
 */
public class AxisLabelRenderer extends AbstractLabelRenderer {

	private static final String SHOW = "show";
	private static final String LABEL = "label";
	private static final String ESCAPE_HTML = "escapeHTML";
	private Boolean show;
	private String label;
	private Boolean escapeHTML;

	public AxisLabelRenderer() {
	}

	@Override
	protected List<String> getFragments() {
		List<String> fragments = new ArrayList<>();

		if (getShow() != null) {
			fragments.add(PlotUtilities.createVariable(SHOW, getShow()));
		}

		if (getLabel() != null) {
			fragments.add(PlotUtilities.createVariable(LABEL, getLabel()));
		}

		if (getEscapeHTML() != null) {
			fragments.add(PlotUtilities.createVariable(ESCAPE_HTML, getEscapeHTML()));
		}

		return fragments;
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
	public String getRendererName() {
		return "AxisLabelRenderer";
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getEscapeHTML() {
		return escapeHTML;
	}

	public void setEscapeHTML(Boolean escapeHTML) {
		this.escapeHTML = escapeHTML;
	}
}