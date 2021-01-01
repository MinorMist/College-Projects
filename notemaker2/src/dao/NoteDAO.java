package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Note;

public class NoteDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcNotename = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_NOTES_SQL = "INSERT INTO notes" + "  (title, despt) VALUES "
			+ " (?, ?);";

	private static final String SELECT_NOTE_BY_ID = "select id,title,despt from notes where id =?";
	private static final String SELECT_ALL_NOTES = "select * from notes";
	private static final String DELETE_NOTES_SQL = "delete from notes where id = ?;";
	private static final String UPDATE_NOTES_SQL = "update notes set title = ?,despt= ? where id = ?;";

	public NoteDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcNotename, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertNote(Note note) throws SQLException {
		System.out.println(INSERT_NOTES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NOTES_SQL)) {
			preparedStatement.setString(1, note.getTitle());
			preparedStatement.setString(2, note.getDespt());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Note selectNote(int id) {
		Note note = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NOTE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String title = rs.getString("title");
				String despt = rs.getString("despt");
				note = new Note(id, title, despt);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return note;
	}

	public List<Note> selectAllNotes() {
		List<Note> notes = new ArrayList<>();

		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NOTES);) {
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String despt = rs.getString("despt");
				notes.add(new Note(id, title, despt));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return notes;
	}

	public boolean deleteNote(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_NOTES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateNote(Note note) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_NOTES_SQL);) {
			statement.setString(1, note.getTitle());
			statement.setString(2, note.getDespt());
			statement.setInt(3, note.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}