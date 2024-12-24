package day1224;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

abstract class Vehicle {
	abstract void run();
}

class Bus extends Vehicle {
	@Override
	public void run() {
		System.out.println("bus run");
	}
}

class Taxi extends Vehicle {
	@Override
	public void run() {
		System.out.println("taxi run");
	}
}

class Driver {
	public void run(Vehicle v) {
		v.run();
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			try {
				System.out.println("1.다형성, 2.파일 입출력, 3.파일탐색기  0.종료");
				System.out.print("선택: ");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					polymorphism();
					break;
				case 2:
					fileIO("D:/temp.txt");
					break;
				case 3:
					fileExplorer(sc, "D:/bird folder");
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

	public static void polymorphism() {
		Vehicle v = new Taxi();
		Driver d = new Driver();
		d.run(v);
		System.out.println(v.getClass().toString());
		v = new Bus();
		d.run(v);
		System.out.println(v.getClass().toString());
	}

	public static void fileIO(String file) {
		FileReader reader = null;
		BufferedReader buffer = null;
		Vector<String> fileContents = new Vector<String>();

		try {
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);

			while (true) {
				String s = buffer.readLine();
				if (s == null) {
					break;
				}
				fileContents.add(s);
			}
			buffer.close();
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (String s : fileContents) {
			System.out.println(s);
		}
	}

	public static void fileExplorer(Scanner scanner, String startPath) throws IOException {
		File currentFile = new File(startPath);
		String input = null;
		if (!currentFile.exists()) {
			System.out.println("Can not Read Path of" + startPath);
		}
		while (true) {
			if (currentFile.isFile()) {
				FileReader reader = new FileReader(currentFile);
				BufferedReader buffer = new BufferedReader(reader);
				System.out.printf("%s 파일 내용\n", currentFile.getName());
				System.out.println("=".repeat(50));
				while (true) {
					String s = buffer.readLine();
					if (s == null) {
						break;
					}
					System.out.println(s);
				}
				System.out.println("=".repeat(50));
				buffer.close();
				currentFile = new File(currentFile.getParent());
				continue;
			}
			File[] fileList = currentFile.listFiles();
			int lastNum = 0, directoryCount = 0, fileCount = 0;
			System.out.println("현재 경로: " + currentFile.getPath());
			System.out.println("-".repeat(50));
			for (int i = 0; i < fileList.length; i++) {
				System.out.printf("%d. %s %s\n", i + 1, fileList[i].isDirectory() ? "<DIR>" : "<FILE>", fileList[i].getName());
				if (fileList[i].isDirectory()) {
					directoryCount++;
				}
				if (fileList[i].isFile()) {
					fileCount++;
				}
				lastNum = i + 1;
			}
			System.out.println(++lastNum + ". [..]상위 디렉터리로 가기");
			System.out.println("-".repeat(50));
			System.out.printf("현재 경로의 디렉터리 수 : %d | 파일 수 : %d\n", directoryCount, fileCount);
			System.out.println("\"quit\": 종료");
			System.out.print("입력: ");
			input = scanner.nextLine();
			if (input.equals("quit")) {
				break;
			}
			int iInput = Integer.parseInt(input);
			if (iInput == lastNum) {
				String parentD = currentFile.getPath();
				int str_index = parentD.length() - 1;
				while (true) {
					if (parentD.charAt(str_index--) == '\\') {
						break;
					}
				}
				parentD = parentD.substring(0, str_index + 1);
				currentFile = new File(parentD);
				continue;
			}
			currentFile = fileList[iInput - 1];
		}
	}
}
