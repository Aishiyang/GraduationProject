package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cart;
import model.Cate;
import model.Details;
import model.Goods;
import model.Orders;
import model.Users;

import org.apache.struts2.interceptor.SessionAware;

import util.CreateId;

import com.opensymphony.xwork2.ActionSupport;

import dao.CartDAO;
import dao.CateDAO;
import dao.DetailsDAO;
import dao.GoodsDAO;
import dao.OrdersDAO;
import dao.UsersDAO;

public class IndexAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String id;
	private String msg;
	private String name;
	private String cond;
	private String num;
	private String username;
	private String password;
	private String repassword;
	private String newpassword;
	private String title;
	private String code;
	private int pageCur;
	private int totalCount = 0;
	private int totalPage = 0;
	private Users users;
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String, Object> session;

	public IndexAction() {
		this.title = "淘票票网站";
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			List<Goods> recommendList = goodsDAO.recommend();
			CateDAO cateDAO = new CateDAO();
			List<Cate> cateList = cateDAO.queryAll();
			this.map.put("cateList", cateList);
			this.map.put("recommendList", recommendList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String index() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			List<Goods> hotList = goodsDAO.hot();
			List<Goods> newsList = goodsDAO.news();
			this.map.put("newsList", newsList);
			this.map.put("hotList", hotList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String cate() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			List<Goods> goodsList = goodsDAO.queryByCateid(this.id);
			this.map.put("goodsList", goodsList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String query() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			List<Goods> goodsList = goodsDAO.queryByLikeGoodsname(name);
			this.map.put("goodsList", goodsList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String recommend() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			List<Goods> goodsList = goodsDAO.queryByRecommend("是");
			this.map.put("goodsList", goodsList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String special() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			List<Goods> goodsList = goodsDAO.queryBySpecial("是");
			this.map.put("goodsList", goodsList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String all() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			List<Goods> goodsList = goodsDAO.queryAll();
			this.map.put("goodsList", goodsList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String detail() {
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			Goods goods = goodsDAO.queryById(this.id);
			this.map.put("goods", goods);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String addcart() {
		String userid = (String) this.session.get("userid");
		CartDAO cartDAO = new CartDAO();
		GoodsDAO goodsDAO = new GoodsDAO();
		try {
			Goods goods = goodsDAO.queryById(this.id);
			Cart cart = new Cart();
			cart.setAddtime(CreateId.getStringDateShort());
			cart.setGoodsid(goods.getGoodsid());
			cart.setNum(this.msg);
			cart.setPrice(goods.getPrice());
			cart.setUsersid(userid);
			cartDAO.saveCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String showcart() {
		double total = 0;
		String userid = (String) this.session.get("userid");
		CartDAO cartDAO = new CartDAO();
		try {
			List<Cart> cartList = cartDAO.queryByUsersid(userid);
			for (Cart cart : cartList) {
				total += Double.parseDouble(cart.getNum()) * Double.parseDouble(cart.getPrice());
			}
			this.map.put("total", total);
			this.map.put("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String deletecart() {
		CartDAO cartDAO = new CartDAO();
		try {
			cartDAO.deleteCart(this.id);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String preCheckout() {
		String userid = (String) this.session.get("userid");
		CartDAO cartDAO = new CartDAO();
		try {
			List<Cart> cartList = cartDAO.queryByUsersid(userid);
			if (cartList.size() == 0) {
				return "cfail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String checkOut() {
		String userid = (String) this.session.get("userid");
		CartDAO cartDAO = new CartDAO();
		try {
			List<Cart> cartList = cartDAO.queryByUsersid(userid);
			String ordercode = CreateId.getStringDatex();
			double total = 0;
			for (Cart cart : cartList) {
				Details details = new Details();
				details.setGoodsid(cart.getGoodsid());
				details.setNum(cart.getNum());
				details.setOrdercode(ordercode);
				details.setPrice(cart.getPrice());
				total += Double.parseDouble(cart.getNum()) * Double.parseDouble(cart.getPrice());
				DetailsDAO detailsDAO = new DetailsDAO();
				detailsDAO.saveDetails(details);
				GoodsDAO goodsDAO = new GoodsDAO();
				Goods goods = goodsDAO.queryById(cart.getGoodsid());
				goods.setNum("" + (Integer.parseInt(goods.getNum()) - Integer.parseInt(cart.getNum())));
				goods.setSellnum("" + (Integer.parseInt(goods.getSellnum()) + Integer.parseInt(cart.getNum())));
				goodsDAO = new GoodsDAO();
				goodsDAO.updateGoods(goods);
				cartDAO = new CartDAO();
				cartDAO.deleteCart(cart.getCartid());
			}
			OrdersDAO ordersDAO = new OrdersDAO();
			Orders orders = new Orders();
			orders.setAddtime(CreateId.getStringDateShort());
			orders.setOrdercode(ordercode);
			orders.setStatus("已预订");
			orders.setTotal("" + total);
			orders.setAddress(cond);
			orders.setContact(msg);
			orders.setReceiver(name);
			orders.setUsersid(userid);
			ordersDAO.saveOrders(orders);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String showOrders() {
		OrdersDAO ordersDAO = new OrdersDAO();
		String userid = (String) session.get("userid");
		try {
			List<Orders> orderList = ordersDAO.queryByUsersid(userid);
			this.map.put("orderList", orderList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String orderdetail() {
		DetailsDAO detailsDAO = new DetailsDAO();
		try {
			List<Details> detailList = detailsDAO.queryByOrdercode(this.id);
			this.map.put("detailList", detailList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String preLogin() {
		return SUCCESS;
	}

	public String preRegist() {
		return SUCCESS;
	}

	public String prePwd() {
		return SUCCESS;
	}

	public String login() {
		UsersDAO usersDAO = new UsersDAO();
		String checkCode = (String) session.get("checkCode");
		if (!checkCode.equals(this.code)) {
			this.msg = "验证码错误";
		} else {
			try {
				List<Users> usersList = usersDAO.queryByUsername(this.username);
				if (usersList.size() == 0) {
					this.msg = "用户名不存在";
				} else {
					Users u = usersList.get(0);
					if (u.getPassword().equals(this.password)) {
						this.session.put("userid", u.getUsersid());
						this.session.put("users", u);
						this.session.put("username", username);
						this.session.put("login", u.getUsersid());
						return "user";
					} else {
						this.msg = "密码错误";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "fail";
			}
		}
		return "fail";
	}

	public String regist() {
		UsersDAO usersDAO = new UsersDAO();
		try {
			List<Users> usersList = usersDAO.queryByUsername(this.users.getUsername());
			if (usersList.size() != 0) {
				this.msg = "用户名已存在";
				return "fail";
			} else {
				usersDAO = new UsersDAO();
				usersDAO.saveUsers(users);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String editPwd() {
		try {
			String userid = (String) session.get("userid");
			UsersDAO usersDAO = new UsersDAO();
			Users u = usersDAO.queryById(userid);
			u.setPassword(repassword);
			usersDAO = new UsersDAO();
			usersDAO.updateUsers(u);
			session.put("users", u);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String personal() {
		UsersDAO usersDAO = new UsersDAO();
		try {
			usersDAO.updateUsers(this.users);
			session.put("users", this.users);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String AdminCenter() {
		return SUCCESS;
	}

	public String UserCenter() {
		return SUCCESS;
	}

	public String exit() {
		this.session.clear();
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
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

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
