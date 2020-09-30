package be.pxl.ja.streamingservice.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordUtilCalculateStrengthTest {
    @Test
    void whenLengthSmallerThan6CalculateStrengthShouldReturn0 () {
        assertEquals(0, PasswordUtil.calculateStrength("abc"));
    }

    @Test
    void whenLengthBetween6And10WithOnlyLowerCaseCalculateStrengthShouldReturn3 () {
        assertEquals(3, PasswordUtil.calculateStrength("marlies"));
    }

    @Test
    void whenLengthLargerThan10WithOnlyLowerCaseCalculateStrengthShouldReturn4 () {
        assertEquals(4,PasswordUtil.calculateStrength("abcdefghijkl"));
    }

    @Test
    void whenLengthLargerThan10WithLowerAndCapitalCaseDigitAndSpecialCharacterCalculateStrengthShouldReturn10 () {
        assertEquals(10, PasswordUtil.calculateStrength("AbcD3fgh!jkl"));
    }
}
