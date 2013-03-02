package org.plotfaces.renderer;

import org.plotfaces.PlotUtilities;

public class CategoryAxisRenderer extends AxisRenderer {
	private Boolean sortMergedLabels;
	private TickRenderer tickRenderer;
	
	@Override
	public boolean plot(StringBuilder builder, boolean isCloseOptions ) {
		boolean isCommaRequired = super.plot(builder, false);

		if (getSortMergedLabels() != null) {
			isCommaRequired = PlotUtilities.addVariable( builder, "sortMergedLabels", String.valueOf( getSortMergedLabels() ), isCommaRequired );
		}
		
		if( getTickRenderer() != null ) {
			if( isCommaRequired ) {
				builder.append(",");
			} else {
				isCommaRequired = true;
			}
			getTickRenderer().plot( builder, isCloseOptions );
		}
		
		if( isCloseOptions ) {
			builder.append("}");
		}
		
		return isCommaRequired;
	}

	/**
	 * True to sort tick labels when labels are created by merging x axis values from multiple series.  That is, say you have two series like:
	 *
     * line1 = [[2006, 4],            [2008, 9], [2009, 16]];
     * line2 = [[2006, 3], [2007, 7], [2008, 6]];
     *
	 * If no label array is specified, tick labels will be collected from the x values of the series.  With sortMergedLabels set to true, tick labels will be:
	 *
     * [2006, 2007, 2008, 2009]
	 * 
	 * With sortMergedLabels set to false, tick labels will be:
	 * 
	 *     [2006, 2008, 2009, 2007]
	 * 
	 * Note, this property is specified on the renderOptions for the axes when creating a plot:
	 * 
	 *     axes:{xaxis:{renderer:$.jqplot.CategoryAxisRenderer, rendererOptions:{sortMergedLabels:true}}}
	 *     
	 * @return the sortMergedLabels
	 */
	public Boolean getSortMergedLabels() {
		return sortMergedLabels;
	}

	/**
	 * @param sortMergedLabels the sortMergedLabels to set
	 */
	public void setSortMergedLabels(Boolean sortMergedLabels) {
		this.sortMergedLabels = sortMergedLabels;
	}

	/**
	 * @return the tickRenderer
	 */
	public TickRenderer getTickRenderer() {
		return tickRenderer;
	}

	/**
	 * @param tickRenderer the tickRenderer to set
	 */
	public void setTickRenderer(TickRenderer tickRenderer) {
		this.tickRenderer = tickRenderer;
	}
}
