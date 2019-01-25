package com.dufl.narutoworld.vo;

public class News {
	private int newsId;
	private String newsDesc;
	private String newsLink;
	private String newsDate;
	private String newsUpdate;
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsDesc() {
		return newsDesc;
	}
	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
	}
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public String getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewsUpdate() {
		return newsUpdate;
	}
	public void setNewsUpdate(String newsUpdate) {
		this.newsUpdate = newsUpdate;
	}
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsDesc=" + newsDesc + ", newsLink=" + newsLink + ", newsDate=" + newsDate
				+ ", newsUpdate=" + newsUpdate + "]";
	}
	
}
