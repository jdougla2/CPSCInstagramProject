/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagramproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.event.*;

/**
 *
 * @author jacko
 */
class ComparatorByDate {
    public static Comparator<post> ComparatorByDate
                          = new Comparator<post>() {

        public int compare(post post1, post post2) {
            Date date1;
            Date date2;
            SimpleDateFormat originalFormat = new SimpleDateFormat("MMddyyyy HH:mm:ss");
            try{
                date1 = post1.getDate();
                date2 = post2.getDate();
                return date1.compareTo(date2);
            } catch(Exception e){
                e.printStackTrace();
            }

            return 0;
        }
    };
}

public class CurrentProfile{
    private RealProfile loggedIn;
    private ArrayList<post> feed = new ArrayList<post>();
    private ArrayList<RealProfile> allProfiles = new ArrayList<RealProfile>();
    
    public CurrentProfile(){
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
        
        if(allProfiles.isEmpty()){
            loggedIn = new RealProfile("guest", "guest", "guest", "guest");
        }
        else{
            this.logIn("guest", "guest");
        }
    }
    
    public boolean logIn(String username, String password){
        for(int i = 0; i < allProfiles.size(); i++){
            if(allProfiles.get(i).getUsername().equals(username) && 
                    allProfiles.get(i).getPassword().equals(password)){
                loggedIn = allProfiles.get(i);
                return true;
            }
        }
        return false;
    }
    
    public void logOut(){
        try {
            FileOutputStream fileOut
                    = new FileOutputStream(System.getProperty("user.dir") + "\\allprofiles.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allProfiles);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        loggedIn = null;
    }
    
    public void updateFeed(){
        if(loggedIn.getUsername().equals("guest")){    
            for(int i = 0; i < loggedIn.getFollowing().size(); i++){
                for(int j = 0; j < loggedIn.getFollowing().get(i).getPosts().size();
                        j++){
                    feed.add(loggedIn.getFollowing().get(i).getPosts().get(j));
                }
            }

            Collections.sort(feed, ComparatorByDate.ComparatorByDate);
        }
    }
    
    public void Follow(RealProfile toFollow){
        toFollow.addFollower(loggedIn.getResponder());
        toFollow.getFollowers().add(toFollow);
    }
    
    public ArrayList<RealProfile> ProfileSearch(String username){
        ArrayList<RealProfile> results = new ArrayList<RealProfile>();
        for(int i = 0; i < allProfiles.size(); i++){
            if(allProfiles.get(i).getUsername().equals(username))
                results.add(allProfiles.get(i));
        }
        return results;
    }
    
    public void PlaceComment(RealProfile profile, String comment){
        
    }
    
    public ArrayList<post> HashtagSearh(String hashtag){
        ArrayList<post> results = new ArrayList<post>();
        for(int i = 0; i < allProfiles.size(); i++){
            for(int j = 0; j < allProfiles.get(i).getPosts().size(); j++){
                for(int k = 0; k < allProfiles.get(i).getPosts().get(j).getHashtags().size(); k++){    //Oh god what have we created...
                    if(allProfiles.get(i).getPosts().get(j).getHashtags().get(k).equals(hashtag)){
                        results.add(allProfiles.get(i).getPosts().get(j));
                    }
                }    
            }
        }
        return results;
    }
}

