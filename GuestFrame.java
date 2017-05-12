
import instagramproject.CurrentProfile;
import instagramproject.RealProfile;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose
 */
public class GuestFrame extends javax.swing.JFrame {

    /**
     * Creates new form GuestFrame
     */
    int width = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 262;
    int height = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - 250;

    public GuestFrame() {
        initComponents();
        this.setTitle("EagleGram");
        this.setLocation(width, height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TopMenu = new javax.swing.JPanel();
        SignInButton = new javax.swing.JButton();
        EagleGramLabel = new javax.swing.JLabel();
        SignUpButton = new javax.swing.JButton();
        BottomMenu = new javax.swing.JPanel();
        SearchMenuButton = new javax.swing.JButton();
        NewPostButton = new javax.swing.JButton();
        NotificationsButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        ProfileButton = new javax.swing.JButton();
        SearchPanel = new javax.swing.JPanel();
        SearchButton = new javax.swing.JButton();
        searchInputField = new javax.swing.JTextField();
        searchParameterBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchOutputPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SignInButton.setText("Sign In");
        SignInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInButtonActionPerformed(evt);
            }
        });

        EagleGramLabel.setText("EagleGram");

        SignUpButton.setText("Sign Up");
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopMenuLayout = new javax.swing.GroupLayout(TopMenu);
        TopMenu.setLayout(TopMenuLayout);
        TopMenuLayout.setHorizontalGroup(
            TopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopMenuLayout.createSequentialGroup()
                .addComponent(SignInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(EagleGramLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TopMenuLayout.setVerticalGroup(
            TopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(TopMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SignInButton)
                    .addComponent(EagleGramLabel)
                    .addComponent(SignUpButton)))
        );

        SearchMenuButton.setText("Search");
        SearchMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchMenuButtonActionPerformed(evt);
            }
        });

        NewPostButton.setText("New Post");
        NewPostButton.setEnabled(false);

        NotificationsButton.setText("Notifications");
        NotificationsButton.setEnabled(false);

        javax.swing.GroupLayout BottomMenuLayout = new javax.swing.GroupLayout(BottomMenu);
        BottomMenu.setLayout(BottomMenuLayout);
        BottomMenuLayout.setHorizontalGroup(
            BottomMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BottomMenuLayout.createSequentialGroup()
                .addComponent(SearchMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NotificationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BottomMenuLayout.setVerticalGroup(
            BottomMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BottomMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(BottomMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchMenuButton)
                    .addComponent(NewPostButton)
                    .addComponent(NotificationsButton)))
        );

        HomeButton.setText("Home");
        HomeButton.setEnabled(false);

        ProfileButton.setText("Profile");
        ProfileButton.setEnabled(false);

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        searchParameterBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "People", "Hash Tags"}));

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(searchParameterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(searchParameterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(searchInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(SearchButton))
        );

        javax.swing.GroupLayout searchOutputPanelLayout = new javax.swing.GroupLayout(searchOutputPanel);
        searchOutputPanel.setLayout(searchOutputPanelLayout);
        searchOutputPanelLayout.setHorizontalGroup(
            searchOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );
        searchOutputPanelLayout.setVerticalGroup(
            searchOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(searchOutputPanel);
        searchOutputPanel.setLayout(new BoxLayout(searchOutputPanel, BoxLayout.Y_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BottomMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BottomMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HomeButton)
                    .addComponent(ProfileButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInButtonActionPerformed
        Login z = new Login();
        z.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_SignInButtonActionPerformed

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        SignUpFrame y = new SignUpFrame();
        y.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        searchOutputPanel.removeAll();
        searchOutputPanel.repaint();
        Input = searchInputField.getText();
        Parameter = searchParameterBox.getSelectedItem().toString();
        //add search output
        ArrayList<RealProfile> results = main.profileSearch(Input);

        Icon ii = null;
        /*for(int i = 0; i < results.size(); i++){
            ii = results.get(i).getProfilePic();
            searchOutputPanel.add(new UserFrame.SearchOutputPanel(Parameter, results.get(i).getUsername(), ii, "date"));
            searchOutputPanel.revalidate();
            searchOutputPanel.repaint();
        }*/
        for(int i = 0; i < results.size(); i++){
         searchOutputPanel.add(new SearchOutputPanel(Parameter, results.get(i).getUsername(), ii, "date"));
         searchOutputPanel.revalidate();
         searchOutputPanel.repaint();
        //add search output
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void SearchMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchMenuButtonActionPerformed
        // TODO add your handling code here:
        searchOutputPanel.removeAll();
        searchOutputPanel.repaint();
    }//GEN-LAST:event_SearchMenuButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GuestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BottomMenu;
    private javax.swing.JLabel EagleGramLabel;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton NewPostButton;
    private javax.swing.JButton NotificationsButton;
    private javax.swing.JButton ProfileButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JButton SearchMenuButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JButton SignInButton;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JPanel TopMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchInputField;
    private javax.swing.JPanel searchOutputPanel;
    private javax.swing.JComboBox searchParameterBox;
    // End of variables declaration//GEN-END:variables
    private String Parameter;
    private String Input;
    private CurrentProfile main = new CurrentProfile();

    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }

    private class SearchOutputPanel extends JPanel {

        public SearchOutputPanel(String method, String username, Icon ii, String date) {
            if (method.equalsIgnoreCase("hash tags")) {
                setLayout(new GridBagLayout());
                Border emptyBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
                Border lineBorder = BorderFactory.createLineBorder(Color.black);
                setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

                JLabel timeLabel = new JLabel();
                timeLabel.setText(date);
                timeLabel.setSize(100, 21);
                add(timeLabel, createGbc(2, 0));

                JLabel usernameLabel = new JLabel();
                usernameLabel.setText(username);
                usernameLabel.setSize(100, 21);
                usernameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                usernameLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        //ProfilePopUp frame= new ProfilePopUp();
                        //frame.setVisible(true); 
                    }
                });
                add(usernameLabel, createGbc(1, 0));

                JLabel pictureLabel = new JLabel();
                pictureLabel.setSize(120, 120);
                try {
                    pictureLabel.setIcon(ii);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                pictureLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                pictureLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        //PostPopUp frame= new PostPopUp(ii, username, likes, liked,
                        //  caption, "comments", "hashtags","people");

                        //frame.setVisible(true);
                    }
                });
                add(pictureLabel, createGbc(0, 0));
            } else if (method.equalsIgnoreCase("people")) {
                setLayout(new GridBagLayout());
                Border emptyBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);
                Border lineBorder = BorderFactory.createLineBorder(Color.black);
                setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

                JLabel usernameLabel = new JLabel();
                usernameLabel.setText(username);
                usernameLabel.setSize(100, 21);
                usernameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                usernameLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        //ProfilePopUp frame= new ProfilePopUp();
                        //frame.setVisible(true); 
                    }
                });
                add(usernameLabel, createGbc(1, 0));

                JLabel pictureLabel = new JLabel();
                pictureLabel.setSize(77, 77);
                try {
                    pictureLabel.setIcon(ii);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                pictureLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                pictureLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        //ProfilePopUp frame= new ProfilePopUp();
                        //frame.setVisible(true);     
                    }
                });
                add(pictureLabel, createGbc(0, 0));
            }
        }

        private GridBagConstraints createGbc(int x, int y) {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = x;
            gbc.gridy = y;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;

            return gbc;
        }
    }
}
