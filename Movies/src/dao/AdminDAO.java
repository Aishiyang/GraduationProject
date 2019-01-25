package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Admin;

public class AdminDAO extends BaseDao {
	private String sql = "";

	public boolean saveAdmin(Admin admin) throws Exception {
		sql = "insert into admin( adminid , username , password , realname , contact) values( ? ,  ? ,  ? ,  ? ,  ? )";
		Object param[] = { getStringID(), admin.getUsername(), admin.getPassword(), admin.getRealname(), admin.getContact() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean deleteAdmin(String id) throws Exception {
		this.sql = "delete from admin where adminid = ? ";
		Object param[] = { id };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean updateAdmin(Admin admin) throws Exception {

		sql = "update admin set username = ? , password = ? , realname = ? , contact = ? where adminid = ?";
		Object param[] = { admin.getUsername(), admin.getPassword(), admin.getRealname(), admin.getContact(), admin.getAdminid() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public List<Admin> queryAll() throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

		sql = "select a.* from admin a order by a.adminid desc ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = {};
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public List<Admin> queryByPage(int pageCur) throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

//		this.sql = "select * from ( select a.* , rownum as a_rownum  from admin a where rownum<=( ? * 10 )) b where b.a_rownum>( ? - 1 )*10";
		this.sql = "select * from ( select a.* from admin a) b";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { pageCur, pageCur };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public List<Admin> queryByUsername(String name) throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

		sql = "select a.* from admin  a where a.username = ? order by a.adminid desc ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public List<Admin> queryByPassword(String name) throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

		sql = "select a.* from admin  a where a.password = ? order by a.adminid desc ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public List<Admin> queryByRealname(String name) throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

		sql = "select a.* from admin  a where a.realname = ? order by a.adminid desc ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public List<Admin> queryByContact(String name) throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

		sql = "select a.* from admin  a where a.contact = ? order by a.adminid desc ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public List<Admin> queryByLikeUsername(String name) throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

		sql = "select a.* from admin  a where a.username like ? order by a.adminid desc ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public List<Admin> queryByLikePassword(String name) throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

		sql = "select a.* from admin  a where a.password like ? order by a.adminid desc ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public List<Admin> queryByLikeRealname(String name) throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

		sql = "select a.* from admin  a where a.realname like ? order by a.adminid desc ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public List<Admin> queryByLikeContact(String name) throws Exception {
		List<Admin> adminList = new ArrayList<Admin>();

		sql = "select a.* from admin  a where a.contact like ? order by a.adminid desc ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Admin admin = new Admin();
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			adminList.add(admin);
		}
		System.out.println(sql);
		return adminList;
	}

	public Admin queryById(String id) throws Exception {
		Admin admin = new Admin();

		sql = "select a.* from admin  a where a.adminid = ?  ";
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Object param[] = { id };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			admin.setAdminid("" + map.get("adminid"));
			admin.setUsername("" + map.get("username"));
			admin.setPassword("" + map.get("password"));
			admin.setRealname("" + map.get("realname"));
			admin.setContact("" + map.get("contact"));
			System.out.println(sql);
		}
		return admin;
	}
}