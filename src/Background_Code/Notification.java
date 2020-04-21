/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Background_Code;

import java.io.Serializable;

/**
 * This is the Notification class where all of the Notifications objects are
 * made
 *
 * @author Jose
 */
public class Notification implements Serializable {

    private RealProfile actor;
    private RealProfile receiver;
    private String date;
    private String notification;
    private post post;
    private String method;

    /**
     * Constructor of the Notification object
     *
     * @param a the user that did the action
     * @param r the user that received the action
     * @param date the date the action happened
     * @param notification the notification of what happened
     * @param post the post related to this notification if there is one
     * @param method whether this is post related or not
     */
    public Notification(RealProfile a, RealProfile r, String date,
            String notification, post post, String method) {
        this.actor = a;
        this.receiver = r;
        this.date = date;
        this.notification = notification;
        this.post = post;
        this.method = method;
    }

    /**
     * Returns the user that did this action
     *
     * @return return the user that did this the action
     */
    public RealProfile getActor() {
        return actor;
    }

    /**
     * Returns the user that received this action
     *
     * @return returns the user that received this action
     */
    public RealProfile getReceiver() {
        return receiver;
    }

    /**
     * Returns the date that this action happened
     *
     * @return returns the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the notification of this notification
     *
     * @return returns the notification
     */
    public String getNotification() {
        return notification;
    }

    /**
     * Gets the post related to this notification
     *
     * @return returns the related post to this notification
     */
    public post getPost() {
        return post;
    }

    /**
     * Returns whether or not this is a post related notification
     *
     * @return returns the method
     */
    public String getMethod() {
        return method;
    }
}
