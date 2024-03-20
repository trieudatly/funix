package models;

import java.io.Serializable;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String name;


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public User() {
        this.userId="000000000000";
        this.name="Default name";
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", customerId='" + userId + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return userId;
    }

    public void setCustomerId(String customerId) {
        this.userId = customerId;
    }
}
