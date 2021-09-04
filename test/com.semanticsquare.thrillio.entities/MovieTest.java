package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void isKidFriendlyEligible() {
        Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen porn", "", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, "Classics", 8.5);
        boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "Tile has porn must return false");

        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen title", "", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, "porn", 8.5);
        isKidFriendlyEligible = movie.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "Genre has porn must return false");

        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen title", "", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, "Horror", 8.5);
        isKidFriendlyEligible = movie.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "Genre is horror must return false");

        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen title", "", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, "Thrillers", 8.5);
        isKidFriendlyEligible = movie.isKidFriendlyEligible();
        assertFalse(isKidFriendlyEligible, "Genre is thrillers must return false");

        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen", "", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, "Classics", 8.5);
        isKidFriendlyEligible = movie.isKidFriendlyEligible();
        assertTrue(isKidFriendlyEligible, "must return true");
    }
}