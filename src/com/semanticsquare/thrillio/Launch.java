package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

import static com.semanticsquare.thrillio.DataStore.loadData;

public class Launch {
    private static User[] users;
    private static Bookmark[][] bookmarks;
    public static void main(String[] args) {
        System.out.println("1. Loading data ...");
        loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

//        System.out.println("\nPrinting data ...");
        printUserData();
        printBookmarkData();
        start();
    }

    private static void start() {
//        System.out.println("\n2. Bookmarking ...");
        for (User user : users) {
            View.browse(user, bookmarks);
        }
    }

    private static void printBookmarkData() {
        for (Bookmark[] bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                System.out.println(bookmark);
            }
        }
    }

    private static void printUserData() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
