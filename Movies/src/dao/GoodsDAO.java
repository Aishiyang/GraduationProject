package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Goods;

public class GoodsDAO extends BaseDao {
	private String sql = "";
	public boolean saveGoods(Goods goods) throws Exception {
		sql = "insert into goods( goodsid , goodsname , image , cateid , price , recommend , special , num , sellnum , contents  , countries  )"
				+ " values( ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? )";
		Object param[] = { getStringID(), goods.getGoodsname(), goods.getImage(), goods.getCateid(), goods.getPrice(), goods.getRecommend(),
				goods.getSpecial(), goods.getNum(), goods.getSellnum(), goods.getContents(),  goods.getCountries() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean deleteGoods(String id) throws Exception {
		this.sql = "delete from goods where goodsid = ? ";
		Object param[] = { id };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean updateGoods(Goods goods) throws Exception {
		sql = "update goods set num = ? , sellnum = ?  where goodsid = ?";
		Object param[] = { 
				goods.getNum(), goods.getSellnum() ,goods.getGoodsid() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public List<Goods> queryAll() throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid order by a.goodsid desc ";
		mapList = select(sql, null);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));

			goods.setCountries("" + map.get("countries"));
		
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> hot() throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

//		sql = "select rownum , a.* , b.catename from goods a , cate b where a.cateid = b.cateid and rownum < 6 order by a.sellnum desc ";
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid order by a.sellnum desc ";
		mapList = select(sql, null);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> news() throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

//		sql = "select rownum , a.* , b.catename from goods a , cate b where a.cateid = b.cateid and rownum < 6 order by a.goodsid desc ";
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid order by a.goodsid desc ";
		mapList = select(sql, null);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
		
			goods.setCountries("" + map.get("countries"));
		
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> recommend() throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

//		sql = "select rownum , a.* , b.catename from goods a , cate b where a.cateid = b.cateid and recommend = '是' and rownum < 6 order by a.goodsid desc ";
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and recommend = '是' order by a.goodsid desc ";
		
		mapList = select(sql, null);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
		
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByPage(int pageCur) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		this.sql = "select * from ( select a.* , c.catename  from goods a , cate c where a.cateid = c.cateid "
				+ ") b";
		Object param[] = { pageCur, pageCur };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByGoodsname(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.goodsname = ? order by a.goodsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
	
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByImage(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.image = ? order by a.goodsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByCateid(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.cateid = ? order by a.goodsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByPrice(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.price = ? order by a.goodsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByRecommend(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.recommend = ? order by a.goodsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryBySpecial(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.special = ? order by a.goodsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByNum(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.num = ? order by a.goodsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryBySellnum(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.sellnum = ? order by a.goodsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByContents(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.contents = ? order by a.goodsid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByLikeGoodsname(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.goodsname like ? order by a.goodsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByLikeImage(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.image like ? order by a.goodsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByLikeCateid(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.cateid like ? order by a.goodsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByLikePrice(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.price like ? order by a.goodsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByLikeRecommend(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.recommend like ? order by a.goodsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByLikeSpecial(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.special like ? order by a.goodsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByLikeNum(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.num like ? order by a.goodsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByLikeSellnum(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.sellnum like ? order by a.goodsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public List<Goods> queryByLikeContents(String name) throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.contents like ? order by a.goodsid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Goods goods = new Goods();
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			goodsList.add(goods);
		}
		System.out.println(sql);
		return goodsList;
	}

	public Goods queryById(String id) throws Exception {
		Goods goods = new Goods();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* , b.catename from goods a , cate b where a.cateid = b.cateid and a.goodsid = ?  ";
		Object param[] = { id };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			goods.setGoodsid("" + map.get("goodsid"));
			goods.setGoodsname("" + map.get("goodsname"));
			goods.setImage("" + map.get("image"));
			goods.setCateid("" + map.get("cateid"));
			goods.setPrice("" + map.get("price"));
			goods.setRecommend("" + map.get("recommend"));
			goods.setSpecial("" + map.get("special"));
			goods.setNum("" + map.get("num"));
			goods.setSellnum("" + map.get("sellnum"));
			goods.setContents("" + map.get("contents"));
			goods.setCatename("" + map.get("catename"));
			
			goods.setCountries("" + map.get("countries"));
			
			System.out.println(sql);
		}
		return goods;
	}
}