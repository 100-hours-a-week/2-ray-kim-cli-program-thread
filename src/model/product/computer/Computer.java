package model.product.computer;

import constants.ProductType;
import model.product.Product;

public abstract class Computer extends Product {
    protected String cpu;
    protected int ram;  // GB 단위

    public Computer(ProductType type, String name, int price, String color, int storage,
                    String cpu, int ram) {
        super(type, name, price, color, storage);
        this.cpu = cpu;
        this.ram = ram;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + "GB");
    }
}