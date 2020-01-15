package model;

public class Ticket implements ItemInterface {

    public Ticket() {
        new Ticket();
    }

    @Override
    public int calculateQuantity(Item item) {
        if ((item.getDaysLeft() < 11)) {
            // See commit fec84d on git.
            if ((item.getQuality() < 50)) {
                item.setQuality(item.getQuality() + 1);
                // Increases the quality of Ticker
            }
        }
        if ((item.getDaysLeft() < 6)) {
            if ((item.getQuality() < 50)) {
                items[i].quality = (items[i].quality + 1);
            }
        }

        return item.getQuality();
    }

    @Override
    public int calculateDaysLeft(Item item) {
        return  item.getDaysLeft();
    }
}