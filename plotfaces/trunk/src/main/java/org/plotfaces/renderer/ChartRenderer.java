package org.plotfaces.renderer;

public abstract class ChartRenderer {

	private Boolean highlightMouseOver;
	private Boolean highlightMouseDown;
	private String highlightColor;

	/**
	 * Provides the type of the renderer for the renderer option.
	 *
	 * @return
	 */
	public abstract String getRendererType();

	/**
	 * True to highlight area on a filled plot when moused over. This must be
	 * false to enable highlightMouseDown to highlight when clicking on an area
	 * on a filled plot. default true;
	 *
	 * @return the highlightMouseOver
	 */
	public Boolean getHighlightMouseOver() {
		return highlightMouseOver;
	}

	/**
	 * True to highlight area on a filled plot when moused over. This must be
	 * false to enable highlightMouseDown to highlight when clicking on an area
	 * on a filled plot. default true
	 *
	 * @param highlightMouseOver the highlightMouseOver to set
	 */
	public void setHighlightMouseOver(Boolean highlightMouseOver) {
		this.highlightMouseOver = highlightMouseOver;
	}

	/**
	 * True to highlight when a mouse button is pressed over an area on a filled
	 * plot. This will be disabled if highlightMouseOver is true. default false
	 *
	 * @return the highlightMouseDown
	 */
	public Boolean getHighlightMouseDown() {
		return highlightMouseDown;
	}

	/**
	 * True to highlight when a mouse button is pressed over an area on a filled
	 * plot. This will be disabled if highlightMouseOver is true. default false
	 *
	 * @param highlightMouseDown the highlightMouseDown to set
	 */
	public void setHighlightMouseDown(Boolean highlightMouseDown) {
		this.highlightMouseDown = highlightMouseDown;
	}

	/**
	 * Colour to use when highlighting an area on a filled plot. default null
	 *
	 * @return the highlightColor
	 */
	public String getHighlightColor() {
		return highlightColor;
	}

	/**
	 * Colour to use when highlighting an area on a filled plot. default null
	 *
	 * @param highlightColor the highlightColor to set
	 */
	public void setHighlightColor(String highlightColor) {
		this.highlightColor = highlightColor;
	}
}
