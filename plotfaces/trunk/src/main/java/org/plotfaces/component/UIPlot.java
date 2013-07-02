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
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UIOutput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostAddToViewEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import org.plotfaces.data.ChartModel;

/**
 *
 * @author Graham Smith
 */
@FacesComponent("UIPlot")
public class UIPlot extends UIComponentBase implements SystemEventListener {

	private static final String PRIMEFACES_LIBRARY = "primefaces";
	private static final String PRIMEFACES_JQUERY_LIBRARY = "jquery/jquery.js";
	private static final String PLOTFACES_LIBRARY = "plotfaces";
	private static final String PLOTFACES_JQUERY_LIBRARY = "jquery.min.js";
	private static final String JQPLOT_LIBRARY = "jquery.jqplot.cc.js";
	public static final String DEFAULT_REDERER = "org.plotfaces.component.PlotRenderer";
	public static final String COMPONENT_FAMILY = "org.plotfaces";

	protected enum PropertyKeys {

		style, styleClass, chartModel, data, rendererOptions;
	}

	public UIPlot() {
		setRendererType(DEFAULT_REDERER);
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot root = context.getViewRoot();
		root.subscribeToViewEvent(PostAddToViewEvent.class, this);
	}

	@Override
	public boolean isListenerForSource(Object source) {
		return (source instanceof UIViewRoot);
	}

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		//We are listening for the creation of a new UIViewRoot so that we can
		//make sure that the jQuery library appears before the jqPlot libraries
		//and optionally add in the jQuery library if it isn't found.

		FacesContext context = FacesContext.getCurrentInstance();
		List<UIComponent> componentResources = context.getViewRoot().getComponentResources(context, "head");
		boolean primefacesExists = false;
		int jqueryIdx = -1;
		int jqPlotIdx = -1;
		for (int i = 0, n = componentResources.size(); i < n; i++) {
			if (PRIMEFACES_LIBRARY.equals(componentResources.get(i).getAttributes().get("library"))) {
				primefacesExists = true;
				if (PRIMEFACES_JQUERY_LIBRARY.equals(componentResources.get(i).getAttributes().get("name"))) {
					jqueryIdx = i;
					//Move the jQuery library to before the jqPlot library.
					if (jqPlotIdx != -1) {
						UIComponent jqueryResource = componentResources.remove(jqueryIdx);
						componentResources.add(jqPlotIdx, jqueryResource);
					}
					break;
				}
			} else if (PLOTFACES_LIBRARY.equals(componentResources.get(i).getAttributes().get("library"))) {
				if (JQPLOT_LIBRARY.equals(componentResources.get(i).getAttributes().get("name"))) {
					jqPlotIdx = i;
				}
			}
		}

		//If we've not found jQuery make sure that it gets added.
		if (jqueryIdx == -1) {
			UIOutput js = new UIOutput();
			js.setRendererType("javax.faces.resource.Script");
			//If we've found PrimeFaces then we've probably found jQuery already
			//but just in case we haven't add the PrimeFaces version of the
			//jQuery library. Failing that add our version.
			if (primefacesExists) {
				js.getAttributes().put("library", PRIMEFACES_LIBRARY);
				js.getAttributes().put("name", PRIMEFACES_JQUERY_LIBRARY);
			} else {
				js.getAttributes().put("library", PLOTFACES_LIBRARY);
				js.getAttributes().put("name", PLOTFACES_JQUERY_LIBRARY);
			}

			//Add jQuery to the start of the list because it's required by everything.
			componentResources.add(0, js);
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

	public ChartModel getChartModel() {
		return (ChartModel) getStateHelper().eval(PropertyKeys.chartModel, null);
	}

	public void setChartModel(ChartModel chartModel) {
		getStateHelper().put(PropertyKeys.chartModel, chartModel);
	}

//	public Object getData() {
//		return getStateHelper().eval(PropertyKeys.data, null);
//	}
//
//	public void setData(Object data) {
//		getStateHelper().put(PropertyKeys.data, data);
//	}
	/**
	 * Get the renderer options that control how the output is produced and
	 * formatted.
	 *
	 * @return
	 */
	public Object getRendererOptions() {
		return getStateHelper().eval(PropertyKeys.rendererOptions, null);
	}

	/**
	 * Set renderer options that control how the output is produced and
	 * formatted.
	 *
	 * @param data
	 */
	public void setRendererOptions(Object data) {
		getStateHelper().put(PropertyKeys.rendererOptions, data);
	}
}
