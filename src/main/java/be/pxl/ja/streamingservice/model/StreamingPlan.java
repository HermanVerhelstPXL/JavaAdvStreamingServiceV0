package be.pxl.ja.streamingservice.model;

import java.math.BigDecimal;

public enum StreamingPlan {
    BASIC(1, BigDecimal.valueOf(7.99)),
    STANDAARD(2, BigDecimal.valueOf(11.99)),
    PREMIUM(4, BigDecimal.valueOf(15.99));

    private int numberOfProfiles;
    private BigDecimal price;

    StreamingPlan(int numberOfProfiles, BigDecimal price) {
        this.numberOfProfiles = numberOfProfiles;
        this.price = price;
    }
}
