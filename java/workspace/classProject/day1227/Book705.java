package day1227;

//p704
//Workable
@FunctionalInterface
interface Workable
{
	void work(String name,String job);
}
//Speakable
@FunctionalInterface
interface Speakable
{
	void speak(String content);
}
//p705
//Person
class Person
{
	public void action1(Workable workable)
	{
		workable.work("홍길동", "프로그래밍");
	}
	
	public void action2(Speakable speakable)
	{
		speakable.speak("안녕하세요");
	}
}

public class Book705 {//p705 LambdaExample
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person=new Person();
		
		person.action1((name,job)->{
			System.out.print(name+" 이 ");
			System.out.println(job+" 을 합니다");
		});
		
		person.action2(word->{
			System.out.print("\""+word+"\"");
			System.out.println("라고 말합니다");
		});
		
		person.action2(word->System.out.println("\""+word+"\" 하고 외칩니다"));
		
	}

}





