package constants;

public enum ProductType {
    IMAC("iMac"),
    MACBOOK("MacBook"),
    IPHONE("iPhone"),
    IPAD("iPad");

    private final String displayName;

    ProductType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}