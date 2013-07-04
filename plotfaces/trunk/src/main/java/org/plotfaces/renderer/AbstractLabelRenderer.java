package org.plotfaces.renderer;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.plotfaces.data.Plotable;

public abstract class AbstractLabelRenderer implements LabelRenderer {

	protected static final String RENDERER_NAME_PREFIX = "$.jqplot.";

	public AbstractLabelRenderer() {
	}

	/**
	 * Provides the standard opening to the renderer block of options.
	 *
	 * @return
	 */
	protected String plotBegin() {
		StringBuilder builder = new StringBuilder();
		builder.append("labelRenderer: ");
		builder.append(getRendererName());
		builder.append(",\nlabelOptions: ");
		builder.append("{");
		return builder.toString();

	}

	/**
	 * Closes the renderer options block.
	 *
	 * @return
	 */
	protected String plotEnd() {
		return "}";
	}

	@Override
	public String plot() {
		StringBuilder builder = new StringBuilder();
		builder.append(plotBegin());
		builder.append(StringUtils.join(getFragments().toArray(), ",\n"));
		builder.append(plotEnd());
		return builder.toString();
	}

	@Override
	public abstract String getRendererName();

	protected abstract List<String> getFragments();
}
