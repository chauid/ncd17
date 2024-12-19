package day1213;

import java.util.Scanner;

public class Ex12For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 1 
		 * 숫자 n 을 입력하면 1부터 n까지의 합계를 구하시오
		 * (for문 사용할것)
		 */
		Scanner sc=new Scanner(System.in);
		int n,sum=0;
		System.out.println("숫자 n 입력");
		n=sc.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			sum+=i;
		}
		
		System.out.println("1부터 "+n+" 까지의 합계:"+sum);
	}

}
