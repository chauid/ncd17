package day0106;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public static class UserDTO {
		private int id;
		private String name;
		private int asset;
		private String description;
		private String key;

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAsset() {
			return asset;
		}

		public void setAsset(int asset) {
			this.asset = asset;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getKey() {
			return key;
		}

		public UserDTO() {
		}

		public UserDTO(int id, String name, int asset, String description, String key) {
			this.id = id;
			this.name = name;
			this.asset = asset;
			this.description = description;
			this.key = key;
		}
	}

	private PreparedStatement pstmt = null;

	public UserDAO() {
	}

	public List<UserDTO> readAllUsers() {
		List<UserDTO> result = new ArrayList<UserDAO.UserDTO>();
		String query = "SELECT * FROM users";
		try {
			Connection connect = MariaDBConnect.getConnection();
			pstmt = connect.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(new UserDTO(rs.getInt("id"), rs.getString("name"), rs.getInt("asset"), rs.getString("description"), rs.getString("key")));
			}
		} catch (SQLException e) {
			System.out.println("쿼리 실행 실패:" + e.getMessage());
		}
		return result;
	}

	public UserDTO readUserById(int id) {
		UserDTO result = new UserDTO();
		String query = "SELECT * FROM users WHERE id=?";
		try {
			Connection connect = MariaDBConnect.getConnection();
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				result = new UserDTO(rs.getInt("id"), rs.getString("name"), rs.getInt("asset"), rs.getString("description"), rs.getString("key"));
			}
		} catch (SQLException e) {
			System.out.println("쿼리 실행 실패:" + e.getMessage());
		}
		return result;
	}

	public void createUser(UserDTO user) {
		String query = "INSERT INTO users(`name`, asset, `description`) VALUES(?, ?, ?)";
		try {
			Connection connect = MariaDBConnect.getConnection();
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, user.name);
			pstmt.setInt(2, user.asset);
			pstmt.setString(3, user.description);
			pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("쿼리 실행 실패:" + e.getMessage());
		}
	}

	public void updateUserById(int id, UserDTO user) {
		String query = "UPDATE users SET `name`=?, asset=?, `description`=? WHERE id=?";
		try {
			Connection connect = MariaDBConnect.getConnection();
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, user.name);
			pstmt.setInt(2, user.asset);
			pstmt.setString(3, user.description);
			pstmt.setInt(4, id);
			pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("쿼리 실행 실패:" + e.getMessage());
		}
	}

	public void deleteUserById(int id) {
		String query = "DELETE FROM users WHERE id=?";
		try {
			Connection connect = MariaDBConnect.getConnection();
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("쿼리 실행 실패:" + e.getMessage());
		}
	}
}
