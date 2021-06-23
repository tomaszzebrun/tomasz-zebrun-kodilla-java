package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private int userID;
    private String userName;
    private char userSex;
    private LocalDate birthDate;
    private int postsCount;

    public ForumUser(int userID, String userName, char userSex, LocalDate birthDate, int postsCount) {
        this.userID = userID;
        this.userName = userName;
        this.userSex = userSex;
        this.birthDate = birthDate;
        this.postsCount = postsCount;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", birthDate=" + birthDate +
                ", postsCount=" + postsCount +
                '}';
    }
}
