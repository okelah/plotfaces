/*
 * Copyright 2012 Graham Smith.
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
package org.plotfaces;

import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

/**
 *
 * @author Graham Smith
 */
public final class PlotUtilities {

	private PlotUtilities() {
	}

	/**
	 * The default separator character for JSF is a colon. However jQuery trips
	 * up badly if presented with an id that contains a colon because it treats
	 * it as a sub-selector. This method escapes any colons in the id to make it
	 * JavaScript safe.
	 *
	 * @param id the id to escape.
	 * @return the JavaScript safe escaped id.
	 */
	public static String getEscapedClientId(FacesContext context, UIComponent component) {
		return component.getClientId(context).replace(":", "\\\\:");
	}

	@Deprecated
	public static boolean addVariable(StringBuilder stringBuilder, String variableName, String variableValue, Boolean isCommaRequired) {
		return addVariable(stringBuilder, variableName, variableValue, isCommaRequired, true);
	}

	@Deprecated
	public static boolean addVariable(StringBuilder stringBuilder, String variableName, String variableValue, Boolean isCommaRequired, boolean addApostrophes) {
		if (variableValue != null && !variableValue.equals("")) {
			if (addApostrophes) {
				StringBuffer variableValueBuf = new StringBuffer();
				variableValueBuf.append("'");
				variableValueBuf.append(variableValue);
				variableValueBuf.append("'");
				variableValue = variableValueBuf.toString();
			}
			addProcessedVariable(stringBuilder, variableName, String.valueOf(variableValue), isCommaRequired);
			return true;
		}
		return isCommaRequired;
	}

	@Deprecated
	public static boolean addVariable(StringBuilder stringBuilder, String variableName, Number variableValue, Boolean isCommaRequired) {
		if (variableValue != null) {
			addProcessedVariable(stringBuilder, variableName, String.valueOf(variableValue), isCommaRequired);
			return true;
		}
		return isCommaRequired;
	}

	@Deprecated
	public static boolean addVariable(StringBuilder stringBuilder, String variableName, Boolean variableValue, Boolean isCommaRequired) {
		if (variableValue != null) {
			addProcessedVariable(stringBuilder, variableName, String.valueOf(variableValue), isCommaRequired);
			return true;
		}
		return isCommaRequired;
	}

	@Deprecated
	private static void addProcessedVariable(StringBuilder stringBuilder, String variableName, String variableValue, Boolean isCommaRequired) {
		if (isCommaRequired) {
			stringBuilder.append(",");
		}
		stringBuilder.append("\n");
		stringBuilder.append(variableName).append(":");
		stringBuilder.append(variableValue);
	}

	/**
	 * Creates a new variable entry with the format:<br/>
	 * variableName:variableValue<br/>
	 * If the variableValue is a {@code String} or an enumerated type the value
	 * is wrapped in single quotes like this:<br/>
	 * variableName:'variableValue'<br/>
	 *
	 * @param variableName
	 * @param variableValue
	 * @return
	 */
	public static String createVariable(String variableName, Object variableValue) {
		return createVariable(variableName, variableValue, false);
	}

	public static String createVariable(String variableName, Object variableValue, boolean suppressStringQuoting) {
		boolean isString = variableValue instanceof String;
		boolean isEnum = variableValue.getClass().isEnum();
		boolean quote = !suppressStringQuoting && (isString || isEnum);

		StringBuilder builder = new StringBuilder();
		builder.append(variableName).append(":");
		if (quote) {
			builder.append("'");
		}
		builder.append(variableValue);
		if (quote) {
			builder.append("'");
		}
		return builder.toString();
	}

	/**
	 * We often need to name JavaScript variables in a unique way. The obvious
	 * choice is to use the component id but this usually contains characters
	 * that can't be included in variable names.
	 *
	 * @param context
	 * @param component
	 * @return
	 */
	public static String getSafeClientId(FacesContext context, UIComponent component) {
		return component.getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}
}
