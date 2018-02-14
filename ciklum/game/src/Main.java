import models.Inventory;
import models.itemsModel.Armor;
import models.itemsModel.HealthPotion;
import models.itemsModel.MannaPotion;
import models.itemsModel.Weapon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addToInventory(new HealthPotion());
        inventory.addToInventory(new HealthPotion());
        inventory.addToInventory(new HealthPotion());
        inventory.addToInventory(new MannaPotion());
        inventory.addToInventory(new HealthPotion());
        inventory.addToInventory(new HealthPotion());
        inventory.addToInventory(new Armor());
        inventory.addToInventory(new Armor());
        inventory.addToInventory(new Weapon());


        inventory.printInventory();

        inventory.replaceItem(0,3);
        System.out.println("______________________________________________");
        System.out.println("After replace");
        inventory.printInventory();

        inventory.executeItemInInventory(3);

        System.out.println("______________________________________________");
        System.out.println("After execute one healthPotion");

        inventory.printInventory();

        inventory.executeItemInInventory(1);

        System.out.println("______________________________________________");
        System.out.println("After execute one armor");

        inventory.printInventory();


    }


}
