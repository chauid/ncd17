package day1216;

public class Ex10Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int dan=2;dan<=9;dan++)
			System.out.print("["+dan+"단]\t");
		System.out.println();
		System.out.println("=".repeat(65));
		
		for(int i=1;i<=9;i++)
		{
			for(int dan=2;dan<=9;dan++)
			{
				System.out.print(dan+"x"+i+"="+dan*i+"\t");				
			}
			System.out.println();
		}
	}

}
