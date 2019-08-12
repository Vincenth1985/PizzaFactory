package be.intecbrussel.services;

import be.intecbrussel.controller.PizzaFactory1;
import be.intecbrussel.controller.PizzaFactory2;
import be.intecbrussel.controller.PizzaShop1;

import java.util.ArrayList;
import java.util.Random;

public class PizzaWareHouse extends Thread {

    private ArrayList<String> wareHouseList = new ArrayList<>();
    private int wareHouseStock;
    private boolean minimumStockBeforSellingPizza = wareHouseList.size() > (wareHouseStock / 100) * 2;
    private Object monitor = new Object();


    public PizzaWareHouse(int wareHouseStock) {
        this.wareHouseStock = wareHouseStock;
    }

    public ArrayList<String> getWareHouseList() {
        return wareHouseList;
    }

    public int getWareHouseStock() {
        return wareHouseStock;
    }


    public void addPizzaFactory1(ArrayList<String> pizzaList, PizzaFactory1 pizzaFactory1, int wareHouseStock) {

        while (pizzaList.size() < wareHouseStock) {
            try {
                synchronized (monitor) {
                    if (pizzaList.size() < wareHouseStock) {
                        pizzaList.add(pizzaFactory1.getPizzaType());
                        System.out.println("Scampi  Pizza - > " + pizzaList.size() + " Added in WareHouse");
                    }
                }
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addPizzaFactory2(ArrayList<String> pizzaList, PizzaFactory2 pizzaFactory2, int wareHouseStock) {

        while (pizzaList.size() < wareHouseStock) {
            try {
                synchronized (monitor) {
                    if (pizzaList.size() < wareHouseStock) {
                        pizzaList.add(pizzaFactory2.getPizzaType());
                        System.out.println("Funghi  Pizza - > " + pizzaList.size() + " Added in WareHouse");
                    }
                }
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sellPizzaShop1(ArrayList<String> pizzaList, PizzaShop1 pizzaShop1) {

        while (wareHouseList.size() < wareHouseStock) {

            if (wareHouseList.size() > (wareHouseStock / 2)) {
                int randomPizzas = new Random().nextInt(wareHouseList.size() / 2);
                System.out.println();
                System.out.println(pizzaList.get(randomPizzas) + " Pizza - > is removed from WareHouse for " + pizzaShop1.getShop1());
                pizzaList.remove(randomPizzas);
            }
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
















