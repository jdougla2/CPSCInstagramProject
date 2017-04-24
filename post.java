package instagramproject;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
public class post {

    private String caption;
    private URL link;
    private ArrayList<String> comments = new ArrayList<String>();
    private ArrayList<String> tags = new ArrayList<String>();
    private ArrayList<String> hashtags = new ArrayList<String>();
    DateFormat dateFormat = new SimpleDateFormat("MMddyyyy HH:mm:ss");
    private Date date = new Date();
    private int likes;
    
    public post(String caption, ArrayList<String> comments, ArrayList<String> tags, ArrayList<String> hashtags, URL imageLink){
        this.caption = caption;
        this.comments = comments;
        this.hashtags = hashtags;
        this.tags = tags;
        this.link = imageLink;
        this.getImage();
    }

    public String getCaption() {
        return caption;
    }

    public void getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(link);
            ImageIO.write(image, "png",new File(System.getProperty("user.dir") + "\\out.png"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public ArrayList getComments() {
        return comments;
    }

    public Date getDate() {
        return date;
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
}
