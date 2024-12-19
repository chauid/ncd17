package day1219;

import java.util.Scanner;

// showTitle: 제목 출력
// 사원명 직급 기본급 수당 가족수당 세금 실수령액

// writeSawon(Sawon sawon): 1개의 사원 데이터 출력

// 인원 수을 입력 후 인원수만큼 배열 메모리 할당
// 배열에 데이터 입력 후 생성자를 통해서 데이터 저장하기
// 제목 출력
// 반복문 통해서 데이터 출력하는 메서드 호출
public class Ex12SawonArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberSawon, family;
		String name, position;
		Sawon[] mySawon = null;

		System.out.print("인원 수 입력: ");
		numberSawon = sc.nextInt();
		mySawon = new Sawon[numberSawon];
		for (int i = 0; i < numberSawon; i++) {
			System.out.print("이름: ");
			name = sc.next();
			System.out.print("직급: ");
			position = sc.next();
			System.out.print("가족수: ");
			family = sc.nextInt();
			mySawon[i] = new Sawon(name, position, family);
		}
		showTitle();
		for (Sawon s : mySawon) {
			writeSawon(s);
		}
		sc.close();
	}

	public static void showTitle() {
		System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(50));
	}

	public static void writeSawon(Sawon sawon) {
		System.out.println(sawon.getSawonName() + "\t" + sawon.getPosition() + "\t" + sawon.getBasePay() + "\t" + sawon.getSalary() + "\t"
				+ sawon.getFamilySalary() + "\t" + sawon.getTax() + "\t" + sawon.getNetPay());
	}

}
