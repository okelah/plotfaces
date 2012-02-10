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
import javax.faces.context.ResponseWriter;

/**
 *
 * @author Graham Smith
 */
public class Axis implements Encodable {
	
	public static enum AxisName{
		axisDefaults, xaxis, x2axis, yaxis, y2axis, y3axis, y4axis, y5axis, y6axis, y7axis, y8axis, y9axis;
	}
	
	private AxisName axisName;
	private String label;

	public Axis() {
	}

	public Axis(AxisName axisName) {
		this.axisName = axisName;
	}
	
	/**
	 * Used to encode these axis options for jqPlot.
	 * 
	 * @param out
	 * @throws IOException 
	 */
	public String encode( ) {
		StringBuilder builder = new StringBuilder();
		builder.append( getAxisName().name() + ":{\n" );
		builder.append( "label: '" + getLabel() + "'\n" );
		builder.append( "}" );
		return builder.toString();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public AxisName getAxisName() {
		return axisName;
	}

	/**
	 * Supports all of the current x (two) and y (nine) axes and the default axis.
	 * 
	 * @param axis 
	 */
	public void setAxisName(AxisName axisName) {
		this.axisName = axisName;
	}
	
	
	
}
