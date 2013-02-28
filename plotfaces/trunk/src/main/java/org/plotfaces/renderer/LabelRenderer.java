package org.plotfaces.renderer;

public class LabelRenderer {
	public void plot( StringBuilder builder ) {
		builder.append(",\nlabelRender: ");
		builder.append(getClass().getSimpleName());
//		builder.append(",\nlabelOptions: ");
//		builder.append(getLabelOptions());
	}
}
