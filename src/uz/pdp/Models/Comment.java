package uz.pdp.Models;

import java.util.List;

public class Comment {
    private User author;
    private String text;
    private List<Comment> reply;
    private List<User> like;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getReply() {
        return reply;
    }

    public void setReply(List<Comment> reply) {
        this.reply = reply;
    }

    public List<User> getLike() {
        return like;
    }

    public void setLike(List<User> like) {
        this.like = like;
    }
}
