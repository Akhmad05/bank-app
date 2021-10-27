package ru.developer.model;

public class UsersInfo {
    private int id;
    private String userName;
    private int amount;

    public UsersInfo(int id, String userName, int amount) {
        this.id = id;
        this.userName = userName;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
