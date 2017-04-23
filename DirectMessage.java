/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instagramproject;

/**
 *
 * @author jack
 */
public class DirectMessage {
    private String message;
    private String imageLink;
    private RealProfile sender;
    
    public DirectMessage(String message, String imageLink, RealProfile sender){
        this.message = message;
        this.imageLink = imageLink;
        this.sender = sender;
    }
    
    public String getMessage(){
        return message;
    }
    
    public String getImageLink(){
        return imageLink;
    }
    
    public RealProfile sender(){
        return sender;
    }
}
