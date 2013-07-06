package org.plotfaces.renderer;

public abstract class AbstractLabelRenderer implements LabelRenderer {

	protected static final String RENDERER_NAME_PREFIX = "$.jqplot.";

	public AbstractLabelRenderer() {
	}

	@Override
	public abstract String getRendererName();
}
