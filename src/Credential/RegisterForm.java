package Credential;


import java.awt.Color;
import DatabaseConnection.DatabaseConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DatabaseConnection.registerUserCon;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bisma
 */
public class RegisterForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    
    // create a variable to set the image path in it
    String imagePath = null;
    
    public RegisterForm() {
        initComponents();
        setTitle("Register Account");
        this.setLocationRelativeTo(null);
      
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fullNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        register_btn = new javax.swing.JPanel();
        register_btn_text = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        maleRb = new javax.swing.JRadioButton();
        femaleRb = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        phoneField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Register Page");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Register your new account into our system");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Full Name");

        fullNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Username");

        register_btn.setBackground(new java.awt.Color(0, 104, 183));
        register_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        register_btn_text.setBackground(new java.awt.Color(255, 255, 255));
        register_btn_text.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        register_btn_text.setForeground(new java.awt.Color(255, 255, 255));
        register_btn_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register_btn_text.setText("Register");
        register_btn_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_btn_textMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                register_btn_textMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                register_btn_textMouseExited(evt);
            }
        });

        javax.swing.GroupLayout register_btnLayout = new javax.swing.GroupLayout(register_btn);
        register_btn.setLayout(register_btnLayout);
        register_btnLayout.setHorizontalGroup(
            register_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(register_btnLayout.createSequentialGroup()
                .addComponent(register_btn_text, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        register_btnLayout.setVerticalGroup(
            register_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(register_btn_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Email");

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("Already have an account?");

        jLabel9.setForeground(new java.awt.Color(51, 106, 215));
        jLabel9.setText("Sign In");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Password");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Gender");

        maleRb.setBackground(new java.awt.Color(255, 255, 255));
        gender.add(maleRb);
        maleRb.setSelected(true);
        maleRb.setText("Male");
        maleRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRbActionPerformed(evt);
            }
        });

        femaleRb.setBackground(new java.awt.Color(255, 255, 255));
        gender.add(femaleRb);
        femaleRb.setText("Female");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Phone");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setText("Confirm Password");

        phoneField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(register_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(emailField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(54, 54, 54)
                                .addComponent(maleRb)
                                .addGap(37, 37, 37)
                                .addComponent(femaleRb))
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fullNameField)
                                .addComponent(jLabel3)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(maleRb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(femaleRb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(register_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fullNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullNameFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // Display the Login Form
        LoginForm loginPage = new LoginForm(); 
        loginPage.setVisible(true); 
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void register_btn_textMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_btn_textMouseEntered
        // TODO add your handling code here:
        register_btn.setBackground(new Color(51,106,215));
    }//GEN-LAST:event_register_btn_textMouseEntered

    private void register_btn_textMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_btn_textMouseExited
        // TODO add your handling code here:
        register_btn.setBackground(new Color(0,104,183));
    }//GEN-LAST:event_register_btn_textMouseExited

    private void maleRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleRbActionPerformed

    private void phoneFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneFieldKeyTyped
        // allow numbers only
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
        if(phoneField.getText().length() >= 13){
            JOptionPane.showMessageDialog(null, "Maximum Charachter limit is 13");
            evt.consume();
        }
    }//GEN-LAST:event_phoneFieldKeyTyped

    private void register_btn_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_btn_textMouseClicked
        // TODO add your handling code here:
        
        String email = emailField.getText();
        String fname = fullNameField.getText();
        String uname = usernameField.getText();
        String phone = phoneField.getText();
        String pass = String.valueOf(passwordField.getPassword());
        String confpass = String.valueOf(confirmPasswordField.getPassword());
        String gender = "Male";
        
        if (femaleRb.isSelected()){
            gender = "Female";
        }
        
        if (verifyFields()){
            
            if(!checkUsernameAvaibility(uname)){
                PreparedStatement ps;
                ResultSet rs;
                String registerUserQuery = "INSERT INTO `register_user`(`full_name`, `username`, `password`, `email`, `phone`, `gender`) VALUES (?,?,?,?,?,?)";
                
                
                try {
                    ps = registerUserCon.getConnection().prepareStatement(registerUserQuery);
                    ps.setString(1, fname);
                    ps.setString(2, uname);
                    ps.setString(3, pass);
                    ps.setString(4, email);
                    ps.setString(5, phone);
                    ps.setString(6, gender);
                        
                        
                    if (ps.executeUpdate() != 0 ){
                        JOptionPane.showMessageDialog(null, "Your account has been created");
                    } else{
                        JOptionPane.showMessageDialog(null, "Error: Check your information");
                    }   

                    
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }//GEN-LAST:event_register_btn_textMouseClicked

// create a function to verify the empth fields
    public boolean verifyFields(){
    
        String email = emailField.getText();
        String fname = fullNameField.getText();
        String uname = usernameField.getText();
        String phone = phoneField.getText();
        String pass = String.valueOf(passwordField.getPassword());
        String confpass = String.valueOf(confirmPasswordField.getPassword());
        
        if(email.trim().equals("") || fname.trim().equals("") || uname.trim().equals("") ||
            phone.trim().equals("") || pass.trim().equals("") || confpass.trim().equals("")){
        
            JOptionPane.showMessageDialog(null, "One or more Fields are empty");
            return false;
        }
        
        // check if the two password are equals
        else if (!pass.equals(confpass)){
            JOptionPane.showMessageDialog(null, "Password does not match", "Error", 2);
            return false;
        }
        
        //if everything is ok 
        else {return true;}
    }
    
// create a function to check if the entired username already exist in the database
    public boolean checkUsernameAvaibility(String username){
    
        PreparedStatement st; 
        ResultSet rs;
        boolean username_exist = false;
        
        String query = "SELECT * FROM `register_user` WHERE `username` = ?";
        
        try {
            st = registerUserCon.getConnection().prepareStatement(query);
            st.setString(1, username); 
            rs = st.executeQuery();
            
            if(rs.next()){
                username_exist = true;
                JOptionPane.showMessageDialog(null, "This username is already taken, choose another one", "Username Failed", HEIGHT);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return username_exist;
    }
    
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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JTextField emailField;
    private javax.swing.JRadioButton femaleRb;
    private javax.swing.JTextField fullNameField;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton maleRb;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JPanel register_btn;
    private javax.swing.JLabel register_btn_text;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
