package day1216;

import java.util.Scanner;

public class Ex6LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문자열 str 을 입력후 엔터를 누르면
		 * 문자열을 분석해서 대문자,소문자,숫자 각각의 갯수를 구해서
		 * 출력하시오
		 * 사용할 문자메소드 : length(),charAt(인덱스)
		 */
		Scanner sc=new Scanner(System.in);
		String str;
		int upperCount=0,lowerCount=0,numberCount=0;
		
		System.out.println("문자열을 입력하세요");
		str=sc.nextLine();
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
//			if(ch>='A' && ch<='Z')
//				upperCount++;
//			else if(ch>='a' && ch<='z')
//				lowerCount++;
//			else if(ch>='0' && ch<='9')
//				numberCount++;
			
			if(ch>=65 && ch<=90)
				upperCount++;
			else if(ch>=97 && ch<=122)
				lowerCount++;
			else if(ch>=48 && ch<=57)
				numberCount++;
		}
		
		System.out.println("대문자 갯수:"+upperCount);
		System.out.println("수문자 갯수:"+lowerCount);
		System.out.println("숫자 갯수 :"+numberCount);
	}

}












