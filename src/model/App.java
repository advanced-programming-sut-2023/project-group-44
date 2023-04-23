package model;

import java.util.ArrayList;

public class App {
    private static User currentUser;
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Requests> tradeList = new ArrayList<>();
    public static Map gameMap = new Map(400);
    
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
    public static User getUserByEmail(String email){
        for (User x : users){
            if (x.getEmail().toLowerCase().equals(email.toLowerCase())){
                return x;
            }
        }
        return null;
    }
    public static void addUser(User user){
        users.add(user);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        App.currentUser = currentUser;
    }
}
