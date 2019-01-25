package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cate;

import com.opensymphony.xwork2.ActionSupport;

import dao.CateDAO;

public class CateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Cate cate;
	private List<Cate> cateList = new ArrayList<Cate>();
	private String msg;
	private String name;
	private String cond;
	private int pageCur;
	private int totalCount = 0;
	private int totalPage = 0;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createCate() {
		return SUCCESS;
	}

	public String addCate() {
		CateDAO cateDAO = new CateDAO();
		try {
			boolean result = cateDAO.saveCate(this.cate);
			if (result) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String deleteCate() {
		CateDAO cateDAO = new CateDAO();
		try {
			boolean result = cateDAO.deleteCate(this.cate.getCateid());
			if (result) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String updateCate() {
		CateDAO cateDAO = new CateDAO();
		try {
			boolean result = cateDAO.updateCate(this.cate);
			if (result) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String getAllCate() {
		CateDAO cateDAO = new CateDAO();
		try {
			List<Cate> list = cateDAO.queryAll();
			int temp = list.size();
			setTotalCount(list.size());
			if (pageCur <= 0) {
				pageCur = 1;
			}
			if ((pageCur - 1) * 10 >= temp) {
				pageCur = pageCur - 1;
			}
			if (temp == 0) {
				totalPage = 0;
			} else {
				totalPage = (int) Math.ceil((double) temp / 10);
			}
			cateDAO = new CateDAO();
			this.setCateList(cateDAO.queryByPage(pageCur));
			if (this.cateList.size() == 0) {
				this.msg = "没有查询到数据";
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String queryCateByCond() {
		CateDAO cateDAO = new CateDAO();
		try {
			if ("catename".equals(this.cond)) {
				this.cateList = cateDAO.queryByLikeCatename(this.name);
			}
			if (this.cateList.size() == 0) {
				this.msg = "没有查询到数据";
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String getCateById() {
		CateDAO cateDAO = new CateDAO();
		try {
			this.cate = cateDAO.queryById(this.cate.getCateid());
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public Cate getCate() {
		return cate;
	}

	public void setCate(Cate cate) {
		this.cate = cate;
	}

	public List<Cate> getCateList() {
		return cateList;
	}

	public void setCateList(List<Cate> cateList) {
		this.cateList = cateList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getPageCur() {
		return pageCur;
	}

	public void setPageCur(int pageCur) {
		this.pageCur = pageCur;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}