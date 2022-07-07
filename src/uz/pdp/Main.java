package uz.pdp;

import java.util.*;
import uz.pdp.Models.Responses;
import uz.pdp.Models.User;
import uz.pdp.Services.UserService;

public class Main {

    public static void main(String[] args) {
        System.out.println(Responses.INSTAGRAM);
        UserService userService = new UserService();
        while (true){
            System.out.println(Responses.MAIN_MENU);
            User user = new User();
            int ans = new Scanner(System.in).nextInt();
            switch (ans){
                case 1:{
                    System.out.println(userService.signUp());
                    break;
                }
                case 2:{
                    user = userService.signIn();
                    if(user == null)
                        break;
                    if (user.getNotifications().size() > 0){
                        System.out.println(user.alert());
                    }
                    int res = new Scanner(System.in).nextInt();
                    if(user.getNotifications().size() > 0 && res == -1){
                        System.out.println(user.showNotifications());
                        user.clearNotifications();
                    }
                    break;
                }
                case 3:{
                    userService.showUsers();
                    break;
                }
            }
        }
    }
}
