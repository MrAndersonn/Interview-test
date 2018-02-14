package models.itemsModel;

public abstract class Potion extends Item {
    protected int pointForRestore;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Potion potion = (Potion) o;

        return pointForRestore == potion.pointForRestore;
    }

    @Override
    public int hashCode() {
        char[] nameOfClass = this.getClass().getName().toCharArray();
        int salt =0;
        for (int i = 0; i < nameOfClass.length; i++) {
            salt+=nameOfClass[i];
        }
        return pointForRestore+salt ;
    }
}
