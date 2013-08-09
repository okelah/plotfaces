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
 *
 * @author Graham Smith
 */
public class LinearAxisRenderer extends AbstractAxisRenderer {

	//TODO: support breakPoints, probably an array of something
	//private String breakPoints
	private String breakTickLabel;
	private Boolean forceTickAt0;
	private Boolean forceTickAt100;

	public LinearAxisRenderer() {
	}

	@Override
	public String getRendererName() {
		return DEFAULT_RENDERER_NAME_PREFIX + "LinearAxisRenderer";
	}

	public String getBreakTickLabel() {
		return breakTickLabel;
	}

	public void setBreakTickLabel(String breakTickLabel) {
		this.breakTickLabel = breakTickLabel;
	}

	public Boolean getForceTickAt0() {
		return forceTickAt0;
	}

	public void setForceTickAt0(Boolean forceTickAt0) {
		this.forceTickAt0 = forceTickAt0;
	}

	public Boolean getForceTickAt100() {
		return forceTickAt100;
	}

	public void setForceTickAt100(Boolean forceTickAt100) {
		this.forceTickAt100 = forceTickAt100;
	}
}
