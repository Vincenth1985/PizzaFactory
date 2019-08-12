package be.intecbrussel.services;

import be.intecbrussel.controller.PizzaFactory1;
import be.intecbrussel.controller.PizzaFactory2;
import be.intecbrussel.controller.PizzaShop1;
import be.intecbrussel.controller.PizzaShop2;

import java.util.ArrayList;
import java.util.Random;

public class PizzaWareHouse {

    private ArrayList<String> wareHouseList = new ArrayList<>();
    private int wareHouseStock;
    private Object monitor = new Object();
    private DataWriterAndReader dataWriterAndReader = new DataWriterAndReader();


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
                        dataWriterAndReader.pizzaManagementLog("Scampi  Pizza - > Added in WareHouse");

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
                        dataWriterAndReader.pizzaManagementLog("Funghi  Pizza - > Added in WareHouse");

                    }
                }
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void sellPizzaShop1(ArrayList<String> pizzaList, PizzaShop1 pizzaShop1) {

        while (wareHouseList.size() < wareHouseStock) {

            synchronized (monitor) {
                if (wareHouseList.size() > (wareHouseStock / 3)) {
                    int randomPizzas = new Random().nextInt(wareHouseList.size() / 2);
                    System.out.println();
                    System.out.println(pizzaList.get(randomPizzas) + " Pizza - > is sell from WareHouse for " + pizzaShop1.getShop1());
                    dataWriterAndReader.pizzaManagementLog(pizzaList.get(randomPizzas) + " Pizza - > Pizza - > is sell from WareHouse for " + pizzaShop1.getShop1());
                    pizzaList.remove(randomPizzas);

                }
            }
            try {
                Thread.sleep(2300);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void sellPizzaShop2(ArrayList<String> pizzaList, PizzaShop2 pizzaShop2) {

        while (wareHouseList.size() < wareHouseStock) {

            synchronized (monitor) {
                if (wareHouseList.size() > (wareHouseStock / 3)) {
                    int randomPizzas = new Random().nextInt(wareHouseList.size() / 2);
                    System.out.println();
                    System.out.println(pizzaList.get(randomPizzas) + " Pizza - > is sell from WareHouse for " + pizzaShop2.getShop2());
                    dataWriterAndReader.pizzaManagementLog(pizzaList.get(randomPizzas) + " Pizza - > Pizza - > is sell from WareHouse for " + pizzaShop2.getShop2());
                    pizzaList.remove(randomPizzas);
                }
            }
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




















