package com.iu.s3;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin",method=RequestMethod.GET)
	public void memberJoin(){
		
	}
	
	@RequestMapping(value="memberJoin",method=RequestMethod.POST)
	public ModelAndView memberJoin(MemberDTO memberDTO){
		ModelAndView mv=new ModelAndView();
		int result=0;
		try {
			result=memberService.memberJoin(memberDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0){
			mv.addObject("message", "Success");
			mv.addObject("path", "../");
		}else{
			mv.addObject("message", "Fail");
			mv.addObject("path", "memberJoin");
		}
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="memberLogin",method=RequestMethod.GET)
	public void memberLogin(){
		
	}
	
	@RequestMapping(value="memberLogin",method=RequestMethod.POST)
	public ModelAndView memberLogin(HttpSession session,String id,String pw){
		MemberDTO memberDTO=null;
		ModelAndView mv=new ModelAndView();
		try {
			memberDTO=memberService.memberLogin(id,pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(memberDTO!=null){
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
		}else{
			mv.addObject("message", "Fail");
			mv.addObject("path", "memberLogin");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@RequestMapping(value="memberDelete",method=RequestMethod.GET)
	public ModelAndView memberDelete(HttpSession session){
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		ModelAndView mv=new ModelAndView();
		int result=0;
		try {
			result=memberService.memberDelete(memberDTO.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0){
			mv.addObject("message", "Success");
			session.invalidate();
		}else{
			mv.addObject("message", "Fail");
		}
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="memberLogout",method=RequestMethod.GET)
	public ModelAndView memberLogout(HttpSession session){
		ModelAndView mv=new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:../");
		/*return "home";*/
		return mv;
	}
	
	@RequestMapping(value="memberUpdate",method=RequestMethod.GET)
	public ModelAndView memberUpdate(HttpSession session){
		ModelAndView mv=new ModelAndView();
		MemberDTO memberDTO=null;
		memberDTO=(MemberDTO)session.getAttribute("member");
		if(memberDTO!=null){
			session.setAttribute("member", memberDTO);
			mv.setViewName("member/memberUpdate");
		}else{
			mv.addObject("message", "Fail");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@RequestMapping(value="memberUpdate",method=RequestMethod.POST)
	public ModelAndView memberUpdate(HttpSession session,MemberDTO memberDTO){
		ModelAndView mv=new ModelAndView();
		int result=0;
		try {
			result=memberService.memberUpdate(memberDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0){
			session.setAttribute("member", memberDTO);
			mv.addObject("message", "Success");
		}else{
			mv.addObject("message", "Fail");
		}
		mv.addObject("path", "memberView");
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="memberView",method=RequestMethod.GET)
	public ModelAndView memberView(HttpSession session){
		ModelAndView mv=new ModelAndView();
		MemberDTO memberDTO=null;
		memberDTO=(MemberDTO)session.getAttribute("member");
		if(memberDTO!=null){
			
		}else{
			mv.addObject("message", "Fail");
			mv.addObject("path", "redirect:../");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	
}
