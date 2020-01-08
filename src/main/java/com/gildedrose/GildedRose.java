package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final int MAX_STANDARD_QUALITY = 50;
    private static final int MEDIUM_EXPIRATION = 11;
    private static final int LOW_EXPIRATION = 6;
    private static final int MIN_QUALITY = 0;
    private static final int EXPIRY_DATE = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item currentItem : items) {
            if (isAgedBrie(currentItem) || isBackstagePass(currentItem)) {
                if (isBelowMaxQuality(currentItem)) {
                    increaseQuality(currentItem);
                    if (isBackstagePass(currentItem)) {
                        if (currentItem.sellIn < MEDIUM_EXPIRATION && isBelowMaxQuality(currentItem)) increaseQuality(currentItem);
                        if (currentItem.sellIn < LOW_EXPIRATION && isBelowMaxQuality(currentItem)) increaseQuality(currentItem);
                    }
                }
            } else {
                if (currentItem.quality > MIN_QUALITY && !isSulfuras(currentItem)) {
                    decreaseQuality(currentItem);
                }
            }

            if (!isSulfuras(currentItem)) decreaseSellIn(currentItem);

            if (currentItem.sellIn < EXPIRY_DATE) {
                if (!isAgedBrie(currentItem)) {
                    if (!isBackstagePass(currentItem)) {
                        if (currentItem.quality > MIN_QUALITY) {
                            if (!isSulfuras(currentItem)) {
                                decreaseQuality(currentItem);
                            }
                        }
                    } else {
                        currentItem.quality = MIN_QUALITY;
                    }
                } else {
                    if(isBelowMaxQuality(currentItem)) increaseQuality(currentItem);
                }
            }
        }
    }

    private boolean isBelowMaxQuality(Item currentItem) {
        return currentItem.quality < MAX_STANDARD_QUALITY;
    }

    private boolean isSulfuras(Item currentItem) {
        return currentItem.name.equals(SULFURAS);
    }

    private boolean isBackstagePass(Item currentItem) {
        return currentItem.name.equals(BACKSTAGE);
    }

    private boolean isAgedBrie(Item currentItem) {
        return currentItem.name.equals(AGED_BRIE);
    }

    private void decreaseSellIn(Item currentItem) {
        currentItem.sellIn = currentItem.sellIn - 1;
    }

    private void increaseQuality(Item currentItem) {
        currentItem.quality = currentItem.quality + 1;
    }

    private void decreaseQuality(Item currentItem) {
        currentItem.quality = currentItem.quality - 1;
    }
}