package iuh.fit.se.models.enums;

public enum Origin {
    CHINA("China"),
    SOUTH_KOREA("South Korea"),
    USA("USA"),
    JAPAN("Japan"),
    TAIWAN("Taiwan"),
    INDIA("India"),
    VIETNAM("Vietnam"),
    GERMANY("Germany"),
    SWEDEN("Sweden"),
    FINLAND("Finland");

    private final String country;

    Origin(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
