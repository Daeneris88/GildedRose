package com.gildedrose;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    /* ------------------- STANDARD ITEMS ----------------------- */

    @Test
    public void fixme() {
        Item[] items = new Item[] {new Item("fixme", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
    @Test
    public void ensure_that_the_item_quality_decreases_1_when_sellIn_decreases_1(){
        Item[] items = new Item[] {new Item("minor healing potion", 50, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("minor healing potion", app.items[0].name);
        assertEquals(19, app.items[0].quality);
        assertEquals(49, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_item_quality_stays_0_when_sellIn_decreases_1(){
        Item[] items = new Item[] {new Item("minor healing potion", 40, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("minor healing potion", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(39, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_item_quality_decreases_2_when_sellIn_is_lower_than_1(){
        Item[] items = new Item[] {new Item("minor healing potion", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("minor healing potion", app.items[0].name);
        assertEquals(18, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_item_quality_stays_0_when_sellIn_is_lower_than_0(){
        Item[] items = new Item[] {new Item("minor healing potion", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("minor healing potion", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_item_quality_decreases_1_even_if_sellIn_is_lower_than_0(){
        Item[] items = new Item[] {new Item("minor healing potion", -1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("minor healing potion", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    /* ------------------- SULFURAS EXCEPTION ----------------------- */

    @Test
    public void ensure_that_the_item_quality_of_Sulfuras_is_the_same_and_sellIn_keeps_being_the_same(){
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 50, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(20, app.items[0].quality);
        assertEquals(50, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_Sulfuras_quality_80_and_sellIn_keeps_being_the_same(){
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 55, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(55, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_Sulfuras_quality_80_and_sellIn_keeps_being_the_same_even_even_if_negative(){
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    /* ------------------- CHEESE EXCEPTION ----------------------- */

    @Test
    public void ensure_that_the_cheese_quality_increases_1_wile_sellIn_decreases_1(){
        Item[] items = new Item[] {new Item("Aged Brie", 40, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(11, app.items[0].quality);
        assertEquals(39, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_cheese_quality_increases_2_wile_sellIn_is_lower_than_1(){
        Item[] items = new Item[] {new Item("Aged Brie", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(12, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_cheese_quality_increases_1_even_if_sellIn_is_lower_than_1(){
        Item[] items = new Item[] {new Item("Aged Brie", 0, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_cheese_quality_does_not_increase_even_if_sellIn_is_lower_than_1(){
        Item[] items = new Item[] {new Item("Aged Brie", 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_the_cheese_quality_does_not_increase_more_than_50_wile_sellIn_decreases_1(){
        Item[] items = new Item[] {new Item("Aged Brie", 40, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(39, app.items[0].sellIn);
    }

    /* ------------------- BACKSTAGE EXCEPTION ----------------------- */

    @Test
    public void ensure_that_backStage_tickets_quality_increases_one_wile_sellIn_is_bigger_than_10(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 50, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(21, app.items[0].quality);
        assertEquals(49, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_backStage_tickets_quality_increases_two_wile_sellIn_is_lower_than_5(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }
    @Test
    public void ensure_that_backStage_tickets_quality_increases_one_even_if_sellIn_is_lower_than_10(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49), new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[1].quality);
        assertEquals(4, app.items[1].sellIn);
    }
    @Test
    public void ensure_that_backStage_tickets_quality_increases_2_wile_sellIn_is_between_6_and_10_included(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20), new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(22, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[1].quality);
        assertEquals(5, app.items[1].sellIn);
    }
    @Test
    public void ensure_that_backStage_tickets_quality_increases_3_wile_sellIn_is_between_5_and_1_included(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20), new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(23, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(23, app.items[1].quality);
        assertEquals(4, app.items[1].sellIn);
    }
    @Test
    public void ensure_that_backStage_tickets_quality_turns_0_wile_sellIn_is_0(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}