package com.iu.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.util.DBConnector;

@Repository
public class NoticeDAO {

	
	public List<NoticeDTO> selectList() throws Exception{
		List<NoticeDTO> ar=new ArrayList<NoticeDTO>();
		Connection con=DBConnector.getConnect();
		
		String sql="select * from (select rownum R,N.* from (select * from notice order by num desc) N)"
				+ " where R between 1 and 10";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		NoticeDTO noticeDTO=null;
		while(rs.next()){
			noticeDTO=new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setHit(rs.getInt("hit"));
			noticeDTO.setReg_date(rs.getString("reg_date"));
			ar.add(noticeDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	public int insert(NoticeDTO noticeDTO) throws Exception{
		Connection con=DBConnector.getConnect();
		
		String sql="insert into notice values (board_seq.nextval,?,?,?,sysdate,0)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		st.setString(3, noticeDTO.getContents());
		
		int result=st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
		
	}
	
	public NoticeDTO selectOne(int num) throws Exception{
		Connection con=DBConnector.getConnect();
		String sql="select * from notice where num=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs=st.executeQuery();
		NoticeDTO noticeDTO=null;
		if(rs.next()){
			noticeDTO=new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setHit(rs.getInt("hit"));
			noticeDTO.setReg_date(rs.getString("reg_date"));
		}
		DBConnector.disConnect(rs,st, con);
		return noticeDTO;
	}
	
	public int delete(int num) throws Exception{
		Connection con=DBConnector.getConnect();
		String sql="delete notice where num=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, num);
		
		int result=st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception{
		Connection con=DBConnector.getConnect();
		String sql="update notice set title=?,contents=? where num=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getContents());
		st.setInt(3, noticeDTO.getNum());
		int result=st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
}
