import controller.dataBaseJSON;
import view.SignUpMenu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        dataBaseJSON.initializeUsers();
        //dataBaseJSON.initializeStayLoggInUser();
        dataBaseJSON.initializeMap();

        Scanner scanner = new Scanner(System.in);
        SignUpMenu signUpMenu = new SignUpMenu();
        signUpMenu.run(scanner);

        dataBaseJSON.saveUsersInJSON();
        //dataBaseJSON.saveStayLoggedInUserInJSON();
        dataBaseJSON.saveMapInJSON();

    }
}

