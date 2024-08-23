package serialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SerializeToDatabase {

	private static final String SQL_SERIALIZE_OBJECT = "INSERT INTO serialize_test(str) VALUES (?)";
	private static final String SQL_DESERIALIZE_OBJECT = "SELECT str FROM serialize_test";

	public static void serializeJavaObjectToDB(Connection connection, Object objectToSerialize) throws SQLException {

		PreparedStatement pstmt = connection.prepareStatement(SQL_SERIALIZE_OBJECT);

		pstmt.setObject(1, objectToSerialize);
		pstmt.executeUpdate();
		pstmt.close();
		System.out.println("Java object serialized to database. Object: " + objectToSerialize);
	}

	public static Object deSerializeJavaObjectFromDB(Connection connection)
			throws SQLException, IOException, ClassNotFoundException {
		PreparedStatement pstmt = connection.prepareStatement(SQL_DESERIALIZE_OBJECT);
		ResultSet rs = pstmt.executeQuery();
		rs.next();

		byte[] buf = rs.getBytes(1);
		ObjectInputStream objectIn = null;
		if (buf != null)
			objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));

		Object deSerializedObject = objectIn.readObject();

		rs.close();
		pstmt.close();

		System.out.println("Java object de-serialized from database. Object: " + deSerializedObject + " Classname: "
				+ deSerializedObject.getClass().getName());
		return deSerializedObject;
	}

	@SuppressWarnings("unused")
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = null;

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);

		Student s1 = new Student(1000, "abcd");

		serializeJavaObjectToDB(connection, s1);

		Student objFromDatabase = (Student) deSerializeJavaObjectFromDB(connection);

		connection.close();
	}
}