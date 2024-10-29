package com.tha103.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
//	驅動driver
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	mysql url
	public static final String URL = "jdbc:mysql://localhost:3306/newview?serverTimezone=Asia/Taipei";
//	db account/password
	public static final String USER = "root";
	public static final String PASSWORD = "1111";

	public static void closeResource(Connection con, PreparedStatement pstmt, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}

				if (con != null) {
					try {
						con.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}

				}
			}
		}
	}
}



