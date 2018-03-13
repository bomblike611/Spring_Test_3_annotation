package com.iu.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberJoin(memberDTO);
	}
	
	public MemberDTO memberLogin(String id,String pw) throws Exception{
		return memberDAO.memberLogin(id, pw);
	}
	
	public int memberDelete(String id) throws Exception{
		return memberDAO.memberDelete(id);
	}
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
}
