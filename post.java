
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Armando
 */
public class Posts {

    private String caption;
    private String link;
    private ArrayList comments;
    private ArrayList tags;
    private ArrayList hashtags;
    private long date;
    private int likes;

    public String getCaption() {
        return caption;
    }

    public String getImage() {
        return link;
    }

    public ArrayList getComments() {
        return comments;
    }

    public long getDate() {
        return date;
    }

    public int getLikes() {
        return likes;
    }

    public void addComment(String c) {
        comments.add(c);
    }

    public void addTag(String t) {
        tags.add(t);
    }

    public void addHashtag(String h) {
        hashtags.add(h);
    }
}
