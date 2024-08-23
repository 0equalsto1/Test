package packg1;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatementExample {
	public static void main(String[] argv) throws Exception {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
				PreparedStatement prest = con.prepareStatement("SELECT * FROM employee WHERE NAME = ?");) {
			Class.forName("com.mysql.jdbc.Driver");
			prest.setString(1, "mannu");
			try (ResultSet rs1 = prest.executeQuery();) {
				while (rs1.next()) {
					BigDecimal salarry = rs1.getBigDecimal(4);
					String ssn = rs1.getString(5);
					System.out.println(salarry + "\t- " + ssn);
				}
			} catch (SQLException s) {
				System.out.println(s.getMessage());
				prest.close();

			}

		} catch (SQLException s) {

		}
	}
}
