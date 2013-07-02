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
package org.plotfacesdemo;

import java.util.HashMap;
import java.util.Map;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

/**
 *
 * @author Graham Smith
 */
public class CollapseHandler {

	private Map<String, Boolean> visible = new HashMap<>();

	public CollapseHandler() {
	}

	public boolean isVisible(String id) {
		if (visible.containsKey(id)) {
			return visible.get(id);
		} else {
			return true;
		}
	}

	public void handleToggle(ToggleEvent event) {
		String id = event.getComponent().getId();
		boolean showing = event.getVisibility() == Visibility.VISIBLE;
		visible.put(id, showing);
	}
}
