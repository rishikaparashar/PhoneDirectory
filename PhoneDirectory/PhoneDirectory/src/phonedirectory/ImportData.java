/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonedirectory;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rishika
 */
public class ImportData {

    public static void main(String[] args) {
        /*Connection conn = null;
        try {
            String USERNAME = "root";
            String PASSWORD = "Welcome@123";
            String CONN_STRING = "jdbc:mysql://localhost:3306/PhoneDirectory?autoReconnect=true&useSSL=false";
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected!!");
            ImportAndInsert obj = new ImportAndInsert();
            obj.FetchDataAndInsert(conn);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}

class ImportAndInsert {

    public void FetchDataAndInsert(Connection conn) {
        try {
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Rishika\\Desktop\\PhoneNumbers.csv"));
            List content = reader.readAll();
            String[] row = null;
            for (int i = 1; i < content.size(); i++) {
                Object obj = content.get(i);
                System.out.println(obj);
                row = (String[]) obj;
                int contactId = Integer.parseInt(row[0]) ;
                String areaCode = null;
                String number = null;
                if(!row[1].equals("")){
                    areaCode = row[1].substring(0, 3);
                    number = row[1].substring(4, row[1].length());
                }
                String phoneType = !(row[1].equals(""))?row[2]:null;
                System.out.println("contactId " + contactId + " areaCode " + areaCode + " number " + number + " phoneType " + phoneType);
                String query = "insert into phone (contact_id,phone_type,area_code,number) values (?,?,?,?)";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, contactId);
                st.setString(2, phoneType);
                st.setString(3, areaCode);
                st.setString(4, number);
                int count = st.executeUpdate();
                if(count > 0){
                    System.out.println("Data Inserted");
                }
                else{
                    System.out.println("No Data Inserted");
                }
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }*/
    }
}
