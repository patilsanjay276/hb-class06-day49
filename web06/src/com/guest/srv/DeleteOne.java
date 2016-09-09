package com.guest.srv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.guest.model.Conn;

public class DeleteOne extends HttpServlet{

	private static final long serialVersionUID = 3458305255381985008L;
	private Connection conn;
	private Statement stmt;
	private int result;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String idx=req.getParameter("idx").trim();
		String sql="delete from guest where sabun="+idx;
		System.out.println("deleteOne:sql->"+sql);
		conn = Conn.getConn();
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(result>0){
			resp.sendRedirect("list.naver");
		}else{
			resp.sendRedirect("detail.naver?idx="+idx);
		}
	}
}
