package model;

public class Item {

    public Item(String name, int daysLeft, int quality) {
        this.name = name;
        this.daysLeft = daysLeft;
        this.quality = quality;
    }

    private String name;

    private int daysLeft;

    private int quality;

    public String getName() {
        return name;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public int getQuality() {
        return quality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int hashCode() {
        int result = 0;
        result = ((result * 5) ^ this.name.hashCode());
        result = ((result * 7) ^ this.daysLeft);
        result = ((result * 11) ^ this.quality);
        return result;
    }

    public boolean equals(Object obj) {


        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Item)) {
            return false;
        }
        Item other = (Item) obj;
        return
                this.name.equals(other.name)
                        && this.daysLeft == other.daysLeft
                        && this.quality == other.quality;
    }

    public String toString() {
        return String.format("<Item: %s, %s, %s>", this.name, this.daysLeft, this.quality);
    }
}