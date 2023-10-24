package main.java.patternDesign;

import main.java.Triangle;

public class Product {
    String test = "";

    public void setTest(String prmTest) {
        this.test = prmTest;
    }

    @Override
    public String toString() {
        return "Product{" +
                "test='" + test + '\'' +
                '}';
    }
}