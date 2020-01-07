package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void introduces_an_item_with_zero_everything() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void ensures_standard_product_quality_decreases_by_one_if_sellIn_is_greater_than_zero() {
        Item[] items = new Item[] { new Item("foo", 10, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }
    @Test
    void ensures_standard_product_quality_decreases_by_two_if_sellIn_is_zero() {
        Item[] items = new Item[] { new Item("foo", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void ensures_standard_product_quality_cannot_drop_below_zero(){
        Item[] items = new Item[] { new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void ensures_standard_product_sellIn_decreases_by_one(){
        Item[] items = new Item[] { new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

}