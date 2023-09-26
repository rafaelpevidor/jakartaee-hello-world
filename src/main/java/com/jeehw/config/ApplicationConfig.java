package com.jeehw.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;

//@CustomFormAuthenticationMechanismDefinition(
//        loginToContinue = @LoginToContinue(
//                loginPage = "/login.xhtml",
//                errorPage = "/login.xhtml",
//                useForwardToLogin = false
//        )
//)
@FacesConfig
@ApplicationScoped
public class ApplicationConfig {
}
