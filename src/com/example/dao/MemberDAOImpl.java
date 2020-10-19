package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.db.DBConnector;
import com.example.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO{

	private DBConnector dbConn = new DBConnector();
	private Connection conn = dbConn.connection();

    private PreparedStatement pstmt;  
    private ResultSet rs;   //정보를 담을 수 있는 변수를 생성
    
	@Override
	public List<MemberDTO> selectAllMember() {

		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		String SQL= "SELECT * from communities_member";
		
        try {
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
                       
            while(rs.next()) {
            	MemberDTO vo = new MemberDTO();
            	vo.setIdx(rs.getInt("idx"));
            	vo.setUsername(rs.getString("username"));
            	vo.setPasswd(rs.getString("passwd"));
            	vo.setRegidate(rs.getDate("regidate"));
            	
            	list.add(vo);
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }finally {
        	dbConn.close(conn, pstmt, rs);
        }
		
		return list;
	}

	
	
}
