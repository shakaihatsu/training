package net.shakaihatsu.training.persistence.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import net.shakaihatsu.training.persistence.api.PersonDao;
import net.shakaihatsu.training.persistence.domain.Person;

@Stateless
public class PersonDaoJdbcImpl implements PersonDao {
	private static final AtomicLong ID_SEQUENCE = new AtomicLong(1L);
	
	private static final String FIND_ALL_PERSONS_SQL = "SELECT * FROM person";
	private static final String FIND_PERSONS_BY_ID_SQL = "SELECT * FROM person WHERE id = ?";
	private static final String INSERT_PERSON_SQL = "INSERT INTO person(id, first_name, last_name) VALUES (?, ?, ?)";
	private static final String UPDATE_PERSON_SQL = "UPDATE PERSON SET first_name = ?, last_name = ? WHERE id = ?";
	private static final String DELETE_PERSON_SQL = "DELETE FROM PERSON WHERE id = ?";

	@Resource(name = "ExampleDS")
	private DataSource dataSource;

	@Override
	public List<Person> findAllPersons() {
		List<Person> persons = new ArrayList<>();

		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			
			statement = connection.createStatement();

			ResultSet resultSet = statement
					.executeQuery(FIND_ALL_PERSONS_SQL);
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");

				Person person = new Person();
				person.setId(id);

				person.setFirstName(firstName);
				person.setLastName(lastName);

				persons.add(person);
			}
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

		return persons;
	}

	@Override
	public Person findPersonById(Long id) {
		Person person = null;

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			
			statement = connection.prepareStatement(FIND_PERSONS_BY_ID_SQL);
			statement.setLong(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				if (person != null) {
					throw new IllegalStateException(
							"Multiple entries detected with id " + id + "!");
				}

				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");

				person = new Person();
				person.setId(id);

				person.setFirstName(firstName);
				person.setLastName(lastName);
			}
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

		return person;
	}

	@Override
	public void savePerson(Person person) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			
			statement = connection.prepareStatement(INSERT_PERSON_SQL);
			statement.setLong(1, ID_SEQUENCE.getAndIncrement());
			statement.setString(2, person.getFirstName());
			statement.setString(3, person.getLastName());

			statement.executeUpdate();
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

	@Override
	public void updatePerson(Person person) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			
			statement = connection.prepareStatement(UPDATE_PERSON_SQL);
			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setLong(3, person.getId());

			statement.executeUpdate();
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

	@Override
	public void deletePerson(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			
			statement = connection.prepareStatement(DELETE_PERSON_SQL);
			statement.setLong(1, id);

			statement.executeUpdate();
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
