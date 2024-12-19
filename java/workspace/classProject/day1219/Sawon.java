package day1219;

// 멤버변수: 사원명 sawonName, 직급 position, 가족수 familyAmount

// 기본 생성자
// 사원명, 직급, 가족수를 인자로 받는 생성자

// getter & setter method

// 직급에 따랑 basePay를 구하는데 부장->450, 과장->300, 대리->250, 사원->150
// getBasePay()

// 직급에 따라 수당을 구하는데 부장, 과장->70, 대리, 사원->50
// getSalary()

// getBasePay() 값을 변환받아서 세금 5%를 구해서 반환하는 메서드
// getTax()

// 가족수가 5인 이상이면 30 반환, 5인 미만 2인 이상은 10 반환, 나머지는 0 반환
// getFamilySalary()

// 실수령액을 구해서 반환하는 메서드: 기본급 + 수당 - 세금 + 가족수당을 구해서 반환
// getNetPay()

public class Sawon {
	private String sawonName;
	private String position;
	private int familyAmount;

	public Sawon(String name, String pos, int family) {
		this.sawonName = name;
		this.position = pos;
		this.familyAmount = family;
	}

	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getFamilyAmount() {
		return familyAmount;
	}

	public void setFamilyAmount(int familyAmount) {
		this.familyAmount = familyAmount;
	}

	public int getBasePay() {
		return switch (this.position) {
		case "부장" -> 450;
		case "과장" -> 300;
		case "대리" -> 250;
		case "사원" -> 150;
		default -> 0;
		};
	}

	public int getSalary() {
		return switch (this.position) {
		case "부장", "과장" -> 70;
		case "대리", "사원" -> 50;
		default -> 0;
		};
	}

	public int getTax() {
		return this.getBasePay() / 100 * 5;
	}

	public int getFamilySalary() {
		if (this.familyAmount >= 5) {
			return 30;
		} else if (this.familyAmount >= 2) {
			return 10;
		} else {
			return 0;
		}
	}

	public int getNetPay() {
		return this.getBasePay() + this.getSalary() - this.getTax() + this.getFamilySalary();
	}
}
