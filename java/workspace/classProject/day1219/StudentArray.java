package day1219;

import java.util.Scanner;

public class StudentArray {
	private Student[] students;

	public void inputStudents(int amount, Scanner scanner) {
		students = new Student[amount];
		for (int i = 0; i < amount; i++) {
			students[i] = new Student();
			System.out.print("학생 이름: ");
			students[i].setName(scanner.next());
			System.out.print("학생 혈액형: ");
			students[i].setBlood(scanner.next());
			System.out.print("학생 출생년도: ");
			students[i].setbirthYear(scanner.nextInt());
			System.out.print("학생 점수: ");
			students[i].setScore(scanner.nextInt());
		}
	}

	public void showAllStudents() {
		try {
			System.out.println("이름\t혈액형\t나이\t점수\t학점");
			System.out.println("=".repeat(40));
			for (Student s : students) {
				System.out.println(s.getName() + "\t" + s.getBlood() + "형\t" + s.getAge() + "세\t" + s.getScore() + "점\t" + s.getGrade());
			}
		} catch (NullPointerException e) {
			System.out.println("학생 없음.");
			System.out.println("=".repeat(40));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
