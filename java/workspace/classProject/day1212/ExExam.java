package day1212;

import java.util.Scanner;

public class ExExam {
	public static void main(String[] args) {
		/*
		 * 이름(name)과 java, html, spring의 3과목 점수를 입력받은 후 총점(sum)과 평균(avg), 등급(grade)의 합격여부를 출력하시오.
		 * 
		 * 등급은 평균 90이상이면 "우등장학생", 80이상이면 "50프로장학금", 나머지는 "노력"이라고 출력
		 * 
		 * 합격여부는 3과목이 50이상이고 평균이 70이상이면 "합격입니다"
		 * 나머지는 "불합격입니다."라고 출력(출력문에서 직접 조건연산자로 출력하기) if문 없이
		 */

		Scanner sc = new Scanner(System.in);
		String name = "";
		int java, html, spring;
		name = sc.next();
		java = sc.nextInt();
		html = sc.nextInt();
		spring = sc.nextInt();

		int sum = java + html + spring;
		int avg = sum / 3;
		String grade = avg >= 90 ? "우등장학생" : avg >= 80 ? "50프로장학금" : "노력";
		System.out.print(name+"님 ");
		System.out.println(java > 50 && html > 50 && spring > 50 && avg >= 70 ? "합격입니다" : "불합격입니다");
		System.out.println(grade);
		
		sc.close();
	}
}
