package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.managers.BookmarkManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeblinkTest {
    @Test
    public void testIsKidFriendlyEligible() {
        Weblink weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "http://www.javaworld.com");
        boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For porn in url isKidFriendlyEligible() must return false");

        weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger porn, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "http://www.javaworld.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For porn in url isKidFriendlyEligible() must return false");

        weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger porn, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "http://www.adult.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "For adult in host isKidFriendlyEligible() must return false");

        weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html", "http://www.javaworld.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertTrue(isKidFriendlyEligible, "For porn in url isKidFriendlyEligible() must return true");

        weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html", "http://www.javaworld.com");
        isKidFriendlyEligible = weblink.isKidFriendlyEligible();
        assertTrue(isKidFriendlyEligible, "For adult in title isKidFriendlyEligible() must return true");
    }
}