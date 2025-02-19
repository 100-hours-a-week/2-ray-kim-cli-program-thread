package constants;

public enum Category {
    COMPUTER("컴퓨터", new ProductType[]{ProductType.IMAC, ProductType.MACBOOK}),
    MOBILE("모바일", new ProductType[]{ProductType.IPHONE, ProductType.IPAD});

    private final String displayName;
    private final ProductType[] productTypes;

    Category(String displayName, ProductType[] productTypes) {
        this.displayName = displayName;
        this.productTypes = productTypes;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ProductType[] getProductTypes() {
        return productTypes;
    }
}