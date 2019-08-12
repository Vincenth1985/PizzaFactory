package be.intecbrussel.main;

import be.intecbrussel.controller.PizzaFactory1;
import be.intecbrussel.controller.PizzaFactory2;
import be.intecbrussel.controller.PizzaShop1;
import be.intecbrussel.controller.PizzaShop2;
import be.intecbrussel.services.PizzaWareHouse;

import java.nio.file.Paths;

public class Main {


    public static void main(String[] args) {


        PizzaWareHouse pizzaWareHouse = new PizzaWareHouse(100);
        PizzaFactory1 pizzaScampi = new PizzaFactory1();
        PizzaFactory2 pizzaFunghi = new PizzaFactory2();
        PizzaShop1 shop1 = new PizzaShop1();
        PizzaShop2 shop2 = new PizzaShop2();


        Thread pizzaFactory1 = new Thread(() -> pizzaWareHouse.addPizzaFactory1(pizzaWareHouse.getWareHouseList(), pizzaScampi, pizzaWareHouse.getWareHouseStock()));
        Thread pizzaFactory2 = new Thread(() -> pizzaWareHouse.addPizzaFactory2(pizzaWareHouse.getWareHouseList(), pizzaFunghi, pizzaWareHouse.getWareHouseStock()));

        Thread pizzaShop1 = new Thread(() -> pizzaWareHouse.sellPizzaShop1(pizzaWareHouse.getWareHouseList(), shop1));
        Thread pizzaShop2 = new Thread(() -> pizzaWareHouse.sellPizzaShop2(pizzaWareHouse.getWareHouseList(), shop2));


        pizzaFactory1.start();
        pizzaFactory2.start();
        pizzaShop1.start();
        pizzaShop2.start();


        try {

            if (Paths.get("File.txt").toFile().exists()) {
                Paths.get("File.txt").toFile().delete();
            }

            System.out.println("Adding Pizza's in Warehouse is starting");
            System.out.println("=".repeat(50));
            pizzaFactory1.join();
            pizzaFactory2.join();
            pizzaShop1.join();
            pizzaShop2.join();


            System.out.println("\nPizza Buissness day is finished");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }


    }

}
