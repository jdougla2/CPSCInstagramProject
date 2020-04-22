package Background_Code;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import javax.swing.Icon;

/**
 * This is the Post class where all Post objects are made
 *
 * @author Armando & Jose
 */
public class Post implements Serializable {

    private String caption;
    private URL link;
    private BufferedImage image = null;
    private Icon icon = null;
    private ArrayList<String> comments = new ArrayList<String>();
    private ArrayList<String> tags = new ArrayList<String>();
    private ArrayList<String> hashtags = new ArrayList<String>();
    private SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
    private Date date = new Date();
    private String time = format.format(date);
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
    public Post(String caption, ArrayList<String> comments,
            ArrayList<String> tags, ArrayList<String> hashtags, Icon imageLink) {
        this.caption = caption;
        this.comments = comments;
        this.hashtags = hashtags;
        this.tags = tags;
        this.icon = imageLink;
        this.getImage();
    }

    /**
     * Gets the caption related to this Post
     *
     * @return returns the caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Gets the icon related to this Post
     *
     * @return returns the icon for this Post
     */
    public Icon getImage() {
        return icon;
    }

    /**
     * Gets the ArrayList that contains all of the comments to this Post
     *
     * @return returns the ArrayList of comments to this Post
     */
    public ArrayList getComments() {
        return comments;
    }

    /**
     * Gets the time and date that this Post was posted
     *
     * @return returns the time and date that this Post was posted
     */
    public String getDate() {
        return time;
    }

    /**
     * Gets the number of likes that this Post has
     *
     * @return returns the number of likes that this Post has
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Gets an ArrayList of the hash tags related to this Post
     *
     * @return returns the ArrayList of hash tags related to this Post
     */
    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    /**
     * Gets an ArrayList of the user's tagged in this Post
     *
     * @return returns the ArrayList of user's tagged on this Post
     */
    public ArrayList<String> getTagged() {
        return tags;
    }

    /**
     * Adds a comment to this Post
     *
     * @param c the comment to be added to this Post's comments
     */
    public void addComment(String c) {
        comments.add(c);
    }

    /**
     * Adds a user to the tagged ArrayList of this Post
     *
     * @param t user to be added
     */
    public void addTag(String t) {
        tags.add(t);
    }

    /**
     * Adds a hash tag to this Post's hash tag ArrayList
     *
     * @param h hash tag to be added
     */
    public void addHashtag(String h) {
        hashtags.add(h);
    }

    /**
     * Increase the number of likes this Post has by one
     */
    public void addLike() {
        likes++;
    }

    /**
     * Decrease the number of likes this Post has by one
     */
    public void removeLike() {
        likes--;
    }
}
