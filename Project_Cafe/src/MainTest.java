import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainTest extends JFrame{
	Panel_Main panel_main; 
	Panel_Noodle panel_noodle;
	Panel_Food panel_food;
	Panel_Snack panel_snack;
	Panel_Drink panel_drink;
	JTabbedPane tab = new JTabbedPane();
	public ArrayList<EdibleVo> list = new ArrayList<EdibleVo>();
	public JTextArea taJang = new JTextArea();
	public JTextField tf;// 직원호출
	public JButton sosbt,addbt, addbt2; 
	public JLabel banner1 = new JLabel("요청 쓴후에 호출, 장바구니에는 하나씩만");
	public JTextArea ta; // 장바구니 담기취소

	
	MainTest(){
		setTitle("PC방");
		panel_main = new Panel_Main(this);
		panel_noodle = new Panel_Noodle(this);
		panel_food = new Panel_Food(this);
		panel_noodle = new Panel_Noodle(this);
		panel_food = new Panel_Food(this);
		panel_snack = new Panel_Snack(this);
		panel_drink = new Panel_Drink(this);
		
	} 
	
	void addLayout() {
		//JTabbedPane 추가
		tab.addTab("main", panel_main);
		tab.addTab("라면", panel_noodle);
		tab.addTab("분식", panel_food);
		tab.addTab("간식", panel_snack);
		tab.addTab("음료", panel_drink);
		add(tab,BorderLayout.CENTER);
		
		//
//		JPanel pEast = new JPanel();
//		JButton b = new JButton("확인");
//		pEast.add(b);
//		add(pEast, BorderLayout.EAST);
		// ----------------------------오른쪽패널에 직원호출 및 장바구니
		JPanel pEast = new JPanel();
		pEast.setLayout(new GridLayout(2, 1));
		pEast.setPreferredSize(new java.awt.Dimension(300, 450));

		JPanel pEast1 = new JPanel();
		pEast1.add(tf); // 요청 사항 입력 후, 직원 호출을 눌러주세요
		pEast1.add(sosbt); // 직원 호출

		JPanel pEast2 = new JPanel();
		pEast2.add(banner1); // 이벤트 배너 삽입
		pEast2.add(ta); // 주문내역 출력
		pEast2.add(addbt); // 장바구니 담기
		pEast2.add(addbt2); // 장바구니 취소
		pEast2.add(taJang); // 주문내역 출력
		pEast.add(pEast1);
		pEast.add(pEast2);
		add(pEast, BorderLayout.EAST);
	
		
		setBounds(100, 100, 900, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void eventProc() {	
		
	}
	public static void main(String[] args) {
		MainTest m = new MainTest();
		m.addLayout();
		m.eventProc();
		
	}

}
