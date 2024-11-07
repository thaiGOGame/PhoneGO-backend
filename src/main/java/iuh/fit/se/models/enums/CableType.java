package iuh.fit.se.models.enums;

public enum CableType {
    TYPE_C("Type-C"),
    MICRO_USB("Micro-USB"),
    LIGHTNING("Lightning"),
    USB_A("USB-A"),
    USB_B("USB-B");

    private final String displayName;

    CableType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
