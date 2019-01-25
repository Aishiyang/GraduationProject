package com.dufl.narutoworld.vo;

public class Links {
	private int linksId;
	private String linksDesc;
	private String linksLink;
	private String linksDate;
	private String linksUpdate;
	
	public int getLinksId() {
		return linksId;
	}
	public void setLinksId(int linksId) {
		this.linksId = linksId;
	}
	public String getLinksDesc() {
		return linksDesc;
	}
	public void setLinksDesc(String linksDesc) {
		this.linksDesc = linksDesc;
	}
	public String getLinksLink() {
		return linksLink;
	}
	public void setLinksLink(String linksLink) {
		this.linksLink = linksLink;
	}
	public String getLinksDate() {
		return linksDate;
	}
	public void setLinksDate(String linksDate) {
		this.linksDate = linksDate;
	}
	public String getLinksUpdate() {
		return linksUpdate;
	}
	public void setLinksUpdate(String linksUpdate) {
		this.linksUpdate = linksUpdate;
	}
	@Override
	public String toString() {
		return "Links [linksId=" + linksId + ", linksDesc=" + linksDesc + ", linksLink=" + linksLink + ", linksDate="
				+ linksDate + ", linksUpdate=" + linksUpdate + "]";
	}

	
}
