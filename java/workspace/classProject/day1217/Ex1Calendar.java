package day1217;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Ex1Calendar {
	// 년도와 월을 입력하면 해당월의 달력을 출력하시오.
	// 달력이 제대로 나오게 하려면
	// 1. 그 월의 1일이 무슨 요일인가?
	// 2. 그 월이 몇일까지 있는가?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputYear, inputMonth, weekDay, endDays = 0;
		boolean leapYear;
		System.out.print("년도를 입력: ");
		inputYear = sc.nextInt();
		System.out.print("월을 입력: ");
		inputMonth = sc.nextInt();
		leapYear = inputYear % 4 == 0 && inputYear % 100 != 0 || inputYear % 400 == 0;
		LocalDate localDate = LocalDate.of(inputYear, inputMonth, 1);
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		weekDay = dayOfWeek.getValue();
		System.out.println(inputYear + (leapYear ? "년도는 윤년입니다." : "년도는 평년입니다."));

		switch (inputMonth) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			endDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			endDays = 30;
			break;
		case 2:
			endDays = leapYear ? 29 : 28;
			break;
		default:
			break;
		}

		System.out.println("=".repeat(50));
		System.out.println("\t\t[" + inputYear + "년 " + inputMonth + "월]");
		System.out.println("=".repeat(50));
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));

		if (weekDay < 7) {
			for (int i = 0; i < weekDay; i++) {
				System.out.print("\t");
			}
		}
		for (int i = 1; i <= endDays; i++) {
			++weekDay;
			System.out.printf("%2d\t", i);
			if (weekDay % 7 == 0) {
				System.out.println();
			}
		}
		sc.close();
	}
}
