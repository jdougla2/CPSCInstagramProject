/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagramproject;

import java.util.ArrayList;
import javax.swing.event.*;

/**
 *
 * @author jack
 */
interface PostListener {
    String someonePosted();
}

public class RealProfile{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<post> posts = new ArrayList<post>();
    private boolean isPrivate = false;
    private String profilePic;
    private ArrayList<String> notifications = new ArrayList<String>();
    private ArrayList<PostListener> listeners = new ArrayList<PostListener>();
    private ArrayList<RealProfile> followers = new ArrayList<RealProfile>();
    private ArrayList<RealProfile> following = new ArrayList<RealProfile>();
    private Responder responds = new Responder();
    private ArrayList<DirectMessage> dms = new ArrayList<DirectMessage>();
    
    public RealProfile(String username, String password, String firstName, String lastName){
        this.username = username;
        this.password = password; //To implement: A form of cryptology to protect passwords.
        this.firstName = firstName;
        this.lastName = lastName;     
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
    
    public Responder getResponder(){
        return responds;
    }
            
    public ArrayList<RealProfile> getFollowing(){
        return following;
    }
    
    public ArrayList<RealProfile> getFollowers(){
        return followers;
    }
    
    public void addNotifications(String newNotification){
        notifications.add(newNotification);
    }
    
    public void addPost(String caption, String imageLink, ArrayList comments, ArrayList hashtags, ArrayList mentions){
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
    
    public void setProfilePic(String newImageLink){
        profilePic = newImageLink;
    }
    public void addFollower(PostListener listener){
        listeners.add(listener);
    }
}

class Responder implements PostListener{
    public String someonePosted(){
        return "Someone posted";
    }
}
