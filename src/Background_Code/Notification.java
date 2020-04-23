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
    private Post post;
    private String method;

    /**
     * Constructor of the Notification object
     *
     * @param actor the user that did the action
     * @param receiver the user that received the action
     * @param date the date the action happened
     * @param notification the notification of what happened
     * @param post the Post related to this notification if there is one
     * @param method whether this is Post related or not
     */
    public Notification(RealProfile actor, RealProfile receiver, String date,
            String notification, Post post, String method) {
        this.actor = actor;
        this.receiver = receiver;
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
     * Gets the Post related to this notification
     *
     * @return returns the related Post to this notification
     */
    public Post getPost() {
        return post;
    }

    /**
     * Returns whether or not this is a Post related notification
     *
     * @return returns the method
     */
    public String getMethod() {
        return method;
    }
}
