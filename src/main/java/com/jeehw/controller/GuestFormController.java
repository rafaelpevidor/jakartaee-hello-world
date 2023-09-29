package com.jeehw.controller;

import com.jeehw.model.entity.Guest;
import com.jeehw.repository.GuestRepository;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.h2.util.StringUtils;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class GuestFormController implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(GuestFormController.class.getName());

    private String guestId;
    private Guest guest;

    @Inject
    FacesContext facesContext;

    @Inject
    private GuestRepository guests;

    public void init() {
        LOGGER.info("Initializing guest form...");
        if (StringUtils.isNullOrEmpty(guestId)) {
            guest = new Guest();
        } else {
            LOGGER.log(Level.INFO, "Loading guest from database... [{0}]", guestId);
            guest = guests.findOne(guestId);
            LOGGER.info(guest.toString());
        }
    }

    public String save() {
        LOGGER.log(Level.INFO, "Saving guest@{0}", guest);
        guests.save(guest);
        FacesMessage info = new FacesMessage( "Guest is saved successfully!");
        facesContext.addMessage(null, info);
        return "/app/admin/guest/list.xhtml?faces-redirect=true";
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
