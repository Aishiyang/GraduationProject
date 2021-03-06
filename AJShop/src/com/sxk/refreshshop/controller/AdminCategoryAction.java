package com.sxk.refreshshop.controller;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sxk.refreshshop.pojo.Category;
import com.sxk.refreshshop.service.CategoryService;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	
	private static final long serialVersionUID = 1L;
	
	// 模型驱动使用的对象.
	private Category category = new Category();
	
	public Category getModel() {
		return category;
	}
	
	public CategoryService categoryService = new CategoryService();

	// 查询所有一级分类
	public String findAll(){
		// 调用Service查询所有一级分类
		List<Category> cList = categoryService.findAll();
		// 通过值栈保存一级分类集合:
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	// 保存一级分类的方法
	public String save(){
		// 调用Service完成保存一级分类
		categoryService.save(category);
		// 进行页面跳转:
		return "saveSuccess";
	}
	
	// 删除一级分类的方法:
	public String delete(){
		// 调用Service完成 一级分类的删除
		// 级联删除一定先查询在删除:
		category = categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		// 进行页面转向:
		return "deleteSuccess";
	}
	
	// 编辑一级分类的方法:
	public String edit(){
		// 接收cid:
		// 根据cid进行查询:
		category = categoryService.findByCid(category.getCid());
		// 完成页面转向:将一级分类数据显示到页面上.
		return "editSuccess";
	}
	
	// 修改一级分类的方法:
	public String update(){
		// 使用模型驱动接收前台提交数据:
		categoryService.update(category);
		// 页面跳转:
		return "updateSuccess";
	}
}
