package packg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;

public class TempData {

	/**
	 * String url =
	 * "jdbc:mysql://localhost:3306/databack?rewriteBatchedStatements=true";
	 * String driver = "com.mysql.jdbc.Driver"; String userName = "root"; String
	 * password = "root";
	 */
	public static void main(String[] args) {
		/*
		 * String url =
		 * "jdbc:mysql://192.168.153.60:3306/?rewriteBatchedStatements=true"; String
		 * dbName = "freedataback"; String driver = "com.mysql.jdbc.Driver"; String
		 * userName = "admin"; String password = "=/&q![3A";
		 * 
		 * String replica = "jdbc:mysql://192.168.153.58:3306/"; String rUserName =
		 * "dbselectuser"; String rPassword = "db123456user1234";
		 */

		String url = "jdbc:mysql://localhost:3306/databack?rewriteBatchedStatements=true";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url, userName, password);
			// Connection conn = DriverManager.getConnection(replica, rUserName,
			// rPassword);
			PreparedStatement selectEarn = conn.prepareStatement(
					"SELECT `customer_id`,`campaign_id`,`initial_wifi_data`,`initial_mobile_data`,`wifi_data_earned`,`mobile_data_earned`,`user_campaign_total`,`created`,DATE(`created`),`modified` "
							+ "FROM earning_history "
							+ "WHERE `created` BETWEEN '2016-03-01 00:00:00' AND '2016-03-31 23:59:59' LIMIT ?, 5000");
			PreparedStatement insertTemp = conn.prepareStatement("INSERT INTO temp_table (" + "`customer_id`,"
					+ "`campaign_id`," + "`initial_wifi_data`," + "`initial_mobile_data`," + "`wifi_data_earned`,"
					+ "`mobile_data_earned`," + "`user_campaign_total`," + "`created`," + "`cdate`,"
					+ "`modified`) VALUES  (?,?,?,?,?,?,?,?,?,?)");
			conn.setAutoCommit(false);
			ResultSet rs = null;
			int countj = 0;
			int duplicate = 0;
			for (int i = 0; i < 1700; i++) {
				System.out.println(countj);
				selectEarn.setInt(1, countj);
				rs = selectEarn.executeQuery();
				rs.last();
				int totalRecords = rs.getRow();
				if (totalRecords == 0) {
					break;
				}
				int count = 0;
				rs.beforeFirst();
				System.out.println(totalRecords);
				while (rs.next()) {
					countj++;
					Format formatter = new SimpleDateFormat("yy-MM-dd");
					String cdata = formatter.format(rs.getDate("created"));
					insertTemp.setInt(1, rs.getInt("customer_id"));
					insertTemp.setInt(2, rs.getInt("campaign_id"));
					insertTemp.setInt(3, rs.getInt("initial_wifi_data"));
					insertTemp.setInt(4, rs.getInt("initial_mobile_data"));
					insertTemp.setInt(5, rs.getInt("wifi_data_earned"));
					insertTemp.setInt(6, rs.getInt("mobile_data_earned"));
					insertTemp.setInt(7, rs.getInt("user_campaign_total"));
					insertTemp.setTimestamp(8, rs.getTimestamp("created"));
					insertTemp.setString(9, cdata);
					insertTemp.setTimestamp(10, rs.getTimestamp("modified"));
					insertTemp.addBatch();
					try {
						if (count % 1000 == 0)
							insertTemp.executeBatch();

					} catch (SQLException ex) {
						duplicate++;
					}
					count++;
				}
				insertTemp.executeBatch();
				conn.commit();
				System.out.println(duplicate);
			}
			rs.close();
			selectEarn.close();
			insertTemp.close();
			conn.close();
			conn.close();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}
	}
}
