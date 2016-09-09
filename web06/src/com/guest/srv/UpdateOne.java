package com.guest.srv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.model.Conn;

public class UpdateOne extends HttpServlet{
	private static final long serialVersionUID = -1848188791633326243L;
	private Connection conn;
	private Statement stmt;
	int result=-1;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String sabun = req.getParameter("sabun");
		String name = req.getParameter("name");
		String pay = req.getParameter("pay");
		String sql = "update guest set name='"+name+"',pay="+pay;
		  sql+=" where sabun="+sabun;
		System.out.println(sql);  
		conn = Conn.getConn();
		try{
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(conn!=null)conn.close();
			}catch(Exception ex){
				
			}
		}
		String ur="edit.naver?idx="+sabun;
		if(result>0)ur="list.naver";
		resp.sendRedirect(ur);
		
	}

}
