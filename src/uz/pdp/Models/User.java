package uz.pdp.Models;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String bio;
    private String phoneNumber;
    private List<String> notifications = new ArrayList<String>();
    private List<User> follower = new ArrayList<User>();
    private List<User> following = new ArrayList<User>();
    private List<Publication> main = new ArrayList<Publication>();
    private List<List<DM>> dms = new ArrayList<List<DM>>();
    private List<Publication> myPosts = new ArrayList<Publication>();

    public User(){
        this.notifications.add("First!");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public List<User> getFollower() {
        return follower;
    }

    public void setFollower(List<User> follower) {
        this.follower = follower;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Publication> getMain() {
        return main;
    }

    public void setMain(List<Publication> main) {
        this.main = main;
    }

    public List<List<DM>> getDms() {
        return dms;
    }

    public void setDms(List<List<DM>> dms) {
        this.dms = dms;
    }

    public List<Publication> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<Publication> myPosts) {
        this.myPosts = myPosts;
    }

    public String showUser(){
        String pass = "";
        String phoneNumb = "";
        String tempPhone = "";
        for (int i = 0; i < this.phoneNumber.length(); i++) {
            if(Character.isDigit(this.phoneNumber.charAt(i))){
                tempPhone += String.valueOf(this.phoneNumber.charAt(i));
            }
        }
        phoneNumb += "+998" + "(" + tempPhone.substring(tempPhone.length() - 9, tempPhone.length() - 7) + ") " + tempPhone.substring(tempPhone.length() - 7, tempPhone.length() - 4) + "-" + tempPhone.substring(tempPhone.length() - 4, tempPhone.length() - 2) + "-" + tempPhone.substring(tempPhone.length() - 2, tempPhone.length());
        for(int i = 0; i < password.length(); i++){
            pass += "*";
        }
        return "Username: " + username + "\n" +
                "Password: " + pass + "\n" +
                "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumb + "\n" +
                "Bio: " + bio;
    }

    public String showNotifications(){
        String result = "";
        for (String str: notifications) {
            result += str + "\n";
        }
        return result;
    }
    public String alert(){
        return "!!!!!!!!!! You have " + notifications.size() + " notifications!  !!!!!!!!!!" + "\n-1 -> Check notifications!";
    }

    public void clearNotifications(){
        notifications.clear();
    }

    public String showDms(User user) {
        String result = "";
        for (int i = 0; i < dms.size(); i++) {
            String username = dms.get(i).get(0).from.username;
            if (username.equals(user.username))
                result += i + 1 + " -> " + dms.get(i).get(0).to.username;
            else{
                result += i + 1 + " -> " + username;
            }
            result += "\n";
        }
        return result;
    }

    public void getDm(User user, int num){
         List<DM> dms = user.getDms().get(num-1);
        for (DM dm: dms) {
            System.out.println("From: " + dm.from.name + "\n" + "To: " + dm.to + "\n" + "\"" + dm.message + "\"");
        }
        System.out.println("0 -> Back");
        System.out.print("Message: ");
        String ans = new Scanner(System.in).nextLine();
        if(ans.equals("0"))
            return;
        DM dm = new DM();
        dm.from = user;
    }

    public void goToDm(DM dm){

    }
}
