package model;

public class Emerald implements ItemInterface {

    @Override
    public int calculateQuantity(Item item) {
        return item.getQuality();
    }

    @Override
    public int calculateDaysLeft(Item item) {
        return item.getDaysLeft();
    }
}
