package org.plotfaces.renderer;

import java.util.List;
import org.plotfaces.data.Plotable;

public abstract class AbstractLabelRenderer implements LabelRenderer {

	public AbstractLabelRenderer() {
	}

	/**
	 * Provides the standard opening to the renderer block of options.
	 *
	 * @return
	 */
	protected String plotBegin() {
		StringBuilder builder = new StringBuilder();
		builder.append("labelRenderer: $.jqplot.");
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
	public abstract String plot();

	@Override
	public abstract String getRendererName();

	protected abstract List<String> getFragments();
}
