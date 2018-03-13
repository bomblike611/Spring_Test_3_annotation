package com.iu.s3;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iu.member.MemberDAO;
import com.iu.member.MemberDTO;
import com.iu.member.MemberService;
import com.iu.notice.NoticeDAO;
import com.iu.notice.NoticeDTO;
import com.iu.notice.NoticeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class TestMember {
	
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private NoticeService noticeService;
	@Inject
	private MemberService MemberService;
	@Inject
	private MemberController MemberController;

	
	@Test(expected=RuntimeException.class)
	public void test() throws Exception{
	System.out.println("111");
	}
	
	@Test
	public void test2() throws Exception{
		System.out.println("222");
	}
	@Test
	public void test3() throws Exception{
		System.out.println("333");
	}
	
	@Before
	public void befor(){
		System.out.println("before");
	}
	@After
	public void agre(){
		System.out.println("after");
	}
	@BeforeClass
	public static void start(){
		System.out.println("start");
	}
	@AfterClass
	public static void finish(){
		System.out.println("finish");
	}

}
