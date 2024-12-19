package day1217;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static class Score {
		String name = "";
		int value = 0;

		public Score(String name, int value) {
			this.name = name;
			this.value = value;
		}
	}

	enum Order {
		ASC, DESC,
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		while (true) {
			try {
				System.out.println("1.등수 출력, 2.인원 수 입력받고 등수 출력, 3.알파벳 분석, 4.이름 검색 0.종료");
				System.out.print("선택: ");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					printRank(new int[] { 50, 64, 12, 48, 97, 13, 48 });
					break;
				case 2:
					calcScore(sc);
					break;
				case 3:
					analyseAlphabet(sc);
					break;
				case 4:
					searchName(sc);
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

	public static void printRank(int[] score) {
		int[] rank = new int[score.length];
		for (int i = 0; i < score.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < score.length; j++) {
				if (score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println("번호\t점수\t등수");
		System.out.println("=".repeat(30));
		for (int i = 0; i < rank.length; i++) {
			System.out.println(i + "\t" + score[i] + "\t" + rank[i]);
		}
	}

	// 인원수를 입력 후 그 인원수만큼 이름과 점수를 할당받고
	// 등수와 총점과 평균을 출력
	public static void calcScore(Scanner scanner) {
		String name;
		int score;
		Score[] person;
		int length, total = 0, rank = 0, prev = -1;
		System.out.print("인원수를 입력해주세요.");
		length = scanner.nextInt();
		person = new Score[length];

		for (int i = 0; i < length; i++) {
			System.out.print("이름: ");
			name = scanner.next();
			System.out.print("점수: ");
			score = scanner.nextInt();
			person[i] = new Score(name, score);
			total += score;
		}
		person = mergeSortScore(person, Order.DESC);
		System.out.println("-".repeat(40));
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("-".repeat(40));
		for (int i = 0; i < person.length; i++) {
			if (prev != person[i].value) {
				rank++;
			}
			System.out.println((i + 1) + "\t" + person[i].name + "\t" + person[i].value + "\t" + rank);
			prev = person[i].value;
		}
		System.out.println("=".repeat(40));
		System.out.println("총점: " + total + "점\t평균: " + (total / length) + "점");
	}

	public static void analyseAlphabet(Scanner scanner) {
		int[] lowerAlpha = new int[26];
		int[] upperAlpha = new int[26];
		String input;

		System.out.println("영어문장을 입력하세요.");
		input = scanner.nextLine();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				lowerAlpha[ch - 'a']++;
			}
			if (ch >= 'A' && ch <= 'Z') {
				upperAlpha[ch - 'A']++;
			}
		}

		int wrap = 1;
		System.out.println("=".repeat(30));
		System.out.println("소문자");
		for (int i = 0; i < lowerAlpha.length; i++) {
			if (lowerAlpha[i] > 0) {
				System.out.printf("%c: %d%s", (i + 'a'), lowerAlpha[i], wrap++ % 4 == 0 ? "\n" : " ");
			}
		}
		System.out.println();
		System.out.println("-".repeat(30));
		System.out.println("대문자");
		wrap = 1;
		for (int i = 0; i < upperAlpha.length; i++) {
			if (upperAlpha[i] > 0) {
				System.out.printf("%c: %d%s", (i + 'A'), upperAlpha[i], wrap++ % 4 == 0 ? "\n" : " ");
			}
		}
		System.out.println();
		System.out.println("-".repeat(30));
	}

	public static void searchName(Scanner scanner) {
		String[] member = { "강호동", "김태희", "손미나", "이지혜", "송중기", "김사랑", "손석구", "박미나", "강리나", "김신" };
		String searchWord;

		while (true) {
			List<String> result = new ArrayList<String>();
			int resultCount = 0;
			System.out.print("검색(종료 시 \"quit\"): ");
			searchWord = scanner.nextLine();
			if (searchWord.equals("quit")) {
				break;
			}
			for (int i = 0; i < member.length; i++) {
				if (member[i].contains(searchWord)) {
					result.add(member[i]);
					resultCount++;
				}
			}

			System.out.println("=".repeat(30));
			System.out.print("검색 결과: ");
			for (String name : result) {
				System.out.print(name + " ");
			}
			System.out.println();
			System.out.println("-".repeat(30));
			System.out.println("총 " + resultCount + "개의 결과");
			System.out.println("=".repeat(30));
		}
	}

	public static Score[] mergeSortScore(Score[] arr, Order order) {
		if (arr.length == 1) {
			return new Score[] { arr[0] };
		}
		if (arr.length == 2) {
			if (order == Order.DESC) {
				return arr[0].value > arr[1].value ? new Score[] { arr[0], arr[1] } : new Score[] { arr[1], arr[0] };
			} else {
				return arr[0].value > arr[1].value ? new Score[] { arr[1], arr[0] } : new Score[] { arr[0], arr[1] };
			}
		}
		int addLength = arr.length % 2 == 0 ? 0 : 1;
		Score[] leftArr = new Score[arr.length / 2 + addLength];
		Score[] rightArr = new Score[arr.length / 2];
		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[i];
		}
		for (int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[leftArr.length + i];
		}
		Score[] left = mergeSortScore(leftArr, order);
		Score[] right = mergeSortScore(rightArr, order);
		int leftIndex = 0, rightIndex = 0;
		Score[] conquer = new Score[left.length + right.length];
		for (int i = 0; i < conquer.length; i++) {
			if (order == Order.DESC) {
				if (leftIndex == left.length) {
					conquer[i] = right[rightIndex++];
					continue;
				}
				if (rightIndex == right.length) {
					conquer[i] = left[leftIndex++];
					continue;
				}
				if (left[leftIndex].value > right[rightIndex].value) {
					conquer[i] = left[leftIndex++];
				} else {
					conquer[i] = right[rightIndex++];
				}
			} else {
				if (leftIndex == left.length) {
					conquer[i] = right[rightIndex++];
					continue;
				}
				if (rightIndex == right.length) {
					conquer[i] = left[leftIndex++];
					continue;
				}
				if (left[leftIndex].value < right[rightIndex].value) {
					conquer[i] = left[leftIndex++];
				} else {
					conquer[i] = right[rightIndex++];
				}
			}
		}
		return conquer;
	}
}
