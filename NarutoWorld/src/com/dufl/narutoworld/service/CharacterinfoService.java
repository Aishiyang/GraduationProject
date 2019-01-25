package com.dufl.narutoworld.service;

import java.util.List;

import com.dufl.narutoworld.dao.CharacterinfoDao;
import com.dufl.narutoworld.vo.Characterinfo;

public class CharacterinfoService {

	private CharacterinfoDao characterinfoDao = new CharacterinfoDao();
	
	public int deleteCharacterInfoById(String characterInfoId){
		return characterinfoDao.deleteCharacterInfoById(characterInfoId);
	}
	
	public int UpdateCharacterInfoById(Characterinfo characterinfo){
		return characterinfoDao.UpdateCharacterInfoById(characterinfo);
	}
	
	public int activeCharacterInfoById(Characterinfo characterinfo){
		return characterinfoDao.activeCharacterInfoById(characterinfo);
	}
	
	public List<Characterinfo> selectAll(){
		return characterinfoDao.selectAll();
	}
	
	public List<Characterinfo> selectAllByCondition(){
		return characterinfoDao.selectAllByCondition();
	}
}
