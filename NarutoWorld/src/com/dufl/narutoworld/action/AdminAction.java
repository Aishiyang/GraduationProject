package com.dufl.narutoworld.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dufl.narutoworld.service.CharacterinfoService;
import com.dufl.narutoworld.service.HomenewsService;
import com.dufl.narutoworld.service.LinksService;
import com.dufl.narutoworld.service.NewsService;
import com.dufl.narutoworld.service.UserService;
import com.dufl.narutoworld.vo.Characterinfo;
import com.dufl.narutoworld.vo.Homenews;
import com.dufl.narutoworld.vo.Links;
import com.dufl.narutoworld.vo.News;
import com.dufl.narutoworld.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	
	private static final long serialVersionUID = 4751728903347882500L;
 
	private NewsService newsService = new NewsService();
	private LinksService linksService = new LinksService();
	private UserService userService = new UserService();
	private CharacterinfoService characterinfoService = new CharacterinfoService();
	private HomenewsService homenewsService = new HomenewsService();
	
	private List<User> users = new ArrayList<User>();
	private List<Characterinfo> characterinfos = new ArrayList<Characterinfo>();
	private List<News> newss = new ArrayList<News>();
	private List<Links> linkss = new ArrayList<Links>();
	
	public List<Characterinfo> getCharacterinfos() {
		return characterinfos;
	}

	public void setCharacterinfos(List<Characterinfo> characterinfos) {
		this.characterinfos = characterinfos;
	}

	public List<News> getNewss() {
		return newss;
	}

	public void setNewss(List<News> newss) {
		this.newss = newss;
	}

	public List<Links> getLinkss() {
		return linkss;
	}

	public void setLinkss(List<Links> linkss) {
		this.linkss = linkss;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	 
	public List<User> getUsers() {
		return users;
	}
	
	private User user = new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	private News news = new News();
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	private Links links = new Links();
	
	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}
	
	private Characterinfo characterinfo = new Characterinfo();
	
	public Characterinfo getCharacterinfo() {
		return characterinfo;
	}

	public void setCharacterinfo(Characterinfo characterinfo) {
		this.characterinfo = characterinfo;
	}
	
	private Homenews homenews = new Homenews();
	
	public Homenews getHomenews() {
		return homenews;
	}

	public void setHomenews(Homenews homenews) {
		this.homenews = homenews;
	}
	
	public String index(){
		return "index";
	}
 
	//TODO
	public String userInformationManagement(){
		List<User> userList = userService.selectAll();
		this.setUsers(userList);
		return "userInformationManagement";
	} 
	
	public String deleteUser(){
		String userid = ServletActionContext.getRequest().getParameter("userid");
		userService.deleteUserById(userid);
		userInformationManagement();
		return "userInformationManagement";
	}
	
	//TODO
	public String characterInfoManagement(){
		List<Characterinfo> CharacterinfoList = characterinfoService.selectAll();
		this.setCharacterinfos(CharacterinfoList);
		return "characterInfoManagement";
	} 
	
	public String characterInfoManagementCondition(){
		List<Characterinfo> CharacterinfoList = characterinfoService.selectAllByCondition();
		this.setCharacterinfos(CharacterinfoList);
		return "characterInfoManagementCondition";
	} 
	
	public String deleteCharacterInfo(){
		String characterInfoId = ServletActionContext.getRequest().getParameter("characterinfoid");
		characterinfoService.deleteCharacterInfoById(characterInfoId);
		characterInfoManagement();
		return "characterInfoManagement";
	}
	
	public String updateCharacterInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Characterinfo characterinfo1 = new Characterinfo();
		characterinfo1.setCharacterinfoNum(request.getParameter("characterinfoNum"));
		characterinfo1.setCharacterinfoName(request.getParameter("characterinfoName"));
		characterinfo1.setCharacterinfoDesc(request.getParameter("characterinfoDesc"));
		characterinfo1.setCharacterinfoId(Integer.parseInt(request.getParameter("characterinfoId")));
		characterinfoService.UpdateCharacterInfoById(characterinfo1);
		characterInfoManagement();
		return "characterInfoManagement";
	}
	
	public String activeCharacterInfo(){
		String characterInfoId = ServletActionContext.getRequest().getParameter("characterinfoid");
		String characterinfoActivated = ServletActionContext.getRequest().getParameter("characterinfoActivated");
		Characterinfo characterinfo = new Characterinfo();
		characterinfo.setCharacterinfoId(Integer.parseInt(characterInfoId));
		characterinfo.setCharacterinfoActivated(Integer.parseInt(characterinfoActivated));
		characterinfoService.activeCharacterInfoById(characterinfo);
		characterInfoManagement();
		return "characterInfoManagement";
	}
	
	//TODO
	public String newsManagement(){
		List<News> newsList = newsService.selectByAdminAll();
		this.setNewss(newsList);
		return "newsManagement";
	} 
	
	public String deleteNews(){
		String newsId = ServletActionContext.getRequest().getParameter("newsid");
		newsService.deleteNewsById(newsId);
		newsManagement();
		return "newsManagement";
	}
	
	public String updateNews(){
		HttpServletRequest request = ServletActionContext.getRequest();
		News news1 = new News();
		news1.setNewsId(Integer.parseInt(request.getParameter("newsId")));
		news1.setNewsDesc(request.getParameter("newsDesc"));
		news1.setNewsLink(request.getParameter("newsLink"));
		newsService.UpdateNewsById(news1);
		newsManagement();
		return "newsManagement";
	}
	
	public String activeNews(){
		String newsId = ServletActionContext.getRequest().getParameter("newsid");
		String newsUpdate = ServletActionContext.getRequest().getParameter("newsupdate");
		News news1 = new News();
		news1.setNewsId(Integer.parseInt(newsId));
		news1.setNewsUpdate(newsUpdate);
		newsService.activeNewsById(news1);
		newsManagement();
		return "newsManagement";
	}
	
	//TODO
	public String linksManagement(){
		List<Links> linksList = linksService.selectByAdminAll();
		this.setLinkss(linksList);
		return "linksManagement";
	} 
	
	public String deleteLinks(){
		String linksId = ServletActionContext.getRequest().getParameter("linksid");
		linksService.deleteLinksById(linksId);
		linksManagement();
		return "linksManagement";
	}
	
	public String updateLinks(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Links links1 = new Links();
		links1.setLinksId(Integer.parseInt(request.getParameter("linksId")));
		links1.setLinksDesc(request.getParameter("linksDesc"));
		links1.setLinksLink(request.getParameter("linksLink"));
		linksService.UpdateLinksById(links1);
		linksManagement();
		return "linksManagement";
	}
	
	public String activeLinks(){
		String linksId = ServletActionContext.getRequest().getParameter("linksid");
		String linksUpdate = ServletActionContext.getRequest().getParameter("linksUpdate");
		Links links1 = new Links();
		links1.setLinksId(Integer.parseInt(linksId));
		links1.setLinksUpdate(linksUpdate);
		linksService.activeLinksById(links1);
		linksManagement();
		return "linksManagement";
	}
}
