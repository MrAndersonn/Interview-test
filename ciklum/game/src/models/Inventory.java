package models;

import models.itemsModel.Item;

import java.util.*;

public class Inventory {

    private LinkedList<NodeForInventory> inventory = new LinkedList<>();

    public void executeItemInInventory(int index) {
        if (index > -1 && index < inventory.size()) {
            NodeForInventory nodeForInventory = inventory.get(index);
            nodeForInventory.getItem().execute();
            nodeForInventory.decrementCount();
            if (nodeForInventory.getCount()<=0)
                inventory.remove(nodeForInventory);
        }
    }

    public void addToInventory(Item item) {
        boolean isExist = false;
        for (NodeForInventory nodeForInventory :
                inventory) {
            if (nodeForInventory.getItem().equals(item)) {
                nodeForInventory.incrementCount();
                isExist = true;
            }
        }
        if (!isExist)
            inventory.add(new NodeForInventory(item));
    }

    public void replaceItem(int indexFirst, int indexSecond) {
        NodeForInventory buff = inventory.get(indexSecond);
        inventory.set(indexSecond, inventory.get(indexFirst));
        inventory.set(indexFirst, buff);
    }

    public void printInventory() {

        for (int i = 0; i < inventory.size(); i++) {
            NodeForInventory node = inventory.get(i);
            System.out.printf("%d. %s - count in inventory %s\n", i, node.getItem(), node.getCount());
        }
    }

    private class NodeForInventory {
        private Item item;
        private Integer count;

        NodeForInventory(Item item) {
            this.item = item;
            count = 1;
        }

        Item getItem() {
            return item;
        }

        Integer getCount() {
            return count;
        }

        void incrementCount() {
            count++;
        }

        void decrementCount() {
            count--;
        }
    }
}
