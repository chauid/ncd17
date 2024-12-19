package day1213;

public class Ex6While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=65;
		while(a<=90) {
			//System.out.printf("%c",a++);
			System.out.print((char)a++);
		}
		
		System.out.println();
		char b='a';
		//do~while 문을 이용해서 a부터 z까지 출력하시오
		do {
			System.out.print(b++);
		}while(b<='z');
		
		System.out.println();
		int n=0;
		while(n<=10) {
			n++;
			if(n%2==0)
				continue;//조건식으로 이동(while 이나 do~while에서)
			System.out.printf("%3d",n);
		}
	}

}
