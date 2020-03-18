package com.airhacks;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.Serializable;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author airhacks.com
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application implements Serializable {

}
