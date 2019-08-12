package be.intecbrussel.services;

import be.intecbrussel.controller.PizzaFactory1;
import be.intecbrussel.controller.PizzaFactory2;

import java.util.ArrayList;
import java.util.List;

public class PizzaWareHouse extends Thread {

    private ArrayList<String> wareHouseList = new ArrayList<>();
    private int wareHouseStock;
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

    @Override
    public void run() {


    }


    public void addPizzafactory1(ArrayList<String> pizzaList, PizzaFactory1 pizzaFactory1, int wareHouseStock) {

        while (pizzaList.size() < wareHouseStock) {
            try {
                synchronized (monitor) {
                    if (pizzaList.size() < wareHouseStock) {
                        pizzaList.add(pizzaFactory1.getPizzaType());
                        System.out.println("Scampi  Pizza - > " + pizzaList.size() + " Added in WareHouse");
                    }
                }
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addPizzafactory2(ArrayList<String> pizzaList, PizzaFactory2 pizzaFactory2, int wareHouseStock) {

        while (pizzaList.size() < wareHouseStock) {
            try {
                synchronized (monitor) {
                    if (pizzaList.size() < wareHouseStock) {
                        pizzaList.add(pizzaFactory2.getPizzaType());
                        System.out.println("Funghi  Pizza - > " + pizzaList.size() + " Added in WareHouse");
                    }
                }
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}



