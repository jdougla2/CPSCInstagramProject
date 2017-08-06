/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Background_Code;

import java.io.Serializable;
import javax.swing.Icon;

/**
 * This is the DirectMessage class where all the DirectMessage objects are
 * created
 *
 * @author jack & Jose
 */
public class DirectMessage implements Serializable {

    private String message;
    private String date;
    private Icon imageLink;
    private RealProfile sender;
    private RealProfile receiver;

    /**
     * Constructor of the DirectMessage object
     *
     * @param message the message related to this post
     * @param date the date this message was sent
     * @param imageLink the picture related to this message if there is one
     * @param sender the user that sent this message
     * @param receiver the user that received this message
     */
    public DirectMessage(String message, String date, Icon imageLink,
            RealProfile sender, RealProfile receiver) {
        this.receiver = receiver;
        this.message = message;
        this.date = date;
        this.imageLink = imageLink;
        this.sender = sender;
    }

    /**
     * Gets the message related to this DirectMessage
     *
     * @return returns the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the date this message was sent
     *
     * @return returns the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the icon that is related to this DirectMessage
     *
     * @return returns the icon
     */
    public Icon getImageLink() {
        return imageLink;
    }

    /**
     * Gets the user that sent this message
     *
     * @return returns the sender
     */
    public RealProfile getSender() {
        return sender;
    }

    /**
     * Gets the user that receiver this message
     *
     * @return returns the receiver
     */
    public RealProfile getReceiver() {
        return receiver;
    }
}
