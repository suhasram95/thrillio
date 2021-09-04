package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void isKidFriendlyEligible() {
        Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, "Philosophy", 4.3);
        boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "Genre is Philosophy, Kid friendly is not eligible");

        book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, "Self Help", 4.3);
        isKidFriendlyEligible = book.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "Genre is Self Help, Kid friendly is not eligible");

        book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, "Children", 4.3);
        isKidFriendlyEligible = book.isKidFriendlyEligible();
        assertTrue(isKidFriendlyEligible, "Genre is Children, Kid friendly is eligible");
    }
}