package model.product.computer;

import constants.ProductType;

public class IMac extends Computer {
    protected double displaySize;
    protected String ethernet;

    public IMac(String name, int price, String color, int storage,
                String cpu, int ram, double displaySize, String ethernet) {
        super(ProductType.IMAC, name, price, color, storage, cpu, ram);
        this.displaySize = displaySize;
        this.ethernet = ethernet;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("디스플레이: " + displaySize + "인치");
        System.out.println("이더넷: " + ethernet);
    }
}