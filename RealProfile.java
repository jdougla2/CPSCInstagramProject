/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagramproject;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.*;

/**
 *
 * @author jack
 */
interface PostListener {
    String someonePosted();
}

public class RealProfile implements Serializable{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<post> posts = new ArrayList<post>();
    private boolean isPrivate = false;
    private ImageIcon profilePic;
    private ArrayList<String> notifications = new ArrayList<String>();
    private ArrayList<PostListener> listeners = new ArrayList<PostListener>();
    private ArrayList<RealProfile> followers = new ArrayList<RealProfile>();
    private ArrayList<RealProfile> following = new ArrayList<RealProfile>();
    private ArrayList<DirectMessage> dms = new ArrayList<DirectMessage>();
    private static final long serialVersionUID = -8245875722878500126L;
    
    public RealProfile(String username, String password, String firstName, String lastName){
        this.username = username;
        this.password = password; //To implement: A form of cryptology to protect passwords.
        this.firstName = firstName;
        this.lastName = lastName;
        try{
            profilePic = new ImageIcon(scaleImage(77, 77, ImageIO.read(new File(System.getProperty("user.dir")+"\\ProfilePicture.png"))));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getName(){
        return firstName + " " + lastName;
    }
    
    public ArrayList<post> getPosts(){
        return posts;
    }
    
    public ArrayList getNotifications(){
        return notifications;
    }
            
    public ArrayList<RealProfile> getFollowing(){
        return following;
    }
    
    public ArrayList<RealProfile> getFollowers(){
        return followers;
    }
    
    public boolean getPrivacy(){
        return isPrivate;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    /*public void getProfilePic(){
        BufferedImage image = null;
        try {
            image = ImageIO.read(profilePic);
            ImageIO.write(image, "png",new File(System.getProperty("user.dir") + username + "\\profilepic.png"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }*/
    
    public Icon getProfilePic(){
        return profilePic;
    }
    
    public void setLastName(String newLastName){
        lastName = newLastName;
    }
    
    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }
    
    public void addFollowing(RealProfile toAdd){
        following.add(toAdd);
    }
    
    public void addNotifications(String newNotification){
        notifications.add(newNotification);
    }
    
    public void addPost(String caption, Icon imageLink, ArrayList comments, ArrayList<String> hashtags, ArrayList<String> mentions){
        posts.add(new post(caption, comments, hashtags, mentions, imageLink));
        
        for (PostListener listener : listeners) {
            listener.someonePosted();
        }
    }
    
    public void addDM(DirectMessage dm){
        dms.add(dm);
    }
    
    public void changePrivacy(boolean newPrivacy){
        isPrivate = newPrivacy;
    }
    
    public void setPassword(String newPassword) {
        password = newPassword;
    }
    
    public void setProfilePic(ImageIcon newImageLink){
        profilePic = newImageLink;
    }
    
    public void addFollower(PostListener listener){
        listeners.add(listener);
    }
    
    public void addFollower(RealProfile add){
        followers.add(add);
    }
    
    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }
    
    public void removeFollowing(RealProfile toRemove){
        for(int i = 0; i < following.size(); i++){
            if(following.get(i).getUsername().equals(toRemove)){
                following.remove(i);
            }
        }
    }
}


