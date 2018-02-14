package models.itemsModel;

public abstract class Item implements Executable {
    protected String itemName;

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();

    }
}
