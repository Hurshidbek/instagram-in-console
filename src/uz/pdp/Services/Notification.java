package uz.pdp.Services;

import uz.pdp.Models.*;

public class Notification implements NotificationsInterface {

    @Override
    public void notifyDm(User user, DM dm) {
        String result = "You have new message from " + dm.from + "!";
        user.getNotifications().add(result);
        user.setNotifications(user.getNotifications());
        refreshUser(user);
    }
    @Override
    public void notifyFollow(User user, User follower) {
        String result = follower.getName() + " started following you!";
        user.getNotifications().add(result);
        user.setNotifications(user.getNotifications());
        refreshUser(user);
    }
    @Override
    public void notifyLike(User user, Publication publication, User liker) {
        String result = liker.getName() + " liked your " + publication.getTitle();
        user.getNotifications().add(result);
        user.setNotifications(user.getNotifications());
        refreshUser(user);
    }
    @Override
    public void notifyComment(User user, Publication publication, Comment comment, User commenter) {
        String result = commenter.getName() + " commented your " + publication.getTitle() + comment.getText();
        user.getNotifications().add(result);
        user.setNotifications(user.getNotifications());
        refreshUser(user);
    }
    public void refreshUser(User user){
        for(int i = 0; i < UserService.users.size(); i++){
            if(user.getUsername().equals(UserService.users.get(i).getUsername()) && user.getPassword().equals(UserService.users.get(i).getPassword())){
                UserService.users.set(i, user);
                return;
            }
        }
    }
}
