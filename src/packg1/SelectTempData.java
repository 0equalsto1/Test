package packg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTempData {
	private static String url = "jdbc:mysql://103.248.82.13:3306/freedataback";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String userName = "databack_staging";
	private static String password = "databack1234staging!";

	public static void main(String[] args) {
		insertTempData();
//		test();
	}
	@SuppressWarnings("unused")
	private static void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement selectEarn = 
				conn.prepareStatement("SELECT a.email_id,a.android_id ,a.google_ad_id ,"
						+ "a.mobile_model,a.name,a.created,b.sex as gender, b.age, "
						+ "c.email_id as verified_email_id FROM customers a left "
						+ "join customers_profile b on a.id = b.customer_id left "
						+ "join verified_emails c on a.id = c.customer_id "
						+ "WHERE a.mobile_no= 9560340438 and a.is_active =1");
		ResultSet rs = selectEarn.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("created"));
			
		}
	}
	public static void insertTempData() {


		try {
			Connection conn = getConnection();
			PreparedStatement insertTemp = conn
					.prepareStatement("INSERT INTO customer_stats ( customer_id, android_id, type, created)" + " VALUES(?,?,?,NOW())");

			conn.setAutoCommit(false);
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < 500000; i++) {
					insertTemp.setInt(1, i+1);
					insertTemp.setString(2, "bfa01a09eae47b15");
					insertTemp.setInt(3, 1);
					insertTemp.addBatch();
					try {
						if (i+1 % 2000 == 0)
							insertTemp.executeBatch();

					} catch (Exception ex) {
						System.out.println(ex);
					}
			}
			insertTemp.executeBatch();
			conn.commit();
			long endTime = System.currentTimeMillis();
			System.out.println("total time taken : " + (endTime - startTime));
			insertTemp.close();
			conn.close();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}

	
		
	}
	@SuppressWarnings("null")
	public static void insertIntoLocalCustomer() {

		try {
			Connection conn = getConnection();
			PreparedStatement selectEarn = conn.prepareStatement("SELECT id,latitude,longitude FROM customers"
					+ " where latitude IS NOT NULL and longitude IS NOT NULL LIMIT ?, 50");
			PreparedStatement insertTemp = conn
					.prepareStatement("INSERT INTO local_cus(cus_id,latitude,longitude)" + " VALUES(?,?,?)");

			conn.setAutoCommit(false);
			ResultSet rs = null;
			int countj = 0;
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < 2; i++) {
				selectEarn.setInt(1, countj);
				rs = selectEarn.executeQuery();
				int count = 0;
				while (rs.next()) {
					countj++;
					count++;
					insertTemp.setInt(1, rs.getInt("id"));
					insertTemp.setFloat(2, rs.getFloat("latitude"));
					insertTemp.setFloat(3, rs.getFloat("longitude"));
					insertTemp.addBatch();
					try {
						if (count % 50 == 0)
							insertTemp.executeBatch();

					} catch (SQLException ex) {
					}
				}
				insertTemp.executeBatch();
				conn.commit();
			}
			long endTime = System.currentTimeMillis();
			System.out.println("total time taken : " + (endTime - startTime));
			rs.close();
			selectEarn.close();
			insertTemp.close();
			conn.close();
			conn.close();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}

	}
	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName(driver).newInstance();
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
		
	}
}
