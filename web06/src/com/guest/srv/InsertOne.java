package com.guest.srv;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertOne extends HttpServlet{

	private static final long serialVersionUID = 3617481329974351118L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		        req.setCharacterEncoding("UTF-8");
				String name = req.getParameter("name");
				int pay = Integer.parseInt(req.getParameter("pay"));
				String sql = "insert into guest values (guest_seq.nextval, '"+name+"', sysdate, "+pay+")";
				String url = "jdbc:oracle:thin:@203.236.209.201:1521/xe";
				String user = "scott";
				String password = "tiger";
				
				Connection conn = null;
				Statement stmt = null;
				int result = -1;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, password);
					stmt = conn.createStatement();
					result = stmt.executeUpdate(sql);
				} catch (Exception e) {
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
					resp.sendRedirect("addform.html");
				}
	}
			
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>주의-정상적으로 접근하세요</h1>");
	}
}

