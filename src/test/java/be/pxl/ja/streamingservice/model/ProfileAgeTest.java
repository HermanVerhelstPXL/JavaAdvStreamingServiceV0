package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.model.Profile;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileAgeTest {
    @Test
    void itShouldGetCorrectAgeWhenSettingBirthdate() {
        // ARRANGE
        Profile profile = new Profile();

        // ACT
        profile.setDateOfBirth(LocalDate.of(2001, 12, 28));

        // ASSERT
        assertTrue(profile.getAge() == 18);
    }
}
