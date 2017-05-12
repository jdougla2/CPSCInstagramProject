package instagramproject;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import javax.imageio.ImageIO;

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
import javax.swing.Icon;
public class post implements Serializable{

    private String caption;
    private URL link;
    private BufferedImage image = null;
    private Icon icon = null;
    private ArrayList<String> comments = new ArrayList<String>();
    private ArrayList<String> tags = new ArrayList<String>();
    private ArrayList<String> hashtags = new ArrayList<String>();
    SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
    Date date = new Date();
    String time = format.format(date);
    private int likes;
    private static final long serialVersionUID = -8245875722878500126L;
    
    public post(String caption, ArrayList<String> comments, ArrayList<String> tags, ArrayList<String> hashtags, URL imageLink){
        this.caption = caption;
        this.comments = comments;
        this.hashtags = hashtags;
        this.tags = tags;
        this.link = imageLink;
        this.getImage();
    }
    
    public post(String caption, ArrayList<String> comments, ArrayList<String> tags, ArrayList<String> hashtags, Icon imageLink){
        this.caption = caption;
        this.comments = comments;
        this.hashtags = hashtags;
        this.tags = tags;
        this.icon = imageLink;
        this.getImage();
    }

    public String getCaption() {
        return caption;
    }

    public Icon getImage() {
        return icon;
    }

    public ArrayList getComments() {
        return comments;
    }

    public String getDate() {
        return time;
    }

    public int getLikes() {
        return likes;
    }
    
    public ArrayList<String> getHashtags() {
        return hashtags;
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
    
    public void setLikes(int num){
        likes++;
    }
}
