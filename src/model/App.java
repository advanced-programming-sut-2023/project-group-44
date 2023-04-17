package model;

import java.util.ArrayList;

public class App {
    private static User currentUser;
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Requests> tradeList = new ArrayList<>();

    public static User getUserByUserName(String name){
        for(User x: users){
            if(x.getUsername().equals(name))
                return x;
        }
        return null;
    }

    public static User getUserByEmail(String email){
        for(User x: users){
            if(x.getEmail().toLowerCase().equals(email.toLowerCase()))
                return x;
        }
        return null;
    }

    public static void addUser(User user){
        users.add(user);
    }
}
