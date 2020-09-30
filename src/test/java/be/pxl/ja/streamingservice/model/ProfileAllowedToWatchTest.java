package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProfileAllowedToWatchTest {
    private Profile profile;
    private Content content;
    @BeforeEach
    public void init() {
        profile = new Profile();
        content = new Content("test", Rating.TEENS);
    }


    @Test
    void ifDateOfBirthNullReturnFalse () {
        assertFalse(profile.allowedToWatch(content));
    }

    @Test
    void ifAgeLowerThanMinimumAgeReturnFalse () {
        profile.setDateOfBirth(LocalDate.now());
        assertFalse(profile.allowedToWatch(content));
    }

    @Test
    void ifAgeHigherThanMinimumAgeReturnTrue () {
        profile.setDateOfBirth(LocalDate.of(1990, 1, 1));
        assertTrue(profile.allowedToWatch(content));
    }

}