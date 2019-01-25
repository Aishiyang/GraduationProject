package model;

public class Orders {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String ordersid;

	public String getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	private String ordercode;

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	private String usersid;

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	private String total;

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	private String addtime;

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	private String status;

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String receiver;

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	private String address;

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String contact;

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}