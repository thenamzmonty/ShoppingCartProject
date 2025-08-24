package com.example.shopping;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    @Test
    public void testSingleItems() {
        assertEquals(0.35, ShoppingCart.calculateTotal(java.util.Arrays.asList("Apple")), 0.001);
        assertEquals(0.20, ShoppingCart.calculateTotal(java.util.Arrays.asList("Banana")), 0.001);
        assertEquals(0.50, ShoppingCart.calculateTotal(java.util.Arrays.asList("Melon")), 0.001);
        assertEquals(0.15, ShoppingCart.calculateTotal(java.util.Arrays.asList("Lime")), 0.001);
    }

    @Test
    public void testMultipleItems() {
        assertEquals(0.90, ShoppingCart.calculateTotal(java.util.Arrays.asList("Apple", "Apple", "Banana")), 0.001);
    }

    @Test
    public void testBOGOMelon() {
        assertEquals(0.50, ShoppingCart.calculateTotal(java.util.Arrays.asList("Melon", "Melon")), 0.001);
        assertEquals(1.00, ShoppingCart.calculateTotal(java.util.Arrays.asList("Melon", "Melon", "Melon", "Melon")), 0.001);
    }

    @Test
    public void testThreeForTwoLime() {
        assertEquals(0.30, ShoppingCart.calculateTotal(java.util.Arrays.asList("Lime", "Lime", "Lime")), 0.001);
        assertEquals(0.45, ShoppingCart.calculateTotal(java.util.Arrays.asList("Lime", "Lime", "Lime", "Lime")), 0.001);
    }

    @Test
    public void testMixedBasket() {
        List<String> basket = java.util.Arrays.asList(
            "Apple", "Melon", "Melon", "Banana", "Lime", "Lime", "Lime"
        );
        assertEquals(1.35, ShoppingCart.calculateTotal(basket), 0.001);
    }

    // --- Edge Cases ---

    @Test
    public void testEmptyBasket() {
        List<String> emptyBasket = java.util.Arrays.asList();
        assertEquals(0.0, ShoppingCart.calculateTotal(emptyBasket), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownItemThrowsException() {
        ShoppingCart.calculateTotal(java.util.Arrays.asList("Apple", "Orange"));
    }

    @Test
    public void testLargeQuantities() {
        List<String> largeBasket = java.util.Arrays.asList(
            "Melon","Melon","Melon","Melon","Melon","Melon", // 6 Melons → 3 charged
            "Lime","Lime","Lime","Lime","Lime","Lime"       // 6 Limes → 4 charged
        );
        double expected = (3 * 0.50) + (4 * 0.15); // 1.50 + 0.60 = 2.10
        assertEquals(expected, ShoppingCart.calculateTotal(largeBasket), 0.001);
    }
}
