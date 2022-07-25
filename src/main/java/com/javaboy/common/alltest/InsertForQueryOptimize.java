package com.javaboy.common.alltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: zyf
 * @create: 2021-10-20 16:00
 **/
public class InsertForQueryOptimize {

        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/sys";


        static final String USER = "root";
        static final String PASS = "root";

        public static void main(String[] args) throws SQLException {
            Connection conn = null;
            PreparedStatement stmt = null;
            try{
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 3: Open a connection
                System.out.println("Connecting to a selected database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected database successfully...");

                //STEP 4: Execute a query
                System.out.println("Inserting records into the table...");

                conn.setAutoCommit(false);
                for (int i = 69998; i < 700000; i++) {
                    String sql = "insert into `student` (id,sc) VALUES (?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1,String.valueOf(i));
                    stmt.setString(2,"张天爱"+i);
                    System.out.println(sql);
                    stmt.executeUpdate();
                }

                conn.commit();

                System.out.println("Inserted records into the table...");

            }catch(Exception e){
                //Handle errors for Class.forName
                conn.rollback();
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



    }



