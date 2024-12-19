package day1218;

import java.util.Scanner;

public class Main {
	static class User {
		private String name = "fffffffdefaultNamerrrrrr";
		private int asset_quotient = 0;
		private int asset_remainder = 0;

		private static String frontStr = "fffffff";
		private static String rearStr = "rrrrrr";
		private static int operand = 7;

		public void setName(String name) {
			this.name = frontStr + name + rearStr;
		}

		public String getName() {
			return this.name.substring(frontStr.length(), name.length() - rearStr.length());
		}

		public void setAsset(int asset) {
			this.asset_quotient = asset / operand;
			this.asset_remainder = asset % operand;
		}

		public int getAsset() {
			return (this.asset_quotient * operand) + this.asset_remainder;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User user = new User();
		start(sc, user);
	}

	public static void start(Scanner scanner, User user) {
		int iInput;
		String sInput;
		while (true) {
			System.out.print("1.자산 설정 2.현재 자산 확인 3.이름 설정 4. 이름 확인 5. 종료: ");
			sInput = scanner.nextLine();
			switch (sInput) {
			case "1":
				System.out.print("자산 입력: ");
				sInput = scanner.nextLine();
				iInput = Integer.parseInt(sInput);
				user.setAsset(iInput);
				break;
			case "2":
				System.out.println("현재 자산: " + user.getAsset());
				break;
			case "3":
				System.out.print("이름 입력: ");
				sInput = scanner.nextLine();
				user.setName(sInput);
				break;
			case "4":
				System.out.println("현재 이름: " + user.getName());
				break;
			case "5":
				System.out.println("종료됨.");
				break;
			default:
				break;
			}
			if (sInput.equals("5")) {
				break;
			}
		}
	}
}
