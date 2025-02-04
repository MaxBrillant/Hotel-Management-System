/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ClientDao;
import dao.RoomDao;
import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Client;
import model.Room;

/**
 *
 * @author hg_ofthecity
 */
public class RegisterClient extends javax.swing.JFrame {
    SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");
    Date today = new Date();

    /**
     * Creates new form RegisterClient
     */
    public RegisterClient() {
        initComponents();
        RoomDao roomDao = new RoomDao();
        Room theRoom = new Room();
        ResultSet result = roomDao.getAllRooms(theRoom);
        
        // populate rooms in room number combo box by showing available and unavailable rooms
        try {
            javax.swing.DefaultComboBoxModel roomTypeElement = new javax.swing.DefaultComboBoxModel<>(new String[] {});
            
            while(result.next()) {
                roomTypeElement.addElement(result.getString("room_no") +"-"+result.getString("status"));
            }
            roomTypeSelector.setModel(roomTypeElement);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        entranceDateBox.setDate(today);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        registerClientBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        clientIdBox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        fnameBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lnameBox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        roomTypeSelector = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        entranceDateBox = new com.toedter.calendar.JDateChooser();
        exitDateBox = new com.toedter.calendar.JDateChooser();
        gotoMenuLink = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        openClientMgtWindowLink = new javax.swing.JMenu();
        openRoomMgtWindowLink = new javax.swing.JMenu();
        openAddRoomWindowLink = new javax.swing.JMenu();
        adminWindowLink = new javax.swing.JMenu();
        openLogoutWindowLink = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registerClientBtn.setBackground(new java.awt.Color(255, 255, 255));
        registerClientBtn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        registerClientBtn.setForeground(new java.awt.Color(0, 102, 102));
        registerClientBtn.setText("Save");
        registerClientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerClientBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("National/Passport Id");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Entrance date");

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Record Client");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("First name");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Last name");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Room number");

        roomTypeSelector.setForeground(new java.awt.Color(0, 102, 102));
        roomTypeSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select room no", "r0001", "r0002", "r0003", "r0004", "r0005" }));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Exit date");

        entranceDateBox.setDateFormatString("dd MM yyyy");

        exitDateBox.setDateFormatString("dd MM yyyy");

