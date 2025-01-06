package day0106;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import day0106.MariaDBConnect.connectionParams;
import day0106.UserDAO.UserDTO;

public class Main {
	public static void main(String[] args) {
		connectionParams params = new connectionParams("localhost", "root", "1234", "test", "3307");
		MariaDBConnect.createConnection(params);
		UserDAO userDao = new UserDAO();

		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			try {
				System.out.println("1.모두 조회, 2.id로 조회, 3.생성, 4.갱신 5.삭제 0.종료");
				System.out.print("선택: ");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1: {
					List<UserDTO> users = userDao.readAllUsers();
					for (UserDTO u : users) {
						System.out.println(u.getId() + " " + u.getName() + " " + u.getAsset() + " " + u.getDescription() + " " + u.getKey());
					}
					break;
				}
				case 2: {
					System.out.print("id: ");
					int userId = sc.nextInt();
					UserDTO u = userDao.readUserById(userId);
					if (u.getId() == 0) {
						System.out.println("해당 id의 사용자가 없음");
					} else {
						System.out.println(u.getId() + " " + u.getName() + " " + u.getAsset() + " " + u.getDescription() + " " + u.getKey());
					}
					break;
				}
				case 3: {
					System.out.print("name: ");
					String name = sc.next();
					System.out.print("asset: ");
					int asset = sc.nextInt();
					System.out.print("description: ");
					String description = sc.next();
					userDao.createUser(new UserDTO(0, name, asset, description, null));
					break;
				}
				case 4: {
					System.out.print("id: ");
					int userId = sc.nextInt();
					System.out.print("name: ");
					String name = sc.next();
					System.out.print("asset: ");
					int asset = sc.nextInt();
					System.out.print("description: ");
					String description = sc.next();
					userDao.updateUserById(userId, new UserDTO(0, name, asset, description, null));
					break;
				}
				case 5: {
					System.out.print("id: ");
					int userId = sc.nextInt();
					userDao.deleteUserById(userId);
					break;
				}
				case 0:
					System.out.println("종료됨.");
					break;
				default:
					System.out.println("보기 중에서만 고르세요.");
					break;
				}
				if (choice == 0) {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력하세요.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		sc.close();
		MariaDBConnect.closeConnection();
	}
}
