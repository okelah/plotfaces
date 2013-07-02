/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.plotfacesdemo;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Graham Smith
 */
public class LoggingUtilities {

	@Produces
	public Logger produceLogger(final InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
	}
}
