package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Users;

public class UsersDAO extends BaseDao {
	private String sql = "";

	public boolean saveUsers(Users users) throws Exception {
		sql = "insert into users values( ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ?  )";
		Object param[] = { getStringID(), users.getUsername(), users.getPassword(), users.getRealname(), users.getSex(), users.getBirthday(),
				users.getContact(), users.getAddress(), users.getEmail() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean deleteUsers(String id) throws Exception {
		this.sql = "delete from users where usersid = ? ";
		Object param[] = { id };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public boolean updateUsers(Users users) throws Exception {
		sql = "update users set username = ? , password = ? , realname = ? , sex = ? , birthday = ? , contact = ? , address = ? , email = ?  where usersid = ?";
		Object param[] = { users.getUsername(), users.getPassword(), users.getRealname(), users.getSex(), users.getBirthday(), users.getContact(),
				users.getAddress(), users.getEmail(), users.getUsersid() };
		System.out.println(sql);
		return updateByParams(sql, param);
	}

	public List<Users> queryAll() throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* from users a order by a.usersid desc ";
		mapList = select(sql, null);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByPage(int pageCur) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
//		this.sql = "select * from ( select a.* , rownum as a_rownum  from users a where rownum<=( ? * 10 )) b where b.a_rownum>( ? - 1 )*10";
		this.sql = "select * from ( select a.* from users a) b";
		Object param[] = { pageCur, pageCur };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByUsername(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.username = ? order by a.usersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByPassword(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.password = ? order by a.usersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByRealname(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.realname = ? order by a.usersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryBySex(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.sex = ? order by a.usersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByBirthday(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.birthday = ? order by a.usersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByContact(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.contact = ? order by a.usersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByAddress(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.address = ? order by a.usersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByEmail(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* from users  a where a.email = ? order by a.usersid desc ";
		Object param[] = { name };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));

			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByLikeUsername(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.username like ? order by a.usersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByLikePassword(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* from users  a where a.password like ? order by a.usersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByLikeRealname(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* from users  a where a.realname like ? order by a.usersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByLikeSex(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.sex like ? order by a.usersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByLikeBirthday(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* from users  a where a.birthday like ? order by a.usersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByLikeContact(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* from users  a where a.contact like ? order by a.usersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByLikeAddress(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.address like ? order by a.usersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public List<Users> queryByLikeEmail(String name) throws Exception {
		List<Users> usersList = new ArrayList<Users>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		sql = "select a.* from users  a where a.email like ? order by a.usersid desc ";
		Object param[] = { "%" + name + "%" };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			Users users = new Users();
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			usersList.add(users);
		}
		System.out.println(sql);
		return usersList;
	}

	public Users queryById(String id) throws Exception {
		Users users = new Users();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		sql = "select a.* from users  a where a.usersid = ?  ";
		Object param[] = { id };
		mapList = select(sql, param);
		for (int i = 0; i < mapList.size(); i++) {
			Map<String, Object> map = mapList.get(i);
			users.setUsersid("" + map.get("usersid"));
			users.setUsername("" + map.get("username"));
			users.setPassword("" + map.get("password"));
			users.setRealname("" + map.get("realname"));
			users.setSex("" + map.get("sex"));
			users.setBirthday("" + map.get("birthday"));
			users.setContact("" + map.get("contact"));
			users.setAddress("" + map.get("address"));
			users.setEmail("" + map.get("email"));
			System.out.println(sql);
		}
		return users;
	}
}