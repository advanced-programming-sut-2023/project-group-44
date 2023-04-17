package model;

import java.util.ArrayList;

public class App {
    private static User currentUser;
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Requests> tradeList = new ArrayList<>();
    
    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUserByUsername (String username){
        for (User user : App.getUsers()){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}
