package model.product.computer;

import constants.ProductType;

public class MacBook extends Computer {
    protected String model;
    protected double weight;
    protected String displayType;

    public MacBook(String name, int price, String color, int storage,
                   String cpu, int ram, String model, double weight, String displayType) {
        super(ProductType.MACBOOK, name, price, color, storage, cpu, ram);
        this.model = model;
        this.weight = weight;
        this.displayType = displayType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("모델: MacBook " + model);
        System.out.println("무게: " + weight + "kg");
        System.out.println("디스플레이: " + displayType);
    }
}