package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="red|green|yellow|white|black";
		//String msg="red,green,yellow,white,black";
		// | 로 분리해서 출력
//		String []arr=msg.split("|");//잘 안됨
//		for(String a:arr)
//		{
//			System.out.println(a);
//		}
		
		StringTokenizer st=new StringTokenizer(msg, "|");
		System.out.println("분리할 총 토큰수 : "+st.countTokens());
		
		//countTokens 는 토큰을 읽을때마다 갯수가 줄어든다
		//이런식으로 반복문을 돌리면 3번만 반복
//		for(int i=0;i<st.countTokens();i++)//안됨
//		{
//			System.out.println(st.nextToken());
//		}
		
		//방법 1
		int count=st.countTokens();
		for(int i=0;i<count;i++)
		{
			System.out.println(st.nextToken());
		}
		System.out.println();
		StringTokenizer st2=new StringTokenizer(msg, "|");
		//방법2
		while(st2.hasMoreTokens())
		{
			System.out.println(st2.nextToken());
		}
		System.out.println();
		String []arr2=msg.split("|");
		System.out.println("총 "+arr2.length+"개");
		
		String []arr3=msg.split("\\|");//정규표현식
		System.out.println("총 "+arr3.length+"개");
		for(String a:arr3)
			System.out.println(a);
		System.out.println();
		//아래 데이타를 . 으로 분리하여 출력하시오(split)
		String msg2="이미자.손태영.강호동.이영자.박진아";
		String []arr4=msg2.split("\\.");
		System.out.println("총 "+arr4.length+"개로 분리");
		for(String s:arr4)
			System.out.println(s);
	}

}











