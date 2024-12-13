package day1210;

public class Main {
	/*
	 * 연속된 입력값에 대하여 for i in args.length 
	 * String + String이면 두 문자열을 합치고
	 * String + Integer이면 문자열과 숫자를 문자열로 합치고
	 * Integer + Integer이면 두 숫자를 덧셈한다.
	 * 가장 마지막 입력값은 그대로 출력
	 */
	public static void main(String[] args) {
		String[] typeList = new String[args.length];
		for (int i = 0; i < args.length; i++) {
			try {
				Integer.parseInt(args[i]);
				typeList[i] = "Integer";
			} catch (Exception e) {
				typeList[i] = "String";
			}
		}
		System.out.print("안녕하세요 ");
		for (int i = 0; i < args.length; i++) {
			if (i < args.length - 1) {
				if (typeList[i] == typeList[i + 1]) {
					int sum = Integer.parseInt(args[i]) + Integer.parseInt(args[i + 1]);
					System.out.print("(" + typeList[i] + ")" + sum + " ");
				} else {
					System.out.print(args[i] + args[i + 1] + " ");
				}
			} else {
				System.out.print(args[i]);
			}
		}
	}
}