        gotoMenuLink.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        gotoMenuLink.setForeground(new java.awt.Color(0, 153, 255));
        gotoMenuLink.setText("Cancel");
        gotoMenuLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoMenuLinkMouseClicked(evt);
            }
        });

        openClientMgtWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        openClientMgtWindowLink.setText("Client management");
        openClientMgtWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openClientMgtWindowLinkMouseClicked(evt);
            }
        });
        jMenuBar1.add(openClientMgtWindowLink);

        openRoomMgtWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        openRoomMgtWindowLink.setText("Room management");
        openRoomMgtWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openRoomMgtWindowLinkMouseClicked(evt);
            }
        });
        jMenuBar1.add(openRoomMgtWindowLink);

        openAddRoomWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        openAddRoomWindowLink.setText("Add room");
        openAddRoomWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openAddRoomWindowLinkMouseClicked(evt);
            }
        });
        jMenuBar1.add(openAddRoomWindowLink);

        adminWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        adminWindowLink.setText("Admin");
        adminWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminWindowLinkMouseClicked(evt);
            }
        });
        jMenuBar1.add(adminWindowLink);

        openLogoutWindowLink.setForeground(new java.awt.Color(0, 153, 255));
        openLogoutWindowLink.setText("Logout");
        openLogoutWindowLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openLogoutWindowLinkMouseClicked(evt);
            }
        });
        jMenuBar1.add(openLogoutWindowLink);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel1)
                .addContainerGap(294, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(clientIdBox, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(fnameBox)
                    .addComponent(registerClientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entranceDateBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9)
                        .addComponent(jLabel7)
                        .addComponent(lnameBox)
                        .addComponent(roomTypeSelector, 0, 311, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addComponent(exitDateBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(gotoMenuLink, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lnameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roomTypeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitDateBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fnameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clientIdBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entranceDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerClientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gotoMenuLink))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public int updateRoom(String no, String status) {
        Room theRoom = new Room();
        RoomDao roomDao = new RoomDao();
        
        theRoom.setRoomNo(no);
        theRoom.setRoomStatus(status);
        
        int rowsAffected = roomDao.updateRoomStatus(theRoom);
        
        return rowsAffected;
    }
    
    private void registerClientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerClientBtnActionPerformed
        // TODO add your handling code here:
        if (fnameBox.getText().isEmpty() || lnameBox.getText().isEmpty()
                || clientIdBox.getText().isEmpty() || entranceDateBox.getDate() == null
                || exitDateBox.getDate() == null ) {
            JOptionPane.showMessageDialog(this, "Can't register fill all the fields");
        } else {
            if (entranceDateBox.getDate().compareTo(today) < 0) {
                JOptionPane.showMessageDialog(this, "Sorry, can not select passed date");
            } else {
                Client theClient = new Client();
                // set the rooms in model
                theClient.setClientId(clientIdBox.getText());
                theClient.setFirstName(fnameBox.getText());
                theClient.setLastName(lnameBox.getText());

                // get room number of selected room type
                String SelectedRoom = roomTypeSelector.getSelectedItem().toString();
                String selected = SelectedRoom.substring(0, SelectedRoom.indexOf("-"));
                
                theClient.setRoomNo(selected);

                // --------------

                String entranceDate = df.format(entranceDateBox.getDate());
                theClient.setEntranceDate(entranceDate);

                String exitDate = df.format(exitDateBox.getDate());
                theClient.setExitDate(exitDate);

                // Instantiate the User DAO object
                ClientDao clientDao = new ClientDao();
                int rows = clientDao.registerClient(theClient);
                
                // update room from available to taken
                int updatedRooms = updateRoom(selected, "taken");

                if (rows >= 1 && updatedRooms >= 1) {
                    // Update the room table to mark a room as unavailable
                    JOptionPane.showMessageDialog(this, "Client registered");
                    Home homeForm = new Home();
                    homeForm.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Client not registered");
                }
            }
        }
    }//GEN-LAST:event_registerClientBtnActionPerformed

    private void openClientMgtWindowLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openClientMgtWindowLinkMouseClicked
        // TODO add your handling code here:
        Home homeForm = new Home();
        homeForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_openClientMgtWindowLinkMouseClicked

    private void openRoomMgtWindowLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openRoomMgtWindowLinkMouseClicked
        // TODO add your handling code here:
        RoomMgt roomMgtForm = new RoomMgt();
        roomMgtForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_openRoomMgtWindowLinkMouseClicked

    private void openAddRoomWindowLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openAddRoomWindowLinkMouseClicked
        // TODO add your handling code here:
        RegisterRoom registerRoomForm = new RegisterRoom();
        registerRoomForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_openAddRoomWindowLinkMouseClicked

    private void openLogoutWindowLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openLogoutWindowLinkMouseClicked
        // TODO add your handling code here:
        Login loginForm = new Login();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_openLogoutWindowLinkMouseClicked

    // this function is for getting the user level
    // as admin or regular user don't perform same functions
    private String getUserLevel() {
        File file = new File("usrlvl.txt");
        
        Path sourceFile = Paths.get(file.toURI());
        
        try (BufferedReader reader = Files.newBufferedReader(sourceFile)){
            String line = reader.readLine();
            return line;
        } catch (Exception e) {
            System.out.println("Something went wrong! " + e);
            return null;
        }
    }
    
    private void adminWindowLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminWindowLinkMouseClicked
        // TODO add your handling code here:
        if ((getUserLevel()).equals("1")) {
            Admin adminForm = new Admin();
            adminForm.setVisible(true);
            this.dispose();
        } else {
            Login loginForm = new Login();
            loginForm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_adminWindowLinkMouseClicked

    private void gotoMenuLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gotoMenuLinkMouseClicked
        // TODO add your handling code here:
        if ((getUserLevel()).equals("1")) {
            Admin adminForm = new Admin();
            adminForm.setVisible(true);
            this.dispose();
        } else {
            Receptionist recepForm = new Receptionist();
            recepForm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_gotoMenuLinkMouseClicked

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
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu adminWindowLink;
    private javax.swing.JTextField clientIdBox;
    private com.toedter.calendar.JDateChooser entranceDateBox;
    private com.toedter.calendar.JDateChooser exitDateBox;
    private javax.swing.JTextField fnameBox;
    private javax.swing.JLabel gotoMenuLink;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField lnameBox;
    private javax.swing.JMenu openAddRoomWindowLink;
    private javax.swing.JMenu openClientMgtWindowLink;
    private javax.swing.JMenu openLogoutWindowLink;
    private javax.swing.JMenu openRoomMgtWindowLink;
    private javax.swing.JButton registerClientBtn;
    private javax.swing.JComboBox<String> roomTypeSelector;
    // End of variables declaration//GEN-END:variables
}
