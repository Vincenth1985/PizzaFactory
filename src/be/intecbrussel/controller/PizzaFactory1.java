package be.intecbrussel.controller;

public class PizzaFactory1 extends Thread {

    private String pizzaType = "Pizza Scampi";


    public String getPizzaType() {
        return pizzaType;
    }

    @Override
    public void run() {
        getPizzaType();
    }
}
