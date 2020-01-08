package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            final Item currentItem = items[i];
            if (!currentItem.name.equals("Aged Brie")
                    && !currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (currentItem.quality > 0) {
                    if (!currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(currentItem);
                    }
                }
            } else {
                if (currentItem.quality < 50) {
                    increaseQuality(currentItem);

                    if (currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (currentItem.sellIn < 11) {
                            increaseQualityWhenBelow50(currentItem);
                        }

                        if (currentItem.sellIn < 6) {
                            increaseQualityWhenBelow50(currentItem);
                        }
                    }
                }
            }

            if (!currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseSellIn(currentItem);
            }

            if (currentItem.sellIn < 0) {
                if (!currentItem.name.equals("Aged Brie")) {
                    if (!currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (currentItem.quality > 0) {
                            if (!currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(currentItem);
                            }
                        }
                    } else {
                        currentItem.quality = 0;
                    }
                } else {
                    increaseQualityWhenBelow50(currentItem);
                }
            }

        }
    }

    private void increaseQualityWhenBelow50(Item currentItem) {
        if (currentItem.quality < 50) {
            increaseQuality(currentItem);
        }
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