package com.jeehw.config;

import com.jeehw.model.entity.Guest;
import com.jeehw.repository.GuestRepository;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Startup
@Singleton
public class Bootstrap {


    private static final Logger LOGGER = Logger.getLogger(Bootstrap.class.getName());

    @Inject
    private GuestRepository guests;

    @PostConstruct
    public void init() {
        LOGGER.info("Initializing application: loading data...");

        Stream.of("First", "Second")
                .map(s -> {
                    Guest guest = new Guest();
                    guest.setFirstName(s);
                    guest.setEmail("%s@ymail.com".formatted(s));
                    guest.setTitleName("Mr.");
                    return guest;
                })
                .map(data -> guests.save(data))
                .collect(Collectors.toList())
                .forEach(guest -> LOGGER.log(Level.INFO, " Guest saved: {0}", new Object[]{guest}));
    }
}
