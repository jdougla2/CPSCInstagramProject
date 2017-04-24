/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagramproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.event.*;

/**
 *
 * @author jack
 */
class ComparatorByDate {

    public static Comparator<post> ComparatorByDate
            = new Comparator<post>() {

        public int compare(post post1, post post2) {
            Date date1;
            Date date2;
            SimpleDateFormat originalFormat = new SimpleDateFormat("MMddyyyy HH:mm:ss");
            try {
                date1 = post1.getDate();
                date2 = post2.getDate();
                return date1.compareTo(date2);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 0;
        }
    };
}

/* TO DO:
    Implement imageIO. .awt.image something.
    Implement dm-ing.
 */
public class CurrentProfile {

    private RealProfile loggedIn;
    private ArrayList<post> feed = new ArrayList<post>();
    private ArrayList<RealProfile> allProfiles = new ArrayList<RealProfile>();

    public CurrentProfile() {

        if (allProfiles.isEmpty()) {
            loggedIn = new RealProfile("guest", "guest", "guest", "guest");
            allProfiles.add(loggedIn);
            this.output();
            this.input();
        } else {
            this.logIn("guest", "guest");
        }
    }
    
    public void output() {
        try {
         FileOutputStream fileOut = 
         new FileOutputStream(System.getProperty("user.dir") + "\\allprofiles.ser");;
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(allProfiles);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /src/allprofiles.ser");
      }catch(IOException i) {
         i.printStackTrace();
      }
    }

    public void input() {
        try {
            FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "\\allprofiles.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            allProfiles = (ArrayList<RealProfile>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("AllProfiles not found :(");
            c.printStackTrace();
            return;
        }
    }

    public boolean signUp(String username, String password, String firstName, String lastName) {
        for (int i = 0; i < allProfiles.size(); i++) {
            if (!allProfiles.get(i).getUsername().equals(username)) {
                allProfiles.add(new RealProfile(username, password, firstName, lastName));
                this.logIn(username, password);
                return true;
            }
        }
        return false;
    }

    public boolean logIn(String username, String password) {
        for (int i = 0; i < allProfiles.size(); i++) {
            if (allProfiles.get(i).getUsername().equals(username)
                    && allProfiles.get(i).getPassword().equals(password)) {
                loggedIn = allProfiles.get(i);
                return true;
            }
        }
        return false;
    }

    public void close() {
        this.output();
        loggedIn = null;
    }

    public void updateFeed() {
        if (!loggedIn.getUsername().equals("guest")) {
            for (int i = 0; i < loggedIn.getFollowing().size(); i++) {
                for (int j = 0; j < loggedIn.getFollowing().get(i).getPosts().size();
                        j++) {
                    feed.add(loggedIn.getFollowing().get(i).getPosts().get(j));
                }
            }

            Collections.sort(feed, ComparatorByDate.ComparatorByDate);
        }
    }

    public void follow(String toFollow) {
        for (int i = 0; i < allProfiles.size(); i++) {
            if (allProfiles.get(i).getUsername().equals(toFollow)) {
                loggedIn.getFollowers().add(allProfiles.get(i));
            }
        }
    }

    public ArrayList<RealProfile> profileSearch(String username) {
        ArrayList<RealProfile> results = new ArrayList<RealProfile>();
        for (int i = 0; i < allProfiles.size(); i++) {
            if (allProfiles.get(i).getUsername().equals(username)) {
                results.add(allProfiles.get(i));
            }
        }
        return results;
    }

    public void newPost(String caption, URL imageLink, ArrayList comments, ArrayList hashtags, ArrayList mentions) {
        loggedIn.addPost(caption, imageLink, comments, mentions, hashtags);

        for (int i = 0; i < loggedIn.getFollowers().size(); i++) {
            loggedIn.getFollowers().get(i).addNotifications(loggedIn.getUsername() + " created a new post.");
        }
    }

    public void placeComment(RealProfile profile, int postNum, String comment) {
        for (int i = 0; i < allProfiles.size(); i++) {
            if (allProfiles.get(i).getUsername().equals(profile.getName())) {
                allProfiles.get(i).getPosts().get(postNum).addComment(comment);
                profile.addNotifications(loggedIn.getUsername() + " has added a comment to your post.");
                return;
            }
        }
    }

    public void messageUser(String message, String image, String sender, String reciever) {
        for (int i = 0; i < allProfiles.size(); i++) {
            if (allProfiles.get(i).getUsername().equals(reciever)) {
                allProfiles.get(i).addDM(new DirectMessage(message, image, loggedIn));
                allProfiles.get(i).addNotifications(loggedIn.getName() + " has sent you a DM!");
            }
        }
    }

    public ArrayList<post> hashtagSearch(String hashtag) {
        ArrayList<post> results = new ArrayList<post>();
        for (int i = 0; i < allProfiles.size(); i++) {
            for (int j = 0; j < allProfiles.get(i).getPosts().size(); j++) {
                for (int k = 0; k < allProfiles.get(i).getPosts().get(j).getHashtags().size(); k++) {    //Oh god what have we created...
                    if (allProfiles.get(i).getPosts().get(j).getHashtags().get(k).equals(hashtag)) {
                        results.add(allProfiles.get(i).getPosts().get(j));
                    }
                }
            }
        }
        return results;
    }

    public void addProfile(String username, String password, String firstName, String lastName) {
        for (int i = 0; i < allProfiles.size(); i++) {
            if (!allProfiles.get(i).getUsername().equals(username)) {
                allProfiles.add(new RealProfile(username, password, firstName, lastName));
            }
        }
    }
    
    public void printAllProfiles(){
        for(int i = 0; i < allProfiles.size(); i++){
            System.out.println(allProfiles.get(i).getUsername());
        }
    }
}
