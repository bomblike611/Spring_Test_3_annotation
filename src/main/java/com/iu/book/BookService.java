package com.iu.book;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	public List<BookDTO> selectList()throws Exception{
		return bookDAO.selectList();
	}
	
	public int insert(BookDTO bookDTO)throws Exception{
		return bookDAO.insert(bookDTO);
	}
	
	
	
	
}
