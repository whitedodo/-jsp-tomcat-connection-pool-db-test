package com.example.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBConnector {

	public Connection connection() {

	    // 컨텍스트 객체를 가져온다.
		
		try {
			Context initCtx = new InitialContext();
			//initCtx의 lookup메서드를 이용해서 "java:comp/env" 에 해당하는 객체를 찾아서 evnCtx에 삽입
            Context envCtx = (Context) initCtx.lookup("java:comp/env");         
            //envCtx의 lookup메서드를 이용해서 "jdbc/orcl"에 해당하는 객체를 찾아서 ds에 삽입
            DataSource ds = (DataSource) envCtx.lookup("jdbc/Oracle11g");
		    Connection conn = null;
		    
		    // datasource 객체에서 커넥션 객체를 가져온다.
		    conn = ds.getConnection();
		    // 이후는 기존과 동일하게 사용하면 된다
		    System.out.println(conn);
		    
		    return conn;
		    
		    /*
		         
			Context context = new InitialContext();
    		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
    		Connection con = dataSource.getConnection();        

		    */
		    
		}
		// 시큐어 코딩(Exception만 해놓으면 ... 안 된다)
		catch(NamingException e) {
			
		}
		catch(SQLException e) {
			
		}
		catch(Exception e) {
			
		}
		
		return null;	    
		
	}

    public void close(Connection conn, PreparedStatement ps, ResultSet rs) {

		if ( rs != null ) {

			try {
				rs.close();
			}
			catch(SQLException ex) {
				
			}			
			catch(Exception ex) {
				System.out.println("오류 발생: " + ex);
			}
			
			close(conn, ps);	// Recursive 구조 응용(재귀 함수)
		} // end of if

	}	

	public void close(Connection conn, PreparedStatement ps) {

		if (ps != null ) {

			try {
				ps.close();
			}
			catch(SQLException ex) {
				System.out.println("오류 발생: " + ex);
			}
			catch(Exception ex) {
				System.out.println("오류 발생: " + ex);
			}
		} // end of if

		if (conn != null ) {
			try {
				conn.close();
			}
			catch(SQLException ex) {

				System.out.println("오류 발생: " + ex);
			}
			catch(Exception ex) {
				System.out.println("오류 발생: " + ex);
			}
		} // end of if

	}
	
}
