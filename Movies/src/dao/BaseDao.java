package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BaseDao {
	// list连接池
	static ArrayList<Connection> list = new ArrayList<Connection>();

	/**
	 * 从连接池中获得一个连接
	 */
	public synchronized static Connection getConnection() throws Exception {
		Connection con = null;
		// 如果连接池> 0有连接
		if (list.size() > 0) {
			return list.remove(0);// 从容器中得到元素再删除
		}
		// 连接池中没有连接
		else {
			Properties p = new Properties();// 属性类固定写法
			// 加载配置文件
			p.load(BaseDao.class.getClassLoader().getResourceAsStream("dao/jdbc.properties"));
			String driverClass = p.getProperty("jdbc.driverClass");
			String jdbcUrl = p.getProperty("jdbc.jdbcUrl");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");
			// 加载驱动
			Class.forName(driverClass);
			// 和指定的数据库建立连接
			for (int i = 0; i < 10; i++) {
				con = DriverManager.getConnection(jdbcUrl, username, password);
				list.add(con);
			}
		}
		return list.remove(0);
	}

	/**
	 * 关闭结果集
	 * 
	 * @param rs代表结果集
	 */
	public static void close(ResultSet rs) throws Exception {
		if (rs != null)
			rs.close();
	}

	/**
	 * 关闭预处理对象
	 * 
	 * @param pst代表预处理
	 */
	public static void close(PreparedStatement pst) throws Exception {
		if (pst != null)
			pst.close();
	}

	/**
	 * 关闭连接对象
	 * 
	 * @param con代表连接对象
	 */
	public synchronized static void close(Connection con) {
		if (con != null)
			list.add(con);
	}

	/**
	 * 关闭结果集，预处理，连接等对象
	 * 
	 * @param rs
	 *            结果集
	 * @param ps
	 *            预处理
	 * @param con
	 *            连接
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) throws Exception {
		close(rs);
		close(ps);
		close(con);
	}

	/**
	 * 根据SQL语句，进行insert，update，delete等操作
	 * 
	 * @param sql
	 * @param param代表SQL语句里面的通配符
	 *            （？）对应的值，一定注意顺序
	 * @return Object 可以传入通配符值，可以各种类型，赋值setObject
	 */
	public boolean updateByParams(String sql, Object param[]) throws Exception {
		boolean flag = false;
		Connection con = getConnection();
		PreparedStatement ps = null;
		ps = con.prepareStatement(sql);
		// 替换参数?
		if (param != null) {
			for (int i = 1; i <= param.length; i++) {
				ps.setObject(i, param[i - 1]);
			}
		}
		int n = ps.executeUpdate();
		if (n > 0)
			flag = true;
		close(null, ps, con);
		return flag;
	}

	/**
	 * 批量进行insert，update，delete等操作
	 * 
	 * @param sql
	 * @param param
	 * @return
	 */
	public boolean BatchUpdateByParams(String sql, Object param[][]) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ps = con.prepareStatement(sql);
		// 替换参数?
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				for (int j = 1; j <= param[i].length; j++) {
					ps.setObject(j, param[i][j - 1]);
				}
				ps.addBatch();
			}
			ps.executeBatch();
		}
		close(null, ps, con);
		return true;
	}

	/**
	 * 查询操作
	 * 
	 * @param sql
	 * @param param
	 * @return List<Map<String, Object>>，map的key是查询的列名（小写）或别名，map的value是每列对应的值
	 */
	public static List<Map<String, Object>> select(String sql, Object[] param) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ps = con.prepareStatement(sql);
		// 替换参数?
		if (param != null) {
			for (int i = 1; i <= param.length; i++) {
				ps.setObject(i, param[i - 1]);
			}
		}
		rs = ps.executeQuery();// 执行查询
		ResultSetMetaData rm = rs.getMetaData();// 得到元数据列名，元素值，列数
		// 获得结果集列的总数
		int count = rm.getColumnCount();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 1; i <= count; i++) {
				// key是列名，并且是小写的toLowerCase()小写方法；value是根据列名获得某条记录对应的值getObject取任意类型的值
				map.put(rm.getColumnName(i).toLowerCase(), rs.getObject(rm.getColumnName(i)));
			}
			list.add(map);
		}
		close(rs, ps, con);
		return list;
	}

	/**
	 * 获得一个以时间字符串为标准的ID，固定长度是17位
	 * 
	 * @return
	 */
	public static String getStringID() {
		String id = null;
		Date date = new Date();// 系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		id = sdf.format(date);
		return id;
	}
}
