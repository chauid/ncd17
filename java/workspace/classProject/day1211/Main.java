package day1211;

public class Main {
	public static void main(String[] args) {
		byte a = 127;
		byte b = (byte) 128; // 명시적 형변환: overflow
		byte c = (byte) 200;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);

		int ia = 12;
		int ib = 24;
		System.out.println("ia+ib=" + ia + ib); // String + Ieteger => String

		// 진번 변환
		int oa = 056;
		int xa = 0x45;
		System.out.println("oa=" + oa + ", xa=" + xa);

		float fa = 2.1234567891234f;
		double da = 3.1234567891234;
		System.out.println("fa=" + fa);
		System.out.println("da=" + da);

		char ca = 'a';
		char cb = 'b';
		System.out.printf("%c: %d, %c: %d\n", ca, (int) ca, cb, (int) cb);

		String name = "Car";
		int age = 39;
		float height = 160.0f;
		double weight = 103.4;
		char blood = 'B';

		System.out.printf("이름 : %s님\n", name);
		System.out.printf("나이 : %d세\n", age);
		System.out.printf("키 : %.1fcm\n", height);
		System.out.printf("몸무게 : %.1fkg\n", weight);
		System.out.printf("혈액형 : %c형\n", blood);

	}
}
