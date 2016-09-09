package com.guest.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	private static Connection conn;
	private final static String driver = "oracle.jdbc.driver.OracleDriver";
	private final static String url = "jdbc:oracle:thin:@203.236.209.201:1521/xe";
	private final static String user = "scott";
	private final static String password = "tiger";
	
	public static Connection getConn() {
		
		if(conn==null){
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("err:Conn1");
			}
			
		}else{
			try{
				if(conn.isClosed()){
					try {
						Class.forName(driver);
						conn = DriverManager.getConnection(url, user, password);
					} catch (Exception e) {
						//e.printStackTrace();
						System.out.println("err:Conn1");
					}
				}
			}catch(Exception ex){
				System.out.println("err:Conn2");
			}
		}
			
		return conn;
	}
}
