package com.gildedrose;

public class Item {

    public String name;
    public int sellIn;
    public int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        Item item;
        switch (name) {
            case "Aged Brie":
                item = new AgedBrie(sellIn, quality);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item = new BackstagePass(sellIn, quality);
                break;
            case "Sulfuras, Hand of Ragnaros":
                item = new Sulfuras(sellIn, quality);
                break;
            default:
                item = new Item(name, sellIn, quality);
        }
        return item;
    }

    protected void update() {
        if (quality > 0) quality = quality - 1;
        sellIn = sellIn - 1;
        if (sellIn < 0) if (quality > 0) quality = quality - 1;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}