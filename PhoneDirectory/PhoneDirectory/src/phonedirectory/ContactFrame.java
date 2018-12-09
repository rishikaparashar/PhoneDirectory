/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;

import java.sql.*;
import java.util.ArrayList;
import javax.accessibility.AccessibleContext;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Rishika
 */
public class ContactFrame extends javax.swing.JFrame {

    private UpdateAddress updateAddressFrame;
    private UpdatePhoneInfo updatePhoneFrame;
    private UpdateDateInfo updateDateFrame;
    private UpdateNameInfo updateNameFrame;
    private static int addressID;
    private static int phoneID;
    private static int dateID;

    public static Connection connect() throws SQLException {
        Connection conn = null;
        try {
            String USERNAME = "root";
            String PASSWORD = "Welcome@123";
            String CONN_STRING = "jdbc:mysql://localhost:3306/PhoneDirectory?autoReconnect=true&useSSL=false";
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected!!");
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return conn;
    }

    public ContactFrame() {
        initComponents();
        jPanel1.setVisible(true);
        try {
            Connection conn = connect();
            GetContacts(conn);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public void close() {
        WindowEvent closeEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeEvent);
    }

    public void GetContacts(Connection conn) {
        try {
            ResultSet rs = null;
            PreparedStatement pat = null;
            String query = "select * from contact";
            pat = conn.prepareStatement(query);
            rs = pat.executeQuery();
            if (rs != null) {
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void ModifyContact(Connection conn, int id, String modifyType) {
        try {
            if (!modifyType.equals("")) {
                ArrayList<String[]> result = new ArrayList<>();
                String modtype = null;
                String query = null;
                switch (modifyType) {
                    case "Home address":
                        modtype = "home";
                        query = "select address_id,address_type,address,city,state,zip from address where contact_id =" + id + " and address_type=" + "'" + modtype + "'";
                        result = GetContactInfo(conn, query);
                        if (result != null && result.size() > 0) {
                            updateAddressFrame = new UpdateAddress();
                            String[] contactInfo = result.get(0);
                            addressID = Integer.parseInt(contactInfo[0]);
                            if (contactInfo[1] != null || !contactInfo[1].equals("")) {
                                updateAddressFrame.addressType.setSelectedItem(contactInfo[1]);
                            }
                            if (contactInfo[2] != null || !contactInfo[2].equals("")) {
                                updateAddressFrame.address.setText(contactInfo[2]);
                            }
                            if (contactInfo[3] != null || !contactInfo[3].equals("")) {
                                updateAddressFrame.cityName.setText(contactInfo[3]);
                            }
                            if (contactInfo[4] != null || !contactInfo[4].equals("")) {
                                updateAddressFrame.stateName.setText(contactInfo[4]);
                            }
                            if (contactInfo[5] != null || !contactInfo[5].equals("")) {
                                updateAddressFrame.zipCode.setText(contactInfo[5]);
                            }
                            updateAddressFrame.SetIDs(id, addressID);
                            updateAddressFrame.setVisible(true);
                            close();
                        } else {
                            JOptionPane.showMessageDialog(null, "No data to update/modify");
                        }
                        break;
                    case "Work address":
                        modtype = "work";
                        query = "select address_id,address_type,address,city,state,zip from address where contact_id =" + id + " and address_type=" + "'" + modtype + "'";
                        result = GetContactInfo(conn, query);
                        if (result != null && result.size() > 0) {
                            updateAddressFrame = new UpdateAddress();
                            String[] contactInfo = result.get(0);
                            addressID = Integer.parseInt(contactInfo[0]);
                            if (contactInfo[1] != null || !contactInfo[1].equals("")) {
                                updateAddressFrame.addressType.setSelectedItem(contactInfo[1]);
                            }
                            if (contactInfo[2] != null || !contactInfo[2].equals("")) {
                                updateAddressFrame.address.setText(contactInfo[2]);
                            }
                            if (contactInfo[3] != null || !contactInfo[3].equals("")) {
                                updateAddressFrame.cityName.setText(contactInfo[3]);
                            }
                            if (contactInfo[4] != null || !contactInfo[4].equals("")) {
                                updateAddressFrame.stateName.setText(contactInfo[4]);
                            }
                            if (contactInfo[5] != null || !contactInfo[5].equals("")) {
                                updateAddressFrame.zipCode.setText(contactInfo[5]);
                            }
                            updateAddressFrame.SetIDs(id, addressID);
                            updateAddressFrame.setVisible(true);
                            close();
                        } else {
                            JOptionPane.showMessageDialog(null, "No data to update/modify");
                        }
                        break;
                    case "Home phone":
                        modtype = "home";
                        query = "select phone_id,phone_type,area_code,number from phone where contact_id =" + id + " and phone_type=" + "'" + modtype + "'";
                        result = GetContactInfo(conn, query);
                        if (result != null && result.size() > 0) {
                            updatePhoneFrame = new UpdatePhoneInfo();
                            String[] phoneInfo = result.get(0);
                            phoneID = Integer.parseInt(phoneInfo[0]);
                            if (phoneInfo[1] != null || !phoneInfo[1].equals("")) {
                                updatePhoneFrame.phoneType.setSelectedItem(phoneInfo[1]);
                            }
                            if (phoneInfo[2] != null || !phoneInfo[2].equals("")) {
                                updatePhoneFrame.AreaCode.setText(phoneInfo[2]);
                            }
                            if (phoneInfo[3] != null || !phoneInfo[3].equals("")) {
                                updatePhoneFrame.Number.setText(phoneInfo[3]);
                            }
                            updatePhoneFrame.SetIDs(id, phoneID);
                            updatePhoneFrame.setVisible(true);
                            close();
                        } else {
                            JOptionPane.showMessageDialog(null, "No data to update/modify");
                        }
                        break;
                    case "Work phone":
                        modtype = "work";
                        query = "select phone_id,phone_type,area_code,number from phone where contact_id =" + id + " and phone_type=" + "'" + modtype + "'";
                        result = GetContactInfo(conn, query);
                        if (result != null && result.size() > 0) {
                            updatePhoneFrame = new UpdatePhoneInfo();
                            String[] phoneInfo = result.get(0);
                            phoneID = Integer.parseInt(phoneInfo[0]);
                            if (phoneInfo[1] != null || !phoneInfo[1].equals("")) {
                                updatePhoneFrame.phoneType.setSelectedItem(phoneInfo[1]);
                            }
                            if (phoneInfo[2] != null || !phoneInfo[2].equals("")) {
                                updatePhoneFrame.AreaCode.setText(phoneInfo[2]);
                            }
                            if (phoneInfo[3] != null || !phoneInfo[3].equals("")) {
                                updatePhoneFrame.Number.setText(phoneInfo[3]);
                            }
                            updatePhoneFrame.SetIDs(id, phoneID);
                            updatePhoneFrame.setVisible(true);
                            close();
                        } else {
                            JOptionPane.showMessageDialog(null, "No data to update/modify");
                        }
                        break;
                    case "Cell phone":
                        modtype = "cell";
                        query = "select phone_id,phone_type,area_code,number from phone where contact_id =" + id + " and phone_type=" + "'" + modtype + "'";
                        result = GetContactInfo(conn, query);
                        if (result != null && result.size() > 0) {
                            updatePhoneFrame = new UpdatePhoneInfo();
                            String[] phoneInfo = result.get(0);
                            phoneID = Integer.parseInt(phoneInfo[0]);
                            if (phoneInfo[1] != null || !phoneInfo[1].equals("")) {
                                updatePhoneFrame.phoneType.setSelectedItem(phoneInfo[1]);
                            }
                            if (phoneInfo[2] != null || !phoneInfo[2].equals("")) {
                                updatePhoneFrame.AreaCode.setText(phoneInfo[2]);
                            }
                            if (phoneInfo[3] != null || !phoneInfo[3].equals("")) {
                                updatePhoneFrame.Number.setText(phoneInfo[3]);
                            }
                            updatePhoneFrame.SetIDs(id, phoneID);
                            updatePhoneFrame.setVisible(true);
                            close();
                        } else {
                            JOptionPane.showMessageDialog(null, "No data to update/modify");
                        }
                        break;
                    case "birth date":
                        modtype = "birth date";
                        query = "select date_id,date_type,date from date where contact_id =" + id + " and date_type=" + "'" + modtype + "'";
                        result = GetContactInfo(conn, query);
                        if (result != null && result.size() > 0) {
                            String[] dateInfo = result.get(0);
                            updateDateFrame = new UpdateDateInfo();
                            dateID = Integer.parseInt(dateInfo[0]);
                            if (dateInfo[1] != null || !dateInfo[1].equals("")) {
                                updateDateFrame.dateType.setSelectedItem(dateInfo[1]);
                            }
                            if (dateInfo[2] != null || !dateInfo[2].equals("")) {
                                updatePhoneFrame.Number.setText(dateInfo[2]);
                            }
                            updateDateFrame.SetIDs(id, dateID);
                            updateDateFrame.setVisible(true);
                            close();
                        } else {
                            JOptionPane.showMessageDialog(null, "No data to update/modify");
                        }
                        break;
                    case "anniversary date":
                        modtype = "anniversary";
                        query = "select date_id,date_type,date from date where contact_id =" + id + " and date_type=" + "'" + modtype + "'";
                        result = GetContactInfo(conn, query);
                        if (result != null && result.size() > 0) {
                            String[] dateInfo = result.get(0);
                            updateDateFrame = new UpdateDateInfo();
                            dateID = Integer.parseInt(dateInfo[0]);
                            if (dateInfo[1] != null || !dateInfo[1].equals("")) {
                                updateDateFrame.dateType.setSelectedItem(dateInfo[1]);
                            }
                            if (dateInfo[2] != null || !dateInfo[2].equals("")) {
                                updatePhoneFrame.Number.setText(dateInfo[2]);
                            }
                            updateDateFrame.SetIDs(id, dateID);
                            updateDateFrame.setVisible(true);
                            close();
                        } else {
                            JOptionPane.showMessageDialog(null, "No data to update/modify");
                        }
                        break;
                    case "name":
                        query = "select Fname,Mname.Lname from contact where contact_id =" + id;
                        result = GetContactInfo(conn, query);
                        if (result != null && result.size() > 0) {
                            updateNameFrame = new UpdateNameInfo();
                            String[] nameInfo = result.get(0);
                            if (nameInfo[0] != null || !nameInfo[0].equals("")) {
                                updateNameFrame.Fname.setText(nameInfo[0]);
                            }
                            if (nameInfo[1] != null || !nameInfo[1].equals("")) {
                                updateNameFrame.Mname.setText(nameInfo[1]);
                            }
                            if (nameInfo[2] != null || !nameInfo[2].equals("")) {
                                updateNameFrame.Lname.setText(nameInfo[2]);
                            }
                            updateNameFrame.SetIDs(id);
                            updateNameFrame.setVisible(true);
                            close();
                        } else {
                            JOptionPane.showMessageDialog(null, "No data to update/modify");
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public ArrayList<String[]> GetContactInfo(Connection conn, String query) {
        ArrayList<String[]> info = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                String[] row = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getString(i + 1);
                }
                info.add(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return info;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deleteContact = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        modifyContact = new javax.swing.JButton();
        searchContact = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Main");
        setAlwaysOnTop(true);

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jButton2.setText("Add Contact");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        deleteContact.setText("Delete");
        deleteContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteContactMouseClicked(evt);
            }
        });
        deleteContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteContactActionPerformed(evt);
            }
        });

        jLabel2.setText("Select the row from table and category below to modify and click modify");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Home address", "Work address", "Home phone", "Work phone", "Cell phone", "birth date", "anniversary date" }));

        modifyContact.setText("Modify");
        modifyContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyContactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modifyContact, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(modifyContact, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        searchContact.setToolTipText("Search a contact");
        searchContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchContactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchContact, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(deleteContact, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(searchContact))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteContact, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            String search = searchContact.getText();
            if (search != null || !search.equals("")) {
                Connection conn = connect();
                String query = "select con.* from PhoneDirectory.contact con inner join PhoneDirectory.address ad on con.contact_id = ad.contact_id inner join phonedirectory.phone ph on con.contact_id = ph.contact_id inner join phonedirectory.date d on con.contact_id=d.contact_id where Concat(con.contact_id,Fname,Mname,Lname,address_type,address,city,state,zip,phone_type,area_code,number,date_type,date) like " + "'%" + search + "%'" + "group by con.contact_id";
                PreparedStatement st = conn.prepareStatement(query);
                //st.setString(1, search);
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    JOptionPane.showMessageDialog(null, "No data found");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AddContact addContact = new AddContact();
        addContact.setVisible(true);
        close();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleteContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteContactActionPerformed
        try {
            int row = jTable1.getSelectedRow();
            if (row > 0) {
                Connection conn = connect();
                String id = jTable1.getModel().getValueAt(row, 0).toString();
                //String mname = jTable1.getModel().getValueAt(row, 1).toString();
                //String lname = jTable1.getModel().getValueAt(row, 2).toString();
                PreparedStatement st = conn.prepareStatement("delete from contact where contact_id=" + id);
                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Not Deleted Successfully");
                }
                GetContacts(conn);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_deleteContactActionPerformed

    private void deleteContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteContactMouseClicked

    }//GEN-LAST:event_deleteContactMouseClicked

    private void modifyContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyContactActionPerformed
        try {
            jPanel1.setVisible(true);
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow > 0) {
                String id = jTable1.getModel().getValueAt(selectedRow, 0).toString();
                String modify_type = null;
                Object selectedType = jComboBox1.getSelectedItem();
                modify_type = (selectedType != null || !selectedType.toString().equals("Select to modify")) ? selectedType.toString() : null;
                ModifyContact(connect(), Integer.parseInt(id), modify_type);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_modifyContactActionPerformed

    private void searchContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchContactActionPerformed

    }//GEN-LAST:event_searchContactActionPerformed

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
            java.util.logging.Logger.getLogger(ContactFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteContact;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifyContact;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchContact;
    // End of variables declaration//GEN-END:variables
}
