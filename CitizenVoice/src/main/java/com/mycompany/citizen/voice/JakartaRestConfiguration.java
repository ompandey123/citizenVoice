package com.mycompany.citizen.voice;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@DeclareRoles({"admin", "citizen"})
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
    
}
