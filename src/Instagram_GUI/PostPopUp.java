package Instagram_GUI;

import Background_Code.*;
import static Instagram_GUI.ProfilePopUp.scaleImage;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class deals with creating the post pop up frame
 *
 * @author Jose
 */
public class PostPopUp extends javax.swing.JFrame {

    private String fileSeparator = System.getProperty("file.separator");
    private String workingDir = System.getProperty("user.dir");
    private String imagesDir =  workingDir + fileSeparator + "src"
            + fileSeparator + "Images" + fileSeparator;
    private boolean liked;
    private int likes;
    int width = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 262;
    int height = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - 250;

    /**
     * Constructor for the post pop up class
     *
     * @param ii icon of this post
     * @param lookingAt the user that owns this post
     * @param postIndex the location of this post
     * @param likes the number of likes for this post
     * @param caption caption of this post
     * @param comments the comments on this post
     * @param hashTags the hash tags on this post
     * @param peopleTaged the people tagged on this post
     * @param loggedIn the user that is currently loggedIn
     * @param liked whether or not the loggedIn user has liked this post
     */
    public PostPopUp(Icon ii, RealProfile lookingAt, int postIndex,
            int likes,
            String caption, ArrayList<String> comments, ArrayList<String> hashTags,
            ArrayList<String> peopleTaged, RealProfile loggedIn, boolean liked) {
        initComponents();
        this.setTitle("EagleGram");
        this.setLocation(width, height);
        
        try {
            ImageIcon emptyPicture = new ImageIcon(scaleImage(
                    100, 23, ImageIO.read(new File(imagesDir
                            + "EagleGramTransparent.png"))));
            eagleGramLabel.setIcon(emptyPicture);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        this.loggedIn = loggedIn;
        postPicture.setIcon(ii);
        dateLabel.setText(lookingAt.getPosts().get(postIndex).getDate());
        usernameLabel.setText(lookingAt.getUsername());
        likeLabel.setText("LIKES: " + likes);
        this.likes = likes;
        this.liked = liked;

        this.lookingAt = lookingAt;
        if (lookingAt.getUsername().equalsIgnoreCase(loggedIn.getUsername())) {
            likeButton.setEnabled(false);
        }

        if (loggedIn.getUsername().equals(main.getLoggedIn().getUsername())) {
            likeButton.setEnabled(false);
            addCommentButton.setEnabled(false);
            addCommentArea.setEditable(false);
            addCommentArea.setEnabled(false);
        }

        this.postIndex = postIndex;
        if (this.liked) {
            likeButton.setText("unLike");
        }
        captionArea.setText(caption);
        for (int i = 0; i < comments.size(); i++) {
            commentsArea.append(comments.get(i) + "\n");
        }
        for (int i = 0; i < hashTags.size(); i++) {
            hashTagsArea.append(hashTags.get(i) + "\n");
        }
        for (int i = 0; i < peopleTaged.size(); i++) {
            peopleTagedArea.append(peopleTaged.get(i) + "\n");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        postPicture = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        likeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        peopleTagedArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        captionArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        hashTagsArea = new javax.swing.JTextArea();
        likeButton = new javax.swing.JButton();
        peopleTaggedLabel = new javax.swing.JLabel();
        hashTagsLabel = new javax.swing.JLabel();
        commentsLabel = new javax.swing.JLabel();
        addCommentLabel = new javax.swing.JLabel();
        addCommentButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        addCommentArea = new javax.swing.JTextArea();
        dateLabel = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        eagleGramLabel = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));

        contentPanel.setMaximumSize(new java.awt.Dimension(550, 550));
        contentPanel.setMinimumSize(new java.awt.Dimension(500, 500));

        usernameLabel.setText("username");
        usernameLabel.setPreferredSize(new java.awt.Dimension(100, 21));

        likeLabel.setText("likes");
        likeLabel.setPreferredSize(new java.awt.Dimension(100, 21));

        commentsArea.setEditable(false);
        commentsArea.setColumns(20);
        commentsArea.setLineWrap(true);
        commentsArea.setRows(5);
        commentsArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(commentsArea);

        peopleTagedArea.setEditable(false);
        peopleTagedArea.setColumns(20);
        peopleTagedArea.setLineWrap(true);
        peopleTagedArea.setRows(5);
        peopleTagedArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(peopleTagedArea);

        captionArea.setEditable(false);
        captionArea.setColumns(20);
        captionArea.setRows(5);
        jScrollPane2.setViewportView(captionArea);

        hashTagsArea.setEditable(false);
        hashTagsArea.setColumns(20);
        hashTagsArea.setLineWrap(true);
        hashTagsArea.setRows(5);
        jScrollPane4.setViewportView(hashTagsArea);

        likeButton.setText("Like");
        likeButton.setCursor(Cursor.getPredefinedCursor(
            Cursor.HAND_CURSOR));
    likeButton.setPreferredSize(new java.awt.Dimension(100, 21));
    likeButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            likeButtonActionPerformed(evt);
        }
    });

    peopleTaggedLabel.setText("People tagged:");
    peopleTaggedLabel.setPreferredSize(new java.awt.Dimension(100, 21));

    hashTagsLabel.setText("Hash Tags: ");
    hashTagsLabel.setPreferredSize(new java.awt.Dimension(100, 21));

    commentsLabel.setText("Comments: ");
    commentsLabel.setPreferredSize(new java.awt.Dimension(100, 21));

    addCommentLabel.setText("Add Comment:");

    addCommentButton.setText("Add");
    addCommentButton.setCursor(Cursor.getPredefinedCursor(
        Cursor.HAND_CURSOR));
