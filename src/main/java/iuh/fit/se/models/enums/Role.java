package iuh.fit.se.models.enums;

public enum Role {
    ADMIN("Admin"), 
    CUSTOMER("Customer"), 
    GUEST("Guest");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
