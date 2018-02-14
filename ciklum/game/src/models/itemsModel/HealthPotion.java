package models.itemsModel;

public class HealthPotion extends Potion{
    public HealthPotion() {
        pointForRestore=50;
    }

    @Override
    public void execute() {
        System.out.println("Restore 50 HP");
    }
}
