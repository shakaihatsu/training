package net.shakaihatsu.training.persistence.init;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;

@Startup
@Singleton
public class DBInitializer {
	@Resource(name = "ExampleDS")
	private DataSource dataSource;

	private static final String DELTE_PERSON_TABLE_SQL = "DROP TABLE PERSON";
	private static final String CREATE_PERSON_SQL = "CREATE TABLE PERSON "
			+ "(id INTEGER not NULL, " + " first_name VARCHAR(255), "
			+ " last_name VARCHAR(255), " + " PRIMARY KEY ( id ))";

	@PostConstruct
	public void startUp() {
		deletePersonTable();
		createPersonTable();
	}

	private void deletePersonTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			
			statement = connection.createStatement();

			statement.executeUpdate(DELTE_PERSON_TABLE_SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void createPersonTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			
			statement = connection.createStatement();

			statement.executeUpdate(CREATE_PERSON_SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
