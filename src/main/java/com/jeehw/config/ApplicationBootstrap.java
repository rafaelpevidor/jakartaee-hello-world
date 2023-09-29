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

@Startup//which means this bean will be initialized as soon as possible when EJB container is ready. And must be used with singleton EJB
@Singleton
public class ApplicationBootstrap {


    private static final Logger LOGGER = Logger.getLogger(ApplicationBootstrap.class.getName());

    @Inject
    private GuestRepository guests;

    @PostConstruct
    public void init() {
        LOGGER.info("Initializing application: loading data...");

        Stream.of("First", "Second")
                .map(s -> {
                    Guest guest = new Guest();
                    guest.setFirstName(s);
                    guest.setLastName(capitalizeFirst(new StringBuilder(s).reverse().toString()));
                    guest.setEmail("%s@ymail.com".formatted(s).toLowerCase());
                    guest.setTitleName("Mr.");
                    return guest;
                })
                .map(data -> guests.save(data))
                .collect(Collectors.toList())
                .forEach(guest -> LOGGER.log(Level.INFO, " Guest saved: {0}", new Object[]{guest}));
    }

    private String capitalizeFirst(String word) {
        return word.substring(0, 1).toUpperCase()
                + word.substring(1).toLowerCase();
    }
}
