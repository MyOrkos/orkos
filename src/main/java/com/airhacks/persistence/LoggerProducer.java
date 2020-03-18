package com.airhacks.persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.Serializable;

public class LoggerProducer implements Serializable {

    @Produces
    public Logger getLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
