package org.plotfaces.renderer;

public abstract class TickRenderer {

	public boolean plot(StringBuilder builder, boolean isCloseOptions ) {
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
