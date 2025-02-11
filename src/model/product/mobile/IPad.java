package model.product.mobile;

import constants.ProductType;

public class IPad extends Mobile {
    protected String pencilSupport;
    protected String keyboardSupport;

    public IPad(String name, int price, String color, int storage,
                String network, double screenSize, String pencilSupport,
                String keyboardSupport) {
        super(ProductType.IPAD, name, price, color, storage, network, screenSize);
        this.pencilSupport = pencilSupport;
        this.keyboardSupport = keyboardSupport;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Apple Pencil 지원: " + pencilSupport);
        System.out.println("키보드 지원: " + keyboardSupport);
    }
}