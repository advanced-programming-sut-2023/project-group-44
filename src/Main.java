import view.SignUpMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SignUpMenu signUpMenu = new SignUpMenu();
        signUpMenu.run(scanner);

    }
}

