package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    protected void update() {
        if (quality < 50) {
            quality = quality + 1;
            if (sellIn < 11 && quality < 50) quality = quality + 1;
            if (sellIn < 6 && quality < 50) quality = quality + 1;
        }
        sellIn = sellIn - 1;
        if (sellIn < 0) quality = 0;
    }
}
