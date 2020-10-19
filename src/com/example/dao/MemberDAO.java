package com.example.dao;

import java.util.List;

import com.example.dto.MemberDTO;

public interface MemberDAO {

	public List<MemberDTO> selectAllMember();
	
}