addCommentButton.setPreferredSize(new java.awt.Dimension(75, 21));
addCommentButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        addCommentButtonActionPerformed(evt);
    }
    });

    addCommentArea.setColumns(20);
    addCommentArea.setCursor(Cursor.getPredefinedCursor(
        Cursor.HAND_CURSOR));
addCommentArea.setLineWrap(true);
addCommentArea.setRows(5);
addCommentArea.setToolTipText("");
jScrollPane5.setViewportView(addCommentArea);

dateLabel.setText("date");
dateLabel.setPreferredSize(new java.awt.Dimension(100, 21));

javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
contentPanel.setLayout(contentPanelLayout);
contentPanelLayout.setHorizontalGroup(
    contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(contentPanelLayout.createSequentialGroup()
        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(postPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(likeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 45, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(likeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166)
                .addComponent(addCommentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addCommentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peopleTaggedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(hashTagsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))))
        .addContainerGap())
    );
    contentPanelLayout.setVerticalGroup(
        contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(contentPanelLayout.createSequentialGroup()
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(likeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(postPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(likeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGap(18, 18, 18)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCommentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(addCommentLabel))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(peopleTaggedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(hashTagsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(96, Short.MAX_VALUE))
    );

    returnButton.setText("Return");
    returnButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            returnButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
    menuPanel.setLayout(menuPanelLayout);
    menuPanelLayout.setHorizontalGroup(
        menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(menuPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(returnButton)
            .addGap(131, 131, 131)
            .addComponent(eagleGramLabel)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    menuPanelLayout.setVerticalGroup(
        menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(menuPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(returnButton)
                .addComponent(eagleGramLabel))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Changes the state of the like button and add this post to the loggedIn
     * user's liked posts, and adds a like to the post
     *
     * @param evt when the user clicks the like button
     */
    private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeButtonActionPerformed
        if (liked == false) {
            likes++;
            likeLabel.setText("LIKES: " + Integer.toString(likes));
            likeButton.setText("UnLike");

            loggedIn.addLikedPost(
                    lookingAt.getPosts().get(postIndex).getCaption()
                    + lookingAt.getPosts().get(postIndex).getDate());

            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            String time = format.format(date);
            lookingAt.addNotification(lookingAt, loggedIn, time,
                    "liked your post:", lookingAt.getPosts().get(postIndex),
                     "post");

            lookingAt.getPosts().get(postIndex).addLike();
            liked = true;
            main.output();
        } else {
            likes--;
            loggedIn.removeLikedPost(
                    lookingAt.getPosts().get(postIndex).getCaption()
                    + lookingAt.getPosts().get(postIndex).getDate());
            likeLabel.setText("LIKES: " + Integer.toString(likes));
            likeButton.setText("Like");
            liked = false;
            lookingAt.getPosts().get(postIndex).removeLike();

            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            String time = format.format(date);
            if (!lookingAt.getUsername().equals(loggedIn.getUsername())) {
                lookingAt.addNotification(lookingAt, loggedIn, time,
                        "unliked your post:", lookingAt.getPosts().get(postIndex),
                         "post");
            }

            main.output();
        }

    }//GEN-LAST:event_likeButtonActionPerformed

    /**
     * Adds a comment to this post
     *
     * @param evt when the user clicks the add comment button
     */
    private void addCommentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCommentButtonActionPerformed
        // TODO add your handling code here:
        //add comments
        if (!addCommentArea.getText().equalsIgnoreCase("")) {
            commentsArea.append(loggedIn.getUsername() + ": "
                    + addCommentArea.getText() + "\n");
            lookingAt.getPosts().get(postIndex)
                    .addComment(loggedIn.getUsername() + ": "
                            + addCommentArea.getText());
            addCommentArea.setText("");

            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
            String time = format.format(date);
            if (!lookingAt.getUsername().equals(loggedIn.getUsername())) {
                lookingAt.addNotification(lookingAt, loggedIn, time,
                        "commented on \nyour post:",
                        lookingAt.getPosts().get(postIndex), "post");
            }

            main.output();
        }
    }//GEN-LAST:event_addCommentButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PostPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostPopUp(null, null, 0, 2, "this is a caption",
                        null, null, null, null, false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addCommentArea;
    private javax.swing.JButton addCommentButton;
    private javax.swing.JLabel addCommentLabel;
    private javax.swing.JTextArea captionArea;
    private javax.swing.JTextArea commentsArea;
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel eagleGramLabel;
    private javax.swing.JTextArea hashTagsArea;
    private javax.swing.JLabel hashTagsLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton likeButton;
    private javax.swing.JLabel likeLabel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTextArea peopleTagedArea;
    private javax.swing.JLabel peopleTaggedLabel;
    private javax.swing.JLabel postPicture;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
    private CurrentProfile main = new CurrentProfile();
    private RealProfile lookingAt;
    private RealProfile loggedIn;
    private int postIndex;
}