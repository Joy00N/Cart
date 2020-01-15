import model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AppTest {
    private Item[] items;
    private Item[] result;
    private Store store;

    @Before
    public void setup() {
        store = new Store();
        this.items = new Item[1];
        this.result = new Item[1];
    }

    @Test
    public final void testRegularItemsDecreaseByOne() {
        this.items[0] = new Item("Bread", 10, 20);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Bread", 9, 19), this.result[0]);
    }

    @Test
    public final void testRegularItemQualityDoesNotGoBelowZero() {
        this.items[0] = new Item("Bread", 2, 0);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Bread", 1, 0), this.result[0]);
    }

    @Test
    public final void testQualityGoesUpForCheese() {
        this.items[0] = new Item("Cheese", 20, 30);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Cheese", 19, 31), this.result[0]);
    }

    @Test
    public final void testQualityGoesUpForTicket() {
        this.items[0] = new Item("Ticket", 19, 31);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Ticket", 18, 32), this.result[0]);
    }

    @Test
    public final void testQualityGoesUpBy2ForCheeseWith10DaysOrLessLeft() {
        this.items[0] = new Item("Cheese", 10, 30);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Cheese", 9, 32), this.result[0]);
    }

    @Test()
    public final void testQualityGoesUpBy2ForTicketWith10DaysOrLessLeft() {
        this.items[0] = new Item("Ticket", 9, 31);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Ticket", 8, 33), this.result[0]);
    }

    @Test
    public final void testQualityGoesUpBy3ForCheeseWith5DaysOrLessLeft() {
        this.items[0] = new Item("Cheese", 4, 11);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Cheese", 3, 14), this.result[0]);
    }

    @Test
    public final void testQualityGoesUpBy3ForTicketWith5DaysOrLessLeft() {
        this.items[0] = new Item("Ticket", 4, 11);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Ticket", 3, 14), this.result[0]);
    }

    @Test
    public final void testGoingFromUnexpiredToExpired() {
        this.items[0] = new Item("Bread", 1, 11);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Bread", 0, 9), this.result[0]);
    }

    @Test
    public final void testQualityDecreasesTwiceAsFastAfterExpired() {
        this.items[0] = new Item("Bread", 0, 11);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Bread", -1, 9), this.result[0]);
    }

    @Test
    public final void testCheeseQualityIncreasesBy3AfterExpired() {
        this.items[0] = new Item("Cheese", 0, 20);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Cheese", -1, 23), this.result[0]);
    }

    @Test
    public final void testTicketGoesToQuality0AfterExpired() {
        this.items[0] = new Item("Ticket", 0, 20);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Ticket", -1, 0), this.result[0]);
    }

    @Test
    public final void testEmerald() {
        this.items[0] = new Item("Emerald", 0, 80);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Emerald", 0, 80), this.result[0]);
    }

    @Test
    public final void testQualityDoesNotIncreasePast50() {
        this.items[0] = new Item("Cheese", 4, 49);
        this.result = store.updateQuality(this.items);
        Assert.assertEquals(new Item("Cheese", 3, 50), this.result[0]);
    }
}
