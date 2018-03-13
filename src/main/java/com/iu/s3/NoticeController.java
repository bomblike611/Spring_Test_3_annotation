package com.iu.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.notice.NoticeDAO;
import com.iu.notice.NoticeDTO;
import com.iu.notice.NoticeService;

@RequestMapping(value="/notice/**")
@Controller
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	
	
	/*@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public void noticeList(HttpServletRequest request){
		String curPage=request.getParameter("curPage");
		int cur=Integer.parseInt(curPage);
		System.out.println(curPage);
	}*/
	
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public void noticeList(Model model,@RequestParam(value="curPage",defaultValue="1",required=false) int cur){
		List<NoticeDTO> ar=null;
		
		try {
			ar=noticeService.selectList();
		} catch (Exception e) {
			
		}
		model.addAttribute("list",ar);
		model.addAttribute(cur).addAttribute("board", "notice");
		System.out.println(cur);
	}
	
	@RequestMapping(value="noticeTest", method=RequestMethod.POST)
	public void noticeList2(int [] check){
		for(int i=0;i<check.length;i++){
		System.out.println("number :"+check[i]);
		}
	}
	
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.GET)
	public void noticeWrite(Model model){
		String notice="notice";
		model.addAttribute("board", notice);
	}
	
	/*@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String noticeWrite2(String title,String writer,String contents){
		System.out.println("title : "+title);
		System.out.println("writer : "+writer);
		System.out.println("contents : "+contents);
		return "common/result";
	}*/
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public ModelAndView noticeWrite2(NoticeDTO noticeDTO){
		int result=0;
		try {
			result=noticeService.insert(noticeDTO);
		} catch (Exception e) {
			
		}
		ModelAndView mv= new ModelAndView();
		if(result>0){
		mv.addObject("message", "Success");
		}else{
			mv.addObject("message", "Fail");
		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/result");
		
		return mv;
	}
	@RequestMapping(value="noticeWrite2",method=RequestMethod.POST)
	public String noticeWrite3(RedirectAttributes rd){
		rd.addFlashAttribute("message", "ooooooooo");
		return "redirect:./noticeList?curPage=20";
	}
	
	@RequestMapping(value="noticeView",method=RequestMethod.GET)
	public ModelAndView noticeView(@RequestParam(defaultValue="0",required=false) int num){
		ModelAndView mv=new ModelAndView();
		NoticeDTO noticeDTO=null;
		try {
			noticeDTO = noticeService.selectOne(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(noticeDTO!=null){
		mv.addObject("view", noticeDTO);
		}else{
			mv.addObject("message", "Fail");
			mv.addObject("path", "noticeList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@RequestMapping(value="noticeDelete",method=RequestMethod.GET)
	public ModelAndView noticeDelete(int num){
		int result=0;
		try {
			result=noticeService.delete(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv=new ModelAndView();
		if(result>0){
			mv.addObject("message","Success");
		}else{
			mv.addObject("message","Fail");
		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="noticeUpdate",method=RequestMethod.GET)
	public ModelAndView noticeUpdate(int num){
		NoticeDTO noticeDTO=null;
		ModelAndView mv=new ModelAndView();
		try {
			noticeDTO=noticeService.selectOne(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(noticeDTO!=null){
		mv.addObject("notice", noticeDTO);
		mv.setViewName("notice/noticeUpdate");
		}else{
			mv.addObject("message", "not found");
			mv.addObject("path", "noticeList");
		mv.setViewName("common/result");
		}
		return mv;
	}
	
	@RequestMapping(value="noticeUpdate",method=RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeDTO noticeDTO){
		int result=0;
		try {
			result=noticeService.update(noticeDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv=new ModelAndView();
		if(result>0){
			mv.addObject("message","Success");
		}else{
			mv.addObject("message","Fail");
		}
		mv.addObject("path", "noticeView?num="+noticeDTO.getNum());
		mv.setViewName("common/result");
		return mv;
	}
	
}
