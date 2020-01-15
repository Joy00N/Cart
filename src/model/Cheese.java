package model;

public class Cheese implements ItemInterface {
    @Override
    public int calculateQuantity(Item item) {
        return 0;
    }

    @Override
    public int calculateDaysLeft(Item item) {
        return 0;
    }
}
