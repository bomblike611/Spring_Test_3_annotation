package com.iu.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.util.DBConnector;

@Repository
public class BookDAO {

	public List<BookDTO> selectList() throws Exception{
		List<BookDTO> ar=new ArrayList<BookDTO>();
		
		Connection con=DBConnector.getConnect();
		String sql="select * from (select rownum R,B.* from (select * from books order by bookid desc) B) where R between 1 and 10";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		BookDTO bookDTO=null;
		while(rs.next()){
			bookDTO=new BookDTO();
			bookDTO.setBookid(rs.getInt("bookid"));
			bookDTO.setBookname(rs.getString("bookname"));
			bookDTO.setPrice(rs.getInt("price"));
			bookDTO.setPublisher(rs.getString("publisher"));
			ar.add(bookDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	public int insert(BookDTO bookDTO) throws Exception{
		Connection con=DBConnector.getConnect();
		String sql="insert into books values(book_seq.nextval,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, bookDTO.getBookname());
		st.setString(2, bookDTO.getPublisher());
		st.setInt(3, bookDTO.getPrice());
		
		int result=st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
}
