package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Cate;

public class CateDAO extends BaseDao {
	private String sql = "";

	public boolean saveCate(Cate cate) throws Exception {
		sql = "insert into cate( cateid , catename) values( ? ,  ? )";
		Object param[] = { getStringID(), cate.getCatename() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean deleteCate(String id) throws Exception {
		this.sql = "delete from cate where cateid = ? ";
		Object param[] = { id };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean updateCate(Cate cate) throws Exception {
		sql = "update cate set catename = ? where cateid = ?";
		Object param[] = { cate.getCatename(), cate.getCateid() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public List<Cate> queryAll() throws Exception {
		List<Cate> cateList = new ArrayList<Cate>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from cate a order by a.cateid desc ";
		mapList = select(sql, null);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cate cate = new Cate();
			cate.setCateid("" + map.get("cateid"));
			cate.setCatename("" + map.get("catename"));
			cateList.add(cate);
		}
		System.out.println(sql);
		return cateList;
	}

	public List<Cate> queryByPage(int pageCur) throws Exception {
		List<Cate> cateList = new ArrayList<Cate>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
//		this.sql = "select * from ( select a.* , rownum as a_rownum  from cate a where rownum<=( ? * 10 )) b where b.a_rownum>( ? - 1 )*10";
		this.sql = "select * from ( select a.* from cate a) b";
		Object param[] = { pageCur, pageCur };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cate cate = new Cate();
			cate.setCateid("" + map.get("cateid"));
			cate.setCatename("" + map.get("catename"));
			cateList.add(cate);
		}
		System.out.println(sql);
		return cateList;
	}

	public List<Cate> queryByCatename(String name) throws Exception {
		List<Cate> cateList = new ArrayList<Cate>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from cate  a where a.catename = ? order by a.cateid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cate cate = new Cate();
			cate.setCateid("" + map.get("cateid"));
			cate.setCatename("" + map.get("catename"));
			cateList.add(cate);
		}
		System.out.println(sql);
		return cateList;
	}

	public List<Cate> queryByLikeCatename(String name) throws Exception {
		List<Cate> cateList = new ArrayList<Cate>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from cate  a where a.catename like ? order by a.cateid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Cate cate = new Cate();
			cate.setCateid("" + map.get("cateid"));
			cate.setCatename("" + map.get("catename"));
			cateList.add(cate);
		}
		System.out.println(sql);
		return cateList;
	}

	public Cate queryById(String id) throws Exception {
		Cate cate = new Cate();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from cate  a where a.cateid = ?  ";
		Object param[] = { id };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			cate.setCateid("" + map.get("cateid"));
			cate.setCatename("" + map.get("catename"));
		}
		System.out.println(sql);
		return cate;
	}
}