package org.plotfaces.renderer;

public abstract class AxisRenderer {

	public boolean plot(StringBuilder builder, boolean isCloseOptions) {
		builder.append("\nrenderer: $.jqplot.");
		builder.append(getClass().getSimpleName());
		builder.append(",\nrendererOptions: ");
		builder.append("{");
		
		if( isCloseOptions ) {
			builder.append( "}" );
		}
		return false;
	}
}
