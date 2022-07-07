package uz.pdp.Services;

import java.util.*;
import uz.pdp.Models.Responses;
import uz.pdp.Models.User;
import uz.pdp.Models.UserServiceInter;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserServiceInter, Responses {
    static List<User> users = new ArrayList<User>();

    @Override
    public String signUp() {
        System.out.print(Responses.INSERT_USERNAME);
        User user = new User();
        String username = new Scanner(System.in).nextLine();
        for (User u: UserService.users) {
            if(u.getUsername().equals(username)){
                return Responses.USER_EXIST;
            }
        }
        user.setUsername(username);
        System.out.print(Responses.INSERT_NAME);
        String name = new Scanner(System.in).nextLine();
        user.setName(name);
        System.out.print(Responses.INSERT_SURNAME);
        String surname = new Scanner(System.in).nextLine();
        user.setSurname(surname);
        System.out.print(Responses.INSERT_EMAIL);
        String email = new Scanner(System.in).nextLine();
        user.setEmail(email);
        System.out.print(Responses.INSERT_PHONE_NUMBER);
        String phoneNumber = new Scanner(System.in).nextLine();
        user.setPhoneNumber(phoneNumber);
        System.out.print(Responses.INSERT_BIO);
        String bio = new Scanner(System.in).nextLine();
        user.setBio(bio);
        System.out.print(Responses.INSERT_PASSWORD);
        String pass = new Scanner(System.in).nextLine();
        user.setPassword(pass);
        UserService.users.add(user);
        return Responses.REGISTERED;
    }

    @Override
    public User signIn() {
        System.out.print(Responses.INSERT_USERNAME);
        String username = new Scanner(System.in).nextLine();
        for (int i = 0; i < UserService.users.size(); i++) {
            if(UserService.users.get(i).getUsername().equals(username)){
                System.out.print(Responses.INSERT_PASSWORD);
                String pass = new Scanner(System.in).nextLine();
                if(!pass.equals(UserService.users.get(i).getPassword())){
                    System.out.println(Responses.WRONG_PASSWORD);
                    return null;
                }
                System.out.println(Responses.WELCOME_BACK);
                return UserService.users.get(i);
            }
        }
        System.out.println(Responses.USER_NOT_FOUND);
        return null;
    }

    @Override
    public String showUsers() {
        for (User u: UserService.users) {
            System.out.println(u.showUser());
            System.out.println();
        }
        return "";
    }
}
