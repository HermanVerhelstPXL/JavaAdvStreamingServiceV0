package be.pxl.ja.streamingservice.model;

public enum Rating {
    LITTLE_KIDS(0),
    OLDER_KIDS(7),
    TEENS(12),
    MATURE(16);

    private int minimumAge;

    Rating(int age) {
        minimumAge = age;
    }

    public int getMinimumAge() {
        return minimumAge;
    }
}
