package day1216;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print(Math.random() + " ");
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			n = (int) (Math.random() * 10);
			System.out.print(n + " ");
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			n = (int) (Math.random() * 10) + 1;
			System.out.print(n + " ");
		}
		System.out.println();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.print(rnd.nextInt(10) + " ");
		}
		System.out.println("\nA~Z(65~90)난수 구하기");
		for (int i = 0; i < 5; i++) {
			System.out.print((char) rnd.nextInt(65, 90) + " ");
			System.out.print((char) (rnd.nextInt(26) + 65) + " ");
		}

		System.out.println();
		tryCorrectNumber(sc, 100);
	}

	public static void tryCorrectNumber(Scanner scanner, int maxNumber) {
		int tryCount = (int) log2(maxNumber, 2);
		Random rnd = new Random();
		String tryAgain;
		int input;
		while(true) {
			boolean isWin = false;
			int number = rnd.nextInt(1, maxNumber);
			System.out.printf("1~%d사이에 숫자 맞추기\n", maxNumber);
			for (int i = 0; i < tryCount; i++) {
				System.out.printf("시도 횟수(%d/%d): ", i, tryCount);
				input = scanner.nextInt();
				if (input == number) {
					System.out.printf("%d번의 시도 끝에 ", i);
					isWin = true;
					break;
				}
				if (input < number) {
					System.out.println("up");
				}
				if (input > number) {
					System.out.println("down");
				}
			}
			if (isWin) {
				System.out.println("맞추기 성공. 정답: " + number);
			} else {
				System.out.println("못 맞춤. 정답: " + number);
			}
			System.out.print("다시하려면 \"n\" 또는 \"N\"  이외에 아무 키나 누르세요...");
			tryAgain = scanner.next();
			if(tryAgain.equals("N") || tryAgain.equals("n")) {
				System.out.println("종료.");
				break;
			}
		}
	}

	public static double log2(double x, double base) {
		return Math.log(x) / Math.log(base);
	}
}
