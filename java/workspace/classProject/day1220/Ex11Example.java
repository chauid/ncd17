package day1220;

import java.util.Scanner;

// Command라는 인터페이스에 process() 추상메서드 추가
// 인터페이스 Command를 구현하는 Select, Insert, Delete, Update 클래스를 구현하시오.
// 메인에서 while문을 통해 다음과 같이 메뉴가 나오면
// 1.추가 2.출력 3.삭제 4.수정 5.종료
// 1번을 누르면 데이터가 추가되었습니다.
// 2번을 누르면 데이터를 출력합니다.
// 3번을 누르면 데이터가 삭제되었습니다.
// 4번을 누르면 데이터가 수정되었습니다.
// 5번을 누르면 프로그램을 종료합니다. -> 실제 종료
// dbProcess(Command command)

interface Command {
	public void process();
}

class Select implements Command {
	@Override
	public void process() {
		System.out.println("데이터를 출력합니다.");
	}
}

class Insert implements Command {
	@Override
	public void process() {
		System.out.println("데이터가 추가되었습니다.");
	}
}

class Delete implements Command {
	@Override
	public void process() {
		System.out.println("데이터가 삭제되었습니다.");
	}
}

class Update implements Command {
	@Override
	public void process() {
		System.out.println("데이터가 수정되었습니다.");
	}
}

public class Ex11Example {
	public static void dbProcess(Command command) {
		command.process();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Command command = null;
		int choice;
		while (true) {
			System.out.print("1.추가 2.출력 3.삭제 4.수정 5.종료");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				command = new Insert();
				command.process();
				break;
			case 2:
				command = new Select();
				command.process();
				break;
			case 3:
				command = new Delete();
				command.process();
				break;
			case 4:
				command = new Update();
				command.process();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				break;
			}
			if (choice == 5) {
				break;
			}
		}
		sc.close();
	}
}
