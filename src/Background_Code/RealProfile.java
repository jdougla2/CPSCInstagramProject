/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Background_Code;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * This is where each of the profiles for EagleGram are created
 *
 * @author jack & Jose
 */
public class RealProfile implements Serializable {

    private String fileSeparator = System.getProperty("file.separator");
    private String dir = System.getProperty("user.dir") + fileSeparator;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isPrivate = false;
    private ImageIcon profilePic;
    private ArrayList<post> posts = new ArrayList<>();
    private ArrayList<String> likedPosts = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();
    private ArrayList<RealProfile> followers = new ArrayList<>();
    private ArrayList<RealProfile> following = new ArrayList<>();
    private ArrayList<DirectMessage> inbox = new ArrayList<>();
    private ArrayList<DirectMessage> sents = new ArrayList<>();
    private static final long serialVersionUID = -8245875722878500126L;

    /**
     * Constructor for RealProfile
     *
     * @param username the user's username
     * @param password the user's password
     * @param firstName the user's first name
     * @param lastName the user's last name
     */
    public RealProfile(String username, String password, String firstName,
            String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            profilePic = new ImageIcon(scaleImage(77, 77, ImageIO.read(
                    new File(dir + "src" + fileSeparator + "Images" 
                            + fileSeparator + "ProfilePicture.png"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user's username
     *
     * @return returns the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the user's password
     *
     * @return returns the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user's full name
     *
     * @return returns the user's full name
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Gets the posts that this user has posted
     *
     * @return returns the user's posts
     */
    public ArrayList<post> getPosts() {
        return posts;
    }

    /**
     * Gets all of the posts that this user has liked
     *
     * @return returns all the posts that this user has liked
     */
    public ArrayList getLikedPosts() {
        return likedPosts;
    }

    /**
     * Gets all of the notifications that this user has
     *
     * @return returns all of this user's notifications
     */
    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    /**
     * Gets an ArrayList of the people that this user follows
     *
     * @return returns all of the people that this user follows
     */
    public ArrayList<RealProfile> getFollowing() {
        return following;
    }

    /**
     * Gets all of the people that follow this user
     *
     * @return returns all of the people that are following this user
     */
    public ArrayList<RealProfile> getFollowers() {
        return followers;
    }

    /**
     * Gets the state of this user's profile. Private or not Private
     *
     * @return returns the state of this profile. Private or not Private
     */
    public boolean getPrivacy() {
        return isPrivate;
    }

    /**
     * Gets the first name of this user
     *
     * @return returns the users first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of this user
     *
     * @return returns the users last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the user's profile picture
     *
     * @return returns the user's profile picture
     */
    public Icon getProfilePic() {
        return profilePic;
    }

    /**
     * Gets the user's inbox of messages
     *
     * @return returns an Arraylist of the user's inbox
     */
    public ArrayList<DirectMessage> getInbox() {
        return inbox;
    }

    /**
     * Gets the user's sent messages
     *
     * @return returns an ArrayList of the messages that the user has sent
     */
    public ArrayList<DirectMessage> getSents() {
        return sents;
    }

    /**
     * Changes the user's last name
     *
     * @param newLastName the new last name for the user
     */
    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    /**
     * Changes the user's first name
     *
     * @param newFirstName the new first name for the user
     */
    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    /**
     * Adds a another user to this users following list
     *
     * @param add the user to be added to this users following list
     */
    public void addFollowing(RealProfile add) {
        following.add(add);
    }

    /**
     * Adds a notification to this users notification ArrayList
     *
     * @param a the user that did the action
     * @param r the user that received the action
     * @param date the time that this happened
     * @param notification what the action is
     * @param post the related post if there is one
     * @param method whether or not this is post related
     */
    public void addNotification(RealProfile a, RealProfile r, String date,
            String notification, post post, String method) {
        notifications.add(new Notification(a, r, date, notification, post,
                method));
    }

    /**
     * Clears this users notification ArrayList
     */
    public void clearNotifications() {
        notifications.clear();
    }

    /**
     * Adds a post to this users post ArrayList
     *
     * @param caption caption to this post
     * @param imageLink the picture related to this post
     * @param comments any comments related to this post
     * @param hashtags the hash tags related to this post
     * @param mentions any users that have been tagged in this post
     */
    public void addPost(String caption, Icon imageLink, ArrayList comments,
            ArrayList<String> hashtags, ArrayList<String> mentions) {
        posts.add(new post(caption, comments, mentions, hashtags, imageLink));

    }

    /**
     * adds a DirectMessage to this user's inbox
     *
     * @param dm the DirectMessage to be add to this user's inbox
     */
    public void addInbox(DirectMessage dm) {
        inbox.add(dm);
    }

    /**
     * Adds a DirectMessage to this user's sents
     *
     * @param dm the DirectMessage to be add to this user's sents
     */
    public void addSents(DirectMessage dm) {
        sents.add(dm);
    }

    /**
     * Clears this user's inbox ArrayList
     */
    public void clearInbox() {
        inbox.clear();
    }

    /**
     * Clears this user's sents ArrayList
     */
    public void clearSents() {
        sents.clear();
    }

    /**
     * Adds a post to this user's liked posts
     *
     * @param toAdd the post ID to be add to the likedPosts ArrayList
     */
    public void addLikedPost(String toAdd) {
        likedPosts.add(toAdd);
    }

    /**
     * Removes a post from this user's liked posts
     *
     * @param toRemove the post to be removed from this user's liked posts
     */
    public void removeLikedPost(String toRemove) {
        for (int i = 0; i < likedPosts.size(); i++) {
            if (likedPosts.get(i).equals(toRemove)) {
                likedPosts.remove(i);
            }
        }
    }

    /**
     * Changes the privacy setting of this user
     *
     * @param newPrivacy the new privacy setting for this user
     */
    public void changePrivacy(boolean newPrivacy) {
        isPrivate = newPrivacy;
    }

    /**
     * Changes this user's password
     *
     * @param newPassword the new password to be changed for the old one
     */
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    /**
     * Changes this user's profile picture
     *
     * @param newImageLink the picture to replace the old profile picture
     */
    public void setProfilePic(ImageIcon newImageLink) {
        profilePic = newImageLink;
    }

    /**
     * Adds a new user to this user's Follower ArrayList
     *
     * @param add the user to be add to this user's follower ArrayList
     */
    public void addFollower(RealProfile add) {
        followers.add(add);
    }

    /**
     * Processes any new picture to be used as an icon, for jLabels
     *
     * @param w width of the picture
     * @param h height of the picture
     * @param img the picture to be processed
     * @return the processed picture now usable as an icon for jLabels
     * @throws Exception ----
     */
    public static BufferedImage scaleImage(int w, int h, BufferedImage img)
            throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }

    /**
     * Removes a user from this user's following list
     *
     * @param toRemove the user that is to be removed from this user's following
     * ArrayList
     */
    public void removeFollowing(RealProfile toRemove) {
        for (int i = 0; i < following.size(); i++) {
            if (following.get(i) == toRemove) {
                following.remove(i);
            }
        }
    }

    /**
     * Removes a user from this user's follower list
     *
     * @param toRemove the user to be removed from this user's follower
     * ArrayList
     */
    public void removeFollower(RealProfile toRemove) {
        for (int i = 0; i < followers.size(); i++) {
            if (followers.get(i) == toRemove) {
                followers.remove(i);
            }
        }
    }
}
