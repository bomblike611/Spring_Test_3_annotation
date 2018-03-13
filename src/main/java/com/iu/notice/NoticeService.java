package com.iu.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Inject
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> selectList() throws Exception{
		return noticeDAO.selectList();
	}
	
	public int insert(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.insert(noticeDTO);
	}
	
	public NoticeDTO selectOne(int num) throws Exception{
		return noticeDAO.selectOne(num);
	}
	
	public int delete(int num) throws Exception{
		return noticeDAO.delete(num);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.update(noticeDTO);
	}
	
}
