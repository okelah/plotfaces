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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.plotfaces.renderer.AxisTickRenderer;
import org.plotfaces.renderer.CanvasAxisTickRenderer;
import org.plotfaces.renderer.TickRenderer;

/**
 * The JSF EL lacks an instanceof type check so a call such as<br/>
 * #{axis.tickRenderer['class'].simpleName == 'AxisTickRenderer' }<br/>
 * will not work as desired if the tick renderer is of the type
 * CanvasAxisTickRenderer (or another sub-class). This class provides a range of
 * simple instanceof checks that can be used in JSF pages.
 *
 * See: https://java.net/jira/browse/JSP_SPEC_PUBLIC-113
 *
 * @author Graham Smith
 */
@Named
@ApplicationScoped
public class TypeCheck {

	public TypeCheck() {
	}

	public boolean isAxisTickRenderer(TickRenderer tickRenderer) {
		return tickRenderer instanceof AxisTickRenderer;
	}

	public boolean isCanvasAxisTickRenderer(TickRenderer tickRenderer) {
		return tickRenderer instanceof CanvasAxisTickRenderer;
	}
}
