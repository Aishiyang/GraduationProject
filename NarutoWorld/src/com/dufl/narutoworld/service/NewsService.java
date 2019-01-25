package com.dufl.narutoworld.service;

import java.util.ArrayList;
import java.util.List;

import com.dufl.narutoworld.dao.NewsDao;
import com.dufl.narutoworld.vo.News;

public class NewsService {

	private NewsDao newsDao = new NewsDao();
	
	public List<News> selectAll(){
		List<News> result = new ArrayList<>();
		List<News> list = newsDao.selectAll();
		for(int i = 0; i < 5; i++) {
			result.add(list.get(i));
		}
		return result;
	}
	
	public int deleteNewsById(String NewsId){
		return newsDao.deleteNewsById(NewsId);
	}
	
	public int UpdateNewsById(News News){
		return newsDao.UpdateNewsById(News);
	}
	
	public int activeNewsById(News News){
		return newsDao.activeNewsById(News);
	}
	
	public List<News> selectByAdminAll(){
		return newsDao.selectByAdminAll();
	}
	
}
