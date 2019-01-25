package com.dufl.narutoworld.service;

import java.util.ArrayList;
import java.util.List;

import com.dufl.narutoworld.dao.LinksDao;
import com.dufl.narutoworld.vo.Links;


public class LinksService {
	
	private LinksDao linksDao = new LinksDao();
	
	public List<Links> selectAll(){
		List<Links> result = new ArrayList<>();
		List<Links> list = linksDao.selectAll();
		for(int i = 0; i < 5; i++) {
			result.add(list.get(i));
		}
		return result;
	}
	
	public int deleteLinksById(String linksId){
		return linksDao.deleteLinksById(linksId);
	}
	
	public int UpdateLinksById(Links links){
		return linksDao.UpdateLinksById(links);
	}
	
	public int activeLinksById(Links links){
		return linksDao.activeLinksById(links);
	}
	
	public List<Links> selectByAdminAll(){
		return linksDao.selectByAdminAll();
	}
}
