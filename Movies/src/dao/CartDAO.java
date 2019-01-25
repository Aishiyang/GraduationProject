package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Cart;

public class CartDAO extends BaseDao {
	private String sql = "";

	public boolean saveCart(Cart cart) throws Exception {
		sql = "insert into cart( cartid , usersid , goodsid , price , num , addtime) values( ? ,  ? ,  ? ,  ? ,  ? ,  ? )";
		Object param[] = { getStringID(), cart.getUsersid(), cart.getGoodsid(), cart.getPrice(), cart.getNum(), cart.getAddtime() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean deleteCart(String id) throws Exception {
		this.sql = "delete from cart where cartid = ? ";
		Object param[] = { id };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean updateCart(Cart cart) throws Exception {
		sql = "update cart set usersid = ? , goodsid = ? , price = ? , num = ? , addtime = ? where cartid = ?";
		Object param[] = { cart.getUsersid(), cart.getGoodsid(), cart.getPrice(), cart.getNum(), cart.getAddtime(), cart.getCartid() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public List<Cart> queryAll() throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid order by a.cartid desc ";
		mapList = select(sql, null);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByPage(int pageCur) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		this.sql = "select * from ( select a.* from cart a ) b ";
		Object param[] = { pageCur, pageCur };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByUsersid(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.usersid = ? order by a.cartid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByGoodsid(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.goodsid = ? order by a.cartid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByPrice(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.price = ? order by a.cartid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByNum(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.num = ? order by a.cartid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByAddtime(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.addtime = ? order by a.cartid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByLikeUsersid(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.usersid like ? order by a.cartid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByLikeGoodsid(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.goodsid like ? order by a.cartid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByLikePrice(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.price like ? order by a.cartid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByLikeNum(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.num like ? order by a.cartid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public List<Cart> queryByLikeAddtime(String name) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.addtime like ? order by a.cartid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cart cart = new Cart();
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
			cartList.add(cart);
		}
		System.out.println(sql);
		return cartList;
	}

	public Cart queryById(String id) throws Exception {
		Cart cart = new Cart();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from cart a , goods b where a.goodsid = b.goodsid and a.cartid = ?  ";
		Object param[] = { id };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			cart.setCartid("" + map.get("cartid"));
			cart.setUsersid("" + map.get("usersid"));
			cart.setGoodsid("" + map.get("goodsid"));
			cart.setPrice("" + map.get("price"));
			cart.setNum("" + map.get("num"));
			cart.setAddtime("" + map.get("addtime"));
			cart.setGoodsname("" + map.get("goodsname"));
			cart.setImage("" + map.get("image"));
		}
		System.out.println(sql);
		return cart;
	}
}