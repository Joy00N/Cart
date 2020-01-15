import model.Item;

public class Main {
    public static void main(String[] args) {
        Item item = new Item("Ticket", 1, 1);
        Item[] items = new Item[1];
        items[0] = item;

//        System.out.println("before: " + items[0].toString());
//        Store store = new Store();
//        store.updateQuality(items);
//        System.out.println("after: " + items[0].toString());
    }
}
