package day1219;

import java.time.LocalDate;

public class Student {
	private String name;
	private String blood;
	private int birthYear;
	private int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public int getbirthYear() {
		return birthYear;
	}

	public void setbirthYear(int birth) {
		this.birthYear = birth;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public char getGrade() {
		return switch (score / 10) {
		case 9, 10 -> 'A';
		case 8 -> 'B';
		case 7 -> 'C';
		case 6 -> 'D';
		default -> 'F';
		};
	}

	public int getAge() {
		return LocalDate.now().getYear() - LocalDate.ofYearDay(birthYear, 1).getYear();
	}
}
