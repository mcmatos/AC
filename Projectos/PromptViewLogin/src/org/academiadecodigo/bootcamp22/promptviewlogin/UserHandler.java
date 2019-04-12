package org.academiadecodigo.bootcamp22.promptviewlogin;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class UserHandler {

    private UserStorage storage;
    private Prompt prompt;
    private StringInputScanner nameQuestion;
    private PasswordInputScanner passwordQuestion;

    public UserHandler() {

        storage = new UserStorage();
        prompt = new Prompt(System.in, System.out);
        nameQuestion = new StringInputScanner();
        passwordQuestion = new PasswordInputScanner();
    }

    private void signUp() {

        nameQuestion.setMessage("What is your username?\n");
        passwordQuestion.setMessage("What is your password\n");
        String userName = prompt.getUserInput(nameQuestion);
        String password = prompt.getUserInput(passwordQuestion);

        storage.getUserList().add(new User(userName, password));
    }

    private void signIn() {

        nameQuestion.setMessage("Username: ");
        passwordQuestion.setMessage("Password: ");
        String userName = prompt.getUserInput(nameQuestion);
        String password = prompt.getUserInput(passwordQuestion);

        for (int i = 0; i < storage.getUserList().size(); i++) {

            if (storage.getUserList().get(i).getUserName().equals(userName) &&
                    storage.getUserList().get(i).getPassword().equals(password)) {
                System.out.println("\nLogin successful!\nWelcome " + userName);
                return;
            }
        }
        System.out.println("\nWrong credentials!");
    }

    private void menu() {

        while (true) {
            String[] options = {"Sign up", "Sign in"};
            MenuInputScanner scanner = new MenuInputScanner(options);
            scanner.setMessage("What would you like to do?");
            if (prompt.getUserInput(scanner) == 1) {
                signUp();
                continue;
            }
            signIn();
        }
    }

    public void start() {
        menu();
    }
}
