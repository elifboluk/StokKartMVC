package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnect {

    public static Connection getConnection() {
	Connection conn = null;

	try {
	    Class.forName("com.mysql.cj.jdbc.Driver"); // Database bağlantısı için class'ı aldım.
	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stok_karti", "root", "31415813"); // Bağlantı
													      // yapıldı
	}

	catch (Exception e) {
	    System.out.println(e);
	    e.printStackTrace();
	}
	return conn;
    }
}
