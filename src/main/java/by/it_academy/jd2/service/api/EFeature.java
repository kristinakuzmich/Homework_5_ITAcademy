package by.it_academy.jd2.service.api;

public enum EFeature {
    STORAGE_TYPE("SQL");

    private final String defaultValue;

    EFeature(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefault() {
        return defaultValue;
    }
}
