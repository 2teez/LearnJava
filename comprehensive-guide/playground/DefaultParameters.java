package com.practice.defaultparameters;

public class DefaultParameters {

    public static void main(String[] args) {
        System.out.println(tax(34.6));
        System.out.println(tax(34.9, 10));
    }

    // overloaded method
    static double tax(double cost, double rate) {
        return (cost * rate) / 100.0;
    }

    // overloaded method
    static double tax(double cost /*, use a literal double rate 19. 0*/) {
        return tax(cost, 19.0);
    }
}
