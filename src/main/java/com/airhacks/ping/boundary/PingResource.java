package com.airhacks.ping.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.Serializable;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource implements Serializable {

    @GET
    public String ping() {
        return "Enjoy Java EE 8!";
    }

}
