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
package org.plotfaces.model;

/**
 * A hold for the various axes that can be created in a chart.
 *
 * @author Graham Smith
 */
public class Axes {

	private Axis xaxis;
	private Axis x2axis;
	private Axis yaxis;
	private Axis y2axis;
	private Axis y3axis;
	private Axis y4axis;
	private Axis y5axis;
	private Axis y6axis;
	private Axis y7axis;
	private Axis y8axis;
	private Axis y9axis;
	private Axis yMidAxis;

	public Axes() {
	}

	public Axis getXaxis() {
		return xaxis;
	}

	public void setXaxis(Axis xaxis) {
		this.xaxis = xaxis;
	}

	public Axis getX2axis() {
		return x2axis;
	}

	public void setX2axis(Axis x2axis) {
		this.x2axis = x2axis;
	}

	public Axis getYaxis() {
		return yaxis;
	}

	public void setYaxis(Axis yaxis) {
		this.yaxis = yaxis;
	}

	public Axis getY2axis() {
		return y2axis;
	}

	public void setY2axis(Axis y2axis) {
		this.y2axis = y2axis;
	}

	public Axis getY3axis() {
		return y3axis;
	}

	public void setY3axis(Axis y3axis) {
		this.y3axis = y3axis;
	}

	public Axis getY4axis() {
		return y4axis;
	}

	public void setY4axis(Axis y4axis) {
		this.y4axis = y4axis;
	}

	public Axis getY5axis() {
		return y5axis;
	}

	public void setY5axis(Axis y5axis) {
		this.y5axis = y5axis;
	}

	public Axis getY6axis() {
		return y6axis;
	}

	public void setY6axis(Axis y6axis) {
		this.y6axis = y6axis;
	}

	public Axis getY7axis() {
		return y7axis;
	}

	public void setY7axis(Axis y7axis) {
		this.y7axis = y7axis;
	}

	public Axis getY8axis() {
		return y8axis;
	}

	public void setY8axis(Axis y8axis) {
		this.y8axis = y8axis;
	}

	public Axis getY9axis() {
		return y9axis;
	}

	public void setY9axis(Axis y9axis) {
		this.y9axis = y9axis;
	}

	public Axis getyMidAxis() {
		return yMidAxis;
	}

	public void setyMidAxis(Axis yMidAxis) {
		this.yMidAxis = yMidAxis;
	}

	public boolean isEmpty() {
		return xaxis == null && x2axis == null
				&& yaxis == null && y2axis == null
				&& y3axis == null && y4axis == null
				&& y5axis == null && y6axis == null
				&& y7axis == null && y8axis == null
				&& y9axis == null && yMidAxis == null;
	}
}
