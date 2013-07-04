package org.plotfaces.renderer;

import java.util.ArrayList;
import java.util.List;
import org.plotfaces.PlotUtilities;

public class CategoryAxisRenderer extends AbstractAxisRenderer {

	private static final String SORT_MERGED_LABELS = "sortMergedLabels";
	private Boolean sortMergedLabels;
	private TickRenderer tickRenderer;

	@Override
	protected List<String> getFragments() {
		List<String> fragments = new ArrayList<>();

		if (getSortMergedLabels() != null) {
			fragments.add(PlotUtilities.createVariable(SORT_MERGED_LABELS, getSortMergedLabels()));
		}

		if (getTickRenderer() != null) {
			fragments.add(getTickRenderer().plot());
		}

		return fragments;
	}

	/**
	 * True to sort tick labels when labels are created by merging x axis values
	 * from multiple series. That is, say you have two series like:
	 *
	 * line1 = [[2006, 4], [2008, 9], [2009, 16]]; line2 = [[2006, 3], [2007,
	 * 7], [2008, 6]];
	 *
	 * If no label array is specified, tick labels will be collected from the x
	 * values of the series. With sortMergedLabels set to true, tick labels will
	 * be:
	 *
	 * [2006, 2007, 2008, 2009]
	 *
	 * With sortMergedLabels set to false, tick labels will be:
	 *
	 * [2006, 2008, 2009, 2007]
	 *
	 * Note, this property is specified on the renderOptions for the axes when
	 * creating a plot:
	 *
	 * axes:{xaxis:{renderer:$.jqplot.CategoryAxisRenderer,
	 * rendererOptions:{sortMergedLabels:true}}}
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
	 * TODO: This sets a {@code TickRenderer} but the jqPlot documentation makes
	 * no mention of what to do with the options.
	 *
	 * @param tickRenderer the tickRenderer to set
	 */
	public void setTickRenderer(TickRenderer tickRenderer) {
		this.tickRenderer = tickRenderer;
	}

	@Override
	public String getRendererName() {
		return RENDERER_NAME_PREFIX + "CategoryAxisRenderer";
	}
}
