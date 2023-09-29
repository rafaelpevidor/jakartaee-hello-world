package com.jeehw.repository;

import com.jeehw.model.entity.Guest;
import jakarta.ejb.Stateless;

@Stateless
public class GuestRepository extends GenericRepository<Guest> {

    public GuestRepository() {
        super(Guest.class);
    }
}
