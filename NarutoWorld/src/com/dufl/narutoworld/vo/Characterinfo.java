package com.dufl.narutoworld.vo;

public class Characterinfo {
	private int characterinfoId;
	private String characterinfoNum;
	private String characterinfoName;
	private String characterinfoDesc;
	private int characterinfoActivated;
	public int getCharacterinfoId() {
		return characterinfoId;
	}
	public void setCharacterinfoId(int characterinfoId) {
		this.characterinfoId = characterinfoId;
	}
	public String getCharacterinfoNum() {
		return characterinfoNum;
	}
	public void setCharacterinfoNum(String characterinfoNum) {
		this.characterinfoNum = characterinfoNum;
	}
	public String getCharacterinfoName() {
		return characterinfoName;
	}
	public void setCharacterinfoName(String characterinfoName) {
		this.characterinfoName = characterinfoName;
	}
	public String getCharacterinfoDesc() {
		return characterinfoDesc;
	}
	public void setCharacterinfoDesc(String characterinfoDesc) {
		this.characterinfoDesc = characterinfoDesc;
	}
	public int getCharacterinfoActivated() {
		return characterinfoActivated;
	}
	public void setCharacterinfoActivated(int characterinfoActivated) {
		this.characterinfoActivated = characterinfoActivated;
	}
	@Override
	public String toString() {
		return "Characterinfo [characterinfoId=" + characterinfoId + ", characterinfoNum=" + characterinfoNum
				+ ", characterinfoName=" + characterinfoName + ", characterinfoDesc=" + characterinfoDesc
				+ ", characterinfoActivated=" + characterinfoActivated + "]";
	}
	
}
