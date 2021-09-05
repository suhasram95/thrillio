package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;

public class View {
    public static void browse(User user, Bookmark[][] bookmarks) {
        System.out.println("\n" + user.getEmail() + " is browsing items");
        int bookmarkCount = 0;

        for (Bookmark[] bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                if (bookmarkCount < DataStore.USER_BOOKMARK_COUNT) {
                    boolean isBookmarked = getBookmarkDecision(bookmark);
                    if (isBookmarked) {
                        bookmarkCount++;

                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                        System.out.println("New Item Bookmarked --" + bookmark);
                    }
                }
                if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
                    if (bookmark != null && bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
                        System.out.println("Kid Friendly status "+ kidFriendlyStatus + " ,"+ bookmark);
                    }
                }
            }
        }
        //  Mark as kid-friendly

    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        double randomVal = Math.random();

        return randomVal < 0.4 ? KidFriendlyStatus.APPROVED :
                (randomVal >= 0.4 && randomVal < 0.8) ? KidFriendlyStatus.REJECTED :
        KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true : false;
    }
}
