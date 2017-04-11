
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import java.util.Date;
public class post {

    private String caption;
    private String link;
    private ArrayList<String> comments = new ArrayList<String>();
    private ArrayList<String> tags = new ArrayList<String>();
    private ArrayList<String> hashtags = new ArrayList<String>();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private Date date = new Date();
    private int likes;
    
    public post(String caption, ArrayList<String> comments, ArrayList<String> tags, ArrayList<String> hashtags){
        this.caption = caption;
        this.comments = comments;
        this.hashtags = hashtags;
    }

    public String getCaption() {
        return caption;
    }

    public String getImage() {
        return link;
    }

    public ArrayList getComments() {
        return comments;
    }

    public String getDate() {
        return dateFormat.format(date).substring(11);
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
