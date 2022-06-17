package com.javaboy.common.alltest;

import com.javaboy.common.util.ReadUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * @author: zyf
 * @create: 2021-10-20 16:00
 **/
public class OrderSort {

        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/order";


        static final String USER = "root";
        static final String PASS = "root";

        public static void main(String[] args) {
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
                final List<String> date = ReadUtil.getFileContext("D:\\zcPermissionOrder.txt");
                for (int i = 0; i < date.size(); i++) {
                    String sql = "update module_function_menu set sort=? where remark= ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1,String.valueOf(i));
                    stmt.setString(2,date.get(i));
                    System.out.println(date.get(i));
                    stmt.executeUpdate();

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
            return Collections.emptyList();
        }
    }



