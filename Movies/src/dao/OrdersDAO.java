package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Orders;

public class OrdersDAO extends BaseDao {
	private String sql = "";

	public boolean saveOrders(Orders orders) throws Exception {

		sql = "insert into orders values( ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? )";
		Object param[] = { getStringID(), orders.getOrdercode(), orders.getUsersid(), orders.getTotal(), orders.getAddtime(), orders.getStatus(),
				orders.getReceiver(), orders.getAddress(), orders.getContact() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean deleteOrders(String id) throws Exception {

		this.sql = "delete from orders where ordersid = ? ";
		Object param[] = { id };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean updateOrders(Orders orders) throws Exception {

		sql = "update orders set ordercode = ? , usersid = ? , total = ? , addtime = ? , status = ? , receiver = ? , address = ? , contact = ? where ordersid = ?";
		Object param[] = { orders.getOrdercode(), orders.getUsersid(), orders.getTotal(), orders.getAddtime(), orders.getStatus(), orders.getReceiver(),
				orders.getAddress(), orders.getContact(), orders.getOrdersid() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public List<Orders> queryAll() throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid order by a.ordersid desc ";
		mapList = select(sql, null);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByPage(int pageCur) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		this.sql = "select * from ( select a.* , c.username  from orders a , users c where a.usersid = c.usersid ) b ";
		Object param[] = { pageCur, pageCur };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByOrdercode(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.ordercode = ? order by a.ordersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByUsersid(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.usersid = ? order by a.ordersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByTotal(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.total = ? order by a.ordersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByAddtime(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.addtime = ? order by a.ordersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByStatus(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.status = ? order by a.ordersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByReceiver(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.receiver = ? order by a.ordersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByAddress(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.address = ? order by a.ordersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByContact(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.contact = ? order by a.ordersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByLikeOrdercode(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.ordercode like ? order by a.ordersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByLikeUsersid(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.usersid like ? order by a.ordersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByLikeTotal(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.total like ? order by a.ordersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByLikeAddtime(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.addtime like ? order by a.ordersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByLikeStatus(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.status like ? order by a.ordersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByLikeReceiver(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.receiver like ? order by a.ordersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByLikeAddress(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.address like ? order by a.ordersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public List<Orders> queryByLikeContact(String name) throws Exception {
		List<Orders> ordersList = new ArrayList<Orders>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.contact like ? order by a.ordersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Orders orders = new Orders();
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			ordersList.add(orders);
		}
		System.out.println(sql);
		return ordersList;
	}

	public Orders queryById(String id) throws Exception {
		Orders orders = new Orders();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.username from orders a , users b where a.usersid = b.usersid and a.ordersid = ?  ";
		Object param[] = { id };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			orders.setOrdersid("" + map.get("ordersid"));
			orders.setOrdercode("" + map.get("ordercode"));
			orders.setUsersid("" + map.get("usersid"));
			orders.setTotal("" + map.get("total"));
			orders.setAddtime("" + map.get("addtime"));
			orders.setStatus("" + map.get("status"));
			orders.setReceiver("" + map.get("receiver"));
			orders.setAddress("" + map.get("address"));
			orders.setContact("" + map.get("contact"));
			orders.setUsername("" + map.get("username"));
			System.out.println(sql);
		}
		return orders;
	}
}