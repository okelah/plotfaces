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

public class LoggerFactoryProducer {
    
    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
    }

}
}
