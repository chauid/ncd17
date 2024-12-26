package day1226;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex5TableStudent extends JFrame {
	private static final long serialVersionUID = 6858530854030931405L;
	static final String FILENAME = Paths.get("").toAbsolutePath().toString();
	List<Student> list = new ArrayList<Student>();

	public Ex5TableStudent() throws Exception {
		super("학생성적관리");
		this.setBounds(300, 100, 400, 300);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void studentFileRead() throws Exception {
		FileReader reader = new FileReader(new File(FILENAME + "/day1226/students.txt"));
		BufferedReader buffer = new BufferedReader(reader);

		while(true) {
			String line = buffer.readLine();
			if(line == null) {
				break;
			}
			String[] split = line.split("\\|");
			list.add(new Student(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
		}
		buffer.close();
	}

	public void initDesign() throws Exception {
		this.studentFileRead(); // 파일을 읽어서 list 변수에 담는다
		// list의 데이터를 읽어서 테이블에 출력 후
		// 프레임에 출력하시오
		// 제목은 이름, 국어, 영어, 총점, 평균
		this.add("North", new JLabel("학생 성적", JLabel.CENTER));
		String[][] rows = new String[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			String total = Integer.toString(list.get(i).getKor()+list.get(i).getEng());
			String avg = Float.toString((list.get(i).getKor()+list.get(i).getEng()) / 2.0f);
			rows[i] = new String[]{list.get(i).getName(), Integer.toString(list.get(i).getKor()), Integer.toString(list.get(i).getEng()), total, avg};
		}
		String[] header = { "이름", "국어", "영어", "총점", "평균" };
		JTable table = new JTable(rows, header);
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
		this.pack();
	}

	public static void main(String[] args) {
		try {
			new Ex5TableStudent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
