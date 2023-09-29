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

    private List<Guest> entityList = new ArrayList<>();

    //Method to initialize the data in the page in JSF invoke application phase. The execution is triggered by a viewAction in xhtml page.
    public void init() {
        LOGGER.info("Initializing guest list...");
        this.entityList = guests.findAll();
    }

    public List<Guest> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Guest> entityList) {
        this.entityList = entityList;
    }
}
