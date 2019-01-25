package com.dufl.narutoworld.action;

import java.util.List;

import com.dufl.narutoworld.service.HomenewsService;
import com.dufl.narutoworld.service.LinksService;
import com.dufl.narutoworld.service.NewsService;
import com.dufl.narutoworld.vo.Homenews;
import com.dufl.narutoworld.vo.Links;
import com.dufl.narutoworld.vo.News;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private LinksService linksService = new LinksService();
	
	private NewsService newsService = new NewsService();
	
	private HomenewsService homenewsService = new HomenewsService();
	
	public String execute() {
		List<Links> linksList = linksService.selectAll();
		ActionContext.getContext().put("linksList",linksList);
		
		List<News> newsList = newsService.selectAll();
		ActionContext.getContext().put("newsList",newsList);
		
//		List<Homenews> homenewsList = homenewsService.selectAll();
//		ActionContext.getContext().put("homenewsList",homenewsList);
		
		return "index";
	}

}
