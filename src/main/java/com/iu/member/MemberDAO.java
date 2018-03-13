package com.iu.member;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.iu.util.DBConnector;

@Repository
public class MemberDAO {

	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		Connection con=DBConnector.getConnect();
		String sql="insert into member values(?,?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getPhone());
		st.setInt(6, memberDTO.getAge());
		st.setString(7, memberDTO.getJob());
		
		int result=st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public MemberDTO memberLogin(String id,String pw)throws Exception{
		Connection con=DBConnector.getConnect();
		String sql="select * from member where id=? and pw=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, pw);
		ResultSet rs=st.executeQuery();
		MemberDTO memberDTO=null;
		if(rs.next()){
			memberDTO=new MemberDTO();
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setJob(rs.getString("job"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setAge(rs.getInt("age"));
		}
		DBConnector.disConnect(rs, st, con);
		return memberDTO;
	}
	
	public int memberDelete(String id) throws Exception{
		Connection con= DBConnector.getConnect();
		String sql="delete member where id=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, id);
		int result=st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		Connection con=DBConnector.getConnect();
		String sql="update member set pw=?,name=?,email=?,phone=?,age=? where id=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, memberDTO.getPw());
		st.setString(2, memberDTO.getName());
		st.setString(3, memberDTO.getEmail());
		st.setString(4, memberDTO.getPhone());
		st.setInt(5, memberDTO.getAge());
		st.setString(6, memberDTO.getId());
		int result=st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	
}
