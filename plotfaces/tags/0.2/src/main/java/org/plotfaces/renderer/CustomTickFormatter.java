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
 * A tick formatter that allows the use to specify a custom formatter to use. It
 * is the users responsibility to ensure that the custom formatter class is
 * available to the client side JavaScript.
 *
 * @author Graham Smith
 */
public class CustomTickFormatter extends AbstractTickFormatter {

	private String formatter;

	public CustomTickFormatter() {
	}

	public CustomTickFormatter(String formatter) {
		this.formatter = formatter;
	}

	@Override
	public String getRendererName() {
		return getFormatter();
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}
}
