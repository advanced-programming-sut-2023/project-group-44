package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.App;
import model.Map;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class dataBaseJSON {
    public static void saveUsersInJSON() throws IOException {
        FileWriter fileWriter = new FileWriter("usersData.json");
        fileWriter.write(new Gson().toJson(App.getUsers()));
        fileWriter.close();
    }

    public static void initializeUsers() throws IOException {
        String json = null;
        json = new String(Files.readAllBytes(Paths.get("usersData.json")));
        ArrayList<User> users = new Gson().fromJson(json,new TypeToken<ArrayList<User>>(){}.getType());
        if (users!=null)
            App.setUsers(users);
    }

    public static void saveStayLoggedInUserInJSON() throws IOException {
        if(App.getStayedLoggedInUser() != null) {
            FileWriter fileWriter = new FileWriter("loggedInUser.json");
            fileWriter.write(new Gson().toJson(App.getStayedLoggedInUser()));
            fileWriter.close();
        }
    }

    public static void initializeStayLoggInUser() throws IOException {
        String json = null;
        json = new String(Files.readAllBytes(Paths.get("loggedInUser.json")));
        User user = new Gson().fromJson(json,new TypeToken<User>(){}.getType());
        if(user != null)
            App.setStayedLoggedInUser(user);
    }

    public static void saveMapInJSON() throws IOException {
        FileWriter fileWriter = new FileWriter("map.json");
        fileWriter.write(new Gson().toJson(App.getGameMap()));
        fileWriter.close();
    }

    public static void initializeMap() throws IOException {
        String json = null;
        json = new String(Files.readAllBytes(Paths.get("map.json")));
        Map map = new Gson().fromJson(json,new TypeToken<Map>(){}.getType());
        if(map != null)
            App.setGameMap(map);
    }
}
