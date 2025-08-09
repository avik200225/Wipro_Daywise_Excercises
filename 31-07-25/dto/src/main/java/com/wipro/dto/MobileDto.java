package com.wipro.dto;
public class MobileDto {
    private String make;
    private String modelNumber;
    private double price;

    public MobileDto () {}

    public MobileDto (String make, String modelNumber, double price) {
        this.make = make;
        this.modelNumber = modelNumber;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mobile [make=" + make + ", modelNumber=" + modelNumber + ", price=" + price + "]";
    }
}