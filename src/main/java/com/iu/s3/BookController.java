package com.iu.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.book.BookDTO;
import com.iu.book.BookService;

@RequestMapping(value="/book/**")
@Controller
public class BookController {

	@Inject
	private BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	//================강사님이 짜신 bookList======================
/*	@RequestMapping(value="bookList",method=RequestMethod.GET)
	public void bookList(Model model){
		List<BookDTO> ar=null;
		try {
			ar=bookService.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("list", ar);
	}*/
	
	@RequestMapping(value="bookList",method=RequestMethod.GET)
	public ModelAndView bookList(){
		ModelAndView modelAndView=new ModelAndView();
		List<BookDTO> ar=null;
		try {
			ar=bookService.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("book/bookList");
		
		return modelAndView;
	}
	
	@RequestMapping(value="bookWrite",method=RequestMethod.GET)
	public void bookWrite(){
		
	}
	
	@RequestMapping(value="bookWrite",method=RequestMethod.POST)
	public ModelAndView bookWrite(BookDTO bookDTO){
		int result=0;
		ModelAndView modelAndView=new ModelAndView();
		try {
			result=bookService.insert(bookDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0){
			modelAndView.addObject("message", "Success");
		}else{
			modelAndView.addObject("message", "Fail");
		}
		modelAndView.addObject("path", "bookList");
		modelAndView.setViewName("common/result");
		return modelAndView;
	}
	
}
