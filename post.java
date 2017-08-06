package Background_Code;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import javax.swing.Icon;

/**
 * This is the post class where all post objects are made
 *
 * @author Armando & Jose
 */
public class post implements Serializable {

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

    /**
     * Constructor for the object post
     *
     * @param caption the caption to this post
     * @param comments any comments related to this post
     * @param tags any users that are tagged in this post
     * @param hashtags any hash tags related to this post
     * @param imageLink the picture related to this post
     */
    public post(String caption, ArrayList<String> comments,
            ArrayList<String> tags, ArrayList<String> hashtags, Icon imageLink) {
        this.caption = caption;
        this.comments = comments;
        this.hashtags = hashtags;
        this.tags = tags;
        this.icon = imageLink;
        this.getImage();
    }

    /**
     * Gets the caption related to this post
     *
     * @return returns the caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Gets the icon related to this post
     *
     * @return returns the icon for this post
     */
    public Icon getImage() {
        return icon;
    }

    /**
     * Gets the ArrayList that contains all of the comments to this post
     *
     * @return returns the ArrayList of comments to this post
     */
    public ArrayList getComments() {
        return comments;
    }

    /**
     * Gets the time and date that this post was posted
     *
     * @return returns the time and date that this post was posted
     */
    public String getDate() {
        return time;
    }

    /**
     * Gets the number of likes that this post has
     *
     * @return returns the number of likes that this post has
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Gets an ArrayList of the hash tags related to this post
     *
     * @return returns the ArrayList of hash tags related to this post
     */
    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    /**
     * Gets an ArrayList of the user's tagged in this post
     *
     * @return returns the ArrayList of user's tagged on this post
     */
    public ArrayList<String> getTagged() {
        return tags;
    }

    /**
     * Adds a comment to this post
     *
     * @param c the comment to be added to this post's comments
     */
    public void addComment(String c) {
        comments.add(c);
    }

    /**
     * Adds a user to the tagged ArrayList of this post
     *
     * @param t user to be added
     */
    public void addTag(String t) {
        tags.add(t);
    }

    /**
     * Adds a hash tag to this post's hash tag ArrayList
     *
     * @param h hash tag to be added
     */
    public void addHashtag(String h) {
        hashtags.add(h);
    }

    /**
     * Increase the number of likes this post has by one
     */
    public void addLike() {
        likes++;
    }

    /**
     * Decrease the number of likes this post has by one
     */
    public void removeLike() {
        likes--;
    }
}
