package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Users;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UsersDAO;

public class UsersAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Users users;
	private List<Users> usersList = new ArrayList<Users>();
	private String msg;
	private String name;
	private String cond;
	private int pageCur;
	private int totalCount = 0;
	private int totalPage = 0;
	private Map<String, Object> map = new HashMap<String, Object>();
	private Map<String, Object> session;

	public String login() {
		UsersDAO usersDAO = new UsersDAO();
		try {
			List<Users> usersList = usersDAO.queryByUsername(this.users.getUsername());
			if (usersList.size() == 0) {
				this.msg = "用户名不存在";
			} else {
				Users u = usersList.get(0);
				if (u.getPassword().equals(this.users.getPassword())) {
					if ("管理员".equals(u.getRole())) {
						this.session.put("adminid", u.getUsersid());
						this.session.put("admin", u);
						this.session.put("username", this.users.getUsername());
						// this.session.put("login", u.getUsersid());
						return SUCCESS;
					} else {
						return "fail";
					}
				} else {
					this.msg = "密码错误";
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	public String createUsers() {
		return SUCCESS;
	}

	public String addUsers() {
		UsersDAO usersDAO = new UsersDAO();
		try {
			boolean result = usersDAO.saveUsers(this.users);
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

	public String deleteUsers() {
		UsersDAO usersDAO = new UsersDAO();
		try {
			boolean result = usersDAO.deleteUsers(this.users.getUsersid());
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

	public String updateUsers() {
		UsersDAO usersDAO = new UsersDAO();
		try {
			boolean result = usersDAO.updateUsers(this.users);
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

	public String getAllUsers() {
		UsersDAO usersDAO = new UsersDAO();
		try {
			List<Users> list = usersDAO.queryAll();
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
			usersDAO = new UsersDAO();
			this.setUsersList(usersDAO.queryByPage(pageCur));
			if (this.usersList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String queryUsersByCond() {
		UsersDAO usersDAO = new UsersDAO();
		try {
			if ("username".equals(this.cond)) {
				this.usersList = usersDAO.queryByLikeUsername(this.name);
			}
			if ("password".equals(this.cond)) {
				this.usersList = usersDAO.queryByLikePassword(this.name);
			}
			if ("realname".equals(this.cond)) {
				this.usersList = usersDAO.queryByLikeRealname(this.name);
			}
			if ("sex".equals(this.cond)) {
				this.usersList = usersDAO.queryByLikeSex(this.name);
			}
			if ("birthday".equals(this.cond)) {
				this.usersList = usersDAO.queryByLikeBirthday(this.name);
			}
			if ("contact".equals(this.cond)) {
				this.usersList = usersDAO.queryByLikeContact(this.name);
			}
			if ("address".equals(this.cond)) {
				this.usersList = usersDAO.queryByLikeAddress(this.name);
			}
			if ("email".equals(this.cond)) {
				this.usersList = usersDAO.queryByLikeEmail(this.name);
			}
			if (this.usersList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String getUsersById() {
		UsersDAO usersDAO = new UsersDAO();
		try {
			this.users = usersDAO.queryById(this.users.getUsersid());
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}