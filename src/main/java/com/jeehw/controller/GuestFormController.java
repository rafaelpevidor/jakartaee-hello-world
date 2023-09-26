package com.jeehw.controller;

import com.jeehw.model.entity.Guest;
import com.jeehw.repository.GuestRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.h2.util.StringUtils;

import java.io.Serializable;
import java.util.logging.Logger;

@Named
@RequestScoped
public class GuestFormController implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(GuestFormController.class.getName());

    private String guestId;
    private Guest guest = new Guest();

    @Inject
    private GuestRepository guests;

    public void init() {
        if (StringUtils.isNullOrEmpty(guestId)) return;
        guest = guests.findOne(guestId);
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
