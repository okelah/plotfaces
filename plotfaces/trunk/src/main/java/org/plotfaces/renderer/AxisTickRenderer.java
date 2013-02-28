package org.plotfaces.renderer;

public class AxisTickRenderer {
	private Integer size;
	private Boolean escapeHtml; 
	
	/**
	 * Length of the tick beyond the grid in pixels.  DEPRECATED: This has been superceeded by markSize
	 * default 4
	 * 
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * Length of the tick beyond the grid in pixels.  DEPRECATED: This has been superceeded by markSize
	 * default 4
	 * 
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	/**
	 * true to escape HTML entities in the label.
	 * default false
	 * 
	 * @return the escapeHtml
	 */
	public Boolean getEscapeHtml() {
		return escapeHtml;
	}
	/**
	 * true to escape HTML entities in the label.
	 * default false
	 * 
	 * @param escapeHtml the escapeHtml to set
	 */
	public void setEscapeHtml(Boolean escapeHtml) {
		this.escapeHtml = escapeHtml;
	}
}
