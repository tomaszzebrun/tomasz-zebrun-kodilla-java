package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private int statUsersCount;
    private int statPostsCount;
    private int statCommentsCount;
    private double statPostsPerUser;
    private double statCommentsPerUser;
    private double statCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        statUsersCount = statistics.userNames().size();
        statPostsCount = statistics.postCount();
        statCommentsCount = statistics.commentsCount();
        if (statUsersCount > 0) {
            statPostsPerUser = (double)statPostsCount/(double)statUsersCount;
            statCommentsPerUser = (double)statCommentsCount/(double)statUsersCount;
        } else {
            statPostsPerUser = -1;
            statCommentsPerUser = -1;
        }
        if (statPostsCount > 0) {
            statCommentsPerPost = (double)statCommentsCount/(double)statPostsCount;
        } else {
            statCommentsPerPost = -1;
        }
    }

    public String showStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nUsers count: " + statUsersCount);
        stringBuilder.append("\nPosts count: " + statPostsCount);
        stringBuilder.append("\nComments count: " + statCommentsCount);
        stringBuilder.append("\nAverage posts per user: " + statPostsPerUser);
        stringBuilder.append("\nAverage comments per user: " + statCommentsPerUser);
        stringBuilder.append("\nAverage comments per post: " + statCommentsPerPost);
        return stringBuilder.toString();
    }

    public int getStatUsersCount() {
        return statUsersCount;
    }

    public int getStatPostsCount() {
        return statPostsCount;
    }

    public int getStatCommentsCount() {
        return statCommentsCount;
    }

    public double getStatPostsPerUser() {
        return statPostsPerUser;
    }

    public double getStatCommentsPerUser() {
        return statCommentsPerUser;
    }

    public double getStatCommentsPerPost() {
        return statCommentsPerPost;
    }
}
