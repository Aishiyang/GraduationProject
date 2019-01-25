package action;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import util.CreateId;

import model.Cart;

import com.opensymphony.xwork2.ActionSupport;
import dao.CartDAO;

public class CartAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Cart cart;
	private List<Cart> cartList = new ArrayList<Cart>();
	private String msg;
	private String name;
	private String cond;
	private int pageCur;
	private int totalCount = 0;
	private int totalPage = 0;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createCart() {
		return SUCCESS;
	}

	public String addCart() {
		CartDAO cartDAO = new CartDAO();
		this.cart.setCartid(CreateId.getId());
		try {
			boolean result = cartDAO.saveCart(this.cart);
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

	public String deleteCart() {
		CartDAO cartDAO = new CartDAO();
		try {
			boolean result = cartDAO.deleteCart(this.cart.getCartid());
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

	public String updateCart() {
		CartDAO cartDAO = new CartDAO();
		try {
			boolean result = cartDAO.updateCart(this.cart);
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

	public String getAllCart() {
		CartDAO cartDAO = new CartDAO();
		try {
			List<Cart> list = cartDAO.queryAll();
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
			cartDAO = new CartDAO();
			this.setCartList(cartDAO.queryByPage(pageCur));
			if (this.cartList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String queryCartByCond() {
		CartDAO cartDAO = new CartDAO();
		try {
			if ("usersid".equals(this.cond)) {
				this.cartList = cartDAO.queryByLikeUsersid(this.name);
			}
			if ("goodsid".equals(this.cond)) {
				this.cartList = cartDAO.queryByLikeGoodsid(this.name);
			}
			if ("price".equals(this.cond)) {
				this.cartList = cartDAO.queryByLikePrice(this.name);
			}
			if ("num".equals(this.cond)) {
				this.cartList = cartDAO.queryByLikeNum(this.name);
			}
			if ("addtime".equals(this.cond)) {
				this.cartList = cartDAO.queryByLikeAddtime(this.name);
			}
			if (this.cartList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String getCartById() {
		CartDAO cartDAO = new CartDAO();
		try {
			this.cart = cartDAO.queryById(this.cart.getCartid());
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
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