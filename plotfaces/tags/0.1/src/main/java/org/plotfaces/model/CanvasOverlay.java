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
package org.plotfaces.model;

import java.util.ArrayList;
import java.util.List;
import org.plotfaces.renderer.overlay.CanvasOverlayHolder;
import org.plotfaces.renderer.overlay.CanvasOverlayRenderer;

/**
 *
 * @author Graham Smith
 */
public class CanvasOverlay {

	private Boolean show;
	private List<CanvasOverlayHolder> objects;

	public CanvasOverlay() {
		this.objects = new ArrayList<>();
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public List<CanvasOverlayHolder> getObjects() {
		return objects;
	}

	public void setObjects(List<CanvasOverlayHolder> objects) {
		this.objects = objects;
	}

	public void addObject(CanvasOverlayHolder object) {
		this.objects.add(object);
	}
}
