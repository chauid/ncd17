package day1219;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static class Test {
		int value;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			try {
				System.out.println("1.학생 입출력, 2.변수 변경  0.종료");
				System.out.print("선택: ");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					studentIO(sc);
					break;
				case 2:
					Integer[] IntegerArr = new Integer[] { 1, 2, 3, 4, 5 };
					int[] intArr = new int[] { 1, 2, 3, 4, 5 };
					int ix = 10;
					Test test = new Test();
					test.value = 20;
					System.out.println("=".repeat(30));
					System.out.println("Primitive Type");
					modifyInt(ix);
					System.out.println("int: " + ix);
					System.out.println("-".repeat(30));
					System.out.println("Reference Type: Array, Object");
					modifyIntArr(intArr);
					System.out.print("Array: ");
					printArr(intArr);
					modifyObject(test);
					System.out.println("Object: " + test.value);
					modifyIntegerArr(IntegerArr);
					System.out.print("Object Array: ");
					printArray(IntegerArr);
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

	public static void studentIO(Scanner scanner) {
		StudentArray students = new StudentArray();
		students.inputStudents(3, scanner);
		students.showAllStudents();
	}

	public static void modifyIntegerArr(Integer[] arr) {
		arr[2]++;
	}

	public static void modifyIntArr(int[] arr) {
		arr[2]++;
	}

	public static void modifyObject(Test x) {
		x.value++;
	}

	public static void modifyInt(int x) {
		x++;
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static <T> void printArray(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
