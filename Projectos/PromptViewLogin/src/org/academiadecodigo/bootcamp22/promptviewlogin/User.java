package org.academiadecodigo.bootcamp22.promptviewlogin;

public class User {

    private String userName;
    private String password;

    public User(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
