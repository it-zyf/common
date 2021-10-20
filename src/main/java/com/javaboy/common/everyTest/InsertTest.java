package com.javaboy.common.everyTest;

import com.javaboy.common.util.ReadUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author: zyf
 * @create: 2021-10-20 16:00
 **/
public class InsertTest {

        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://10.203.173.232:2390/alltesting";


        static final String USER = "alltesting";
        static final String PASS = "05f7e7cd1b292f9a";

        public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            try{
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 3: Open a connection
                System.out.println("Connecting to a selected database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected database successfully...");

                //STEP 4: Execute a query
                System.out.println("Inserting records into the table...");
                stmt = conn.createStatement();
                final List<String> date = ReadUtil.getFileContext("D:\\123.txt");
                for (String s : date) {
                    String sql = "INSERT INTO role_function " +
                            "VALUES (null, 1, "+s+")";
                    stmt.executeUpdate(sql);
                }
                System.out.println("Inserted records into the table...");

            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null) {
                        conn.close();
                    }
                }catch(SQLException se){
                }// do nothing
                try{
                    if(conn!=null) {
                        conn.close();
                    }
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");
        }


        public List<String> getDate(){
            try {
                return ReadUtil.getFileContext("D:\\123.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }



