package day1211;

public class Ex8Argument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("외부에서 값 읽어오기");
		String name=args[0];//이름
		String city=args[1];//지역
		int birthYear=Integer.parseInt(args[2]);//String형태의 년도를 정수타입으로 변환
		int age=2024-birthYear;
		//두과목의 점수 읽기
		int kor=Integer.parseInt(args[3]);
		int eng=Integer.parseInt(args[4]);
		int total=kor+eng;//총점
		//double average=total/2.0;//평균 int+double=double, int+int=int
		double average=(double)total/2;
		
		
		System.out.println("이름 : "+name);
		System.out.println("지역 : "+city);
		System.out.println("태어난 년도 : "+birthYear+", 나이 : "+age+"세");
		System.out.println("국어점수:"+kor+"점");
		System.out.println("영어점수:"+eng+"점");
		System.out.println("총점:"+total+"점");
		System.out.println("평균:"+average+"점");
		
		
		
	}

}
