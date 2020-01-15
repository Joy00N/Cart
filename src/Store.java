import model.*;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private Map<String, ItemInterface > map;

    public void generateMap(){
        map = new HashMap<>();

        map.put("Ticket", new Ticket());
        map.put("Cheese", new Cheese());
        map.put("Emerald", new Emerald());
    }

    public Item[] updateQuality(Item[] items, String name) {


        for (int i = 0; (i < items.length); i++) {



            if (((!"Cheese".equals(items[i].getName())) && (!"Ticket".equals(items[i].getName())))) {
                // TODO: Improve this code
                if ((items[i].getQuality() > 0)) {
                    if ((!"Emerald".equals(items[i].getName()))) {
                        items[i].setQuality(items[i].getQuality()-1);
                    }
                }
            } else if ((items[i].getQuality() < 50)) {
                items[i].setQuality(items[i].getQuality()+1);
                if (("Cheese".equals(items[i].getName()))) {
                    if ((items[i].getDaysLeft() < 6)) {
                        items[i].setQuality(items[i].getQuality() + 1);
                        // Increases the quality of the cheese
                    }
                }
                if (("Cheese".equals(items[i].getName()))) {
                    if ((items[i].daysLeft < 11)) {
                        items[i].quality = (items[i].quality + 1);
                    }
                }
                if (("Ticket".equals(items[i].getName()))) {
                    handleTicket(items, i);
                }
            }

            if ((!"Emerald".equals(items[i].getName()))) {
                items[i].daysLeft = (items[i].daysLeft - 1);
            }

            if ((items[i].daysLeft < 1)) {
                if ((!"Cheese".equals(items[i].getName()))) {
                    if ((!"Ticket".equals(items[i].getName()))) {
                        if ((items[i].quality > 0)) {
                            if ((!"Emerald".equals(items[i].getName()))) {
                                items[i].quality = (items[i].quality - 1);
                            }
                        }
                    } else {
                        // TODO: Fix this!
                        items[i].quality = 0;
                    }
                } else if ((items[i].quality > 50)) {
                    items[i].quality = 50;
                    // of for.
                }
            }

            if ((!"Emerald".equals(items[i].getName()))) {
                if ((items[i].quality > 50)) {
                    items[i].quality = 50;
                }
            }
        }

        return items;
    }


}