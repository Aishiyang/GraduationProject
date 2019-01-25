package com.sxk.refreshshop.controller;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sxk.refreshshop.pojo.Category;
import com.sxk.refreshshop.pojo.Product;
import com.sxk.refreshshop.service.CategoryService;
import com.sxk.refreshshop.service.ProductService;

public class IndexAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private CategoryService categoryService = new CategoryService();
	
	private ProductService productService = new ProductService();
	
	/**
	 * 执行的访问首页的方法:
	 */
	public String execute(){
		// 查询所有一级分类集合
		List<Category> cList = categoryService.findAll();
		// 将一级分类存入到Session的范围:
		ActionContext.getContext().getSession().put("cList", cList);
		// 查询热门商品:
		List<Product> hList = productService.findHot();
		// 保存到值栈中:
		ActionContext.getContext().getValueStack().set("hList", hList);
		// 查询最新商品:
		List<Product> nList = productService.findNew();
		// 保存到值栈中:
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
	
	
}
