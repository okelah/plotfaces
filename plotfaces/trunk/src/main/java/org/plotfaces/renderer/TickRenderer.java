package org.plotfaces.renderer;

public abstract class TickRenderer {

	public boolean plot(StringBuilder builder, boolean isCloseOptions, boolean isCommaRequired ) {
		if( isCommaRequired ) {
			builder.append("," );
		}
		builder.append("\ntickRenderer: $.jqplot.");
		builder.append(getClass().getSimpleName());
		builder.append(",\ntickOptions: ");
		builder.append("{");
		
		if( isCloseOptions ) {
			builder.append( "}" );
		}
		return false;
	}
}
