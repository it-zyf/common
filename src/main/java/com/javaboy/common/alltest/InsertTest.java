package com.javaboy.common.alltest;

import cn.hutool.core.util.IdUtil;
import com.javaboy.common.util.ReadUtil;

import java.sql.*;
import java.util.Collections;
import java.util.List;

/**
 * @author: zyf
 * @create: 2021-10-20 16:00
 **/
public class InsertTest {

        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://10.203.173.232:2390/vul_mob_zc";


        static final String USER = "vul_mob_zc";
        static final String PASS = "633335761d4b3efd";

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
                final List<String> date = ReadUtil.getFileContext("D:\\123.txt");
                for (int i = 0; i < 50; i++) {
                    String id = IdUtil.simpleUUID();
                    String roleId="4f1b1f81512e466e8a2220f30595d1b0";
                    String sql = "insert into `work_order` (id, " +
                            "work_number, " +
                            "work_name, " +
                            "work_referer, " +
                            "submit_time, " +
                            "work_acceptor, " +
                            "disposal_time, " +
                            "disposal_efficiency, " +
                            "work_status, " +
                            "work_circulation, " +
                            "create_time, " +
                            "update_time, " +
                            "conductor ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1,IdUtil.simpleUUID());
                    stmt.setString(2,"ZCGD-2022-0000000"+i);
                    stmt.setString(3,"SQL注入"+"审核");
                    stmt.setString(4,"白帽子");
                    stmt.setDate(5, new Date(System.currentTimeMillis()));
                    stmt.setString(6,"系统管理员");
                    stmt.setDate(7, new Date(System.currentTimeMillis()));
                    stmt.setString(8,"处置时效48h");
                    stmt.setString(9,"处理中");
                    stmt.setString(10,"待修复");
                    stmt.setDate(11, new Date(System.currentTimeMillis()));
                    stmt.setDate(12, new Date(System.currentTimeMillis()));
                    stmt.setString(13,"系统管理员");

                    System.out.println(sql);
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



