package com.jxdedu.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0DBUtil {
	private static ComboPooledDataSource ds = null;
	//当类被加载的时候，就把数据库链接池创建出来
	static{
		ds = new ComboPooledDataSource();
	}
	/**
	 * 从池中拿一个链接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	/**
	 * 把链接还回池中
	 * 
	 * @Description:@param conn 数据库连接
	 * @Description:@param st 执行sql的对象
	 * @Description:@param rs 执行结果
	 */
	public static void closeAll(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {// 如果结果集非空，关闭资源
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (st != null) {// 执行sql对象非空，关闭资源
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try{
			if (conn != null){// 连接对象非空，关闭资源
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
