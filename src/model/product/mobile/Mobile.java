package model.product.mobile;

import constants.ProductType;
import model.product.Product;

public abstract class Mobile extends Product {
    protected String network;
    protected double screenSize;

    public Mobile(ProductType type, String name, int price, String color, int storage,
                  String network, double screenSize) {
        super(type, name, price, color, storage);
        this.network = network;
        this.screenSize = screenSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("네트워크: " + network);
        System.out.println("화면 크기: " + screenSize + "인치");
    }
}