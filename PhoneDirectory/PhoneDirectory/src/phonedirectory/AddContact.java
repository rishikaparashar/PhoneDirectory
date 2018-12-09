/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;

import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rishika
 */
public class AddContact extends javax.swing.JFrame {

    ContactFrame conFrame = new ContactFrame();

    public AddContact() {
        initComponents();
        try {
            Connection conn = conFrame.connect();
            GetAddressType(conn);
            GetPhoneType(conn);
            GetDateType(conn);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public void GetAddressType(Connection conn) {
        try {
            Statement st = conn.createStatement();
            String query = "select address_type from addresstype";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                addType.addItem(rs.getString(1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void GetPhoneType(Connection conn) {
        try {
            Statement st = conn.createStatement();
            String query = "select phone_type from phonetype";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                phoneType.addItem(rs.getString(1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void GetDateType(Connection conn) {
        try {
            Statement st = conn.createStatement();
            String query = "select date_type from datetype";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dateType.addItem(rs.getString(1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public boolean IsValidString(String str, String fieldName) {
        boolean isValid = false;
        if (str == null || str.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter " + fieldName);
            isValid = false;
        } else {
            isValid = true;
        }
        return isValid;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cityName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        stateName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        zipCode = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        phoneType = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        areaCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dateType = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("First Name");

        fName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Middle Name");

        mName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Last Name");

        lName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Address Type");

        addType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select address type" }));
        addType.setToolTipText("Select address type");
        addType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTypeActionPerformed(evt);
            }
        });

        jLabel5.setText("Address");

        jLabel6.setText("City");

        jLabel7.setText("State");

        jLabel8.setText("Zip");

        jLabel9.setText("Phone Type");

        phoneType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select phone type" }));
        phoneType.setToolTipText("Select phone type");

        jLabel10.setText("Area Code");

        jLabel11.setText("Number");

        jLabel12.setText("Date Type");

        dateType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select date type" }));
        dateType.setToolTipText("Select date type");

        jLabel13.setText("Date");

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fName)
                            .addComponent(addType, 0, 141, Short.MAX_VALUE)
                            .addComponent(phoneType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                            .addComponent(stateName)
                                            .addComponent(areaCode))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8))))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lName, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(cityName)
                                    .addComponent(zipCode)
                                    .addComponent(number)))
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(mName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(zipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(phoneType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(areaCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(dateType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(jButton1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            boolean isValid = false;
            int newDataContactID = 0;
            String firstName = fName.getText();
            isValid = IsValidString(firstName, "First Name");
            String middleName = mName.getText();
            isValid = IsValidString(middleName, "Middle Name");
            String lastName = lName.getText();
            isValid = IsValidString(lastName, "Last Name");
            Object selectedAddressType = addType.getSelectedItem();
            String addressType = (selectedAddressType == null || selectedAddressType.toString().equals("Select address type")) ? null: selectedAddressType.toString();
            isValid = IsValidString(addressType, "Address type");
            String addressText = address.getText();
            isValid = IsValidString(addressText, "Address");
            String city = cityName.getText();
            isValid = IsValidString(city, "City");
            String state = stateName.getText();
            isValid = IsValidString(state, "State");
            String zip = zipCode.getText();
            isValid = IsValidString(zip, "Zip");
            Object selectedPhoneType = phoneType.getSelectedItem();
            String phoneTypeText = (selectedPhoneType == null || selectedPhoneType.toString().equals("Select phone type")) ? null: selectedPhoneType.toString();
            isValid = IsValidString(phoneTypeText, "Phone type");
            String areaCodeText = areaCode.getText();
            isValid = IsValidString(areaCodeText, "Area Code");
            String numberText = number.getText();
            isValid = IsValidString(numberText, "Number");
            Object selectedDateType = dateType.getSelectedItem();
            String dateTypeText = (selectedDateType == null || selectedDateType.toString().equals("Select date type")) ? null : selectedDateType.toString();
            isValid = IsValidString(dateTypeText, "Date type");
            String dateText = date.getText();
            isValid = IsValidString(dateText, "Date");
            if (isValid) {
                Connection conn = conFrame.connect();
                PreparedStatement stContact = conn.prepareStatement("insert into contact(Fname,Mname,Lname) values(?,?,?)");
                stContact.setString(1, firstName);
                stContact.setString(2, middleName);
                stContact.setString(3, lastName);
                int i = stContact.executeUpdate();
                if (i > 0) {
                    Statement st = conn.createStatement();
                    String query = "select contact_id from contact where Fname=" + "'" + firstName + "'" + " and Mname=" + "'" + middleName + "'" + " and Lname=" + "'" + lastName + "'";
                    ResultSet rs = st.executeQuery(query);
                    if (rs != null) {
                        int lastValue = 0;
                        while (rs.next()) {
                            lastValue = rs.getInt(1);
                        }
                        newDataContactID = lastValue;
                    }
                    JOptionPane.showMessageDialog(null, "Data is saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Data is not saved");
                }

                PreparedStatement stAddress = conn.prepareStatement("insert into address(contact_id,address_type,address,city,state,zip) values(?,?,?,?,?,?)");
                if (newDataContactID != 0) {
                    stAddress.setInt(1, newDataContactID);
                }
                stAddress.setString(2, addressType);
                stAddress.setString(3, addressText);
                stAddress.setString(4, city);
                stAddress.setString(5, state);
                stAddress.setString(6, zip);
                int j = stAddress.executeUpdate();
                if (j > 0) {
                    JOptionPane.showMessageDialog(null, "Data is saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Data is not saved");
                }

                PreparedStatement stPhone = conn.prepareStatement("insert into phone(contact_id,phone_type,area_code,number) values(?,?,?,?)");
                if (newDataContactID != 0) {
                    stPhone.setInt(1, newDataContactID);
                }
                stPhone.setString(2, phoneTypeText);
                stPhone.setString(3, areaCodeText);
                stPhone.setString(4, numberText);
                int k = stPhone.executeUpdate();
                if (k > 0) {
                    JOptionPane.showMessageDialog(null, "Data is saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Data is not saved");
                }

                PreparedStatement stDate = conn.prepareStatement("insert into date(contact_id,date_type,date) values(?,?,?)");
                if (newDataContactID != 0) {
                    stDate.setInt(1, newDataContactID);
                }
                stDate.setString(2, dateTypeText);
                stDate.setString(3, dateText);
                int l = stDate.executeUpdate();
                if (l > 0) {
                    JOptionPane.showMessageDialog(null, "Data is saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Data is not saved");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void addTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTypeActionPerformed

    }//GEN-LAST:event_addTypeActionPerformed

    private void fNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNameActionPerformed

    private void lNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lNameActionPerformed

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
            java.util.logging.Logger.getLogger(AddContact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddContact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddContact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddContact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddContact().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> addType;
    private javax.swing.JTextField address;
    private javax.swing.JTextField areaCode;
    private javax.swing.JTextField cityName;
    private javax.swing.JTextField date;
    private javax.swing.JComboBox<String> dateType;
    private javax.swing.JTextField fName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lName;
    private javax.swing.JTextField mName;
    private javax.swing.JTextField number;
    private javax.swing.JComboBox<String> phoneType;
    private javax.swing.JTextField stateName;
    private javax.swing.JTextField zipCode;
    // End of variables declaration//GEN-END:variables
}
