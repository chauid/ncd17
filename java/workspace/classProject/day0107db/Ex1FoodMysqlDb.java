package day0107db;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * create table foodrest
(
   num smallint auto_increment primary key,
   foodname varchar(30),
   foodprice int,
   foodsize varchar(20) default '보통');

create table foodorder
(
    idx smallint auto_increment primary key,
    num smallint,
    ordername varchar(20),
    ordercnt smallint,
    bookingday varchar(30),
    constraint fk_foodorder_num foreign key(num) references foodrest(num));
 */

public class Ex1FoodMysqlDb extends JFrame{
	FoodModel foodModel=new FoodModel();

	DefaultTableModel foodResTableModel;
	DefaultTableModel foodOrderTableModel;
	JTable foodResTable;
	JTable foodOrderTable;

	JButton btnFoodResAdd,btnFoodResDel;
	JButton btnFoodOrderAdd,btnFoodOrderDel;
	JTextField tfFoodNum,tfOrderName,tfOrderCnt,tfBookingDay;
	JTextField tfFoodName,tfFoodPrice,tfFoodSize;

	public Ex1FoodMysqlDb() {
		// TODO Auto-generated constructor stub
		super("메뉴등록및예약");
		this.setBounds(200, 100, 1000, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}

	public void initDesign()
	{
		//상단에 버튼들 배치
		JPanel p1=new JPanel();
		btnFoodResAdd=new JButton("메뉴등록");
		btnFoodResDel=new JButton("메뉴삭제");
		btnFoodOrderAdd=new JButton("예약하기");
		btnFoodOrderDel=new JButton("예약취소");

		tfFoodName=new JTextField(7);
		tfFoodPrice=new JTextField(7);
		tfFoodSize=new JTextField(5);

		p1.add(new JLabel("메뉴명"));
		p1.add(tfFoodName);
		p1.add(new JLabel("가격등록"));
		p1.add(tfFoodPrice);
		p1.add(new JLabel("사이즈"));
		p1.add(tfFoodSize);		

		p1.add(btnFoodResAdd);
		p1.add(btnFoodResDel);
		p1.add(btnFoodOrderAdd);
		p1.add(btnFoodOrderDel);
		this.add("North",p1);

		//왼쪽에 등록된 메뉴보이게 하기
		String []menuTitle= {"번호","메뉴명","가격","사이즈"};
		foodResTableModel=new DefaultTableModel(menuTitle,0);//제목과 행갯수는 일단 0으로
		foodResTable=new JTable(foodResTableModel);
		this.add("West",new JScrollPane(foodResTable));

		//가운데 예약테이블 보이게 하기
		String []orderTitle= {"번호","예약자","메뉴명","가격","사이즈","인원수","예약일"};
		foodOrderTableModel=new DefaultTableModel(orderTitle, 0);
		foodOrderTable=new JTable(foodOrderTableModel);
		this.add("Center",new JScrollPane(foodOrderTable));

		//하단에 예약내용 입력부분 추가
		tfOrderName=new JTextField(5);
		tfOrderCnt=new JTextField(3);
		tfBookingDay=new JTextField(10);
		tfFoodNum=new JTextField(3);

		JPanel p2=new JPanel();
		p2.add(new JLabel("메뉴번호"));
		p2.add(tfFoodNum);

		p2.add(new JLabel("예약자명"));
		p2.add(tfOrderName);

		p2.add(new JLabel("인원수"));
		p2.add(tfOrderCnt);

		p2.add(new JLabel("예약시간"));
		p2.add(tfBookingDay);

		this.add("South",p2);	

		//버튼 이벤트들

		//메뉴등록버튼
		btnFoodResAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		//메뉴삭제버튼
		btnFoodResDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		//예약버튼
		btnFoodOrderAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		//예약취소버튼
		btnFoodOrderDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void writeFoodMenu()
	{

	}

	public void writeFoodOrderJoin()
	{

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1FoodMysqlDb ex1=new Ex1FoodMysqlDb();
	}

}





























