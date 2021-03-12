package erp.database;

import org.junit.Assert;
import org.junit.Test;

import com.mysql.jdbc.Connection;

public class JdbcConnTest {

	@Test
	public void testGetConnection() {
		System.out.printf("%s()%n", "testGetConnection");
		Connection con = (Connection) JdbcConn.getConnection();
		System.out.println("con > " + con);
		Assert.assertNotNull(con);
	}

}
