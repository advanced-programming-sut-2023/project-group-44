package model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String Email;
    private String slogan;
    private ArrayList<Requests> listOfRequests;
    private static ArrayList<User> users = new ArrayList<>();
     static private HashMap<Integer,String> numberOfQuestionToMainQuestion=new HashMap<>(){
        {
            numberOfQuestionToMainQuestion.put(1, "What is my father’s name?");
            numberOfQuestionToMainQuestion.put(2, "What was my first pet’s name?");
            numberOfQuestionToMainQuestion.put(3,"What is my mother’s last name?" );
        }
    };
    private int numberOfRecoveryQuestion;
    private String answerOfRecoveryQuestion;
    public User(String username,String password,String nickname,String Email,int numberOfRecoveryQuestion,String answerOfRecoveryQuestion){
        this.username=username;
        this.password=password;
        this.Email=Email;
        this.nickname=nickname;
        this.numberOfRecoveryQuestion=numberOfRecoveryQuestion;
        this.answerOfRecoveryQuestion=answerOfRecoveryQuestion;
        this.listOfRequests=new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return Email;
    }

    public static HashMap<Integer, String> getNumberOfQuestionToMainQuestion() {
        return numberOfQuestionToMainQuestion;
    }

    public String getSlogan() {
        return slogan;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUserByUsername (String username){
        for (User user : User.getUsers()){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

}
