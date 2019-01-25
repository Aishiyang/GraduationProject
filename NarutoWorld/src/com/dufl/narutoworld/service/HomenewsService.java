package com.dufl.narutoworld.service;

import java.util.ArrayList;
import java.util.List;

import com.dufl.narutoworld.dao.HomenewsDao;
import com.dufl.narutoworld.vo.Homenews;

public class HomenewsService {
	
	private HomenewsDao homenewsDao = new HomenewsDao();
	
	public List<Homenews> selectAll(){
		List<Homenews> result = new ArrayList<>();
		List<Homenews> list = homenewsDao.selectAll();
		for(int i = 0; i < 1; i++) {
			result.add(list.get(i));
		}
		return result;
	}
}
