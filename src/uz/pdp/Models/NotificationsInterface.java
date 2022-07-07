package uz.pdp.Models;

public interface NotificationsInterface {
    public void notifyDm(User user, DM dm);
    public void notifyFollow(User user, User follower);
    public void notifyLike(User user, Publication publication, User liker);
    public void notifyComment(User user, Publication publication, Comment comment, User commenter);
}
