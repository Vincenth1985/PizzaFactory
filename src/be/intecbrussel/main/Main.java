package be.intecbrussel.main;

import be.intecbrussel.controller.PizzaFactory1;
import be.intecbrussel.controller.PizzaFactory2;
import be.intecbrussel.services.PizzaWareHouse;

public class Main {


    public static void main(String[] args) {


        PizzaWareHouse pizzaWareHouse = new PizzaWareHouse(20);

        PizzaFactory1 pizzaScampi = new PizzaFactory1();
        PizzaFactory2 pizzaFunghi = new PizzaFactory2();


        Thread pizzaFactory1 = new Thread(() -> pizzaWareHouse.addPizzafactory1(pizzaWareHouse.getWareHouseList(), pizzaScampi, pizzaWareHouse.getWareHouseStock()));

        Thread pizzaFactory2 = new Thread(() -> pizzaWareHouse.addPizzafactory2(pizzaWareHouse.getWareHouseList(), pizzaFunghi, pizzaWareHouse.getWareHouseStock()));


        pizzaFactory1.start();
        pizzaFactory2.start();


        try {
            System.out.println("Adding Pizza's in Warehouse is starting");
            System.out.println("=".repeat(25));
            pizzaFactory1.join();
            pizzaFactory2.join();
            System.out.println("\nJar Is Full : " + pizzaWareHouse.getWareHouseList().size() + " Pizza's added");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }


    }

}
