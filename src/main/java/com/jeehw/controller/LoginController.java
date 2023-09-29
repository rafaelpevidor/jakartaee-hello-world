package com.jeehw.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import java.io.Serializable;

@Named
@RequestScoped
public class LoginController implements Serializable {

    private String title = ".:Login:.";
    private String email;
    private String password;
    private boolean remember;

    public void doLogin() {
        Messages.addInfo(null,"Logged in sucessfully as " + email + ".");
        Faces.getExternalContext().getFlash().setKeepMessages(true);
        Faces.redirect("app/home.xhtml");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}
