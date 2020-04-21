/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Background_Code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Sorts all of the post by their dates
 *
 * @author jack and Jose
 */
class ComparatorByDate {

    public static Comparator<post> ComparatorByDate
            = new Comparator<post>() {

        public int compare(post post1, post post2) {
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            try {
                String time = post1.getDate();
                String time2 = post2.getDate();
                return time.compareTo(time2);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 0;
        }
    };
}

/**
 * This class is for handling the uploading, saving, and creation on the
 * allprofiles.ser file
 *
 * @author jack & Jose
 */
public class CurrentProfile {

    private String fileSeparator = System.getProperty("file.separator");
    private String dir = System.getProperty("user.dir") + fileSeparator;
    private RealProfile loggedIn;
    private ArrayList<post> feed = new ArrayList<>();
    private ArrayList<RealProfile> allProfiles = new ArrayList<>();
    private static final long serialVersionUID = -8245875722878500126L;

    /**
     * Constructor for the CurrentProfile class
     */
    public CurrentProfile() {
        this.input();
        if (allProfiles.isEmpty()) {
            loggedIn = new RealProfile("guest", "guest", "guest", "guest");
            allProfiles.add(loggedIn);
            this.output();
            this.input();
        } else {
            this.logIn("guest", "guest");
        }
    }

    /**
     * Saves all information back into the allprofiles.ser file
     */
    public void output() {
        try {
            FileOutputStream fileOut
                    = new FileOutputStream(dir + "allprofiles.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allProfiles);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Uploads the information from the allprofiles.ser file or creates it if it
     * does not already exist
     */
    public void input() {
        try {
            FileInputStream fileIn = new FileInputStream(dir 
                    + "allprofiles.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            allProfiles = (ArrayList<RealProfile>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("SYSTEM: "
                    + "'allprofiles.ser' file has been created");
        } catch (ClassNotFoundException c) {
            System.out.println("AllProfiles not found");
        }
    }

    /**
     * Signs up a new user
     *
     * @param username new user's username
     * @param password new user's password
     * @param firstName new user's first name
     * @param lastName new user's last name
     * @return returns true or false if the new user has been created
     */
    public boolean signUp(String username, String password, String firstName,
            String lastName) {
        for (int i = 0; i < allProfiles.size(); i++) {
            if (!allProfiles.get(i).getUsername().equals(username)) {
                allProfiles.add(new RealProfile(username, password, firstName,
                        lastName));
                this.logIn(username, password);
                this.output();
                return true;
            }
        }
        return false;
    }

    /**
     * Logs in a user
     *
     * @param username user's username
     * @param password user's password
     * @return returns true or false if user has been logged in
     */
    public boolean logIn(String username, String password) {
        for (int i = 0; i < allProfiles.size(); i++) {
            if (allProfiles.get(i).getUsername().equals(username)
                    && allProfiles.get(i).getPassword().equals(password)) {
                loggedIn = allProfiles.get(i);
                this.output();
                return true;
            }
        }
        return false;
    }

    /**
     * Saves one last time before logging which ever user is currently logged in
     * off
     */
    public void close() {
        this.output();
        loggedIn = null;
    }

    /**
     * Updates with all of the posts from the users that this user follows
     *
     * @return all of the posts
     */
    public ArrayList<post> updateFeed() {
        if (!loggedIn.getUsername().equals("guest")) {
            for (int i = 0; i < loggedIn.getFollowing().size(); i++) {
                for (int j = 0; j
                        < loggedIn.getFollowing().get(i).getPosts().size(); j++) {
                    feed.add(loggedIn.getFollowing().get(i).getPosts().get(j));
                }
            }

            Collections.sort(feed, ComparatorByDate.ComparatorByDate);
        }
        return feed;
    }

    /**
     * Clears this users feed
     */
    public void clearFeed() {
        feed.removeAll(feed);
    }

    /**
     * Adds a new profile
     *
     * @param username new profiles username
     * @param password new profiles password
     * @param firstName new profiles first name
     * @param lastName new profiles last name
     */
    public void addProfile(String username, String password, String firstName,
            String lastName) {
        for (int i = 0; i < allProfiles.size(); i++) {
            if (!allProfiles.get(i).getUsername().equals(username)) {
                allProfiles.add(new RealProfile(username, password, firstName,
                        lastName));
            }
        }
    }

    /**
     * Prints out all of the profiles
     */
    public void printAllProfiles() {
        for (int i = 0; i < allProfiles.size(); i++) {
            System.out.println(allProfiles.get(i).getUsername());
        }
    }

    /**
     * Returns the user that is currently logged in
     *
     * @return returns the user that is logged in
     */
    public RealProfile getLoggedIn() {
        return loggedIn;
    }

    /**
     * Returns all of the profiles
     *
     * @return returns all of the profiles
     */
    public ArrayList<RealProfile> getAllProfiles() {
        return allProfiles;
    }

    /**
     * Returns all users that contain the searchInput
     * 
     * @param searchInput user input to search on
     * @return all users that contain the searchInput
     */
    public ArrayList<RealProfile> profileSearch(String searchInput) {
        ArrayList<RealProfile> returnList = new ArrayList<RealProfile>();
        for(int i= 0; i < allProfiles.size(); i++){
            System.out.println(allProfiles.get(i).getUsername().toLowerCase()
                    .contains(searchInput));
            if (allProfiles.get(i).getUsername().toLowerCase()
                    .contains(searchInput)){
                returnList.add(allProfiles.get(i));
            }
        }
        return null;
    }
}
