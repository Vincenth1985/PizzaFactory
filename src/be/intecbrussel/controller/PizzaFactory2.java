package be.intecbrussel.controller;

public class PizzaFactory2 extends Thread {

    private String pizzaType = "Pizza Funghi";


    public String getPizzaType() {
        return pizzaType;
    }

    @Override
    public void run() {
        getPizzaType();
    }
}
