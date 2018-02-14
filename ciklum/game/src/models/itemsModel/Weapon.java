package models.itemsModel;

public class Weapon extends Item {
    @Override
    public void execute() {
        System.out.println("Add 50 damage to hero");
    }
}
