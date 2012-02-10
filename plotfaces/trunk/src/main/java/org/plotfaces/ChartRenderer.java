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

import java.io.IOException;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

/**
 *
 * @author Graham Smith
 */
@ResourceDependencies({
	@ResourceDependency(library="plotfaces", name="jquery.jqplot.css"),
	@ResourceDependency(library="plotfaces", name="jquery.js"),
	@ResourceDependency(library="plotfaces", name="jquery.jqplot.js"),
	@ResourceDependency(library="plotfaces", name="plugins/jqplot.barRenderer.js")
})
public class ChartRenderer extends Renderer {

	public static final String DATA_SUFFIX = "_data";
	public static final String PLOT_SUFFIX = "_plot";
	public static final String OPTIONS_SUFFIX = "_options";
	
	public ChartRenderer() {
	}
	
	public void encodeTag( FacesContext context, UIPlot plot ) throws IOException {
		ResponseWriter out = context.getResponseWriter();
		String id = plot.getClientId(context);
		
		out.startElement( "div", plot );
		
		out.writeAttribute( "id", id, "id" );
		
		if( plot.getStyle() != null ) {
			out.writeAttribute( "style", plot.getStyle(), "style");
		}		
		
		if( plot.getStyleClass() != null ) {
			out.writeAttribute( "class", plot.getStyleClass(), "class");	
		}
		
		out.endElement( "div" );
	}
	
	protected void encodeScriptBegin(ResponseWriter out, String id) throws IOException {
        out.startElement("script", null);
        out.writeAttribute("id", id + "_script", null);
        out.writeAttribute("type", "text/javascript", "type");
		out.write( "$(document).ready(function(){\n" );
    }
    
    protected void encodeScriptEnd(ResponseWriter out) throws IOException {
		out.write( "});\n" );
        out.endElement("script");
    }
	
	/**
	 * jQuery trips up badly if presented with an id that contains a colon because it
	 * treats it as a sub-selector. This method simply escapes any colons in the
	 * id to make the JavaScript safe.
	 * 
	 * @param id
	 * @return 
	 */
	public String getEscapedClientId( String id ) {
		return id.replace( ":", "\\\\:" );
	}
	
	/**
	 * We often need to name JavaScript variables in a unique way. The obvious choice is to use
	 * the component id but this usually contains characters that can't be included in
	 * variable names.
	 * 
	 * @param context
	 * @param component
	 * @return 
	 */
	public String getSafeClientId( FacesContext context, UIComponent component ) {
		return component.getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}
	
}
