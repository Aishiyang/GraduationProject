package com.dufl.narutoworld.vo;

public class Homenews {
	private String homenewsLink;
	private String homenewsPhoto;
	private int homenewsActivated;
	public String getHomenewsLink() {
		return homenewsLink;
	}
	public void setHomenewsLink(String homenewsLink) {
		this.homenewsLink = homenewsLink;
	}
	public String getHomenewsPhoto() {
		return homenewsPhoto;
	}
	public void setHomenewsPhoto(String homenewsPhoto) {
		this.homenewsPhoto = homenewsPhoto;
	}
	public int getHomenewsActivated() {
		return homenewsActivated;
	}
	public void setHomenewsActivated(int homenewsActivated) {
		this.homenewsActivated = homenewsActivated;
	}
	@Override
	public String toString() {
		return "Homenews [homenewsLink=" + homenewsLink + ", homenewsPhoto=" + homenewsPhoto + ", homenewsActivated="
				+ homenewsActivated + "]";
	}
	
}
