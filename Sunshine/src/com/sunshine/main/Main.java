package com.sunshine.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunshine.utility.DBUtil;

public class Main {

	public static void main(String[] args) {
		try (Connection conn = DBUtil.provideConnection()) {
			
			if (conn != null) {
				System.out.println("success");
			} else {
				System.out.println("failed");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
