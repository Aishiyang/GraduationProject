package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Admin;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminDAO;

public class AdminAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Admin admin;
	private List<Admin> adminList = new ArrayList<Admin>();
	private String msg;
	private String name;
	private String cond;
	private int pageCur;
	private int totalCount = 0;
	private int totalPage = 0;
	private Map<String, Object> session;
	private Map<String, Object> map = new HashMap<String, Object>();

	public String createAdmin() {
		return SUCCESS;
	}

	public String login() {
		AdminDAO adminDAO = new AdminDAO();
		try {
			List<Admin> list = adminDAO.queryByUsername(admin.getUsername());
			if (list.size() == 0) {
				this.msg = "用户名不存在";
			} else {
				Admin a = list.get(0);
				if (!a.getPassword().equals(this.admin.getPassword())) {
					this.msg = "密码错误";
				} else {
					session.put("adminid", a.getAdminid());
					session.put("admin", a);
					return "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "adminfail";
		}
		return "adminfail";
	}

	public String addAdmin() {
		AdminDAO adminDAO = new AdminDAO();
		try {
			boolean result = adminDAO.saveAdmin(this.admin);
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

	public String deleteAdmin() {
		AdminDAO adminDAO = new AdminDAO();
		try {
			boolean result = adminDAO.deleteAdmin(this.admin.getAdminid());
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

	public String updateAdmin() {
		AdminDAO adminDAO = new AdminDAO();
		try {
			boolean result = adminDAO.updateAdmin(this.admin);
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

	public String getAllAdmin() {
		AdminDAO adminDAO = new AdminDAO();
		try {
			List<Admin> list = adminDAO.queryAll();
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
			adminDAO = new AdminDAO();
			this.setAdminList(adminDAO.queryByPage(pageCur));
			if (this.adminList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String queryAdminByCond() {
		AdminDAO adminDAO = new AdminDAO();
		try {
			if ("username".equals(this.cond)) {
				this.adminList = adminDAO.queryByLikeUsername(this.name);
			}
			if ("password".equals(this.cond)) {
				this.adminList = adminDAO.queryByLikePassword(this.name);
			}
			if ("realname".equals(this.cond)) {
				this.adminList = adminDAO.queryByLikeRealname(this.name);
			}
			if ("contact".equals(this.cond)) {
				this.adminList = adminDAO.queryByLikeContact(this.name);
			}
			if (this.adminList.size() == 0) {
				this.msg = "没有查询到数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public String getAdminById() {
		AdminDAO adminDAO = new AdminDAO();
		try {
			this.admin = adminDAO.queryById(this.admin.getAdminid());
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}