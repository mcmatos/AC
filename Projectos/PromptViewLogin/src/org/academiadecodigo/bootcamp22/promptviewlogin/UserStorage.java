package org.academiadecodigo.bootcamp22.promptviewlogin;

import java.util.LinkedList;

public class UserStorage {

    private LinkedList<User> userList;

    public UserStorage() {

        userList = new LinkedList<>();
    }
    public LinkedList<User> getUserList() {
        return userList;
    }
}
