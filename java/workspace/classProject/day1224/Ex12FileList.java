package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex12FileList {
	static final String FILENAME="d:/naver1210/sawon.txt";
	
	List<String> sawonList=new Vector<String>();
	
	public Ex12FileList() {
		// TODO Auto-generated constructor stub
		//파일에서 이름을 읽어서 sawonList 에 추가해주세요
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String name=br.readLine();
				if(name==null)
					break;
				//Vector 에 추가
				sawonList.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sawonMemberList()
	{
		//사원 이름을 번호와 함께 출력해주세요
		System.out.println("총 "+sawonList.size()+"명의 사원이 있습니다");
		System.out.println();
		System.out.println("번호\t사원명");
		int n=0;
		for(String name:sawonList)
			System.out.println(++n+"\t"+name);
		System.out.println();		
	}
	
	//해당 이름이 몇번 인덱스에 있는지 리턴(없으면 -1 리턴)
	public int getSearchName(String name)
	{
		int idx=-1;
		for(int i=0;i<sawonList.size();i++)
		{
			String listName=sawonList.get(i);
			if(listName.equals(name))
			{
				idx=i;
				break;
			}
		}
		return idx;
	}
	
	//이름입력시 삭제하는 메서드
	public void deleteSawon(String name)
	{
		int idx=this.getSearchName(name);
		if(idx==-1)
			System.out.println(name+"님은 사원명단에 없습니다");
		else
		{
			sawonList.remove(idx);
			System.out.println(name+" 님을 사원명단에서 삭제했습니다");
		}
	}
	
	//이름조회
	public void searchName(String name)
	{
		int idx=this.getSearchName(name);
		if(idx==-1)
			System.out.println(name+" 님은 사원 명단에 없습니다");
		else
			System.out.println(name+" 님은 "+(idx+1)+" 번째에 있습니다");
	}
	
	//List 의 이름들을 다시 파일에 저장하기
	public void sawonFileSave()
	{
		FileWriter fw=null;
		try {
			fw=new FileWriter(FILENAME);
			for(String name:sawonList)
			{
				fw.write(name+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//사원명 추가
	public void addSawon(String name)
	{
		//이미 존재할경우 추가못함
		int idx=this.getSearchName(name);
		if(idx!=-1)
			System.out.println(name+" 님은 이미 존재합니다");
		else
		{
			sawonList.add(name);
			System.out.println("추가되었습니다");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex12FileList ex12=new Ex12FileList();
		Scanner sc=new Scanner(System.in);
		int menu=0;
		
		while(true)
		{
			System.out.println("1.사원추가  2.사원삭제  3.사원검색 4.전체목록  5.저장후종료");
			System.out.println("=".repeat(40));
			try {
				menu=Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException e) {
				menu=4;//문자를 잘못 입력시 전체목록이 나오도록
			}
			switch(menu)
			{
			case 1->{
				System.out.println("추가할 사원명을 입력하세요");
				String name=sc.nextLine();
				ex12.addSawon(name);
			}
			case 2->{
				System.out.println("삭제할 사원명을 입력하세요");
				String name=sc.nextLine();
				ex12.deleteSawon(name);
			}
			case 3->{
				System.out.println("검색할 사원명을 입력하세요");
				String name=sc.nextLine();
				ex12.searchName(name);
			}
			case 4->ex12.sawonMemberList();
			default->{
				System.out.println("** 저장후 종료합니다 **");
				ex12.sawonFileSave();
				System.exit(0);
			}
			}
		}
		
	}

}
























