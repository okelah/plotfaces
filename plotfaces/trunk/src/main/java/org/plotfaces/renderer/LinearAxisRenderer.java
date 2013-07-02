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
public class LinearAxisRenderer extends AbstractAxisRenderer {

	private static final String BREAK_POINTS = "breakPoints";
	private static final String BREAK_TICK_LABEL = "breakTickLagel";
	private static final String FORCE_TICK_AT_0 = "forceTickAt0";
	private static final String FORCE_TICK_AT_100 = "forceTickAt100";
	//TODO: support breakPoints, probably an array of something
	//private String breakPoints
	private String breakTickLabel;
	private Boolean forceTickAtZero;
	private Boolean forceTickAtOneHundred;

	public LinearAxisRenderer() {
	}

	@Override
	protected List<String> getFragments() {
		List<String> fragments = new ArrayList<>();

		if (getBreakTickLabel() != null) {
			fragments.add(PlotUtilities.createVariable(BREAK_TICK_LABEL, getBreakTickLabel()));
		}

		if (getForceTickAtZero() != null) {
			fragments.add(PlotUtilities.createVariable(FORCE_TICK_AT_0, getForceTickAtZero()));
		}

		if (getForceTickAtOneHundred() != null) {
			fragments.add(PlotUtilities.createVariable(FORCE_TICK_AT_100, getForceTickAtOneHundred()));
		}

		return fragments;
	}

	@Override
	public String getRendererName() {
		return "LinearAxisRenderer";
	}

	public String getBreakTickLabel() {
		return breakTickLabel;
	}

	public void setBreakTickLabel(String breakTickLabel) {
		this.breakTickLabel = breakTickLabel;
	}

	public Boolean getForceTickAtZero() {
		return forceTickAtZero;
	}

	public void setForceTickAtZero(Boolean forceTickAtZero) {
		this.forceTickAtZero = forceTickAtZero;
	}

	public Boolean getForceTickAtOneHundred() {
		return forceTickAtOneHundred;
	}

	public void setForceTickAtOneHundred(Boolean forceTickAtOneHundred) {
		this.forceTickAtOneHundred = forceTickAtOneHundred;
	}
}
