package com.jeehw.controller;

import com.jeehw.model.entity.Guest;
import com.jeehw.repository.GuestRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@RequestScoped
public class GuestListController implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(GuestListController.class.getName());

    @Inject
    private GuestRepository guests;

    private List<Guest> guestList = new ArrayList<>();

    public void init() {
        LOGGER.info("Initializing guest list....");
        this.guestList = guests.findAll();
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }
}
