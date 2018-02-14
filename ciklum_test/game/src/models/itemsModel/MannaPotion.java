package models.itemsModel;

public class MannaPotion extends Potion {
    public MannaPotion() {
        pointForRestore = 50;
    }

    @Override
    public void execute() {
        System.out.println("Restore 50 Manna Point");
    }
}
