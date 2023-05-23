import controller.dataBaseJSON;
import view.SignUpMenu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

//        File file = new File("usersData.json");
//        file.createNewFile();
//        File file1 = new File("map.json");
//        file1.createNewFile();
        dataBaseJSON.initializeUsers();
<<<<<<< Updated upstream
=======
//        dataBaseJSON.initializeStayLoggInUser();
>>>>>>> Stashed changes
        dataBaseJSON.initializeMap();

        Scanner scanner = new Scanner(System.in);
        SignUpMenu signUpMenu = new SignUpMenu();
        signUpMenu.run(scanner);

        dataBaseJSON.emptyMapJSOn();
        dataBaseJSON.saveUsersInJSON();
<<<<<<< Updated upstream
=======
//        dataBaseJSON.saveStayLoggedInUserInJSON();
>>>>>>> Stashed changes
        dataBaseJSON.saveMapInJSON();

    }
}

