package day1213;

import java.util.Scanner;

public class Ex1 {
	/*
	 * 숫자 n을 입력하면 1부터 n까지의 합계를 구하시오. (for문 사용)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i < n + 1; i++) {
			sum += i;
		}
		System.out.println("sum: " + sum);
		sc.close();
	}

}
