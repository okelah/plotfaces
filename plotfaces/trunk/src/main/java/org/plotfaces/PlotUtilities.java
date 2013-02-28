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
     * it as a sub-selector. This method escapes any colons in the id to make 
     * it JavaScript safe.
     *
     * @param id the id to escape.
     * @return the JavaScript safe escaped id.
     */
    public static String getEscapedClientId(FacesContext context, UIComponent component) {
        return component.getClientId(context).replace(":", "\\\\:");
    }
    
	public static boolean addVariable( StringBuilder stringBuilder, String variableName, String variableValue, Boolean isCommaRequired ) {
		return addVariable(stringBuilder, variableName, variableValue, isCommaRequired, false);
	}
	
	public static boolean addVariable( StringBuilder stringBuilder, String variableName, String variableValue, Boolean isCommaRequired, boolean isString ) {
		if( isCommaRequired ) {
			stringBuilder.append( "," );
		} else {
			isCommaRequired = true;
		}
		stringBuilder.append( "\n" );
		stringBuilder.append( variableName ).append( ":" );
		if( isString ) {
			stringBuilder.append( "'" );
		}
		stringBuilder.append( variableValue );
		if( isString ) {
			stringBuilder.append( "'" );
		}
		return isCommaRequired;
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
