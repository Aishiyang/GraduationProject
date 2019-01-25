package action;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import util.CreateId;

import model.Details;

import com.opensymphony.xwork2.ActionSupport;
import dao.DetailsDAO;

public class DetailsAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Details details;
	private List<Details> detailsList = new ArrayList<Details>();
	private String msg;
	private String name;
	private String cond;
	private int pageCur;
	private int totalCount = 0;
	private int totalPage = 0;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createDetails() {
		return SUCCESS;
	}

	public String addDetails() {
		DetailsDAO detailsDAO = new DetailsDAO();
		this.details.setDetailsid(CreateId.getId());
		try {
			boolean result = detailsDAO.saveDetails(this.details);
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

	public String deleteDetails() {
		DetailsDAO detailsDAO = new DetailsDAO();
		try {
			boolean result = detailsDAO.deleteDetails(this.details.getDetailsid());
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

	public String updateDetails() {
		DetailsDAO detailsDAO = new DetailsDAO();
		try {
			boolean result = detailsDAO.updateDetails(this.details);
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

	public String getAllDetails() {
		DetailsDAO detailsDAO = new DetailsDAO();
		try {
			List<Details> list = detailsDAO.queryAll();
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
			detailsDAO = new DetailsDAO();
			this.setDetailsList(detailsDAO.queryByPage(pageCur));
			if (this.detailsList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String queryDetailsByCond() {
		DetailsDAO detailsDAO = new DetailsDAO();
		try {
			if ("ordercode".equals(this.cond)) {
				this.detailsList = detailsDAO.queryByLikeOrdercode(this.name);
			}
			if ("goodsid".equals(this.cond)) {
				this.detailsList = detailsDAO.queryByLikeGoodsid(this.name);
			}
			if ("num".equals(this.cond)) {
				this.detailsList = detailsDAO.queryByLikeNum(this.name);
			}
			if ("price".equals(this.cond)) {
				this.detailsList = detailsDAO.queryByLikePrice(this.name);
			}
			if (this.detailsList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String getDetailsById() {
		DetailsDAO detailsDAO = new DetailsDAO();
		try {
			this.details = detailsDAO.queryById(this.details.getDetailsid());
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public List<Details> getDetailsList() {
		return detailsList;
	}

	public void setDetailsList(List<Details> detailsList) {
		this.detailsList = detailsList;
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