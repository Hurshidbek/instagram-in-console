package uz.pdp.Models;

import java.util.List;

public class Publication {
    private String title;
    private String body;
    private List<User> likes;
    private List<User> saves;
    private List<Comment> reply;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public List<User> getSaves() {
        return saves;
    }

    public void setSaves(List<User> saves) {
        this.saves = saves;
    }

    public List<Comment> getReply() {
        return reply;
    }

    public void setReply(List<Comment> reply) {
        this.reply = reply;
    }
}
