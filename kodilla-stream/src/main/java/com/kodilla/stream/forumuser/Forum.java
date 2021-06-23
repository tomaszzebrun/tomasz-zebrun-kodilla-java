package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private List<ForumUser> UserList = new ArrayList<>();

    public Forum(List<ForumUser> userList) {
        UserList = userList;
    }

    public List<ForumUser> getUserList() {
        return UserList;
    }
}
