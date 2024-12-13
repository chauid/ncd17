package day1213;

import java.util.Scanner;

public class Ex2 {
	/*
	 * 5명의 나이를 입력 후 40세 이상과 40세 미만이 각각 몇명인지 출력하고 평균 나이도 같이 출력하시오 (for문 사용)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		int person = 5;
		int sum = 0;
		int under40 = 0;
		int above40 = 0;

		for (int i = 0; i < person; i++) {
			age = sc.nextInt();
			sum += age;
			if (age >= 40) {
				above40++;
			} else {
				under40++;
			}
		}
		System.out.println("40세 이상: " + above40 + "명");
		System.out.println("40세 미만: " + under40 + "명");
		System.out.println("평균 나이: " + (double) sum / person + "세");
		sc.close();
	}
}
