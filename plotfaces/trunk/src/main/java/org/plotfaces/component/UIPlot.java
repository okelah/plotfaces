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
package org.plotfaces.component;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UIOutput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 *
 * @author Graham Smith
 */
public class UIPlot extends UIComponentBase implements SystemEventListener {

    public static final String DEFAULT_REDERER = "org.plotfaces.component.PlotRenderer";
    public static final String COMPONENT_FAMILY = "org.plotfaces";

    protected enum PropertyKeys {
	style, styleClass, options, data;
    }
    
    public UIPlot() {
    	setRendererType( DEFAULT_REDERER );
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();

        root.subscribeToViewEvent( PostAddToViewEvent.class, this );
    }
    
    public boolean isListenerForSource( Object source ) {
        return ( source instanceof UIViewRoot );
    }

    public void processEvent( SystemEvent event ) throws AbortProcessingException {
		FacesContext context = FacesContext.getCurrentInstance();
		List<UIComponent> componentResources = context.getViewRoot().getComponentResources(context, "head" );
		boolean primefacesExists = false;
		boolean includeJqueryJs = true;
		for( int i = 0, n = componentResources.size(); i < n; i++ ) {
			if( "primefaces".equals( componentResources.get( i ).getAttributes().get( "library" ) ) ) {
				primefacesExists = true;
				if( "jquery/jquery.js".equals( componentResources.get( i ).getAttributes().get( "name" ) ) ) {
					includeJqueryJs = false;
					break;
				}
			}
		}
		
		if( includeJqueryJs ) {
			UIOutput js = new UIOutput();
			js.setRendererType("javax.faces.resource.Script");
			if( primefacesExists ) {
		    	js.getAttributes().put("library", "primefaces");
		    	js.getAttributes().put("name", "jquery.js");
			} else {
		    	js.getAttributes().put("library", "plotfaces");
		    	js.getAttributes().put("name", "jquery.js");
			}
			
			context.getViewRoot().addComponentResource(context, js, "head");	
		}
    }

    @Override
    public String getFamily() {
	return COMPONENT_FAMILY;
    }

    public String getStyle() {
	return (String) getStateHelper().eval(PropertyKeys.style, null);
    }

    public void setStyle(String style) {
	getStateHelper().put(PropertyKeys.style, style);
    }

    public String getStyleClass() {
	return (String) getStateHelper().eval(PropertyKeys.styleClass, null);
    }

    public void setStyleClass(String styleClass) {
	getStateHelper().put(PropertyKeys.styleClass, styleClass);
    }

    public Object getOptions() {
	return getStateHelper().eval(PropertyKeys.options, null);
    }

    public void setOptions(Object options) {
	getStateHelper().put(PropertyKeys.options, options);
    }

    public Object getData() {
	return getStateHelper().eval(PropertyKeys.data, null);
    }

    public void setData(Object data) {
	getStateHelper().put(PropertyKeys.data, data);
    }
}
