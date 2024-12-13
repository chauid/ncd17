package day1213;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			try {
				System.out.println("1.점수 계산, 2.숫자 합계 계산, 3.문자열 분석, 0.종료");
				System.out.print("선택: ");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					calc_score(sc);
					break;
				case 2:
					sumSequence(sc);
					break;
				case 3:
					AnalyseInput(sc);
					break;
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
	}

	public static void calc_score(Scanner scanner) {
		int sum = 0;
		int count = 0;
		while (true) {
			int score;
			try {
				System.out.print("점수 입력(0입력 시 종료): ");
				score = scanner.nextInt();
				System.out.println(score);
				if (score > 100) {
					throw new InputMismatchException();
				}
				if (score <= 0) {
					break;
				}
				sum += score;
				count++;
			} catch (InputMismatchException e) {
				System.out.println("조건에 맞는 \"숫자\"만 입력하세요.");
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("-------------------------------");
		System.out.println("점수 총점: " + sum);
		System.out.println("점수 평균: " + (int) ((double) sum / count));
		System.out.println("-------------------------------");
	}

	public static void sumSequence(Scanner scanner) {
		int n;
		int sum = 0;
		while (true) {
			try {
				System.out.print("1~N까지의 합. N 입력: ");
				n = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력하세요.");
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		for (int i = 1; i < n + 1; i++) {
			sum += i;
		}
		System.out.println("-------------------------------");
		System.out.println("1~N까지의 합: " + sum);
		System.out.println("-------------------------------");
	}

	public static void AnalyseInput(Scanner scanner) {
		String input;
		int upperCount = 0;
		int lowerCount = 0;
		int numberCount = 0;
		int spaceCount = 0;
		System.out.print("문자열 입력:");
		input = scanner.nextLine();
		System.out.println(input);
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
				upperCount++;
			}
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				lowerCount++;
			}
			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				numberCount++;
			}
			if (input.charAt(i) == ' ') {
				spaceCount++;
			}
		}
		System.out.println("-------------------------------");
		System.out.println("대문자 알파벳: " + upperCount + "개");
		System.out.println("소문자 알파벳: " + lowerCount + "개");
		System.out.println("숫자: " + numberCount + "개");
		System.out.println("공백 문자: " + spaceCount + "개");
		System.out.println("-------------------------------");
	}
}
