package day1218;

class Orange
{
	public static final String MESSAGE="Happy";

	private String name;
	private int age;	
		
	public void showData()
	{
		//일반 멤버 메서드는 this 라는 인스턴스 변수를 가지고 있다
		//static 멤버 메서드에는 this가 없음
		//그래서 this.name 이런식으로 접근가능(this는 경우에 따라 생략가능)
		//System.out.println("이름:"+this.name+",나이:"+this.age);
		System.out.println("이름:"+name+",나이:"+age);//this생략가능
	}
	
	//값을 변경하기 위한 setter method 를 만들어보자
	public void setName(String name)
	{
		//같은 구역에 멤버와 같은이름의 변수가 있을경우
		//멤버변수앞에 반드시 this를 붙인다
		this.name=name;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	
}
public class Ex8Object {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Orange.MESSAGE);
		
		Orange orange=new Orange();
		//System.out.println(orange.name);//오류:private 변수는 직접 접근 불가
		orange.showData();
		System.out.println("값변경");
		orange.setName("김태희");
		orange.setAge(35);
		
		orange.showData();		
	}

}






