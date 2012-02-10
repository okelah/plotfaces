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

import javax.faces.component.UIComponentBase;

/**
 *
 * @author Graham Smith
 */
public abstract class UIPlot extends UIComponentBase {
	
	public static final String FAMILY = "org.plotfaces";
	
	protected enum PropertyKeys {
		style, styleClass, options;
	}
	
	public UIPlot() {
	}

	@Override
	public String getFamily() {
		return FAMILY;
	}
	
	public String getStyle() {
		return (String)getStateHelper().eval( PropertyKeys.style, null );
	}
	
	public void setStyle( String style ) {
		getStateHelper().put( PropertyKeys.style, style );
	}
	
	public String getStyleClass() {
		return (String)getStateHelper().eval( PropertyKeys.styleClass, null );
	}
	
	public void setStyleClass( String styleClass ) {
		getStateHelper().put( PropertyKeys.styleClass, styleClass );
	}
	
	public Object getOptions() {
		return getStateHelper().eval( PropertyKeys.options, null );
	}
	
	public void setOptions( Object options ) {
		getStateHelper().put( PropertyKeys.options, options );
	}
	
//	public Object getAxes() {
//		return getStateHelper().eval( PropertyKeys.axes, null );
//	}
//	
//	public void setXAxisLabel( Object axes ) {
//		getStateHelper().put( PropertyKeys.axes, axes );
//	}
//	
//	public Object getSeriesDefaults() {
//		return getStateHelper().eval( PropertyKeys.seriesDefaults, null );
//	}
//	
//	public void setSeriesDefaults( Object seriesDefaults ) {
//		getStateHelper().put( PropertyKeys.seriesDefaults, seriesDefaults );
//	}
	
}
