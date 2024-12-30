package day1226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex6TableCRUD extends JFrame{
	static final String FILENAME="d:/naver1210/student.txt";
	List<Student> list=new ArrayList<Student>();
	JTable table;
	DefaultTableModel tableModel;//추가,삭제등의 메서드를 갖고있는 클래스모델
	JTextField tfName,tfKor,tfEng;
	JButton btnAdd;

	public Ex6TableCRUD() {
		// TODO Auto-generated constructor stub
		super("학생관리");
		this.setBounds(300, 100, 400, 400);
		
		this.initDesign();
		this.setVisible(true);
		
		//윈도우 x버튼 클릭시 이벤트를 발생시켜서 파일을 저장한다
		//익명 내부클래스 형태로 이벤트를 구현한다
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//list 의 내용을 파일에 저장한다
				saveFile();
				//프로그램 종료
				System.exit(0);
				
				super.windowClosing(e);
			}
		});
	}

	public void studentFileRead()
	{
		//파일을 읽어서 list 변수에 담기
		FileReader fr=null;
		BufferedReader br=null;

		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);

			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;
				Student stu=new Student();
				String []data=s.split("\\|");
				stu.setName(data[0]);
				stu.setKor(Integer.parseInt(data[1]));
				stu.setEng(Integer.parseInt(data[2]));

				//list 에 추가
				list.add(stu);				
			}
			System.out.println(list.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	//List 의 데이타를 테이블에 출력해주는 메서드
	public void writeTableData()
	{
		//기존의 테이블에 출력된 데이타를 삭제후 다시 추가
		tableModel.setRowCount(0);		
	
		for(Student stu:list)
		{
			Vector<String> data=new Vector<String>();
			
			int kor=stu.getKor();
			int eng=stu.getEng();
			int sum=kor+eng;
			double avg=sum/2.0;
			
			data.add(stu.getName());
			data.add(String.valueOf(kor));
			data.add(String.valueOf(eng));
			data.add(String.valueOf(sum));
			data.add(String.valueOf(avg));
			
			//table 에 추가(추가하는 메서드도 모델이 갖구있음)
			tableModel.addRow(data);
		}
		
	}
	public void initDesign()
	{
		//파일을 읽어온다
		this.studentFileRead();
		
		//테이블을 생성해서 center 에 추가
		String []title= {"이름","국어","영어","총점","평균"};
		tableModel=new DefaultTableModel(title, 0);//일단 행갯수는 0으로 생성
		table=new JTable(tableModel);
		
		//table 에 데이타 추가하기
		this.writeTableData();
		
		//frame 에 추가
		this.add("Center",new JScrollPane(table));
		
		//입력부분 디자인
		JPanel panel=new JPanel();
		tfName=new JTextField(5);
		tfKor=new JTextField(4);
		tfEng=new JTextField(4);
		
		btnAdd=new JButton("추가");
		
		//버튼 클릭시 이벤트 발생
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//입력한 데이타를 읽어서 Student 에 넣은후 다시 list 에 추가
				String name=tfName.getText();
				int kor=Integer.parseInt(tfKor.getText());
				int eng=Integer.parseInt(tfEng.getText());
				
				Student stu=new Student(name, kor, eng);
				list.add(stu);
				
				//table 다시 출력
				writeTableData();
				
				//입력데이타는 지우기
				tfName.setText("");
				tfKor.setText("");
				tfEng.setText("");
			}
		});
		
		//panel 에 각 컴포넌트들 추가

		panel.add(new JLabel("이름"));
		panel.add(tfName);
		panel.add(new JLabel("국어"));
		panel.add(tfKor);
		panel.add(new JLabel("영어"));
		panel.add(tfEng);
		panel.add(btnAdd);
		
		//frame 에 panel 을 상단에 추가하자
		this.add("North",panel);
	}

	public void saveFile()
	{
		//List 의 내용을 파일에 저장한다
		FileWriter fw=null;
		
		try {
			fw=new FileWriter(FILENAME);
			
			for(Student stu:list)
			{
				String s=stu.getName()+"|"+stu.getKor()+"|"+stu.getEng()+"\n";
				//파일에 저장
				fw.write(s);
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6TableCRUD();
	}

}














