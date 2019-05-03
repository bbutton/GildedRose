package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo, -1, 0", app.items[0].toString());
    }

    @Test
    public void sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", app.items[0].toString());
    }

    @Test
    public void sulfurasMinusOne() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", app.items[0].toString());
    }

    @Test
    public void reducesQuality() {
        Item[] items = new Item[] { new Item("foo", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo, -1, 3", app.items[0].toString());
    }

    @Test
    public void agedBrieIncreasesQualityWhenBelowMax() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, -1, 50", app.items[0].toString());
    }

    @Test
    public void backStagePassesIncreaseByTwoInQualityWhenWithin10Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 42", app.items[0].toString());
    }

    @Test
    public void backStagePassesIncreaseByThreeInQualityWhenWithin5Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 4, 43", app.items[0].toString());
    }

    @Test
    public void backStagePassesQualityReducesToZeroAfterEvent() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", app.items[0].toString());
    }

    @Test
    public void agedBrieQualityIncreasesAfterSellInDayPasses() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, -2, 42", app.items[0].toString());
    }
}
