package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Orders;
import util.CreateId;

import com.opensymphony.xwork2.ActionSupport;

import dao.OrdersDAO;

public class OrdersAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Orders orders;
	private List<Orders> ordersList = new ArrayList<Orders>();
	private String msg;
	private String name;
	private String cond;
	private int pageCur;
	private int totalCount = 0;
	private int totalPage = 0;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createOrders() {
		return SUCCESS;
	}

	public String addOrders() {
		OrdersDAO ordersDAO = new OrdersDAO();
		this.orders.setOrdersid(CreateId.getId());
		try {
			boolean result = ordersDAO.saveOrders(this.orders);
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

	public String deleteOrders() {
		OrdersDAO ordersDAO = new OrdersDAO();
		try {
			boolean result = ordersDAO.deleteOrders(this.orders.getOrdersid());
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

	public String updateOrders() {
		OrdersDAO ordersDAO = new OrdersDAO();
		try {
			boolean result = ordersDAO.updateOrders(this.orders);
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

	public String getAllOrders() {
		OrdersDAO ordersDAO = new OrdersDAO();
		try {
			List<Orders> list = ordersDAO.queryAll();
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
			ordersDAO = new OrdersDAO();
			this.setOrdersList(ordersDAO.queryByPage(pageCur));
			if (this.ordersList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String queryOrdersByCond() {
		OrdersDAO ordersDAO = new OrdersDAO();
		try {
			if ("ordercode".equals(this.cond)) {
				this.ordersList = ordersDAO.queryByLikeOrdercode(this.name);
			}
			if ("usersid".equals(this.cond)) {
				this.ordersList = ordersDAO.queryByLikeUsersid(this.name);
			}
			if ("total".equals(this.cond)) {
				this.ordersList = ordersDAO.queryByLikeTotal(this.name);
			}
			if ("addtime".equals(this.cond)) {
				this.ordersList = ordersDAO.queryByLikeAddtime(this.name);
			}
			if ("status".equals(this.cond)) {
				this.ordersList = ordersDAO.queryByLikeStatus(this.name);
			}
			if ("receiver".equals(this.cond)) {
				this.ordersList = ordersDAO.queryByLikeReceiver(this.name);
			}
			if ("address".equals(this.cond)) {
				this.ordersList = ordersDAO.queryByLikeAddress(this.name);
			}
			if ("contact".equals(this.cond)) {
				this.ordersList = ordersDAO.queryByLikeContact(this.name);
			}
			if (this.ordersList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String getOrdersById() {
		OrdersDAO ordersDAO = new OrdersDAO();
		try {
			this.orders = ordersDAO.queryById(this.orders.getOrdersid());
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
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