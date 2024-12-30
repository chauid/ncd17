package day1227;
/*
 * 멀티 스레드란 하나의 프로세스에서 여러 개의 스레드가 
 * 병행적으로 처리되는 것을 말한다.

 */
public class Ex4Thread extends Thread{
	String msg;
	int count;
	
	public Ex4Thread(String msg,int count) {
		// TODO Auto-generated constructor stub
		this.msg=msg;
		this.count=count;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=count;i++)
		{
			System.out.println(msg+":"+count);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4Thread ex1=new Ex4Thread("1번 쓰레드", 300);
		Ex4Thread ex2=new Ex4Thread("2번 쓰레드", 300);
		Ex4Thread ex3=new Ex4Thread("3번 쓰레드", 300);
		
		//run 메서드 호출-start
		ex1.start();
		ex2.start();
		ex3.start();		
		
	}

}











