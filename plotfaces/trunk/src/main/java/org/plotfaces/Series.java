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
import org.plotfaces.Axis.AxisName;

/**
 *
 * @author Graham Smith
 */
public class Series implements Encodable {
	
	private boolean show = true;
	private Axis.AxisName xAxis;
	private Axis.AxisName yAxis;
	private String renderer;
	
	public Series() {
	}
	
	public String encode() {
		StringBuilder builder = new StringBuilder();
		builder.append( "{" );
		builder.append( "show:" + Boolean.toString(isShow()) );
		if( xAxis != null ) {
			builder.append( ", xaxis: '" + getxAxis().name() + "'" );
		}
		
		if( yAxis != null ) {
			builder.append( ", yaxis: '" + getyAxis().name() + "'" );
		}
		
		if( renderer != null ) {
			builder.append( ", renderer:" + getRenderer() );
		}
		builder.append( "}" );
		return builder.toString();
	}

	public String getRenderer() {
		return renderer;
	}

	public void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	/**
	 * Whether this series will be shown. Default is true (displayed).
	 * 
	 * @return 
	 */
	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public AxisName getxAxis() {
		return xAxis;
	}

	public void setxAxis(AxisName xAxis) {
		this.xAxis = xAxis;
	}

	public AxisName getyAxis() {
		return yAxis;
	}

	public void setyAxis(AxisName yAxis) {
		this.yAxis = yAxis;
	}
	
}
