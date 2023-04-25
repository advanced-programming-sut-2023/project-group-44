package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String Email;
    private String slogan;
    private int score;
    private int highScore;
    private ArrayList<Requests> listOfRequests;
    /* static private HashMap<Integer,String> numberOfQuestionToMainQuestion=new HashMap<>(){
        {
            numberOfQuestionToMainQuestion.put(1, "What is my father’s name?");
            numberOfQuestionToMainQuestion.put(2, "What was my first pet’s name?");
            numberOfQuestionToMainQuestion.put(3,"What is my mother’s last name?" );
        }
    };*/
    private int numberOfSecurityQuestion;
    private String securityQuestion;
    private String answerOfSecurityQuestion;
    public User(String username,String password,String nickname,String Email){
        this.username=username;
        this.password=password;
        this.Email=Email;
        this.nickname=nickname;
        this.score=0;
        this.highScore=0;
        this.listOfRequests=new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return Email;
    }

    /*public static HashMap<Integer, String> getNumberOfQuestionToMainQuestion() {
        return numberOfQuestionToMainQuestion;
    }*/

    /*public int getNumberOfRecoveryQuestion() {
        return numberOfRecoveryQuestion;
    }

    public String getAnswerOfRecoveryQuestion() {
        return answerOfRecoveryQuestion;
    }*/

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setNumberOfSecurityQuestion(int numberOfSecurityQuestion) {
        this.numberOfSecurityQuestion = numberOfSecurityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public void setAnswerOfSecurityQuestion(String answerOfSecurityQuestion) {
        this.answerOfSecurityQuestion = answerOfSecurityQuestion;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getAnswerOfSecurityQuestion() {
        return answerOfSecurityQuestion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getRank(){
        ArrayList<User> listOfUsers=new ArrayList<>();
        listOfUsers.addAll(App.getUsers());
        for(int i=0;i<listOfUsers.size()-1;i++){
            for(int j=0;j<listOfUsers.size()-1-i;j++){
                if(listOfUsers.get(j).getHighScore()<listOfUsers.get(j+1).getHighScore()){
                    Collections.swap(listOfUsers,j,j+1);
                }
            }
        }
        return listOfUsers.indexOf(this);
    }
}
