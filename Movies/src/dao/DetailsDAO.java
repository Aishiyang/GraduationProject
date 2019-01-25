package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Details;

public class DetailsDAO extends BaseDao {
	private String sql = "";

	public boolean saveDetails(Details details) throws Exception {

		sql = "insert into details( detailsid , ordercode , goodsid , num , price) values( ? ,  ? ,  ? ,  ? ,  ? )";
		Object param[] = { getStringID(), details.getOrdercode(), details.getGoodsid(), details.getNum(), details.getPrice() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean deleteDetails(String id) throws Exception {

		this.sql = "delete from details where detailsid = ? ";
		Object param[] = { id };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean updateDetails(Details details) throws Exception {

		sql = "update details set ordercode = ? , goodsid = ? , num = ? , price = ? where detailsid = ?";
		Object param[] = { details.getOrdercode(), details.getGoodsid(), details.getNum(), details.getPrice(), details.getDetailsid() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public List<Details> queryAll() throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid order by a.detailsid desc ";
		mapList = select(sql, null);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public List<Details> queryByPage(int pageCur) throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		this.sql = "select * from ( select a.* from details a ) b ";
		Object param[] = { pageCur, pageCur };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public List<Details> queryByOrdercode(String name) throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid and a.ordercode = ? order by a.detailsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public List<Details> queryByGoodsid(String name) throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid and a.goodsid = ? order by a.detailsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public List<Details> queryByNum(String name) throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid and a.num = ? order by a.detailsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public List<Details> queryByPrice(String name) throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid and a.price = ? order by a.detailsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public List<Details> queryByLikeOrdercode(String name) throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid and a.ordercode like ? order by a.detailsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public List<Details> queryByLikeGoodsid(String name) throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid and a.goodsid like ? order by a.detailsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public List<Details> queryByLikeNum(String name) throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid and a.num like ? order by a.detailsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public List<Details> queryByLikePrice(String name) throws Exception {
		List<Details> detailsList = new ArrayList<Details>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid and a.price like ? order by a.detailsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Details details = new Details();
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));
			detailsList.add(details);
		}
		System.out.println(sql);
		return detailsList;
	}

	public Details queryById(String id) throws Exception {
		Details details = new Details();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.goodsname , b.image from details a , goods b where a.goodsid = b.goodsid and a.detailsid = ?  ";
		Object param[] = { id };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			details.setDetailsid("" + map.get("detailsid"));
			details.setOrdercode("" + map.get("ordercode"));
			details.setGoodsid("" + map.get("goodsid"));
			details.setNum("" + map.get("num"));
			details.setPrice("" + map.get("price"));
			details.setGoodsname("" + map.get("goodsname"));
			details.setImage("" + map.get("image"));

		}
		System.out.println(sql);
		return details;
	}
}